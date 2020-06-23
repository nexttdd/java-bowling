//package domain;
//
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class PinTest {
//    @ParameterizedTest
//    @CsvSource({"0", "1", "2", "10"})
//    void Pin생성_0이상일경우_10이하일경우(int fallsPin) {
//        Pin pin = Pin.of(fallsPin);
//        assertThat(pin.getNumber()).isBetween(0, 10);
//    }
//
//    @ParameterizedTest
//    @CsvSource({"-1", "11"})
//    void Pin생성_0이상일경우_exception(int fallsPin) {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> Pin.of(fallsPin));
//    }
//}