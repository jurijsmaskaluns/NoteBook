package javacourses;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Alarm extends Note {
    public static final String TIME_FORMAT = "HH:mm";
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() +
                ", Text= '" + getText() + '\'' +
                ", Time= '" + time + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        try {
            String strTime = Main.askString("write time(" + TIME_FORMAT + "): ");
            LocalTime time = LocalTime.parse(strTime, TIME_FORMATTER);
            setTime(time);
            super.askUserData();
        }catch (Exception e){
            System.out.println("wrong format !!!!");
        }
    }

    @Override
    public boolean contains(String part) {
        String strTime = TIME_FORMATTER.format(time); //vremja konvertiruetsja v stroku
        return strTime.contains(part) || super.contains(part);
    }
}
