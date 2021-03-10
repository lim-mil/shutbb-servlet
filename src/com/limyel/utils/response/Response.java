package com.limyel.utils.response;

import com.google.gson.Gson;

public class Response {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Response response = new Response();
        response.setCode(200);
        response.setMsg("OK");
        System.out.println(new Gson().toJson(response));
    }
}
