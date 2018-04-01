package javacourses;

public abstract class Note extends Record {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public String toString() {
//        return "Note{" +
//                "id=" + getId() +
//                ", Note= '" + text + '\'' +
//                '}';
//    }

//    @Override
//    public void askUserData() {
//        String text = Main.askString("write note(start \" and end \"): ");
//        setText(text);
//    }

//    @Override
//    public boolean contains(String part) {
//        return text.contains(part);
//    }
}
