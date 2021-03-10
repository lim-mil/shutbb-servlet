package com.limyel.utils;

import javax.servlet.http.HttpServletRequest;

public class URLUtil {
    public static String[] parseURL(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        return pathInfo.split("/");
    }
}
