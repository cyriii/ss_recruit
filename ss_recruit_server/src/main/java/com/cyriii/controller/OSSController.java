package com.cyriii.controller;

import cn.hutool.core.date.DateUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.cyriii.common.R;
import com.cyriii.config.properties.OssProperties;
import com.cyriii.vo.OssPolicyVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 文件上传
 */
@Tag(name = "文件上传")
@RestController
@RequestMapping("/oss")
public class OSSController {

    @Autowired
    private OssProperties ossProperties;

    @Autowired
    private OSS ossClient;

    @Operation(summary = "获取oss签名")
    @PostMapping("/policy")
    public R policy() throws UnsupportedEncodingException {

        // 填写Host名称，格式为https://bucketname.endpoint。
        String host = "https://" + ossProperties.getBucket() + "." + ossProperties.getEndpoint();

        // 设置上传到OSS文件的前缀，可置空此项。置空后，文件将上传至Bucket的根目录下。
        String dir = DateUtil.today() +"/";

        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("utf-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);

        OssPolicyVO ossPolicyVO = new OssPolicyVO();
        ossPolicyVO.setAccessid(ossProperties.getAccessKeyId());
        ossPolicyVO.setPolicy(encodedPolicy);
        ossPolicyVO.setSignature(postSignature);
        ossPolicyVO.setDir(dir);
        ossPolicyVO.setHost(host);
        ossPolicyVO.setExpire(String.valueOf(expireEndTime / 1000));
        return R.ok(ossPolicyVO);
    }

}
