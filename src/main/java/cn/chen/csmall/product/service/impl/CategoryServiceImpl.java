package cn.chen.csmall.product.service.impl;

import cn.chen.csmall.product.ex.ServiceException;
import cn.chen.csmall.product.mapper.CategoryMapper;
import cn.chen.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.chen.csmall.product.pojo.entity.Category;
import cn.chen.csmall.product.pojo.vo.CategoryStandardVO;
import cn.chen.csmall.product.service.ICategoryService;
import cn.chen.csmall.product.web.ServiceCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper mapper;

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
        mapper.insert(category);

        //判断parentId是否不为0 并判断父级类别中的isParent是否为0
        if (parentId!=0 && parentCategory.getIsParent()==0){
            //是 则将父级类别的isParent更新为1
            Category updateParentCategory = new Category();
            updateParentCategory.setId(parentId);
            updateParentCategory.setIsParent(1);
            mapper.update(updateParentCategory);
        }
    }
}
