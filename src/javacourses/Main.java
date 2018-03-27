package javacourses;

//import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    //    static File Records = new File("Records.txt");
    static ArrayList<Record> records = new ArrayList<>();


    public static void main(String[] args) {
        commandLoop();
    }

    // write your code here


    private static void commandLoop() {
        for (; ; ) {
            String cmd = askString("cmd -> ");
            switch (cmd.toLowerCase()) {
                case "exit":
                    return;
                case "help":
                    help();
                    break;
                case "list":
                    list();
                    break;
                case "create":
                    create();
                    break;
                case "find":
                    find();
                    break;
                default:
                    System.out.println("Unknown command");
            }

        }
    }

    private static void help() {
        System.out.println("cmd: create\ncmd: list \ncmd: exit");
    }

    private static void list() {
        for (Record r : records) {
            System.out.println(r);
        }
    }

    private static void find() {
        String part = askString("What to find? ");
        for (Record r : records) {
            if (r.contains(part)) {
                System.out.println(r);
            }
        }
    }

    private static void create() {
        for (; ; ) {
            String type = askString("what wont to create? ");
            switch (type.toLowerCase()) {
                case "exit":
                    return;
                case "help":
                    helpC();
                    break;
                case "person":
                    addRecord(new Person());
                    return;
                case "note":
                    addRecord(new Note());
                    return;
                default:
                    System.out.println("Unknown command in create");
            }
        }

    }

    private static void addRecord(Record record) {
        record.askUserData();
        records.add(record);
        System.out.println("created!");
    }

    private static void helpC() {
        System.out.println("cmd: person\ncmd: note \ncmd: exit");
    }
//    private static void noteX(){
//        String text = askString("write note(start \" and end \"): ");
//        Note note = new Note();
//        note.setText(text);
//        records.add(note);
//    }

    //   private static void createPerson() {
//      String firstName = askString("First Name: ");
//        String lastName = askString("Last Name: ");
//        String phone = askString("Phone: ");
//        String email = askString("email: ");
///        Person person = new Person();
//        person.setFirstName(firstName);
//        person.setLastName(lastName);
//        person.setPhone(phone);
//        person.setEmail(email);
//
//        records.add(person);
//    }
    public static String askString(String message) {
        System.out.print(message);

        String str = scanner.next();
        if (str.startsWith("\"")) {
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            while (!str.endsWith("\"")) {
                str = scanner.next();
                list.add(str);
            }
            str = String.join(" ", list);
            str = str.substring(1, str.length() - 1); // udaljaem kavi4ki v na4ale i v konce
        }

        return str;
    }
}
