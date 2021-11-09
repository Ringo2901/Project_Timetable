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
        System.out.println("Здравствуй пользователь!\n" +
                "Список доступных функций:\n" +
                "1. Добаление/редактирование расписания\n" +
                "2. Добавление/редактирование задач\n" +
                "3. Удаление задач\n" +
                "4. Добавление данных о преподавателе\n" +
                "5. Вывод расписания\n" +
                "6. Вывод списка задач");// вывод начального текста(можно также сделать из файла)
        System.out.println("Пожалуйста, введите номер функции или введите 'выход', чтобы завершить исполнение программы!");

        while(true) {
            functionNumber = input.nextLine(); // ввод номера функции
            switch (functionNumber) {       //выбор функции пользователем
                case ("выход"): {
                    System.out.println("Пока!");
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
                    System.out.println("Извините, эта функция пока недоступна :(");
                    break;
            }
        }

    }




    }


