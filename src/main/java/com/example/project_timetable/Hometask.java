package com.example.project_timetable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Hometask {private static String filePath = "src\\main\\resources\\hometask.txt";

    public static void addHometask(Scanner input) throws IOException {
        //Scanner input = new Scanner(System.in); // Сканнер для ввода в консоль
        String subject = "", hometask = "", deadline = "";
        System.out.println("Enter subject");
        while(subject.isEmpty()) subject = input.nextLine();
        System.out.println("Enter deadline");
        while(deadline.isEmpty()) deadline = input.nextLine();
        System.out.println("Enter the hometask");
        while(hometask.isEmpty()) hometask = input.nextLine();
        int num = Hometask.getNum();

        String newHometask = Integer.toString(num) + "|" + subject + "|" + deadline + "|" + hometask;

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
        //Scanner input = new Scanner(System.in); // Сканнер для ввода в консоль
        System.out.println("Enter number of the completed hometask");
        output();
        int num = input.nextInt();
        SecondaryFunctions.rewrite(filePath, num, "");
        System.out.println("Hometask deleted");
        //input.close();
    }

    public static void output() throws IOException {
        Scanner output = new Scanner (new File(filePath));

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
            int itemLen = 3, subjectLen = 10, deadlineLen = 8;
            System.out.print(itemNum + '.');
            for(int i = 0; i < itemLen - itemNum.length(); i++) {System.out.print(" ");}
            System.out.print(subject);
            for(int i = 0; i < subjectLen - subject.length(); i++) {System.out.print(" ");}
            System.out.print(deadline);
            for(int i = 0; i < deadlineLen - deadline.length(); i++) {System.out.print(" ");}
            System.out.print(hometask);
            System.out.println();
        }
        output.close();
    }

}