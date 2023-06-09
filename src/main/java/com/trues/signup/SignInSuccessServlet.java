package com.trues.signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/success")
public class SignInSuccessServlet extends HttpServlet {
    private String userId, userPw;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userPw = req.getParameter("userPw");
        String nick = req.getParameter("nickName");
        String date = req.getParameter("date");
        String gender = req.getParameter("gender");
        System.out.println("gender = " + gender);
        System.out.println("date = " + date);
        System.out.println("nick = " + nick);
        System.out.println("userPw = " + userPw);
        System.out.println("userId = " + userId);
        Users.idSet.add(userId);
        Users.nickSet.add(nick);
        Users user = new Users(userId, userPw, nick, date, Integer.parseInt(gender));
        Users.map.put(userId, user);
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1> 가입완료 ^9^ </h1>\n")
                .append("<a href=\"../\">로그인 하러 가기</a>") //어제 하고 싶었던거 성공 ^=^ !@!@!@!@!
                .append("</body>\n")
                .append("</html>");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(sb);
        out.flush();
        out.close();
    }
}
