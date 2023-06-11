import com.trues.signup.CheckId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckIdTest {

    private CheckId id;

    @BeforeEach
    public void setUp(){
        System.out.println("set동작 확인");
        this.id = new CheckId();
    }

    @DisplayName("대문자를 소문자로 치환")
    @Test

    void testLetterChanger(){

        //given
        String letter = "aaaAAA";

        //when
        String res = id.step1(letter);

        //then
        Assertions.assertEquals("aaaaaa", res);
    }

    @DisplayName("공백을 입력하면 a로 치환되는지 확인")
    @Test

    void testStep2(){

        //given
        String letter = "";

        //when
        String res = id.step2(letter);

        //then
        Assertions.assertEquals("a", res);
    }

    @DisplayName("한글과 특수기호를 쓰면 제거")
    @Test

    void idRegularExpressionChkTest(){

        //given
        String letter = "js-_f";

        //when
        boolean res = id.idRegularExpressionChk(letter);

        //then
        Assertions.assertEquals(true, res);

    }


    @DisplayName("아이디 중간에 공백이 있을 시 제거")
    @Test

    void testStep5(){

        //given
        String letter = "korea love";

        //when
        String res = id.step5(letter);

        //then
        Assertions.assertEquals("korealove", res);
    }
}
