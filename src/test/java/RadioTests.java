import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTests {

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 9})
    public void shouldSetCurrentStationInBoundaryRangeWithDefaultValue(int stationNumber) {
        Radio radio = new Radio();

        radio.setCurrentStation(stationNumber);
        assertEquals(stationNumber, radio.getCurrentStation());
    }

    @Test
    public void shouldSetCurrentStationInMaxRangeWithCustomValue() {
        Radio radio = new Radio(22);
        int stationToSet = 21;

        radio.setCurrentStation(stationToSet);
        assertEquals(stationToSet, radio.getCurrentStation());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 100})
    public void shouldSetCurrentVolumeInBoundaryRange(int volumeLevel) {
        Radio radio = new Radio();

        radio.setCurrentVolume(volumeLevel);
        assertEquals(volumeLevel, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    public void shouldNotSetOutOfRangeStationNumberWithDefaultValue(int wrongStationNumber) {
        Radio radio = new Radio();
        int correctStationNumber = 1;

        radio.setCurrentStation(correctStationNumber);
        radio.setCurrentStation(wrongStationNumber);
        assertEquals(correctStationNumber, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetOutOfMaxStationNumberWithCustomValue() {
        Radio radio = new Radio(5);

        radio.setCurrentStation(6);
        assertEquals(0, radio.getCurrentStation());
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    public void shouldNotSetOutOfRangeVolumeLevel(int wrongVolumeLevel) {
        Radio radio = new Radio();
        int correctVolumeLevel = 1;

        radio.setCurrentVolume(correctVolumeLevel);
        radio.setCurrentVolume(wrongVolumeLevel);
        assertEquals(correctVolumeLevel, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "100, 100"})
    public void shouldIncreaseVolume(int currentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.increaseVolume();
        assertEquals(expectedVolume, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({"1,0", "0,0"})
    public void shouldDecreaseVolume(int currentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.decreaseVolume();
        assertEquals(expectedVolume, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({"1,2", "9,0"})
    public void shouldSwitchToNextStationWithDefaultValue(int currentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        assertEquals(expectedStation, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({"20,21", "21,0"})
    public void shouldSwitchToNextStationWithCustomValue(int currentStation, int expectedStation) {
        Radio radio = new Radio(22);
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        assertEquals(expectedStation, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({"2,1", "0,9"})
    public void shouldSwitchToPreviousStationWithDefaultValue(int currentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.prevStation();
        assertEquals(expectedStation, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({"21,20", "0,21"})
    public void shouldSwitchToPreviousStationWithCustomValue(int currentStation, int expectedStation) {
        Radio radio = new Radio(22);

        radio.setCurrentStation(currentStation);
        radio.prevStation();
        assertEquals(expectedStation, radio.getCurrentStation());
    }
}
