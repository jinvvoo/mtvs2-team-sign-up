package com.trues.signup;

public class CheckNickname {

    // 중복을 확인하는 코드 #HashSet (중복을 자체적으로 확인해줌)
    // boolean을 사용하여 true, false값을 반환하도록 한다.
    public boolean checkNick(String nick) {
        if (Users.nickSet.contains(nick)) {
            return false;
        }

        // 닉네임에 공백이 포함되어 있는지 확인하는 코드
        // 닉네임에 공백이 포함되어 있다면 false를 반환, 공백이 없으면 true; 반환
        boolean hasSpace = nick.contains("");
        if (hasSpace) {
            return false;
        }


        // 최소 3글자 이상으로 작성해야한다.
        if (nick.length() >= 3) {
            return true;
        } else {
            return false;
        }
    }
}