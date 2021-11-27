package com.example.project_timetable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class works with task
 * @author Igor Baran
 * @version 2.0
 */
public class TaskList {
    /**
     * filePath - path to the file where the input data is written
     */
    private static String filePath = "src\\main\\resources\\tasks.txt";
    /**
     * DEADLINE - the line where the deadline is written,
     * TASK - the line where the task is written,
     */
    private static String DEADLINE, TASK;
    /**
     * The method assigns the entered deadline to the string
     * @param s a string that accepts the entered value
     */
    public static void setDeadline(String s){
        DEADLINE = s;
    }
    /**
     * The method assigns the entered task to the string
     * @param s a string that accepts the entered value
     */
    public static void setTask(String s){
        TASK = s;
    }
    /**
     * The method writes task like a string in format "num|subject|deadline|hometask" to a file
     */
    public static void addTask() throws IOException {
        int num = TaskList.getNum();
        String newTask = num + "|" + DEADLINE + "|" + TASK;
        SecondaryFunctions.rewrite(filePath, num, newTask); // перезапись файла
        //input.close();
    }

    /**
     * The method counts the number of lines written and returns the line number we are writing
     * @return idx the line number we are writing
     */
    private static int getNum() throws IOException {
        Scanner sc = new Scanner(new File(filePath));
        int idx = 1;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.length() == 0) return idx;
            idx++;
        }
        sc.close();
        return idx;
    }
    /*
    public static void deleteTask(Scanner input) throws IOException {
        Scanner input = new Scanner(System.in); // Сканнер для ввода в консоль
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("Введите номер выполненного задания.");
            while (!sc.hasNextInt()) {
                System.out.println("Данное выражение не является номером задания. Введите число!");
                sc.next(); // this is important!
            }
            num = sc.nextInt();
        } while (num <= 0);

        SecondaryFunctions.rewrite(filePath, num, "");
        System.out.println("Задание удалено.");
        //input.close();
    }*/
    /**
     * The method reads information from a file, generates lines for output, outputs lines in format "Num.Deadline Task"
     * @return res task output string
     */
    public static String StringOutput() throws IOException{
        Scanner output = new Scanner (new File(filePath));
        String res = "";
        for(int j = 0; output.hasNextLine(); j++){
            String s = output.nextLine();
            int idx;
            String itemNum = "", deadline = "", task = "";
            for(idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) deadline += s.charAt(idx);
            idx++;
            for( ; idx < s.length(); idx++) task += s.charAt(idx);
            int itemLen = 3, deadlineLen = 16;

            String point = "";
            if(idx > 2) point = ".";
            res += itemNum + point;
            for(int i = 0; i < itemLen - itemNum.length(); i++) res += " ";
            res += deadline;
            for(int i = 0; i < deadlineLen - deadline.length(); i++) res += " ";
            res += task + "\n";
        }
        output.close();
        return res;
    }
    /*
    public static void addTask(Scanner input) throws IOException {
        //Scanner input = new Scanner(System.in); // Сканнер для ввода в консоль
        System.out.println("Введите свою задачу.");
        String deadline = "", task = "";
        while(task.isEmpty()) task = input.nextLine();
        System.out.println("Введите срок исполнения.");
        while(deadline.isEmpty()) deadline = input.nextLine();
        int num = TaskList.getNum();

        String newTask = Integer.toString(num) + "|" + deadline + "|" + task;

        SecondaryFunctions.rewrite(filePath, num, newTask); // перезапись файла

        //input.close();
    }*/
    public static void deleteTask(int num) throws IOException {
        SecondaryFunctions.rewrite(filePath, num, "");
    }
}
