package com.example.project_timetable;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * class works with information about teachers
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
     * setName the method assigns the entered teacher's name to the string
     * @param s a string that accepts the entered value
     */
    public static void setName(String s){
        NAME = s;
    }
    /**
     * setInf the method assigns the entered information about teacher to the string
     * @param s a string that accepts the entered value
     */
    public static void setInf(String s){
        INF = s;
    }
    /**
     * setSubject the method assigns the entered subject to the string
     * @param s a string that accepts the entered value
     */
    public static void setSubject(String s){
        SUBJECT = s;
    }
    /**
     * setNum the method assigns the number of the line into which the next is written to the string
     * @param s a string that accepts the value
     */
    public static void setNum(String s){
        NUM = Integer.parseInt(s);
    }
    /**
     * addTeacher the method writes task like a string in format "num|name|subject|inf" to a file
     */
    public static void addTeacher() throws IOException {
        String newTeacher = Integer.toString(NUM) + "|" + NAME + "|" + SUBJECT + "|" + INF;
        SecondaryFunctions.rewrite(filePath, NUM, newTeacher); // перезапись файла
        //input.close();
    }

    private static int getNum() throws IOException {
        /*Scanner sc = new Scanner(new File(filePath));
        int idx = 1;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.length() == 0) return idx;
            idx++;
        }
        sc.close();
        return idx;*/
    }
    /**
     * StringOutput the method reads information from a file, generates lines for output, outputs lines in format "Num. Name Subject ContactInf"
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
            res += itemNum + ".";
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
}