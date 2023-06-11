package com.trues.signup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Users {
    static HashSet<String> idSet = new HashSet<>();
    static HashSet<String> nickSet = new HashSet<>();
    static HashMap<String, Users> map = new HashMap<>();
    String id, pw, nick, birth, gender, phone;
    Users(String str1, String str2, String nick, String birth, String gender, String phone){
        this.id = str1;
        this.pw = str2;
        this.nick = nick;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;


    }
    public boolean checkId(String id){
        if(!idSet.isEmpty()){
            return !idSet.contains(id);
        }
        return true;
    }
    public boolean checkPw(String pw){
        boolean upperFlag, lowerFlag, specialFlag, numFlag;
        upperFlag = lowerFlag = specialFlag = numFlag = false;
        if(pw.length() < 8)
            return false;
        for(int i = 0; i < pw.length(); i++){
            char tmp = pw.charAt(i);
            if('A' <= tmp && tmp <= 'Z')
                upperFlag = true;
            if('a' <= tmp && tmp <= 'z')
                lowerFlag = true;
            if('0' <= tmp && tmp <= '9')
                numFlag = true;
            if(!('A' <= tmp && tmp <= 'Z') && !('a' <= tmp && tmp <= 'z') && !('0' <= tmp && tmp <= '9'))
                specialFlag = true;
        }
        return (upperFlag && lowerFlag && numFlag && specialFlag);
    }
    public boolean checkNick(String nick){
        if(!nickSet.isEmpty()){
            return !nickSet.contains(nick);
        }
        return true;
    }
    public boolean checkGender(int gender){
        if(1 <= gender && gender <= 4){
            return true;
        }
        return false;
    }

}
