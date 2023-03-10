package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;
import com.example.demo.repository.ICuentaRepository;
import com.example.demo.repository.ITransferenciaRepository;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaRepository iCuentaRepository;
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;

	private static final Logger LOG = LoggerFactory.getLogger(TransferenciaServiceImpl.class);

	@Override
	public Transferencia realizarTransferencia(String origen, String destino, BigDecimal monto) {

		CuentaBancaria cuentaOrigen = this.iCuentaRepository.buscar(origen);
		CuentaBancaria cuentaDestino = this.iCuentaRepository.buscar(destino);

		BigDecimal saldoOrigen = cuentaOrigen.getSaldo();
		BigDecimal saldoDestino = cuentaDestino.getSaldo();
		
		// Comision:
		BigDecimal comision = monto.multiply(new BigDecimal(0.05));
		BigDecimal montoTotal = monto.add(comision);		
		
		if (montoTotal.compareTo(saldoOrigen) == 1) {
			LOG.info("Saldo insuficiente. La transferencia no pudo ser realizada.");
			return null;
		} else {
			// ORIGEN:
			// Resto:
			BigDecimal saldoNuevoOrigen = saldoOrigen.subtract(montoTotal);
			cuentaOrigen.setSaldo(saldoNuevoOrigen);

			// DESTINO:
			// Sumo:
			cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(monto));
			
			Transferencia transferencia = new Transferencia();
			transferencia.setNumeroCuentaOrigen(origen);
			transferencia.setNumeroCuentaDestino(destino);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setComision(comision);
			this.iTransferenciaRepository.insertar(transferencia);
			return transferencia;
		}
	}

}
