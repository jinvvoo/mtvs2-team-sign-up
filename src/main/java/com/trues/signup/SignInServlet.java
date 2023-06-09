package com.trues.signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userId");
        String pw = req.getParameter("userPw");
        System.out.println("signUp");
        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n" +
                "<head>\n" +
                "    <title>회원가입</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div align=\"center\">\n" +
                "  <h1>회원가입</h1>\n" +
                "  <div class=\"container\">\n" +
                "    <form action=\"success\" method=\"post\">\n" +
                "      <label>ID : <input type=\"text\" name=\"userId\"></label><br>\n" +
                "      <label>PW : <input type=\"password\" name=\"userPw\"></label><br><label style=\"color: gray; font-size: small\">비밀번호는 영문 대소문자와 숫자, 특수문자를 포함하여 8자리 이상으로 입력해주세요.</label><br>\n" +
                "      <label>닉네임 : <input type=\"text\" name=\"nickName\"></label><br>\n" +
                "      <label>주민번호 : <input type=\"date\" name=\"date\"> - <input type=\"number\" name=\"gender\" size=\"2px\">******</label>\n" +
                "      <input type=\"submit\" value=\"가입\" style=\"background-color: dodgerblue; border-color: dodgerblue; color: white\">\n" +
                "    </form>\n" +
                "    <br>\n" +
                "    <button><a href=\"../\">뒤로가기</a></button>\n" +
                "  </div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(sb);
        out.flush();
        out.close();
    }
}
