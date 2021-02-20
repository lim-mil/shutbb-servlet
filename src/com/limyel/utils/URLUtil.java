package com.limyel.utils;

import javax.servlet.http.HttpServletRequest;

public class URLUtil {
    public static String[] parseURL(HttpServletRequest request) {
        String uri = request.getRequestURI().split(request.getServletPath())[1];
        return uri.split("/");
    }
}
