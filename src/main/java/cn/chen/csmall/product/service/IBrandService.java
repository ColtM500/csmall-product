package cn.chen.csmall.product.service;

import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateUpdateNewDTO;
import cn.chen.csmall.product.pojo.dto.BrandAddNewDTO;
import cn.chen.csmall.product.pojo.dto.BrandUpdateNewDTO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import cn.chen.csmall.product.pojo.vo.BrandListItemVO;
import cn.chen.csmall.product.pojo.vo.BrandStandardVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IBrandService {
    /**
     * 添加品牌
     * @param brandAddNewDTO 品牌数据
     */
    void addNew(BrandAddNewDTO brandAddNewDTO);

    /**
     * 查询品牌列表
     * @return 品牌列表
     */
    List<BrandListItemVO> list();

    /**
     * 根据ID查询品牌详情
     * @param id 品牌id
     * @return 品牌列表
     */
    BrandStandardVO getStandardById(Long id);

    /**
     * 根据id删除属性模板
     * @param id 属性模板id
     */
    void delete(Long id);

    /**
     * 修改品牌详情
     * @param id 品牌id
     * @param brandUpdateNewDTO 匹配的品牌信息 如果没有匹配到则数据异常
     */
    void updateInfoById(Long id, BrandUpdateNewDTO brandUpdateNewDTO);
}
