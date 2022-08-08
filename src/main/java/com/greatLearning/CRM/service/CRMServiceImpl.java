package com.greatLearning.CRM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatLearning.CRM.entity.CustomerDetails;

@Repository
public class CRMServiceImpl implements CRMService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	CRMServiceImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			// TODO: handle exception
			session = sessionFactory.openSession();

		}
	}

	@Transactional
	public List<CustomerDetails> findAll() {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		List<CustomerDetails> customerDetails = session.createQuery("from CustomerDetails").list();
		tx.commit();
		return customerDetails;
	}

	@Transactional
	public CustomerDetails findById(int theId) {
		// TODO Auto-generated method stub
		CustomerDetails customerDetails = new CustomerDetails();
		Transaction tx = session.beginTransaction();
		customerDetails = session.get(CustomerDetails.class, theId);
		tx.commit();
		return customerDetails;
	}

	@Transactional
	public void save(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		// save the details and update
		session.saveOrUpdate(customerDetails);
		tx.commit();
	}

	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();
		// delete the details using id
		CustomerDetails customerDetails = session.get(CustomerDetails.class, theId);
		session.delete(customerDetails);
		tx.commit();
	}

}
