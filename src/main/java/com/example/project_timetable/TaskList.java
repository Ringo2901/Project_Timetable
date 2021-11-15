package com.example.project_timetable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TaskList {
    private static String filePath = "src\\main\\resources\\tasks.txt";

    public static void addTask(Scanner input) throws IOException {
        //Scanner input = new Scanner(System.in); // Сканнер для ввода в консоль
        System.out.println("Enter your task");
        String deadline = "", task = "";
        while(task.isEmpty()) task = input.nextLine();
        System.out.println("Enter the deadline");
        while(deadline.isEmpty()) deadline = input.nextLine();
        int num = TaskList.getNum();

        String newTask = Integer.toString(num) + "|" + deadline + "|" + task;

        SecondaryFunctions.rewrite(filePath, num, newTask); // перезапись файла

        //input.close();
    }
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
    public static void deleteTask(Scanner input) throws IOException {
        //Scanner input = new Scanner(System.in); // Сканнер для ввода в консоль
        System.out.println("Enter number of the completed task");
        output();
        int num = input.nextInt();
        SecondaryFunctions.rewrite(filePath, num, "");
        System.out.println("Task deleted");
        //input.close();
    }
    public static void output() throws IOException {
        Scanner output = new Scanner (new File(filePath));

        while(output.hasNextLine()){
            String s = output.nextLine();
            int idx;
            String itemNum = "", deadline = "", task = "";
            for(idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) deadline += s.charAt(idx);
            idx++;
            for( ; idx < s.length(); idx++) task += s.charAt(idx);
            int itemLen = 3, deadlineLen = 8;
            System.out.print(itemNum + '.');
            for(int i = 0; i < itemLen - itemNum.length(); i++) {System.out.print(" ");}
            System.out.print(deadline);
            for(int i = 0; i < deadlineLen - deadline.length(); i++) {System.out.print(" ");}
            System.out.print(task);
            System.out.println();
        }
        output.close();
    }
}
