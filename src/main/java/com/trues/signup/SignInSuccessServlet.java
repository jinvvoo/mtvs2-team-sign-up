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
        String phoneNumber = req.getParameter("phone");
        System.out.println("gender = " + gender);
        System.out.println("date = " + date);
        System.out.println("nick = " + nick);
        System.out.println("userPw = " + userPw);
        System.out.println("userId = " + userId);
        System.out.println("phoneNumber = " + phoneNumber);

        CheckSocialSecurityNumber checkSocialSecurityNumber = new CheckSocialSecurityNumber();

        boolean result = checkSocialSecurityNumber.checkSocialSecurityNumber(date, gender);
        if (result) {
            System.out.println("좋은 주민번호 방식입니다.");
        }

        //전화 번호
        CheckPhoneNumber numCheck = new CheckPhoneNumber();
        boolean phoneFlag = numCheck.checkNumber(phoneNumber);

        //아이디
        CheckId idCheck = new CheckId();
        String id1 = idCheck.step2(userId);
        Boolean idFlag = idCheck.idRegularExpressionChk(idCheck.step5(id1));
        if(idFlag){
            userId = idCheck.step5(idCheck.step1(id1));
        }

        //플래그 추가할 때, 밑에 if(phoneFlag랑 같이 추가해주삼)
        if(phoneFlag && idFlag){
            System.out.println("올바른 폰번호네요.");
            System.out.println(numCheck.getNumber(phoneNumber));
            System.out.println("userId = " + userId);
            Users.idSet.add(userId);
            Users.nickSet.add(nick);
            Users user = new Users(userId, userPw, nick, date, gender, numCheck.getNumber(phoneNumber));
            Users.map.put(userId, user);
        }
        else{
            System.out.println("잘못된 폰번호인데요.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n");

        //여기 말입니다.
        if(phoneFlag && idFlag){
            sb.append("<h1> 가입완료 ^9^ </h1>\n")
              .append("<a href=\"../\">로그인 하러 가기</a>"); //어제 하고 싶었던거 성공 ^=^ !@!@!@!@!
        }
        else{
            sb.append("<h1> 잘못된 입력입니다. 올바르게 입력해주세요 ^-^ </h1>\n")
                    .append("<a href=\"javascript:window.history.back();\">뒤로가기</a>");
        }
        sb.append("</body>\n")
        .append("</html>");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(sb);
        out.flush();
        out.close();*/
    }
}
