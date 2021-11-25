package com.example.project_timetable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Timetable {
    private static String filePathBeginning = "src\\main\\resources\\week_days\\";
    private static String DAY, SUBJECT, TEACHER;
    private static int ITEMNUM;
    public static void setDay(String s){
        DAY = s;
    }
    public static void setSubject(String s){
        SUBJECT = s;
    }
    public static void setTeacher(String s){
        TEACHER = s;
    }
    public static void setItemNum(int n){
        ITEMNUM = n;
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
    private static int numOfDay(String s){
        int result;
        switch (s) {
            case  ("Пн"): result = 1;
                break;
            case  ("Вт"): result = 2;
                break;
            case  ("Ср"): result = 3;
                break;
            case  ("Чт"): result = 4;
                break;
            case  ("Пт"): result = 5;
                break;
            case  ("Сб"): result = 6;
                break;
            case  ("Вс"): result = 7;
                break;
            default:
                result = 1;
                break;
        }
        return result;
    }

    public static String StringOutput() throws IOException {
        String res = "";
        for(int dayNum = 1; dayNum <= 7; dayNum++){
            String filePath = "src\\main\\resources\\week_days\\" + Integer.toString(dayNum) + ".txt";
            Scanner output = new Scanner (new File(filePath));
            res += dayOfWeek(dayNum) + " :" + "\n";

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
                res += itemNum + '.';
                for(int i = 0; i < itemLen - itemNum.length(); i++) res += " ";
                res += subject;
                for(int i = 0; i < subjectLen - subject.length(); i++) res += " ";
                res += teacher + "\n";

            }
            output.close();
        }
        return res;
    }
    public static void changeTimetableItem() throws IOException {

        Scanner sc = new Scanner (System.in);

        String filePath = filePathBeginning + Integer.toString(numOfDay(DAY)) + ".txt";
        String lessonName = "";
        String teacherName = "";


        String newItem = Integer.toString(ITEMNUM) + "|" + SUBJECT + "|" + TEACHER;
        SecondaryFunctions.rewrite(filePath, ITEMNUM, newItem); // перезапись файла

        sc.close();
    }

}