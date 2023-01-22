import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class Radio {
    private int numberOfStations = 10;
    private int currentStation;
    private int currentVolume;

    public Radio (int numberOfStations){
        this.numberOfStations = numberOfStations;
    }

    public void setCurrentStation(int stationNumber) {
        if (stationNumber >= 0 && stationNumber < numberOfStations) {
            currentStation = stationNumber;
        }
    }

    public void setCurrentVolume(int volumeLevel) {
        if (volumeLevel >= 0 && volumeLevel <= 100) {
            currentVolume = volumeLevel;
        }
    }

    public void nextStation() {
        if (currentStation == numberOfStations - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = numberOfStations - 1;
        } else {
            currentStation--;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

}
