package by.tms.DAO;


import by.tms.DAO.interfaces.Constants;
import by.tms.DAO.interfaces.UserInterface;
import by.tms.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDAO implements UserInterface , Constants {
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	@Transactional
	public void save(User user) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.save(user);

	}

	@Override
	@Transactional
	public List<User> getAll() {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<User> query =currentSession.createQuery(GET_ALL_USER,User.class);
		List<User> resultList=query.getResultList();
		return resultList;
	}

	@Override
	@Transactional
	public boolean existByUserName(String username) {
		boolean rez=false;
		Session currentSession=sessionFactory.getCurrentSession();
		org.hibernate.Query<User> existUser=currentSession.createQuery(EXIST_USER_BY_USERNAME,User.class);
		if(existUser!=null){
			rez=true;
		}
		return rez;
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		Session currentSession=sessionFactory.getCurrentSession();
		org.hibernate.Query<User> existUser=currentSession.createQuery(EXIST_USER_BY_USERNAME,User.class);
		existUser.setParameter("username",username);
		User singleResult=existUser.getSingleResult();
		return singleResult;
	}
}
