package javacourses;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reminder extends Alarm {


    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private LocalTime date;

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() +
                ", Text= '" + getText() + '\'' +
                ", Time= '" + getTime() + '\'' +
                " date= '" + date + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        String strDate = Main.askString("write Reminder date(" + DATE_FORMAT + "): ");
        LocalTime date = LocalTime.parse(strDate, DATE_FORMATTER);
        setDate(date);
        super.askUserData();

    }

    @Override
    public boolean contains(String part) {
        String strDate = TIME_FORMATTER.format(date);
        return strDate.contains(part) || super.contains(part);
    }

}
