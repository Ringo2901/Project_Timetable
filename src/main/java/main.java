import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.*;

public class main {

    public static void main(String[] args) throws IOException {
        //boolean firstRun = false;
        FileReader in = null;   //классы, хранящие инфу о том в какие файлы осуществляется ввод/вывод
        FileReader out = null;

        File    fileMarks = new File("src\\main\\resources\\marks.txt"), // файлы в которых хранятся данные
                fileTeachers = new File("src\\main\\resources\\teachers.txt"),
                fileHometask = new File("src\\main\\resources\\hometask.txt"),
                fileTasks = new File("src\\main\\resources\\tasks.txt");

        int functionNumber;    // номер выбранной команды
        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        System.out.println("[Start text]");// вывод начального текста(можно также сделать из файла)
        System.out.println("Please enter the number of function");

        functionNumber = input.nextInt(); // ввод номера функции

        Choosing choosing = new Choosing();
        String r = choosing.cin (functionNumber);

        System.out.println(r);



    }


}