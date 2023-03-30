package cn.chen.csmall.product.service;

import cn.chen.csmall.product.pojo.dto.CategoryAddNewDTO;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICategoryService {
    void addNew(CategoryAddNewDTO categoryAddNewDTO);

    List<CategoryListItemVO> listByParentId(Long parentId);

    void delete(Long id);
}
