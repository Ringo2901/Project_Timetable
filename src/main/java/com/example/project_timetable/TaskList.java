package com.example.project_timetable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TaskList {
    private static String filePath = "src\\main\\resources\\tasks.txt";
    private static String DEADLINE, TASK;
    public static void setDeadline(String s){
        DEADLINE = s;
    }
    public static void setTask(String s){
        TASK = s;
    }

    public static void addTask() throws IOException {

        int num = TaskList.getNum();

        String newTask = Integer.toString(num) + "|" + DEADLINE + "|" + TASK;

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
       /* //Scanner input = new Scanner(System.in); // Сканнер для ввода в консоль
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
        //input.close();*/
    }

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

            res += itemNum + ".";
            for(int i = 0; i < itemLen - itemNum.length(); i++) res += " ";
            res += deadline;
            for(int i = 0; i < deadlineLen - deadline.length(); i++) res += " ";
            res += task + "\n";
        }
        output.close();
        return res;
    }
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
    }
}
