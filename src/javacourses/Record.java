package javacourses;

public abstract class Record {
    private static int counter = 0; // dlja vseh person counter odin
    private int id;

    public Record() {
        counter++;
        id = counter;
    }

    public int getId() {
        return id;
    }

    public abstract void askUserData();

    public abstract boolean contains(String part);
}
