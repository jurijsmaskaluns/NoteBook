package javacourses;

public class Alarm extends Note {
    private String time;
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() +
                ", Time= '" + time + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        String time = Main.askString("write Alarm time: ");
        setTime(time);
    }

    @Override
    public boolean contains(String part) {
        return time.contains(part);
    }
}
