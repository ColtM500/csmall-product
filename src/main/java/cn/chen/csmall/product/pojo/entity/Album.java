package cn.chen.csmall.product.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Album implements Serializable {
    private long id;
    private String name;
    private String description;
    private Integer sort;
    private LocalDateTime gmCreate;
    private LocalDateTime gmModified;
}
