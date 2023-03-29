package cn.chen.csmall.product.service;

import cn.chen.csmall.product.pojo.dto.AttributeTemplateAddNewDTO;
import cn.chen.csmall.product.pojo.dto.AttributeTemplateUpdateNewDTO;
import cn.chen.csmall.product.pojo.entity.AttributeTemplate;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import cn.chen.csmall.product.pojo.vo.AttributeTemplateStandardVO;

import java.util.List;

public interface IAttributeTemplateService {
    /**
     * 添加相册
     * @param attributeTemplateAddNewDTO 属性模板数据
     */
    void addNew(AttributeTemplateAddNewDTO attributeTemplateAddNewDTO);

    /**
     * 查询属性模板列表
     * @return 属性模板列表
     */
    List<AttributeTemplateListItemVO> list();

    /**
     * 根据ID查询属性模板详情
     * @param id 属性模板id
     * @return 属性模板列表
     */
    AttributeTemplateStandardVO getStandardById(Long id);

    /**
     * 根据id删除属性模板
     * @param id 属性模板id
     */
    void delete(Long id);

    /**
     * 修改属性模板详情
     * @param id 属性模板id
     * @param attributeTemplateUpdateNewDTO 匹配的属性模板信息 如果没有匹配到则数据异常
     */
    void updateInfoById(Long id, AttributeTemplateUpdateNewDTO attributeTemplateUpdateNewDTO);
}
