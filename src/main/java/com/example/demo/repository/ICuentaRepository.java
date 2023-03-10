package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.CuentaBancaria;

public interface ICuentaRepository {

	public void insertar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria buscar(String id);
	public List<CuentaBancaria> buscarTodas();
	public void eliminarPorNumero(String numero);
	
}
