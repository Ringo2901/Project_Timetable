package com.example.project_timetable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * This class works with information about timetable
 */
public class Timetable {
    /**
     * filePath - path to the file where the input data is written
     */
    private static String filePathBeginning = "src\\main\\resources\\week_days";
    /**
     * DAY - the line where the day of week is written,
     * SUBJECT - the line where the subject is written,
     * TEACHER - the line where the teacher's name is written
     */
    private static String DAY, SUBJECT, TEACHER;
    /**
     * ITEMNUM - the number of the line into which the next is written
     */
    private static int ITEMNUM, NUMOFWEEK = 1;
    /**
     * The method assigns the entered day of week to the string
     * @param s a string that accepts the entered value
     */
    public static void setDay(String s){
        DAY = s;
    }
    /**
     * The method assigns the entered subject to the string
     * @param s a string that accepts the entered value
     */
    public static void setSubject(String s){
        SUBJECT = s;
    }
    /**
     * The method assigns the entered teacher's name to the string
     * @param s a string that accepts the entered value
     */
    public static void setTeacher(String s){
        TEACHER = s;
    }

    /**
     * The method assigns the number of the line into which the next is written to the string
     * @param n a number of string that accepts the value
     */
    private static boolean CORRECTNESS;

    public static void setItemNum(String s) throws IOException {

        if(SecondaryFunctions.isDigit(s)){
            ITEMNUM = Integer.parseInt(s);
            CORRECTNESS = true;
        }
        else CORRECTNESS = false;

    }
    public static boolean isCorrect(){
        return CORRECTNESS;
    }

    public static void setNumOfWeek(int n){
        NUMOFWEEK = n;
    }

    /**
     * The method selects the name of the day of the week by its number
     * @param num a number of entered day of week
     * @return result a string - name of day of week
     */
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
    /**
     * The method selects the number of the day of the week by its name
     * @param s the name of day of week
     * @return result the number of day of week
     */
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
    /**
     * The method reads information from a file, generates lines for output, outputs lines in format "Num. Name Subject ContactInf"
     * @return res timetable output string
     */
    public static String StringOutput(int numOfWeek) throws IOException {
        String res = "";
        for(int dayNum = 1; dayNum <= 7; dayNum++){
            String filePath = "src\\main\\resources\\week_days" + Integer.toString(numOfWeek) + "\\" + Integer.toString(dayNum) + ".txt";
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
                String point = "";
                if(idx > 2) point = ".";
                res += itemNum + point;
                for(int i = 0; i < itemLen - itemNum.length(); i++) res += " ";
                res += subject;
                for(int i = 0; i < subjectLen - subject.length(); i++) res += " ";
                res += teacher + "\n";
            }
            output.close();
        }
        return res;
    }

    /**
     * The method changes timetable
     */
    public static void changeTimetableItem() throws IOException {//
        Scanner sc = new Scanner (System.in);
        String filePath = filePathBeginning + Integer.toString(NUMOFWEEK) + "\\" + Integer.toString(numOfDay(DAY)) + ".txt";
        String lessonName = "";
        String teacherName = "";
        String newItem = Integer.toString(ITEMNUM) + "|" + SUBJECT + "|" + TEACHER;
        SecondaryFunctions.rewriteTimetable(filePath, ITEMNUM, newItem); // перезапись файла
        newContact();
        newMarkSubject();
        sc.close();
    }
    public static void newContact() throws IOException {
        Teachers.setNum(Integer.toString(SecondaryFunctions.getNum("src\\main\\resources\\teachers.txt")));
        Teachers.setSubject(SUBJECT);
        Teachers.setName(TEACHER);
        Teachers.setInf("-");
        Teachers.addTeacher();
    }
    public static void newMarkSubject() throws IOException {
        Marks.setSubject(SUBJECT);
        Marks.setMarks("");
        Marks.setNum(Integer.toString(SecondaryFunctions.getNum("src\\main\\resources\\marks.txt")));
        Marks.addMarks();
    }

    /**
     * The method delete selected subject
     * @param day the number of day
     * @param num the number of deleted subject
     */
    public static void deleteTimetableItem(String day, int numOfWeek, int num) throws IOException {
        SecondaryFunctions.rewriteTimetable(filePathBeginning + Integer.toString(numOfWeek) + "\\"  + numOfDay(day) + ".txt", num, "");
    }

}