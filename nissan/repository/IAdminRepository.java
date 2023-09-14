package com.nissan.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer_Details;
@Repository
public interface IAdminRepository extends CrudRepository<Customer_Details, Integer>{
	
	//custom methods using JPQL query
	//custom JPQL Query for delete operation
		@Modifying
		@Query("UPDATE com.nissan.model.Customer_Details SET isActive=0 WHERE accountNo=?1")
		
		public void deleteCustomer(int accountNo);
}
