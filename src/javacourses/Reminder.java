package javacourses;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;


public class Reminder extends Alarm {


    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String strDate = DATE_FORMATTER.format(date);
        return "Reminder{" +
                "id=" + getId() +
                ", Text= '" + getText() + '\'' +
                ", Time= '" + getTime() + '\'' +
                " date= '" + strDate + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        try {

            String strDate = Main.askString("write Reminder date(" + DATE_FORMAT + ") :");
            LocalDate date = LocalDate.parse(strDate, DATE_FORMATTER);
            setDate(date);
            super.askUserData();
        } catch (Exception e){
            System.out.println("wrong format !!!!");
            askUserData();
        }

    }

    @Override
    public boolean contains(String part) {
        String strDate = TIME_FORMATTER.format(date);
        return strDate.contains(part) || super.contains(part);
    }

}
