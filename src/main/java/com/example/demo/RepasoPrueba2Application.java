package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.repository.ICuentaRepository;
import com.example.demo.service.ICuentaService;

@SpringBootApplication
public class RepasoPrueba2Application implements CommandLineRunner{

	@Autowired
	private ICuentaService iCuentaService;
	
	public static void main(String[] args) {
		SpringApplication.run(RepasoPrueba2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		CuentaBancaria c1 = this.iCuentaService.encontrar("789");
//		System.out.println(c1);
//		int c2 = this.iCuentaService.actualizarSaldo(new BigDecimal(555));
//		System.out.println(c2);
//		
//		this.iCuentaService.eliminarPorNumero("852");
		
	}

}
