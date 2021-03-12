package com.limyel.shutbb_servlet.utils.response;

import com.google.gson.Gson;
import com.limyel.shutbb_servlet.utils.GsonUtil;

public class Response200 extends Response {
    public Response200() {
        this.setCode(200);
        this.setMsg("OK");
        this.setData(null);
    }

    public Response200(String msg) {
        super();
        this.setMsg(msg);
    }

    public Response200(Object data) {
        super();
        this.setData(data);
    }

    public String makeJson() {
        Gson gson = GsonUtil.makeGson();
        return gson.toJson(this);
    }
}
