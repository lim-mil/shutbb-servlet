import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;

public class HelloWorld extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        String[] uris = uri.split(request.getServletPath());
        System.out.println(uris[1]);
        System.out.println("---------------------------");
        PrintWriter out = response.getWriter();
        for (Cookie cookie: request.getCookies()) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
        System.out.println("---------------------------");
        System.out.println(request.getAuthType());
        System.out.println(request.getHeaderNames());
        System.out.println(request.getMethod());

        System.out.println("---------------------------");
        System.out.println(request.getParameterNames());
        Enumeration<String> p = request.getParameterNames();
        while (p.hasMoreElements()) {
            System.out.println(p.nextElement());

        }

        out.println("<html><head><title>Welcome</title></head>");
        out.println("<body>");
        out.println("hello");
        out.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.println("hello, 你的用户名是 " + username);
        out.println("your password is " + password);
        response.addCookie(new Cookie("username", username));
        out.close();
    }
}
