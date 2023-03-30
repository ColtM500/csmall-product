package cn.chen.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BrandUpdateNewDTO implements Serializable {


    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称", required = true)
    @NotNull(message = "添加品牌名称失败，必须提交品牌名称的名称！")
    private String name;

    /**
     * 品牌名称的拼音
     */
    @ApiModelProperty(value = "品牌名称的拼音", required = true)
    private String pinyin;

    /**
     * 品牌logo的URL
     */
    @ApiModelProperty(value = "品牌logo的URL", required = true)
    private String logo;

    /**
     * 品牌简介
     */
    @ApiModelProperty(value = "品牌简介", required = true)
    private String description;

    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    @ApiModelProperty(value = "关键词", required = true)
    private String keywords;

    /**
     * 排序序号
     */
    @ApiModelProperty(value = "排序序号", required = true)
    private Integer sort;

    /**
     * 销量（冗余）
     */
    @ApiModelProperty(value = "销量（冗余）", required = true)
    private Integer sales;

    /**
     * 商品种类数量总和（冗余）
     */
    @ApiModelProperty(value = "商品种类数量总和（冗余）", required = true)
    private Integer productCount;

    /**
     * 买家评论数量总和（冗余）
     */
    @ApiModelProperty(value = "买家评论数量总和（冗余）", required = true)
    private Integer commentCount;

    /**
     * 买家好评数量总和（冗余）
     */
    @ApiModelProperty(value = "买家好评数量总和（冗余）", required = true)
    private Integer positiveCommentCount;

    /**
     * 是否启用，1=启用，0=未启用
     */
    @ApiModelProperty(value = "是否启用", required = true)
    private Integer enable;
}
