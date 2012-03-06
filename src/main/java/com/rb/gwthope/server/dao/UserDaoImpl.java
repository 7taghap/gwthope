package com.rb.gwthope.server.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.rb.gwthope.shared.dto.User;


@Repository
public class UserDaoImpl extends AbstractJpaDao<User> implements UserDao{
	 private static Logger logger = Logger.getLogger(UserDaoImpl.class.getName());
//	@Autowired
//	EntityManagerFactory entityManagerFactory;
//	@Autowired
//	 SessionFactory sessionFactory;
	
	 //transfer sa AbstractJpaDao
//	 @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "MyPersistenceUnit")
//	 private EntityManager em;
	 
	 public UserDaoImpl() {
		 setClazz(User.class);
	 }

	public User findById(Long userId) {
		try {
//			em = entityManagerFactory.createEntityManager();
			logger.info("entity manager :" + entityManager);
//			User user = (User)entityManager.createNamedQuery("User.findById").setParameter("userId", userId).getSingleResult();
			User user = getById(userId);
//			User user = new User();
//			user.setFullname("hello world");
//			User user = (User) sessionFactory.getCurrentSession().createQuery("from User").list();
			
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	@PostConstruct
//	public void init() {
//		if (entityManagerFactory!=null){
//			System.out.println("entityManager is null");
//		}
//		
//		super.setEntityManagerFactory(entityManagerFactory);
//	}
	
//	@Override
//	public User findById(Long userId) {
//		System.out.println("entity manager :" + entityManagerFactory);
//		em = entityManagerFactory.createEntityManager();
//		List<User> users = em.createNamedQuery("User.findById").setParameter("userId", userId).getResultList();
//		
//		return users.get(0);
//	}
}