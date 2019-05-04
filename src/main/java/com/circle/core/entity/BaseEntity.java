package com.circle.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class BaseEntity {

    @TableId(type = IdType.ID_WORKER)
    private Long id;

    @TableField("DELETED")
    private Boolean deleted;

    @TableField("CREATED_DATE")
    private ZonedDateTime createdDate;


}
