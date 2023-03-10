package com.example.demo.repository;

import java.math.BigDecimal;
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
		Query query = this.entityManager.createQuery("DELETE FROM CuentaBancaria c WHERE c.numero =:datoNumero");
		query.setParameter("datoNumero", numero);
		query.executeUpdate();
	}

	@Override
	public int actualizarSaldo(BigDecimal saldo) {
		Query query = this.entityManager.createQuery("UPDATE CuentaBancaria c SET c.saldo =: datoSaldo WHERE c.saldo < 100");
		query.setParameter("datoSaldo", saldo);
		return query.executeUpdate();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
