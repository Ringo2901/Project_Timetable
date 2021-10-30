import java.io.IOException;

public class Choosing {
        public String cin (int functionNumber) throws IOException {
            String r="";

            switch (functionNumber) {       //выбор функции пользователем
                case  (1):
                {
                    Timetable.changeTimetableItem();
                }
                    break;
                case (2):
                {
                    TaskList.addTask();
                }
                break;
                case (3):
                {
                    TaskList.deleteTask();
                }
                break;
                case (4):
                {
                    Teachers.addTeacher();
                }
                case (5):
                {
                    Timetable.output();
                }
                case (6):
                {
                    TaskList.output();
                }
                break;
                default:
                    r= "Sorry, this function isn't existing yet :(";
                    break;
            }
            return (r);
        }
}
