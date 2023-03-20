package cn.chen.csmall.product.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AlbumStandardVO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Integer sort;

}
