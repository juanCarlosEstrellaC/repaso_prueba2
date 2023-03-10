package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.CuentaBancaria;
import com.example.demo.service.ICuentaService;

@Controller
@RequestMapping("/cuentasbancarias") // URL: http://localhost:8080/cuentasbancarias/inicio
public class CuentaController {
	
	@Autowired
	private ICuentaService iCuentaService;
	
	@GetMapping("/inicio") // URL: http://localhost:8080/cuentasbancarias/inicio
	public String ingresoCuentas(Model model, CuentaBancaria cuentaBancaria) {
		model.addAttribute("cuenta", cuentaBancaria);
		return "vistaInicioCuenta";
	}
	
	@PostMapping("/guardadoCuenta")
	public String guardadoCuentas(Model model, CuentaBancaria cuentaBancaria) {
		model.addAttribute("cuenta", cuentaBancaria);
		this.iCuentaService.guardar(cuentaBancaria);
		return "vistaGuardadoCuenta";
	}
	
	@GetMapping("/visualizarCuentas") // URL: http://localhost:8080/cuentasbancarias/visualizarCuentas
	public String visualizarCuentas(Model model, CuentaBancaria cuentaBancaria) {
		List<CuentaBancaria> listaCuentas = this.iCuentaService.encontrarTodas();
		model.addAttribute("listaCuentas", listaCuentas);
		return "vistaVisualizarCuentas";
	}
	
	@DeleteMapping("/borrarCuenta/{numero}")
	public String borrarCuenta(@PathVariable("numero") String numero,  Model model, CuentaBancaria cuentaBancaria) {
		this.iCuentaService.eliminarPorNumero(numero);
		return "redirect:/cuentasbancarias/visualizarCuentas";
	}

}
