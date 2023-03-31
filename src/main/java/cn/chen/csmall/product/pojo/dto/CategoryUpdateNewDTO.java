package cn.chen.csmall.product.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryUpdateNewDTO implements Serializable {
    /**
     * 类别名称
     */
    private String name;

    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    private String keywords;

    /**
     * 排序序号
     */
    private Integer sort;

    /**
     * 图标图片的URL
     */
    private String icon;
}
