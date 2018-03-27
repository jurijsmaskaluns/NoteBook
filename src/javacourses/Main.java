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
                case "help":
                    help();
                    break;
                case "list":
                    list();
                    break;
                case "create":
                    create();
                    break;
                default:
                    System.out.println("Unknown command");
            }

        }
    }
    private static void help(){
        System.out.println("cmd: create(person)\ncmd: list \ncmd: exit");
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
        String firstName = askString("First Name: ");
        String lastName = askString("Last Name: ");
        String phone = askString("Phone: ");
        String email = askString("email: ");

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhone(phone);
        person.setEmail(email);

        records.add(person);
    }
    private static String askString(String message){
        System.out.print(message);

        String str = scanner.next();
        if (str.startsWith("\"")){
            ArrayList<String> list = new ArrayList<>();
            list.add(str);
            while (!str.endsWith("\"")){
                str = scanner.next();
                list.add(str);
            }
            str = String.join(" ", list);
            str = str.substring(1, str.length()-1); // udaljaem kavi4ki v na4ale i v konce
        }

        return str;
    }
}
