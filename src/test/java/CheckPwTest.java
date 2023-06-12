import com.trues.signup.CheckPassWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckPwTest {

    private CheckPassWord pw;

    @BeforeEach
    public void setUp() {
        System.out.println("set 동작 확인");
        this.pw = new CheckPassWord();
    }

    @DisplayName("글자수가 8보다 적을때 올바르지 않은 비밀번호로 판단하는지")
    @Test

    void testLetterMin() {
        //given
        String letter = "fw";

        //when
        Boolean res = CheckPassWord.checkPw(letter);

        //then
        Assertions.assertEquals(false, res);


    }

    @DisplayName("비밀번호에 특수문자가 포함되지 않았을 경우 오류로 처리하는지")
    @Test

    void testBlank() {
        //given
        String passwdtest = "ktrdF17945";

        //when
        Boolean res = CheckPassWord.checkPw(passwdtest);

        //then
        Assertions.assertEquals(false, res);


    }

    @DisplayName("숫자가 포함되어 있지 않을 때 올바르지 않은 것으로 처리하는지")
    @Test

    void testLetterAl() {
        //given
        String testletter = "gPghkj";

        //when
        Boolean res = CheckPassWord.checkPw(testletter);
        System.out.println("res = " + res);

        //then
        Assertions.assertEquals(false, res);


    }








}
