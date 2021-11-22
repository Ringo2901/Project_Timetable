package com.example.project_timetable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Timetable {
    private static String filePathBeginning = "src\\main\\resources\\week_days\\";
    public static void changeTimetableItem(Scanner input) throws IOException {

        //Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        Scanner sc = new Scanner (System.in);
        int dayNum;
        do {
            System.out.println("Введите число - номер дня недели.");
            while (!sc.hasNextInt()) {
                System.out.println("Данное выражение не является номером дня недели. Введите число!");
                sc.next(); // this is important!
            }
            dayNum = sc.nextInt();
        } while (dayNum < 1 || dayNum > 7);

        int itemNum;
        do {
            System.out.println("Введите номер предмета в расписании.");
            while (!sc.hasNextInt()) {
                System.out.println("Данное выражение не является номером предмета. Введите число!");
                sc.next(); // this is important!
            }
            itemNum = sc.nextInt();
        } while (itemNum < 1 || itemNum > 7);
        String filePath = filePathBeginning + Integer.toString(dayNum) + ".txt";
        String lessonName = "";
        String teacherName = "";
        System.out.println("Введите название предмета.");
        while(lessonName.isEmpty()) lessonName = input.nextLine(); //ожидание ввода названия предмета
        System.out.println("Введите ФИО преподавателя");
        while(teacherName.isEmpty()) teacherName = input.nextLine(); //ожидание ввода фамилии преподаватель



        String newItem = Integer.toString(itemNum) + "|" + lessonName + "|" + teacherName;
        SecondaryFunctions.rewrite(filePath, itemNum, newItem); // перезапись файла

        //input.close();
    }
    private static String dayOfWeek(int num){
        String result = "";
        switch (num) {
            case  (1): result = "Понедельник";
                break;
            case  (2): result = "Вторник";
                break;
            case  (3): result = "Среда";
                break;
            case  (4): result = "Четверг";
                break;
            case  (5): result = "Пятница";
                break;
            case  (6): result = "Суббота";
                break;
            case  (7): result = "Воскресенье";
                break;
            default:
                result = "ERROR";
                break;
        }
        return result;
    }
    public static void output() throws IOException {
        for(int dayNum = 1; dayNum <= 7; dayNum++){
            String filePath = "src\\main\\resources\\week_days\\" + Integer.toString(dayNum) + ".txt";
            Scanner output = new Scanner (new File(filePath));
            System.out.print(dayOfWeek(dayNum) + " :" + "\n");

            while(output.hasNextLine()){
                String s = output.nextLine();
                int idx;
                String itemNum = "", teacher = "", subject = "";
                for(idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
                idx++;
                for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) subject += s.charAt(idx);
                idx++;
                for( ; idx < s.length(); idx++) teacher += s.charAt(idx);

                int itemLen = 4, subjectLen = 10;
                System.out.print(itemNum + '.');
                for(int i = 0; i < itemLen - itemNum.length(); i++) System.out.print(" ");
                System.out.print(subject);
                for(int i = 0; i < subjectLen - subject.length(); i++) System.out.print(" ");
                System.out.print(teacher);
                System.out.println();

            }
            output.close();
        }

    }

}