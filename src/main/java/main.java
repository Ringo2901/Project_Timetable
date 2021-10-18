import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //boolean firstRun = false;
        FileReader in = null;   //классы, хранящие инфу о том в какие файлы осуществляется ввод/вывод
        FileWriter out = null;

        File fileTimetable = new File("timetable.txt"), // файлы в которых хранятся данные
                fileMarks = new File("marks.txt"),
                fileTeachers = new File("teachers.txt");

        int functionNumber;    // номер выбранной команды
        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        System.out.println("Enter text");// вывод начального текста(можно также сделать из файла)

        functionNumber = input.nextInt(); // ввод номера функции
        //System.out.println(functionNumber);

        switch (functionNumber) {
            case  (1):
                break;
            default:
                System.out.println("This function isn't existing yet :(");
                break;
        }


    }

}