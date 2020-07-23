package com.qpyue.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String  message;
    private T       data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }

    public static <R>  CommonResult<R> fail(String message, R r){
        return new CommonResult<>(400, message, r);
    }

    public static <R>  CommonResult<R> success(String message, R r){
        return new CommonResult<>(200, message, r);
    }

}
