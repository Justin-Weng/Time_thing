import java.util.ArrayList;

public class Time {
    private ArrayList <Integer> divisions = new ArrayList<>();
    private int seconds;

    public Time(int h, int m, int s) {
        seconds = 0;
        seconds += h * 3600;
        seconds += m * 60;
        seconds += s;
        divisions.add(3600);
        divisions.add(60);
    }

    public void tick() {
        seconds++;
    }

    public int getSeconds() {
        return seconds;
    }

    public void add(Time time) {
        seconds += time.getSeconds();
    }

    public String info() {
        int remaining = seconds % 86400;
        String returnString = "";

        for (int i = 0; i < divisions.size(); i++) {
            if (remaining / divisions.get(i) >= 10) {
                returnString += remaining / divisions.get(i) + ":";
            } else {
                returnString += "0" + remaining / divisions.get(i) + ":";
            }
            remaining = remaining % divisions.get(i);
        }

        if (remaining >= 10) {
            returnString += remaining;
        } else {
            returnString += "0" + remaining;
        }

        return returnString;
    }
}