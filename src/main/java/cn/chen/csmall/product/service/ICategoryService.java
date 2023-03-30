package cn.chen.csmall.product.service;

import cn.chen.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICategoryService {
    String[] ENABLE_TEXT = {"禁用", "启用"};

    void setEnable(Long id);
    void setDisable(Long id);

    void addNew(CategoryAddNewDTO categoryAddNewDTO);

    List<CategoryListItemVO> listByParentId(Long parentId);

    void delete(Long id);
}
