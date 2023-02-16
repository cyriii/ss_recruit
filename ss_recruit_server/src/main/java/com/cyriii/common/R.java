package com.cyriii.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class R<T> {

    @Schema(description = "状态码，0为正常，非0为异常", example = "0")
    private Integer code;

    @Schema(description = "返回数据")
    private T data;

    @Schema(description = "描述信息", example = "成功")
    private String message;

    public enum ResultCode {
        SUCCESS(0, "成功"),
        ERROR(-1, "失败");


        private Integer code;

        private String desc;

        ResultCode(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    public static R ok() {
        return R.ok(null);
    }

    public static R ok(Object data) {
        return R.builder()
                .code(ResultCode.SUCCESS.code)
                .data(data)
                .message(ResultCode.SUCCESS.desc)
                .build();
    }

    public static R fail() {
        return fail(ResultCode.ERROR.desc);
    }

    public static R fail(String message) {
        return R.builder()
                .code(ResultCode.ERROR.code)
                .message(message).build();
    }

}
