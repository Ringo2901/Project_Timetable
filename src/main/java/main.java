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

        File fileTimetable = new File("src\\main\\resources\\timetable.txt"), // файлы в которых хранятся данные
                fileMarks = new File("src\\main\\resources\\marks.txt"),
                fileTeachers = new File("src\\main\\resources\\teachers.txt");

        int functionNumber;    // номер выбранной команды
        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        System.out.println("Enter text");// вывод начального текста(можно также сделать из файла)

        functionNumber = input.nextInt(); // ввод номера функции

        switch (functionNumber) {       //выбор функции пользователем
            case  (1):
                break;
            default:
                System.out.println("This function isn't existing yet :(");
                break;
        }


    }
    //Далее расположены наброски функций, пока не разбитые на классы
    private void Rewrite(String filePath, String oldLine, String newLine) throws IOException{
        // замена определенной строки в текстовом файле на новую
        // пока в общем виде
        Scanner sc = new Scanner(new File(filePath));
        StringBuilder builder = new StringBuilder(); //переменная хранит весь текст
        while (sc.hasNextLine()) {  //запись текста
            builder.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = builder.toString();
        System.out.println("Contents of the file: "+ fileContents); //иллюстративный вывод старого содержания
        sc.close();
        fileContents = fileContents.replaceAll(oldLine, newLine); // замена старой строки на новую
        FileWriter writer = new FileWriter(filePath);
        System.out.println("new data: "+ fileContents);//иллюстративный вывод нового содержания
        writer.append(fileContents);//запись в файл нового текста
        writer.flush();
        
    }
    private void ChangeTimetableItem(int lineNum, String newLine){


    }
    private void AddTask(int lineNum, String newTask){


    }
    private void DeleteTask(int lineNum, String newTask){


    }
    private void AverageScore(String subject){


    }
    private void AddTeacherInformation(String inf){


    }
    private void Output(){



    }


}