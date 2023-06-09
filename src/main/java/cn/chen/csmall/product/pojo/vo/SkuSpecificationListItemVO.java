package cn.chen.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SkuSpecificationListItemVO implements Serializable {
    /**
     * 数据id
     */
    private Long id;

    /**
     * SKU id
     */
    private Long skuId;

    /**
     * 属性id
     */
    private Long attributeId;

    /**
     * 属性名称
     */
    private String attributeName;

    /**
     * 属性值
     */
    private String attributeValue;

    /**
     * 自动补充的计量单位
     */
    private String unit;

    /**
     * 自定义排序序号
     */
    private Integer sort;
}
