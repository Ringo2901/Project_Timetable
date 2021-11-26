package com.example.project_timetable;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class works with hometask
 * @author Igor Baran
 * @version 3.0
 */
public class Hometask {
    /**
     * filePath - path to the file where the input data is written
     */
    private static String filePath = "src\\main\\resources\\hometask.txt";
    /**
     * DEADLINE - the line where the deadline is written,
     * HOMETASK - the line where the hometask is written,
     * SUBJECT - the line where the subject is written
     */
    private static String DEADLINE, HOMETASK, SUBJECT;

    /**
     * setDeadline the method assigns the entered deadline to the string
     * @param s a string that accepts the entered value
     */
    public static void setDeadline(String s){
        DEADLINE = s;
    }
    /**
     * setHometask the method assigns the entered hometask to the string
     * @param s a string that accepts the entered value
     */
    public static void setHometask(String s){
        HOMETASK = s;
    }

    /**
     * setSubject the method assigns the entered subject to the string
     * @param s a string that accepts the entered value
     */
    public static void setSubject(String s){
        SUBJECT = s;
    }

    /**
     * addHometask the method writes hometask like a string in format "num|subject|deadline|hometask" to a file
     */
    public static void addHometask() throws IOException {
        int num = Hometask.getNum();
        String newHometask = num + "|" + SUBJECT + "|" + DEADLINE + "|" + HOMETASK;
        SecondaryFunctions.rewrite(filePath, num, newHometask); // перезапись файла
        //input.close();
    }

    /**
     * getNum the method counts the number of lines written and returns the line number we are writing
     * @return idx the line number we are writing
     */
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

    /**
     * StringOutput the method reads information from a file, generates lines for output, outputs lines in format "Num.Subject Deadline Hometask"
     * @return res homework output string
     */
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