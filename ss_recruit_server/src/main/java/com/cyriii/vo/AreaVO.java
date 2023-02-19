package com.cyriii.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AreaVO {

    private Long id;

    private String code;

    private String name;

    private String level;

    private String cityCode;

    private String center;

    private Long pId;

    private List<AreaVO> children = new ArrayList<>();
}
