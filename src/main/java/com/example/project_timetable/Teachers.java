package com.example.project_timetable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Teachers {
    private static String filePath = "src\\main\\resources\\teachers.txt";
    public static void addTeacher(Scanner input) throws IOException {
        // Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        String name = "", subject = "", contactInf = "";
        System.out.println("Enter the teacher's name");
        while(name.isEmpty()) name = input.nextLine();
        System.out.println("Enter the subject");
        while(subject.isEmpty())subject = input.nextLine();
        System.out.println("Enter the contact information");
        while(contactInf.isEmpty()) contactInf = input.nextLine();

        int num = Teachers.getNum();

        String newTeacher = Integer.toString(num) + "|" + name + "|" + subject + "|" + contactInf;

        SecondaryFunctions.rewrite(filePath, num, newTeacher); // перезапись файла

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
    public static void output() throws IOException {
    }
}