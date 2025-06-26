package org.lizheng59.newDemo.model;


import lombok.Data;

// 定义code常量


@Data
public class Result<T> {
    private Integer code;
    private Boolean success;
    private String message;
    private T data;
    public Result() { }
    public Result(Integer code, Boolean success, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public Result(Integer code, Boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
    public static <T> Result<T> success(String message, T data){

        return new Result<>(ResultCode.SUCCESS, true, message, data);

    }
    public Result success(String message){
        return new Result(ResultCode.SUCCESS, true, message);
    }
    public static <T> Result<T> error (String message,T data){
        return new Result<>(ResultCode.ERROR, false, message, data);
    }
    public Result error(String message){
        return new Result(ResultCode.ERROR, false, message);
    }
}
