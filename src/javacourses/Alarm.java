package javacourses;

public class Alarm extends Note {
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
        String time = Main.askString("write Note time: ");
        setTime(time);
        String text = Main.askString("write note(start \" and end \"): ");
        setText(text);
    }

    @Override
    public boolean contains(String part) {
        String t = getText();
        return (time.contains(part) || t.contains(part));
    }
}
