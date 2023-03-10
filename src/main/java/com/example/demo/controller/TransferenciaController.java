package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.modelo.Transferencia;
import com.example.demo.service.ICuentaService;
import com.example.demo.service.ITransferenciaService;

@Controller
@RequestMapping("/transferencias") // URL: http://localhost:8080/cuentasbancarias/inicio
public class TransferenciaController {

	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private ICuentaService iCuentaService;

	@GetMapping("/inicio") // URL: http://localhost:8080/transferencias/inicio
	public String ingresoValores(Model model, Transferencia transferencia) {
		model.addAttribute("transferencia", transferencia);
		return "vistaInicioTransferencia";
	}

	@PostMapping("/transferir")
	public String transferir(Model model, Transferencia transferencia) {
		CuentaBancaria origen = this.iCuentaService.encontrar(transferencia.getNumeroCuentaOrigen());
		CuentaBancaria destino = this.iCuentaService.encontrar(transferencia.getNumeroCuentaDestino());
		model.addAttribute("origen", origen);		
		model.addAttribute("destino", destino);
		
		Transferencia trans = new Transferencia();
		trans = this.iTransferenciaService.realizarTransferencia(transferencia.getNumeroCuentaOrigen(), transferencia.getNumeroCuentaDestino(), transferencia.getMonto());

		if (trans == null) {
			return "vistaTransferenciaNOExitosa";
		} else {
			model.addAttribute("transferencia", trans);
			return "vistaTransferenciaExitosa";
		}
	}

}
