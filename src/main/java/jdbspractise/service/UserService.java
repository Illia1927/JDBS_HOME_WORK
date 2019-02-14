package jdbspractise.service;

import jdbspractise.model.User;

public interface UserService {
    void addUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void removeUser(Long id);
}
