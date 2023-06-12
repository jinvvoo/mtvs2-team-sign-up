package com.trues.signup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPassWord {

    // 영문자/숫자/특수문자 포함 8~16자 비밀번호 구성
    public static Boolean checkPw(String pw) {

        Pattern sPattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=]){8,16}$");
        Matcher sMatcher = sPattern.matcher(pw);

        return sMatcher.matches();




        }


}
