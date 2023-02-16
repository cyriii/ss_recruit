package com.cyriii.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryVO {

    private Long id;

    private String name;

    private Long pId;

    private Integer level;

    private Integer sort;

    private List<CategoryVO> children = new ArrayList<>();
}
