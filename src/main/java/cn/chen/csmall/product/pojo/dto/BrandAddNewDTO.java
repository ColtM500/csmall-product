package cn.chen.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 添加品牌类
 *
 * @author java@chen.cn
 * @version 0.0.1
 */
@Data
public class BrandAddNewDTO implements Serializable {

    /**
     * 数据id
     */
//    @ApiModelProperty(value = "相册名称", required = true, example = "11111")
//    @NotNull(message = "添加相册失败，必须提交相册名称！")
    private Long id;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称", required = true, example = "小米手机的品牌名称")
    @NotNull(message = "添加品牌名称失败，必须提交品牌名称！")
    private String name;

    /**
     * 品牌名称的拼音
     */
    @ApiModelProperty(value = "品牌名称的拼音", required = true, example = "小米手机的品牌名称的拼音")
    @NotNull(message = "添加品牌名称的拼音失败，必须提交品牌名称的拼音！")
    private String pinyin;

    /**
     * 品牌logo的URL
     */
    @ApiModelProperty(value = "品牌logo的URL", required = true, example = "小米手机的品牌logo的URL")
    @NotNull(message = "添加品牌logo的URL失败，必须提交品牌logo的URL！")
    private String logo;

    /**
     * 品牌简介
     */
    @ApiModelProperty(value = "品牌简介名称", required = true, example = "小米手机的品牌简介")
    @NotNull(message = "添加品牌简介失败，必须提交品牌简介！")
    private String description;

    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    @ApiModelProperty(value = "关键词列表", required = true, example = "小米手机的关键词列表")
    @NotNull(message = "添加关键词列表失败，必须提交关键词列表！")
    private String keywords;

    /**
     * 排序序号
     */
    @ApiModelProperty(value = "排序序号", required = true, example = "111111")
    @NotNull(message = "添加排序序号失败，必须提交排序序号！")
    private Integer sort;

    /**
     * 销量（冗余）
     */
    @ApiModelProperty(value = "销量（冗余）", required = true, example = "111111")
    @NotNull(message = "添加销量（冗余）失败，必须提交销量（冗余）！")
    private Integer sales;

    /**
     * 商品种类数量总和（冗余）
     */
    @ApiModelProperty(value = "商品种类数量总和（冗余）名称", required = true, example = "1111111")
    @NotNull(message = "添加商品种类数量总和（冗余），必须提交相册名称！")
    private Integer productCount;

    /**
     * 买家评论数量总和（冗余）
     */
    @ApiModelProperty(value = "买家评论数量总和（冗余）", required = true, example = "11111")
    @NotNull(message = "添加买家评论数量总和（冗余）失败，必须提交买家评论数量总和（冗余）！")
    private Integer commentCount;

    /**
     * 买家好评数量总和（冗余）
     */
    @ApiModelProperty(value = "买家好评数量总和（冗余）", required = true, example = "1111111")
    @NotNull(message = "添加买家好评数量总和（冗余）失败，必须提交买家好评数量总和（冗余）！")
    private Integer positiveCommentCount;

    /**
     * 是否启用，1=启用，0=未启用
     */
    @ApiModelProperty(value = "是否启用", required = true, example = "1")
    @NotNull(message = "添加失败，必须提交是否启用！")
    private Integer enable;
}
