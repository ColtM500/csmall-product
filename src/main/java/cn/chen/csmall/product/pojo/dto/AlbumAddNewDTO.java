package cn.chen.csmall.product.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AlbumAddNewDTO implements Serializable {
    /**
     * 相册名称
     */
    @ApiModelProperty(value = "相册名称", required = true, example = "格力空调的名字")
    @NotNull(message = "必须提交相册名称")
    private String name;

    /**
     * 相册简介
     */
    @ApiModelProperty(value = "相册简介", required = true)
    @NotNull(message = "必须提交相册简介")
    private String description;

    /**
     * 排序序号
     */
    @ApiModelProperty(value = "排序序号", required = true, example = "99")
    @NotNull(message = "必须提交相册类型")
    private Integer sort;
}
