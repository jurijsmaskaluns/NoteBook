package javacourses;

public class Note extends Record {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return "Note{" +
                "id=" + getId() +
                ", Text= '" + text + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        String text = Main.askString("write text(start \" and end \"): ");
        setText(text);
    }

    @Override
    public boolean contains(String part) {
        return text.contains(part);
    }
}
