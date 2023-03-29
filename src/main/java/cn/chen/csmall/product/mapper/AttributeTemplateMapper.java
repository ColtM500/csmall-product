package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.pojo.entity.Attribute;
import cn.chen.csmall.product.pojo.entity.AttributeTemplate;
import cn.chen.csmall.product.pojo.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeTemplateMapper {
    int insert(AttributeTemplate attributeTemplate);

    int deleteById(Long id);

    int count();

    int countByName(String name);

    int countByNameAndNotId(@Param("id") Long id, @Param("name") String name);

    AttributeTemplateStandardVO getStandardById(Long id);

    List<AttributeTemplateListItemVO> list();

    int insertBatch(List<AttributeTemplate> attributeTemplateList);

    int deleteByIds(Long[] idList);

    int update(AttributeTemplate attributeTemplate);
}
