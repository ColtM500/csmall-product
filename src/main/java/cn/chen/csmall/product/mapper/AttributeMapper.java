package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.pojo.entity.Attribute;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;
import cn.chen.csmall.product.pojo.vo.AttributeStandardVO;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeMapper {
    int insert(Attribute attribute);

    int deleteById(Long id);

    int count();

    int countByNameAndTemplate(@Param("name") String name, @Param("templateId") Long templateId);

    int countByNameAndTemplateAndNotId(@Param("id") Long id, @Param("name") String name, @Param("templateId") Long templateId);

    AttributeStandardVO getStandardById(Long id);

    List<AlbumListItemVO> list();

    int insertBatch(List<Attribute> attributeList);

    int deleteByIds(Long[] idList);

    int update(Attribute attribute);
}
