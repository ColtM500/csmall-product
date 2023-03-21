package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Category;
import cn.chen.csmall.product.pojo.entity.Picture;
import cn.chen.csmall.product.pojo.vo.CategoryListItemVO;
import cn.chen.csmall.product.pojo.vo.CategoryStandardVO;
import cn.chen.csmall.product.pojo.vo.PictureListItemVO;
import cn.chen.csmall.product.pojo.vo.PictureStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureMapper {
    int insert(Picture picture);

    int deleteById(long id);

    int count();

    PictureStandardVO getStandardById(Long id);

    List<PictureListItemVO> list();

    int insertBatch(List<Picture> pictures);

    int deleteByIds(Long[] idList);

    int update(Picture picture);
}
