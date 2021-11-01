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

        String functionNumber;    // номер выбранной команды
        Scanner input = new Scanner (System.in); // Сканнер для ввода в консоль
        System.out.println("[Start text]");// вывод начального текста(можно также сделать из файла)
        System.out.println("Please enter the number of function");

        while(true) {
            functionNumber = input.nextLine(); // ввод номера функции
            switch (functionNumber) {       //выбор функции пользователем
                case ("exit"): {
                    System.out.println("Goodbye");
                    return;
                }
                case ("1"): {
                    Timetable.changeTimetableItem();
                }
                break;
                case ("2"): {
                    TaskList.addTask();
                }
                break;
                case ("3"): {
                    TaskList.deleteTask();
                }
                break;
                case ("4"): {
                    Teachers.addTeacher();
                }
                break;
                case ("5"): {
                    Timetable.output();
                }
                break;
                case ("6"): {
                    TaskList.output();
                }
                default:
                    System.out.println("Sorry, this function isn't existing yet :(");
                    break;
            }
        }

    }




    }


