package DZ.dz3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import DZ.dz3.MyException.BadBirthdayFormatException;
import DZ.dz3.MyException.BadFIOFormatException;
import DZ.dz3.MyException.BadGenderException;
import DZ.dz3.MyException.BadPhoneNUmberFormatException;
import DZ.dz3.MyException.ValidateFormatException;

public class DataValidator {
    private User user;

    public DataValidator() {
        user = new User();
    }

    public void Validate(String[] splitedString) throws ValidateFormatException {
        if (splitedString == null) {
            throw new NullPointerException("Нет данных");
        }

        StringBuilder errorMessages = new StringBuilder();
        for (String data : splitedString) {
            if (Character.isLetter(data.charAt(0))) {
                if (data.length() == 1) {
                    if (this.user.getGender() == null) {
                        try {
                            this.user.setGender(checkGender(data));
                        } catch (BadGenderException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else {
                        errorMessages.append("Пол указан больше 1 раза\n");
                    }
                } else {
                    if (this.user.getLastName() == null) {
                        try {
                            this.user.setLastName(checkFLP(data));
                        } catch (BadFIOFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else if (this.user.getFirstName() == null) {
                        try {
                            this.user.setFirstName(checkFLP(data));
                        } catch (BadFIOFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else if (this.user.getPatronymic() == null) {
                        try {
                            this.user.setPatronymic(checkFLP(data));
                        } catch (BadFIOFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else {
                        errorMessages.append("Обнаружено много данных формата ФИО\n");
                    }
                }
            } else {

                if (data.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.user.getBirthday() == null) {
                        try {
                            this.user.setBirthday(checkBirthday(data));
                        } catch (BadBirthdayFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else {
                        errorMessages.append("Обнаружено несколько дат");
                    }
                } else {
                    if (this.user.getPhone() == 0) {
                        try {
                            this.user.setPhone(checkPhoneNumber(data));
                        } catch (BadPhoneNUmberFormatException e) {
                            errorMessages.append(e.getMessage());
                        }
                    } else {
                        errorMessages.append("Обнаружено несколько телефонных номеров");
                    }
                }

            }
        }
        if (!errorMessages.isEmpty()) {
            throw new ValidateFormatException(errorMessages.toString());
        }
    }

    public String getLastName() {
        return user.getLastName();
    }

    private String checkFLP(String inputString) throws BadFIOFormatException {
        if (inputString.toLowerCase().matches("^[a-zа-яё]*$")) {
            return inputString;
        } else {
            throw new BadFIOFormatException(inputString);
        }
    }

    private long checkPhoneNumber(String inpuString) throws BadPhoneNUmberFormatException {
        if (inpuString.length() == 10) {
            try {
                return Long.parseLong(inpuString);
            } catch (NumberFormatException e) {
                throw new BadPhoneNUmberFormatException(inpuString);
            }
        } else {
            throw new BadPhoneNUmberFormatException(inpuString);
        }
    }

    private Gender checkGender(String inputString) throws BadGenderException {
        try {
            return Gender.valueOf(inputString);
        } catch (IllegalArgumentException e) {
            throw new BadGenderException(inputString);
        }
    }

    private LocalDate checkBirthday(String inputString) throws BadBirthdayFormatException {
        try {
            return LocalDate.parse(inputString,
                    DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new BadBirthdayFormatException(inputString);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(user.getLastName()).append(">")
                .append("<").append(user.getFirstName()).append(">")
                .append("<").append(user.getPatronymic()).append(">")
                .append("<").append(user.getBirthday()).append(">")
                .append("<").append(user.getPhone()).append(">")
                .append("<").append(user.getGender()).append(">");
        return sb.toString();
    }

}
