package cn.chen.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 添加属性模板类
 *
 * @author java@chen.cn
 * @version 0.0.1
 */
@Data
public class AttributeTemplateAddNewDTO implements Serializable {

    /**
     * 数据id
     */
    private Long id;

    /**
     * 属性模板名称
     */
    @ApiModelProperty(value = "属性模板名称", required = true)
    @NotNull(message = "添加属性模板名称失败，必须提交属性模板名称！")
    private String name;

    /**
     * 属性模板名称的拼音
     */
    @ApiModelProperty(value = "相册名称", required = true)
    @NotNull(message = "添加属性模板名称的拼音失败，必须提交属性模板名称的拼音！")
    private String pinyin;

    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    @ApiModelProperty(value = "关键词列表名称", required = true)
    @NotNull(message = "添加关键词列表失败，必须提交关键词列表名称！")
    private String keywords;

    /**
     * 排序序号
     */
    @ApiModelProperty(value = "排序序号名称", required = true)
    @NotNull(message = "添加排序序号失败，必须提交排序序号！")
    private Integer sort;

}
