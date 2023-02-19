package com.cyriii.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OssPolicyVO {

    @Schema(description = "用户请求的AccessKey ID")
    private String accessid;

    @Schema(description = "用户表单上传的策略")
    private String policy;

    @Schema(description = "对Policy签名后的字符串")
    private String signature;

    @Schema(description = "限制上传的文件前缀")
    private String dir;

    @Schema(description = "用户发送上传请求的域名")
    private String host;

    @Schema(description = "由服务器端指定的Policy过期时间")
    private String expire;
}
