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
                break;
                default:
                    r= "Sorry, this function isn't existing yet :(";
                    break;
            }
            return (r);
        }
}
