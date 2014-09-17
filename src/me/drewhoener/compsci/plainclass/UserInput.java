package me.drewhoener.compsci.plainclass;

import java.util.Scanner;

public class UserInput {
    Scanner scan;
    boolean running = true;

    public UserInput() {
        scan = new Scanner(System.in);
    }

    public static void main(String[] args) {
        UserInput ui = new UserInput();
        ui.welcome();
        while (ui.running) {
            try {
                ui.readWrite();
            } catch (Exception e) {
                ui.newMessage("Couldn't find the next line in the console!");
            }
        }
    }

    public void readWrite() {

        newMessage("Input anything to have it printed back");
        String readLine = scan.nextLine();
        if (readLine.equalsIgnoreCase("stop")) {
            newMessage("Program stopping...");
            running = false;
            newMessage("Program Stopped.");
            scan.close();
            return;
        }

        /*
        * Default Input/Output
        * */
        newMessage("You input: " + readLine);
    }

    public void welcome() {
        running = false;
        newPrint("Enter your first name: ");
        String name1 = scan.nextLine();
        String name2;
        newPrint("Enter your last name: ");
        name2 = scan.nextLine();
        System.out.println(name1 + " " + name2);
        newMessage("Welcome! Moving on to main reader...");
        running = true;
    }

    public void newPrint(String s) {
        System.out.print(s);
    }

    public void newMessage(String s) {
        System.out.println(s);
    }

}
