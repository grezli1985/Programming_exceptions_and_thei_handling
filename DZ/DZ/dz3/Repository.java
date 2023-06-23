package DZ.dz3;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();
    String CreateUser(User user);
    void updateUser(User user);
    void deleteById(String inputId);
    String getFileType();
}
