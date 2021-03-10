package com.limyel.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    public static Gson makeGson() {
        GsonBuilder builder = new GsonBuilder();
//        builder.excludeFieldsWithoutExposeAnnotation();
        builder.serializeNulls();
        return builder.create();
    }
}
