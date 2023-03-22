package cn.chen.csmall.product.mapper;

import cn.chen.csmall.product.pojo.entity.Album;
import cn.chen.csmall.product.pojo.vo.AlbumListItemVO;
import cn.chen.csmall.product.pojo.vo.AlbumStandardVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *处理相册数据的Mapper接口
 * @param  @cn.chen
 * @return 0.0.1
 */
@Repository
public interface AlbumMapper {

    /**
     *插入相册数据
     * @param album 相册数据
     * @return 受影响行数
     */
    int insert(Album album);

    /**
     * 批量插入相册数据
     * @param albumList 相册数据的集合
     * @return 受影响的行数
     */
    int insertBatch(List<Album> albumList);

    /**
     * 根据ID删除行数
     * @param id 尝试删除相册的ID
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 根据若干个ID批量删除
     * @param idList 尝试删除的若干个相册的ID
     * @return 受影响的行数
     */
    int deleteByIds(Long[] idList);

    /**
     * 修改相册的数据
     * @param album 封装了尝试修改数据的相册ID和新数据的对象
     * @return 受影响的行数
     */
    int update(Album album);

    /**
     * 统计相册的数量
     * @return 相册数据的数量
     */
    int count();

    /**
     * 根据相册名称统计相册数据的数量
     * @param name 相册名称
     * @return 匹配的相册数据
     */
    int countByName(String name);

    /**
     * 统计非id 但名称匹配的相册数据的数量 用于检查是否存在其他数据使用了相同的名称
     * @param id 相册id
     * @param name 相册名称
     * @return 匹配名但不匹配id的数据的数量
     */
    int countByNameAndNotId(@Param("id") Long id, @Param("name") String name);


    /**
     * 根据ID查询相册详情
     * @param id 尝试获取详情的相册数据的ID
     * @return 匹配的相册详情 如果没有匹配的数据 返回null
     */
    AlbumStandardVO getStandardById(Long id);

    /**
     * 查询相册列表
     * @return 相册列表
     */
    List<AlbumListItemVO> list();

}
