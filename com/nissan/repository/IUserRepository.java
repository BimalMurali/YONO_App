package com.nissan.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.User;
@Repository
public interface IUserRepository extends CrudRepository<User,Integer> {
	
	
		@Query("from Users WHERE userName=?1 AND password=?2 AND roleId=1")
		public User findAdminByUserNameAndPassword(String userName, String password);

		// custom method
		@Query("from Users WHERE userName=?1 AND password=?2 AND roleId=2")
		public User findCustomerByUserNameAndPassword(String userName, String password);
}
