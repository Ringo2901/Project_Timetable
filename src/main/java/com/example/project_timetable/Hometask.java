package com.example.project_timetable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Hometask {
    private static String filePath = "src\\main\\resources\\hometask.txt";
    private static String DEADLINE, HOMETASK, SUBJECT;
    public static void setDeadline(String s){
        DEADLINE = s;
    }
    public static void setHometask(String s){
        HOMETASK = s;
    }
    public static void setSubject(String s){
        SUBJECT = s;
    }

    public static void addHometask() throws IOException {
        int num = Hometask.getNum();

        String newHometask = Integer.toString(num) + "|" + SUBJECT + "|" + DEADLINE + "|" + HOMETASK;

        SecondaryFunctions.rewrite(filePath, num, newHometask); // перезапись файла

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



    public static void deleteHometask(Scanner input) throws IOException {
        /*//Scanner input = new Scanner(System.in); // Сканнер для ввода в консоль
        System.out.println("Введите номер выплненного задания.");
        output();
        int num = input.nextInt();
        SecondaryFunctions.rewrite(filePath, num, "");
        System.out.println("Выполненное задание удалено.");
        //input.close();*/
    }

    public static String StringOutput() throws IOException{
        Scanner output = new Scanner (new File(filePath));
        String res = "";
        while(output.hasNextLine()){
            String s = output.nextLine();
            int idx;
            String itemNum = "", subject = "", deadline = "", hometask = "";
            for(idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) subject += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) deadline += s.charAt(idx);
            idx++;
            for( ; idx < s.length(); idx++) hometask += s.charAt(idx);
            int itemLen = 3, subjectLen = 15, deadlineLen = 16;
            res += itemNum + '.';
            for(int i = 0; i < itemLen - itemNum.length(); i++) res += " ";
            res += subject;
            for(int i = 0; i < subjectLen - subject.length(); i++) res += " ";
            System.out.println(subjectLen - subject.length());
            res += deadline;
            for(int i = 0; i < deadlineLen - deadline.length(); i++) res += " ";
            res += hometask + "\n";
            System.out.println();
        }
        return res;
    }

}