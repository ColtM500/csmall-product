package cn.chen.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryAttributeTemplateStandardVO implements Serializable {
    /**
     * 数据id
     */
    private Long id;

    /**
     * 类别id
     */
    private Long categoryId;

    /**
     * 属性模板id
     */
    private Long attributeTemplateId;
}
