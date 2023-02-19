package com.cyriii.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Area {

    @TableId
    private Long id;

    private String code;

    private String name;

    private String level;

    private String cityCode;

    private String center;

    private String pId;

}
