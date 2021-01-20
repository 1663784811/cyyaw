package com.cyyaw.common.res;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult implements Serializable {

    public enum CodeEnum{
        SUCCESS("操作成功", 200),
        FAIL("操作失败", 400);
        private String msg;
        private Integer code;
        CodeEnum(String msg, int code) {
            this.msg = msg;
            this.code = code;
        }
    }

    private Result result;
    private Object data;
    private String msg;
    private Integer code;

    public static BaseResult ok() {
        return createResult(CodeEnum.SUCCESS, null, null,null);
    }

    public static BaseResult ok(String msg) {
        return createResult(CodeEnum.SUCCESS, null, null,msg);
    }

    public static BaseResult ok(Object data) {
        return createResult(CodeEnum.SUCCESS, data, null, null);
    }

    public static BaseResult ok(Object data,String msg) {
        return createResult(CodeEnum.SUCCESS, data, null, msg);
    }

    public static BaseResult ok(Object data, Result result) {
        return createResult(CodeEnum.SUCCESS, data, result, null);
    }

    public static BaseResult fail() {
        return createResult(CodeEnum.FAIL, null, null, null);
    }
    public static BaseResult fail(String msg) {
        return createResult(CodeEnum.FAIL, null, null, msg);
    }

    private static BaseResult createResult(CodeEnum codeEnum, Object data, Result result,String msg) {
        BaseResult res = new BaseResult();
        res.setCode(codeEnum.code);
        if(null != msg && !"".equals(msg)){
            res.setMsg(msg);
        }else{
            res.setMsg(codeEnum.msg);
        }
        res.setData(data);
        res.setResult(result);
        return res;
    }
    @Data
    public static class Result {
        private Long total;
        private Integer page;
        private Integer size;
        public Result() {
        }
        public Result( Integer page, Integer size, Long total) {
            this.total = total;
            this.page = page;
            this.size = size;
        }
    }
}
