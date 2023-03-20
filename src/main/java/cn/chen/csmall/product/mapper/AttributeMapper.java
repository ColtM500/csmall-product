package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Attribute;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;
import cn.chen.csmall.product.pojo.vo.AttributeStandardVO;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.List;

public interface AttributeMapper {
    int insert(Attribute attribute);

    int deleteById(Long id);

    //TODO:统计属性的数量
    int count();

    //TODO:根据ID查询属性的详情
    AttributeStandardVO getStandardById(Long id);

    //TODO:查询属性列表
    List<AlbumListItemVO> list();
}
