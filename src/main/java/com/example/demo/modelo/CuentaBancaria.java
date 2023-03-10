package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentabancaria")
public class CuentaBancaria {

	@Id
	@Column(name = "cuenta_numero")
	private String numero;

	@Column(name = "cuenta_tipo")
	private String tipo;

	@Column(name = "cuenta_saldo")
	private BigDecimal saldo;

	@Column(name = "cuenta_cedula")
	private String cedula;

	// toString:
	@Override
	public String toString() {
		return "CuentaBancaria [id=" + numero + ", tipo=" + tipo + ", saldo=" + saldo + ", cedula=" + cedula + "]";
	}

	// Get y Set
	public String getNumero() {
		return numero;
	}

	public void setNumero(String id) {
		this.numero = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
