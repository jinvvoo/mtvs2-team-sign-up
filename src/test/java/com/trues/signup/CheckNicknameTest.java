package com.trues.signup;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckNicknameTest {

    @Test
    @DisplayName("닉네임이 중복된 경우 false를 반환해야 함")
    public void testCheckNickname_DuplicateNickname_ReturnsFalse() {
        // given
        Users.nickSet.add("existingNick");
        CheckNickname nicknameChecker = new CheckNickname();

        // when
        boolean result = nicknameChecker.checkNickname("existingNick");

        // then
        assertFalse(result);
    } }
