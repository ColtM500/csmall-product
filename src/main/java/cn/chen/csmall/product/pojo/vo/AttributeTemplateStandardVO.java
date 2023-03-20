package cn.chen.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeTemplateStandardVO implements Serializable {
    /**
     * 数据id
     */
    private Long id;

    /**
     * 属性模板名称
     */
    private String name;

    /**
     * 属性模板名称的拼音
     */
    private String pinyin;

    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    private String keywords;

    /**
     * 排序序号
     */
    private Integer sort;

}
