package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Picture;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import cn.chen.csmall.product.pojo.vo.CategoryStandardVO;
import cn.chen.csmall.product.pojo.vo.PictureListItemVO;
import cn.chen.csmall.product.pojo.vo.PictureStandardVO;

import java.util.List;

public interface PictureMapper {
    int insert(Picture picture);

    int deleteById(long id);

    int count();

    PictureStandardVO getStandardById(Long id);

    List<PictureListItemVO> list();
}
