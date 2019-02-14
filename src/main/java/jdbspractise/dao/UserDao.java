package jdbspractise.dao;

import jdbspractise.model.User;

public interface UserDao {
    void addUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void removeUser(Long id);
}
