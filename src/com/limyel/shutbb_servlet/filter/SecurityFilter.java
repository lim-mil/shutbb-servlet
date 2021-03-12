package com.limyel.shutbb_servlet.filter;

import com.limyel.shutbb_servlet.dao.UserDao;
import com.limyel.shutbb_servlet.dao.impl.UserDaoImpl;
import com.limyel.shutbb_servlet.models.UserModel;
import com.limyel.shutbb_servlet.utils.SecurityUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class SecurityFilter implements Filter {
    /**
     * 用户验证过滤器，检查请求头是否带 jwt token，没有就重定向到登陆页面
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String token = httpServletRequest.getHeader("Authorization");
        if (token != null) {
            String jwt = token.split(" ")[1];
            Map<String, String> result = SecurityUtil.parseJWT(jwt);
            UserDao userDao = new UserDaoImpl();
            UserModel user = userDao.retriveUserByUsername(result.get("username"));
            if (null != user) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        httpServletResponse.sendRedirect("/user/login");
    }
}
