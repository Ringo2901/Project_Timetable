import java.io.IOException;

public class Choosing {
        public String cin (int functionNumber) throws IOException {
            String r="";
            switch (functionNumber) {       //выбор функции пользователем
                case  (1):
                {
                    Timetable t = new Timetable();
                    t.changeTimetableItem();
                }
                    break;
                case (2):
                    r="Hi";
                    break;
                default:
                    r= "This function isn't existing yet :(";
                    break;
            }
            return (r);
        }
}
