package DZ.dz3;

import java.time.LocalDate;


/* Форматы данных:
        фамилия, имя, отчество - строки

        дата_рождения - строка формата dd.mm.yyyy

        номер_телефона - целое беззнаковое число без форматирования

        пол - символ латиницей f или m. 
*/
public class User {
    // private String id = "";
    private String LastName;
    private String FirstName;
    private String Patronymic;
    private LocalDate Birthday;
    private long Phone;
    private Gender Gender;
    
    // public User(){

    // }

    // public User(String firstName, String lastName, String patronymic, LocalDate birthdate, long phone, Gender gender) {
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.patronymic = patronymic;
    //     this.birthdate = birthdate;
    //     this.phone = phone;
    //     this.gender = gender;
    // }

    // public User(String id, String firstName, String lastName, String patronymic, LocalDate birthdate, long phone, Gender gender) {
    //     this(firstName, lastName, patronymic, birthdate, phone, gender);
    //     this.id = id;
    // }

    // public String getId() {
    //     return id;
    // }

    // public void setId(String id) {
    //     this.id = id;
    // }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.Patronymic = patronymic;
    }

    // получить
    public LocalDate getBirthday() {
        return Birthday;
    }

    // установить
    public void setBirthday(LocalDate birthdate) {
        this.Birthday = birthdate;
    }

    public long getPhone() {
        return Phone;
    }

    public void setPhone(long phone) {
        this.Phone = phone;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender gender) {
        Gender = gender;
    }

    // public void setGender(Gender checkGender) {
    // }



    // @Override
    // public String toString() {
    //     return String.format("Идентафикатор: %s\nИмя: %s,\nФамилия: %s,\nОтчество: %s,\nДата_рождения: %d,\nТелефон: %s,\nПол: %s", id, firstName, lastName, patronymic, birthdate, phone, gender);
    // }
}
