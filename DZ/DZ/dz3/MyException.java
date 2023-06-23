package DZ.dz3;

public class MyException {
    


    public class BadBirthdayFormatException extends Exception {

        String inputString;

        public BadBirthdayFormatException(String inputString) {
            this.inputString = inputString;
        }

        @Override
        public String getMessage() {
            return "Ошибка при вводе даты '" + inputString + "', требуем формат 'дд.мм.гггг'.\n";
        }
    }

    public class BadFIOFormatException extends Exception {

        String inputString;
    
        public BadFIOFormatException(String inputString) {
            this.inputString = inputString;
        }
    
        @Override
        public String getMessage() {
            return "Неправильный формат ФИО '" + inputString + "'. ФИО могут состоять только из букв.\n";
        }
    }

    public class BadGenderException extends Exception {
        String inputString;
    
        public BadGenderException(String inputString) {
            this.inputString = inputString;
        }
    
        @Override
        public String getMessage() {
            return "Неправильно указан пол (используйте только латинские буквы f или m), а не '" + inputString + "'\n";
        }
    }

    public class BadPhoneNUmberFormatException extends Exception {
        String inputString;
    
        public BadPhoneNUmberFormatException(String inputString) {
            this.inputString = inputString;
        }
    
        @Override
        public String getMessage() {
            return "Не получилось преобразовать " + inputString + " в телефонный номер, (нужный формат телефона 10 цифр без разделителей)\n";
        }
    }

    public class ValidateFormatException extends Exception {
        String message;
    
        public ValidateFormatException(String message){
            this.message = message;
        }
    
        @Override
        public String getMessage() {
            return this.message;
        }
    }
}