// Name: Pallav Regmi
// Class: 2251: A02
// Assignment:  To Read in the data,
//              organize the data with a dedicated object and an ArrayList to hold instances of those objects,
//              calculate maximum difference in AverageTravelTime,
//              and finally Display results on command prompt and also output the results to a text file,
// Purpose: Working on file reading, creating and also OOP
// Filename: TravelTimeData.java

public class TravelTimeData {
    private int cogId;
    private int travelTime1;
    private String direction1;
    private int travelTime2;
    private String direction2;

    public TravelTimeData(int cogId, int travelTime1, String direction1, int travelTime2, String direction2) {
        this.cogId = cogId;
        this.travelTime1 = travelTime1;
        this.direction1 = direction1;
        this.travelTime2 = travelTime2;
        this.direction2 = direction2;
    }

    public int getCogId() {
        return cogId;
    }

    public int getTravelTime1() {
        return travelTime1;
    }

    public String getDirection1() {
        return direction1;
    }

    public int getTravelTime2() {
        return travelTime2;
    }

    public String getDirection2() {
        return direction2;
    }

    public int getTravelTimeDifference() {
        return travelTime2 - travelTime1;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-4s %-6d %-4s %-6d", cogId, direction1, travelTime1, direction2, travelTime2);
    }
}
