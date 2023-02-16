package com.cyriii.utils;


import com.alibaba.fastjson.JSONObject;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.cyriii.config.properties.AliSmsProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@EnableConfigurationProperties(AliSmsProperties.class)
public class SmsUtils {

    @Autowired
    private AliSmsProperties properties;

    @Autowired
    private AsyncClient asyncClient;

    public boolean sendSms(String mobileNum, String code) {
        Map<String, Object> param = new HashMap<>();
        param.put("code", code);
        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .signName(properties.getSignName())
                .templateCode(properties.getTemplateCode())
                .phoneNumbers(mobileNum)
                .templateParam(JSONObject.toJSONString(param))
                .build();

        CompletableFuture<SendSmsResponse> response = asyncClient.sendSms(sendSmsRequest);

        try {
            SendSmsResponse resp = response.get();
            log.debug(JSONObject.toJSONString(resp));
        } catch (Exception e) {
            log.error("验证码发送失败！手机号：{}，验证码：{}", mobileNum, code, e);
            return false;
        }
        return true;
    }

}
