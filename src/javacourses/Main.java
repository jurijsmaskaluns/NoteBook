package javacourses;

//import java.io.File;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    //    static File Records = new File("Records.txt");
    //static ArrayList<Record> records = new ArrayList<>();
    static HashMap<Integer, Record> recordsMap = new HashMap<>(); //assiotivnij spisok

    public static void main(String[] args) {
        commandLoop();
    }

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
                case "expired":
                    findExpired();
                    break;
                case "show":
                    showById();
                    break;
                default:
                    System.out.println("Unknown command");
            }

        }
    }

    private static void findExpired() {
        for (Record r : recordsMap.values()) {
            LocalTime now = LocalTime.now();
            if (r instanceof Alarm) { //prosmatrivaet record kotorij javljaetsja alarm (filjtr Alarmov)
                Alarm a = (Alarm) r; // peremennaja a tipa alarm v record r
                if (a.getTime().isBefore(now)) {
                    System.out.println(a);
                }
            }
        }
    }

    private static void help() {
        System.out.println("cmd: create\ncmd: list \ncmd: find \ncmd: expired \ncmd: show \ncmd: exit");
    }

    private static void list() {
        for (Record r : recordsMap.values()) {
            System.out.println(r);
        }
    }

    private static void showById() {
        for (; ; ) {
            try {
                String strPart = askString("What ID? ");
                int part = Integer.valueOf(strPart);
                Record r = recordsMap.get(part);
                break;
            } catch (Exception e) {
                System.out.println("not number !!!");
            }
        }

    }

    private static void find() {
        String part = askString("What to find? ");
        for (Record r : recordsMap.values()) {
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
                    helpCreate();
                    break;
                case "person":
                    addRecord(new Person());
                    return;
                case "note":
                    addRecord(new Note());
                    return;
                case "alarm":
                    addRecord(new Alarm());
                    return;
                case "reminder":
                    addRecord(new Reminder());
                    return;
                default:
                    System.out.println("Unknown command in create");
            }
        }

    }

    private static void addRecord(Record record) {
        record.askUserData();
        int id = record.getId();
        recordsMap.put(id, record);
        System.out.println("created!");
    }

    private static void helpCreate() {
        System.out.println("cmd: person\ncmd: note \ncmd: alarm \ncmd: reminder \ncmd: exit");
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
