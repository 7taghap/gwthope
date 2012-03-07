package com.rb.gwthope.server;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.gwthope.server.dao.UserDao;
import com.rb.gwthope.shared.dto.User;
import com.rb.gwthope.shared.services.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
//	EntityManager em;
//	@PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "MyPersistenceUnit")
//    public void setEntityManager(EntityManager em) {
//        this.em = em;
//       
//    }
	
//	@PostConstruct
//	public void init() throws Exception {
//		
//	}
	
//	@PreDestroy
//	public void destroy() {
//	}

	public String findUser(Integer userId) {
//		User user = new User();
//		user.setFullname("test no persistence data");
//		user.setUserId(1l);
//		user.setUsername("testuser");
//		System.out.println("userDAO : " + userDAO);
//		System.out.println("entity manager :" + this.em);
//		User user = (User)em.createNamedQuery("User.findById").setParameter("userId", userId).getSingleResult();
		String userDetails = "empty";
		User user =  userDao.findById(userId);
		if (user!=null)
			userDetails = user.getFullname();
		return userDetails;
//		return user;
	}

	public boolean saveUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
//		return userDAO.findAll();
		return null;
	}

}
