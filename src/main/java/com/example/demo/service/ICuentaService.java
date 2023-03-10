package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.CuentaBancaria;

public interface ICuentaService {

	public void guardar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria encontrar(String id);
	public List<CuentaBancaria> encontrarTodas();
	public void eliminarPorNumero(String numero);
	
}
