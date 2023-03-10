package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaRepoImpl implements ICuentaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	public CuentaBancaria buscar(String id) {
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public List<CuentaBancaria> buscarTodas() {
		Query query = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c");
		return query.getResultList();
	}

	@Override
	public void eliminarPorNumero(String numero) {
//		Query query = this.entityManager.createQuery("DELETE FROM CuentaBancaria c WHERE c.nombre =:datoNombre");
//		query.setParameter("datoNombre", numero);
//		query.executeUpdate();
		
		Query query = this.entityManager.createNativeQuery("DELETE FROM cuentabancaria WHERE cuenta_numero = :datoNum", CuentaBancaria.class);
		query.setParameter("datoNum", numero);
		query.executeUpdate();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
