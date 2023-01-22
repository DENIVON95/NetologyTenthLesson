import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTests {

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 9})
    public void shouldSetCurrentStationInBoundaryRange(int stationNumber) {
        Radio radio = new Radio();

        radio.setCurrentStation(stationNumber);
        assertEquals(stationNumber, radio.getCurrentStation());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 10})
    public void shouldSetCurrentVolumeInBoundaryRange(int volumeLevel) {
        Radio radio = new Radio();

        radio.setCurrentVolume(volumeLevel);
        assertEquals(volumeLevel, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    public void shouldNotSetOutOfRangeStationNumber(int wrongStationNumber) {
        Radio radio = new Radio();
        int correctStationNumber = 1;

        radio.setCurrentStation(correctStationNumber);
        radio.setCurrentStation(wrongStationNumber);
        assertEquals(correctStationNumber, radio.getCurrentStation());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    public void shouldNotSetOutOfRangeVolumeLevel(int wrongVolumeLevel) {
        Radio radio = new Radio();
        int correntVolumeLevel = 1;

        radio.setCurrentVolume(correntVolumeLevel);
        radio.setCurrentVolume(wrongVolumeLevel);
        assertEquals(correntVolumeLevel, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "10, 10"})
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
    public void shouldSwitchToNextStation(int currentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        assertEquals(expectedStation, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource({"2,1", "0,9"})
    public void shouldSwitchToPreviousStation(int currentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.prevStation();
        assertEquals(expectedStation, radio.getCurrentStation());
    }
}
