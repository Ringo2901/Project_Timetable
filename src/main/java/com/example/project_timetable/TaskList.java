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
    private static boolean CORRECTNESS;
    private static int NUM;
    public static void setNum(String s) throws IOException {
        if(SecondaryFunctions.isDigit(s)){
            NUM = Integer.parseInt(s);
            if(NUM <= SecondaryFunctions.getNum(filePath)) CORRECTNESS = true;
            else CORRECTNESS = false;
        }
        else CORRECTNESS = false;

    }
    public static boolean isCorrect(){
        return CORRECTNESS;
    }
    public static void addTask() throws IOException {
        //int num = TaskList.getNum();
        String newTask = NUM + "|" + DEADLINE + "|" + TASK;
        SecondaryFunctions.rewrite(filePath, NUM, newTask); // перезапись файла

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

    /**
     * The method delete selected line
     * @param num the number of deleted line
     */
    public static void deleteTask(int num) throws IOException {
        SecondaryFunctions.rewrite(filePath, num, "");
    }
}
