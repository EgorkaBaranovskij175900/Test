package by.tms.DAO.interfaces;

import by.tms.entity.User;

import java.util.List;

public interface UserInterface {
    public void save(User user);
    public List<User> getAll();
    public boolean existByUserName(String username);
    public User findByUsername(String username);
}
