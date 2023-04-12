package cn.chen.csmall.product.service.impl;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.mapper.CategoryMapper;
import cn.chen.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.chen.csmall.product.pojo.dto.CategoryUpdateNewDTO;
import cn.chen.csmall.product.pojo.entity.Category;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import cn.chen.csmall.product.pojo.vo.CategoryStandardVO;
import cn.chen.csmall.product.service.ICategoryService;
import cn.chen.csmall.product.web.ServiceCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper mapper;

    @Override
    public void setEnable(Long id) {
        updateEnableById(id, 1);
    }

    @Override
    public void setDisable(Long id) {
        updateEnableById(id, 0);
    }

    @Override
    public void setDisplay(Long id) {
        updateDisplayById(id, 1);
    }

    @Override
    public void setHidden(Long id) {
        updateDisplayById(id, 0);
    }

    //getter返回属性的值 setter接收一个参数并将其赋值给属性
    @Override
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        // 名称不允许重复
        String name = categoryAddNewDTO.getName();
        int countByName = mapper.countByName(name);
        if (countByName > 0) {
            String message = "新增类别失败，类别名称已经被占用！";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        //判断参数中的parentId是否为0
        Long parentId = categoryAddNewDTO.getParentId();
        CategoryStandardVO parentCategory = null;
        Integer depth = 1;//不管咋样默认为1 无子集时代码走到这里自动0->1 有子集增加则走下面判断自动增加depth数值
        if (parentId != 0){
            //是 父级类别的depth + 1 为了优化代码 直接将depth默认设为1
            //否 根据mapper对象中的getStandardById()查询父类级别depth
            parentCategory = mapper.getStandardById(parentId);
            //   判断查询到的父类结果是否为null
            if (parentCategory==null){
                //   是 抛出异常
                String message = "新增类别失败! 父类级别不存在!";
                throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
            } else {
                //   否 在父类depth值基础上+1
                depth = parentCategory.getDepth() + 1;
            }
        }

        //创建Category对象
        Category category = new Category();
        //调用BeanUtils.copyProperties()将参数对象的属性复制到Category()对象中
        BeanUtils.copyProperties(categoryAddNewDTO, category);
        //补全Category对象的属性值: depth深度 通过计算传入这里
        category.setDepth(depth);
        //补全Category对象的属性值: isParent 固定为0 添加子后缀后+1
        category.setIsParent(0);
        //调用mapper对象中的insert()方法插入数据
        int rows = mapper.insert(category);
        if (rows!=1){
            String message = "添加类别失败! 服务器繁忙,请稍后再试!";
            throw new ServiceException(ServiceCode.ERR_INSERT, message);
        }

        //判断parentId是否不为0 并判断父级类别中的isParent是否为0
        if (parentId!=0 && parentCategory.getIsParent()==0){
            //是 则将父级类别的isParent更新为1
            Category updateParentCategory = new Category();
            updateParentCategory.setId(parentId);
            updateParentCategory.setIsParent(1);
            rows =  mapper.update(updateParentCategory);
            if (rows!=1){
                String message = "添加类别失败! 服务器忙, 请稍后再尝试!";
                throw new ServiceException(ServiceCode.ERR_UPDATE, message);
            }
        }
    }

    @Override
    public List<CategoryListItemVO> listByParentId(Long parentId) {
        List<CategoryListItemVO> list = mapper.listByParentId(parentId);
        return list;
    }

    @Override
    public void delete(Long id) {
        //调用mapper查询类别详情
        CategoryStandardVO currentCategory = mapper.getStandardById(id);
        //如果查询结果中 类别内容为null 则 抛出异常
        if (currentCategory==null){
            String message = "删除类别失败, 访问数据不存在!";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }
        //如果查询结果中 类别isParent=1 则 抛出异常
        if (currentCategory.getIsParent()==1){
            String message = "删除类别失败, 当前类别仍包含子集, 不可删除!";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        //调用mapper删除对象
        int rows = mapper.deleteById(id);
        if (rows!=1){
            String message = "删除类别失败, 服务器繁忙, 请稍后重试!";
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }

        //判断此类别父级是否存在其他子级 无 则isParent更新为0
        Long parentId = currentCategory.getParentId();
        if (parentId != 0) {//如果父级id不为0
            //调用mapper中的countByParentId()统计子级数量
            int countByParentId = mapper.countByParentId(parentId);
            //判断统计结果是否为0 如果是 则将父级isParent更新为0
            if (countByParentId == 0) {
                Category updateParentCategory = new Category();
                updateParentCategory.setId(parentId);
                updateParentCategory.setIsParent(0);
                rows = mapper.update(updateParentCategory);
                if (rows != 1) {
                    String message = "删除类别失败，服务器忙，请稍后再尝试！";
                    throw new ServiceException(ServiceCode.ERR_UPDATE, message);
                }
            }
        }
    }

    @Override
    public CategoryStandardVO getStandardById(Long id) {
        CategoryStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult==null){
            String message = "根据id查找信息失败, 访问的数据不存在!";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        return queryResult;
    }

    @Override
    public void updateInfoById(Long id, CategoryUpdateNewDTO categoryUpdateNewDTO) {
        //根据id查询要修改的种类信息
        CategoryStandardVO queryResult = mapper.getStandardById(id);
        if (queryResult==null){
            String message = "修改类别失败, 访问的数据不存在, 请稍后再试!";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        //判断名称是否重合
        String name = categoryUpdateNewDTO.getName();
        int countByNameAndNotId = mapper.countByNameAndNotId(id, name);
        if (countByNameAndNotId>0){
            String message = "修改类别失败, 名称已被占用, 请稍后再试!";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        //调用mapper进行修改
        Category updateCategory = new Category();
        //复制属性 调用id
        BeanUtils.copyProperties(categoryUpdateNewDTO, updateCategory);
        updateCategory.setId(id);
        int rows = mapper.update(updateCategory);
        if (rows==0){
            String message = "修改类别详情失败, 服务器繁忙, 请稍后再试!";
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
    }


    /**
     * 更新是否启用或者禁用
     * @param id 需要启用的类别的id
     * @param enable 对应的状态
     */
    private void updateEnableById(Long id, Integer enable){
        //调用mapper对象进行查询  检查类别是否存在
        CategoryStandardVO currentCategory = mapper.getStandardById(id);
        if (currentCategory==null){
            String message = ENABLE_TEXT[enable] + "类别失败，尝试访问的数据不存在！";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        //检查当前类别的启用状态 如果与参数目标状态相同 则 抛出异常
        if (currentCategory.getEnable()==enable){
            String message = ENABLE_TEXT[enable] + "类别失败，当前类别已经处于【" + ENABLE_TEXT[enable] + "】状态！";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        //调用mapper对象进行修改  更新类别的启用状态
        Category updateCategory = new Category();
        updateCategory.setId(id);
        updateCategory.setEnable(enable);
        int rows = mapper.update(updateCategory);
        if (rows!=1){
            String message = ENABLE_TEXT[enable] + "类别失败，服务器忙，请稍后再尝试！";
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
    }

    /**
     * 更新是否显示在导航栏或者隐藏在导航栏
     * @param id 需要启用的类别的id
     * @param display 对应的状态
     */
    private void updateDisplayById(Long id, Integer display){
        //调用mapper进行查询 检查类别是否存在
        CategoryStandardVO currentCategory = mapper.getStandardById(id);
        if (currentCategory==null){
            String message = DISPLAY_TEXT[display] + "类别失败，尝试访问的数据不存在！";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        //检查是否处于显示状态 如果与参数状态相同 则 抛出异常
        if (currentCategory.getIsDisplay()==display){
            String message = DISPLAY_TEXT[display] + "类别失败，当前类别已经处于【" + DISPLAY_TEXT[display] + "】状态！";
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
        }

        //调用mapper对象进行修改 更新类别的显示作用
        Category updateCategory = new Category();
        updateCategory.setId(id);
        updateCategory.setIsDisplay(display);
        int rows = mapper.update(updateCategory);
        if (rows!=1){
            String message = DISPLAY_TEXT[display] + "类别失败，服务器忙，请稍后再尝试！";
            throw new ServiceException(ServiceCode.ERR_UPDATE, message);
        }
    }
}
