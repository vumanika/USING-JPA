package com.cg.mypaymentapp.repo;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.mypaymentapp.beans.Customer;


public class WalletRepoImpl implements WalletRepo {
	private Map<String, Customer> data = new HashMap<String, Customer>();

	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}

/*	Connection con;

	public WalletRepoImpl() {
		try {

			this.con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "corp123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

	public WalletRepoImpl() {
		// TODO Auto-generated constructor stub
	}
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ParallelProject_153057 Using JPA");
	EntityManager em=emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	public boolean save(Customer customer) {
	
	
		tx.begin();
		em.persist(customer);
		tx.commit();
		return true;
	}

	public Customer findOne(String mobilenum1) {
	
		tx.begin();
		Customer cu=em.find(Customer.class, mobilenum1);
		tx.commit();
		return cu;
	}

	@Override
	public Customer  update(Customer cu1) {
	
		tx.begin();
		em.persist(em.merge(cu1));
		tx.commit();
	
        return cu1;
	}
}