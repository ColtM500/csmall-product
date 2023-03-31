package cn.chen.csmall.product.service;

import cn.chen.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.chen.csmall.product.pojo.dto.CategoryUpdateNewDTO;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import cn.chen.csmall.product.pojo.vo.CategoryStandardVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICategoryService {
    String[] ENABLE_TEXT = {"禁用", "启用"};
    String[] DISPLAY_TEXT = {"隐藏", "显示"};

    void setEnable(Long id);
    void setDisable(Long id);

    void setDisplay(Long id);
    void setHidden(Long id);

    void addNew(CategoryAddNewDTO categoryAddNewDTO);

    List<CategoryListItemVO> listByParentId(Long parentId);

    void delete(Long id);

    CategoryStandardVO getStandardById(Long id);

    void updateInfoById(Long id, CategoryUpdateNewDTO categoryUpdateNewDTO);
}
