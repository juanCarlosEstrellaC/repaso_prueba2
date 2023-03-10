package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trans_seq")
	@SequenceGenerator(name = "trans_seq", sequenceName = "trans_seq", allocationSize = 1)
	@Column(name = "trans_id")
	private Integer id;

	@Column(name = "trans_origen")
	private String numeroCuentaOrigen;

	@Column(name = "trans_destino")
	private String numeroCuentaDestino;

	@Column(name = "trans_monto")
	private BigDecimal monto;

	@Column(name = "trans_comision")
	private BigDecimal comision;

	@Column(name = "trans_fecha")
	private LocalDateTime fecha;

	//tostring
	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", numeroCuentaOrigen=" + numeroCuentaOrigen + ", numeroCuentaDestino="
				+ numeroCuentaDestino + ", monto=" + monto + ", comision=" + comision + ", fecha=" + fecha + "]";
	}

	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCuentaOrigen() {
		return numeroCuentaOrigen;
	}

	public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
		this.numeroCuentaOrigen = numeroCuentaOrigen;
	}

	public String getNumeroCuentaDestino() {
		return numeroCuentaDestino;
	}

	public void setNumeroCuentaDestino(String numeroCuentaDestino) {
		this.numeroCuentaDestino = numeroCuentaDestino;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getComision() {
		return comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	

}
