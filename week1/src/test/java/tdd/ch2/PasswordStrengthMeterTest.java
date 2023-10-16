package tdd.ch2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();
    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertThat(expStr).isEqualTo(result);
    }

    @Test
    void meetsAllCriteria_Then_Strong() {
        //PasswordStrengthMeter meter1 = new PasswordStrengthMeter();
        //PasswordStrength result1 = meter.meter("ab12!@AB");
        //assertThat(PasswordStrength.STRONG).isEqualTo(result1);
        assertStrength("ab12!@AB", PasswordStrength.STRONG);

        //PasswordStrengthMeter meter2 = new PasswordStrengthMeter();
        //PasswordStrength result2 = meter2.meter("abc1!Add");
        //assertThat(PasswordStrength.STRONG).isEqualTo(result2);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        //PasswordStrengthMeter meter = new PasswordStrengthMeter();
        //PasswordStrength result = meter.meter("ab12!@A");
        //assertThat(PasswordStrength.NOMAL).isEqualTo(result);
        assertStrength("ab12!@A", PasswordStrength.NOMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        //PasswordStrengthMeter meter = new PasswordStrengthMeter();
//        PasswordStrength result = meter.meter("abc!@ABC");
//        assertThat(PasswordStrength.NOMAL).isEqualTo(result);
        assertStrength("abc!@ABC", PasswordStrength.NOMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("abc12@!!", PasswordStrength.NOMAL);
    }

    @Test
    void 길이가_8글자_이상인_조건만_충족() {
        assertStrength("abcdefgh", PasswordStrength.WEAK);
    }

    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    void 숫자_포함_조건만_충족() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    void 대문자_포함_조건만_충족() {
        assertStrength("ABCEF", PasswordStrength.WEAK);
    }

    @Test
    void 아무조건도_충족하지_않음() {
        assertStrength("abc", PasswordStrength.WEAK);
    }
}
