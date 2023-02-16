package com.cyriii;

import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@MapperScan("com.cyriii.**.mapper")
public class SsRecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsRecruitApplication.class, args);
    }

}
