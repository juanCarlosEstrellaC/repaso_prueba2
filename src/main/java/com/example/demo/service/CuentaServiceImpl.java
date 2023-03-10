package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.repository.ICuentaRepository;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private ICuentaRepository iCuentaRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(CuentaServiceImpl.class);
	
	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		this.iCuentaRepository.insertar(cuentaBancaria);
	}

	@Override
	public CuentaBancaria encontrar(String id) {
		return this.iCuentaRepository.buscar(id);
	}

	@Override
	public List<CuentaBancaria> encontrarTodas() {
		return this.iCuentaRepository.buscarTodas();
	}

	@Override
	public void eliminarPorNumero(String numero) {
		if (numero == null) {
			LOG.info("Numero de cuenta es nulo, no se puede borrar");
		} else {
			this.iCuentaRepository.eliminarPorNumero(numero);
		}
	}

	@Override
	public int actualizarSaldo(BigDecimal saldo) {
		return this.iCuentaRepository.actualizarSaldo(saldo);
	}
}
