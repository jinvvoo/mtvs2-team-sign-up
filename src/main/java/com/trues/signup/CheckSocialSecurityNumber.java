package com.trues.signup;

public class CheckSocialSecurityNumber {

    public boolean checkSocialSecurityNumber(String date, String gender) {

        boolean result1 = date.matches("^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])");
        boolean result2 = gender.matches("[1-4]");

        if(result1 && result2){
            return true;
        }

        return false;
    }
}
