package util;

public final class ApiResult<T> {
    private Integer status;
    private String message;
    private T date;

    public ApiResult(){
        //调用当前类的构造方法
        this(SUCCESS_CODE,SUCCESS_MSG);
    }
    public ApiResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setDate(T date) {
        this.date = date;
    }



    private static final Integer SUCCESS_CODE = 200;        //成功状态码
    private static final String SUCCESS_MSG = "成功";       //响应成功消息

    public static <T>  ApiResult<T> success(){
        return new ApiResult<>();
    }

    public static <T> ApiResult<T> success(T data){
        ApiResult<T> result = new ApiResult<>();
        result.setDate(data);
        return result;
    }

}