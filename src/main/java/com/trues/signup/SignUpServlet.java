package com.trues.signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
//z
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        String pw = req.getParameter("userPw");
        System.out.println("signUp");
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>")
                .append("<body>\n")
                .append("<h3 align=\"center\">");
        if(Users.map.containsKey(id) && Users.map.get(id).pw.equals(pw)) {
            str = "로그인 성공";
            System.out.println("success");
        }
        else{
            str = "로그인 실패";
            System.out.println("fail");
        }
        sb.append(str).append("</h3>")
                .append("</body>\n")
                .append("</html>");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(sb.toString());
        out.flush();
        out.close();
    }
}
