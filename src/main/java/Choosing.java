public class Choosing {
        public String cin (int functionNumber){
            String r="";
            switch (functionNumber) {       //выбор функции пользователем
                case  (1):
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
