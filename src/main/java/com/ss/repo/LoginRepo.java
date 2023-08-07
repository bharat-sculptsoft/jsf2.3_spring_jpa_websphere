package com.ss.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.model.LoginModel;

@Repository
public class LoginRepo {

	@PersistenceContext
	private EntityManager em;

	public List<LoginModel> findAll() {

		return this.em.createQuery("from LoginModel", LoginModel.class).getResultList();
	}

	public List<LoginModel> findByEmailAndPassword(String email, String password) {

		return this.em.createQuery("from LoginModel where email=:email and password=:password", LoginModel.class)
				.setParameter("email", email).setParameter("password", password).getResultList();
	}

	public void save(LoginModel lm) {
		this.em.persist(lm);
	}
}
