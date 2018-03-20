package javacourses;

//import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    //    static File Records = new File("Records.txt");
    static ArrayList<Person> records = new ArrayList<>();


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
                case "list":
                    list();
                case "create":
                    create();
                    break;
                default:
                    System.out.println("Unknown command");
            }

        }
    }

    private static void list() {
        for (Person p : records) {
            System.out.println(p);
        }
    }

    private static void create() {
        for (; ; ) {
            String type = askString("what wont to create? ");
            switch (type.toLowerCase()) {
                case "exit":
                    return;
                case "person":
                    createPerson();
                    return;
                default:
                    System.out.println("Unknown command in create");
            }
        }

    }

    private static void createPerson() {
        Person person = new Person();

        System.out.print("First name: ");
        person.setFirstName(scanner.next()); //s4itivaet i kladjot v klass person imja

        System.out.print("Second name: ");
        person.setLastName(scanner.next());

        System.out.print("phone: ");
        person.setPhone(scanner.next());

        records.add(person);

    }
    private static String askString(String message){
        System.out.print(message);
        return scanner.next();
    }
}
