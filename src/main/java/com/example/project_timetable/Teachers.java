package com.example.project_timetable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * This class works with information about teachers
 */
public class Teachers {
    /**
     * * filePath - path to the file where the input data is written
     */
    private static String filePath = "src\\main\\resources\\teachers.txt";
    /**
     * NAME - the line where the teacher's name is written,
     * SUBJECT - the line where the subject is written,
     * INF - the line where the information about teacher is written
     */
    private static String NAME, SUBJECT, INF;
    /**
     * NUM - the number of the line into which the next is written
     */
    private static int NUM;
    /**
     * The method assigns the entered teacher's name to the string
     * @param s a string that accepts the entered value
     */
    public static void setName(String s){
        NAME = s;
    }
    /**
     * The method assigns the entered information about teacher to the string
     * @param s a string that accepts the entered value
     */
    public static void setInf(String s){
        INF = s;
    }
    /**
     * The method assigns the entered subject to the string
     * @param s a string that accepts the entered value
     */
    public static void setSubject(String s){
        SUBJECT = s;
    }
    private static boolean CORRECTNESS;
    /**
     * The method assigns the number of the line into which the next is written to the string
     * @param s a string that accepts the value
     */

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
    /**
     * The method writes task like a string in format "num|name|subject|inf" to a file
     */
    public static void addTeacher() throws IOException {
        String newTeacher = Integer.toString(NUM) + "|" + NAME + "|" + SUBJECT + "|" + INF;
        SecondaryFunctions.rewrite(filePath, NUM, newTeacher); // перезапись файла
        //input.close();
    }


    /**
     * The method reads information from a file, generates lines for output, outputs lines in format "Num. Name Subject ContactInf"
     * @return res teacher output string
     */
    public static String StringOutput() throws IOException {
        Scanner output = new Scanner (new File(filePath));
        String res = "";
        while(output.hasNextLine()){
            String s = output.nextLine();
            int idx;
            String itemNum ="", Name = "", subject = "", contactInf = "";
            for(idx = 0; idx < s.length() && s.charAt(idx) != '|'; idx++) itemNum += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) Name += s.charAt(idx);
            idx++;
            for( ; idx < s.length() && s.charAt(idx) != '|'; idx++) subject += s.charAt(idx);
            idx++;
            for( ; idx < s.length(); idx++) contactInf += s.charAt(idx);

            int  NumLen = 3, NameLen = 30, subjectLen = 15;
            String point = "";
            if(idx > 3) point = ".";
            res += itemNum + point;
            for(int i = 0; i < NumLen - itemNum.length(); i++) res+=" ";
            res += Name;
            for(int i = 0; i < NameLen - Name.length(); i++) res+=" ";
            res += subject;
            for(int i = 0; i < subjectLen - subject.length(); i++)res+=" ";
            res += contactInf;

            res += "\n";
        }
        output.close();
        return res;
    }

    /**
     * The method delete selected line
     * @param num the number of deleted line
     */
    public static void deleteTeacher(int num) throws IOException {
        SecondaryFunctions.rewrite(filePath, num, "");
    }
}