package by.tms.service;

import by.tms.entity.User;
import by.tms.DAO.UserDAO;

public class UserService {
	private UserDAO userDAO = new UserDAO();

	public boolean add(User user){
		if (userDAO.existByUserName(user.getUsername())){
			return false;
		} else {
			userDAO.save(user);
			return true;
		}
	}

	public User findByUsername(String username){
		if (userDAO.existByUserName(username)){
			return userDAO.findByUsername(username);
		}
		return null;
	}
}
