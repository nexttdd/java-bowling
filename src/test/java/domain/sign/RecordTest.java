//package domain.sign;
//
//import domain.Pin;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class RecordTest {
//    @ParameterizedTest
//    @CsvSource({"10, X"})
//    void Pin상태값_반환_스트라이크(int fallsPin, String signCharacter) {
//        //given
//        Pin pin = Pin.of(fallsPin);
//
//        //when
//        Strike strike = (Strike) Record.of(pin);
//
//        //then1
//        assertThat(strike.getSpecialCharacter()).isEqualTo(signCharacter);
//    }
//
//    @ParameterizedTest
//    @CsvSource({"0, -"})
//    void Pin상태_반환_거터(int fallsPin, String signCharacter) {
//        //given
//        Pin pin = Pin.of(fallsPin);
//
//        //when
//        Gutter gutter = (Gutter) Record.of(pin);
//
//        //then
//        assertThat(gutter.getSpecialCharacter()).isEqualTo(signCharacter);
//    }
//
//    @ParameterizedTest
//    @CsvSource({"1,9","2,8","3,7","4,6"})
//    void Pin상태_반환_스패어(int fallsPin, String signCharater) {
//        Pin pin = Pin.of(fallsPin);
//
//        Strike strike = (Strike) Record.of(pin);
//        assertThat(strike.getSpecialCharacter()).isEqualTo(signCharater);
//    }
//
//}