package com.cyriii.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("ali.sms")
public class AliSmsProperties {

    private String accessKeyId;

    private String accessKeySecret;

    private String region = "cn-hangzhou";

    private String endpoint = "dysmsapi.aliyuncs.com";

    private String signName;

    private String templateCode;

    /**
     * 验证码过期时间
     */
    private Long codeTimeOut;


}
