package com.example.demo.service;

import java.math.BigDecimal;

import com.example.demo.modelo.Transferencia;

public interface ITransferenciaService {
	
	public Transferencia realizarTransferencia(String origen, String destino, BigDecimal monto);

}
