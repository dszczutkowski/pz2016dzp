package account.service;

import account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
