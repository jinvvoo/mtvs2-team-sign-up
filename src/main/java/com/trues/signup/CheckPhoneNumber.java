package com.trues.signup;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CheckPhoneNumber {
    static Map<String, String> map = new HashMap<>(){{
       put("02", "서울"); put("031", "경기"); put("032", "인천");
       put("033", "강원"); put("041", "충남"); put("042", "대전");
       put("043", "충북"); put("044", "세종"); put("051", "부산");
       put("052", "울산"); put("053", "대구"); put("054", "경북");
       put("055", "경남"); put("061", "전남"); put("062", "광주");
       put("063", "전북"); put("064", "제주"); put("067", "제주");
       put("011", "모바일"); put("016", "모바일"); put("017", "모바일");
       put("018", "모바일"); put("019", "모바일"); put("010", "모바일");
    }};

    static String num1, num2, num3;
    public boolean checkNumber(String num){
        if(isCorrect(num)){
            String number = getStringToPhoneNumber(num);
            StringTokenizer st = new StringTokenizer(number, "-");
            if(st.countTokens() == 3){
                num1 = st.nextToken(); num2 = st.nextToken(); num3 = st.nextToken();
                if(map.containsKey(num1)){
                    if(num1.equals("02")){
                        if((num2.length() == 4 || num2.length() == 3) && num3.length() == 4)
                            return true;
                    }
                    else if(num1.equals("010")){
                        if(num2.length() == 4 && num3.length() == 4)
                            return true;
                    }
                    else{
                        if(num1.length() == 3 && num2.length() == 3 && num3.length() == 4)
                            return true;
                    }
                }
            }
        }
        return false;
    }
    public String getStringToPhoneNumber(String src){
        if(src.startsWith("02")){
            return src.replaceAll("([0-9]{2})([0-9]+)([0-9]{4})", "$1-$2-$3");
        }
        else if(src.startsWith("822")){
            StringBuilder sb = new StringBuilder();
            sb.append(src);
            sb.delete(0, 2);
            sb.insert(0, "0");
            num1 = String.valueOf(sb);
            src = num1;
            return src.replaceAll("([0-9]{2})([0-9]+)([0-9]{4})", "$1-$2-$3");
        }
        else if(src.startsWith("82")){
            StringBuilder sb = new StringBuilder();
            sb.append(src);
            sb.delete(0, 2);
            sb.insert(0, "0");
            num1 = String.valueOf(sb);
            src = num1;
            return src.replaceAll("([0-9]{3})([0-9]+)([0-9]{4})", "$1-$2-$3");
        }
        else{
            return src.replaceAll("([0-9]{3})([0-9]+)([0-9]{4})", "$1-$2-$3");
        }
    }
    public boolean isCorrect(String src){
        boolean checkNumber = src.matches("[0-9-]+");
        return checkNumber;
    }

    public String getNumber(String src){
        String num = getStringToPhoneNumber(src);
        StringTokenizer st = new StringTokenizer(num, "-");
        return "(" + map.get(st.nextToken()) + ") " + num;
    }
}
