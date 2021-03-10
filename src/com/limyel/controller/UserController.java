package com.limyel.controller;

import com.limyel.models.UserModel;
import com.limyel.service.UserService;
import com.limyel.service.impl.UserServiceImpl;
import com.limyel.utils.URLUtil;
import com.limyel.utils.response.Response200;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
    urlPatterns = {"/users/*"},
    loadOnStartup = 1
)
public class UserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
//        request.setCharacterEncoding("");
//        response.setCharacterEncoding("");
        String[] urls = URLUtil.parseURL(request);
        System.out.println(request.getPathInfo());
        switch (urls[0]) {
            case "/login":
                login(request, response);
                break;
            case "/register":
                register(request, response);
                break;
            case "/retrive":
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
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        System.out.println(username);
        if (password.equals(confirmPassword)) {
            UserModel userModel = new UserModel();
            userModel.setUsername(username);
            userModel.setPassword(password);
            userModel.setEmail(email);
            System.out.println(userModel.getEmail());
            System.out.println(userModel.getPassword());
            System.out.println(userModel.getUsername());
            if (userService.createUser(userModel)) {
                try {
                    PrintWriter out = response.getWriter();
                    out.println(new Response200().makeJson());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } else {

        }
    }

    public void retrive(HttpServletRequest request, HttpServletResponse response) {

    }

    public void update(HttpServletRequest request, HttpServletResponse response) {

    }
}
