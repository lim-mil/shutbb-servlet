package com.limyel.shutbb_servlet.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    private static final GsonBuilder builder = new GsonBuilder();

    public static Gson makeGson() {
//        builder.excludeFieldsWithoutExposeAnnotation();
        builder.serializeNulls();
        return builder.setLenient().create();
    }
}
