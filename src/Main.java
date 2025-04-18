import java.time.format.DateTimeParseException;
import java.util.Scanner;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[]args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filepath = "mixkit-classic-alarm-995.wav";

        while (alarmTime == null) {
            try {
                System.out.println("Enter an alarm time (HH:MM:SS)");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime);

            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. please use HH:MM:SS");

            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filepath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();


    }
}