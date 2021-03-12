package com.limyel.shutbb_servlet.controller;

import com.google.gson.Gson;
import com.limyel.shutbb_servlet.dto.UserRegister;
import com.limyel.shutbb_servlet.models.UserModel;
import com.limyel.shutbb_servlet.service.UserService;
import com.limyel.shutbb_servlet.service.impl.UserServiceImpl;
import com.limyel.shutbb_servlet.utils.response.Response200;
import com.limyel.shutbb_servlet.utils.GsonUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(
    urlPatterns = {"/users/*"},
    loadOnStartup = 1
)
public class UserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        switch (request.getPathInfo()) {
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
//        StringBuilder stringBuilder = new StringBuilder();
//        try {
//            String line;
//            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
//            while ((line = reader.readLine()) != null)
//                stringBuilder.append(line);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        char[] data = new char[2048];
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            reader.read(data);
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = null;
        try {
            gson = GsonUtil.makeGson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String info = new String(data);
        String info2 = "{\"username\": \"lim\", \"email\": \"me@limyel.com\", \"password\": \"123456\", \"confirmPassword\": \"123456\"}";
        assert info.equals(info2);
        System.out.println(info);
        System.out.println(info2);
        if (info.equals(info2))
            System.out.println("hhhhh");

        UserRegister userRegister = gson.fromJson(info2, UserRegister.class);
        System.out.println(userRegister.getUsername());
        String username = userRegister.getUsername();
        String email = userRegister.getEmail();
        String password = userRegister.getPassword();
        String confirmPassword = userRegister.getConfirmPassword();
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
