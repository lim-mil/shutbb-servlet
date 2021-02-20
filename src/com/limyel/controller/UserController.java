package com.limyel.controller;

import com.limyel.utils.URLUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
//        request.setCharacterEncoding("");
//        response.setCharacterEncoding("");
        String[] urls = URLUtil.parseURL(request);
        switch (urls[0]) {
            case "login":
                login(request, response);
                break;
            case "register":
                register(request, response);
                break;
            case "retrive":
                retrive(request, response);
                break;
            case "update":
                update(request, response);
                break;
            default:
                ;
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {

    }

    public void register(HttpServletRequest request, HttpServletResponse response) {

    }

    public void retrive(HttpServletRequest request, HttpServletResponse response) {

    }

    public void update(HttpServletRequest request, HttpServletResponse response) {

    }
}
