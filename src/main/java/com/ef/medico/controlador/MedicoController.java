package com.ef.medico.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ef.medico.modelo.TblMedico;
import com.ef.medico.servicio.IMedicoServicio;

@Controller
@RequestMapping("/Vistas")
public class MedicoController {
	
	//aplicamos inyeccion de dependencia
	
	@Autowired
	private IMedicoServicio imedicoservicio;

	// listado de medico
		@GetMapping("ListadoMedicos")
		public String listarMedicos (Model modelo) {
			//recuperamos los datos de la BD
			List<TblMedico> listado=imedicoservicio.ListadoMedico();
			
			//enviamos hacia la vistsa
			modelo.addAttribute("listado",listado);
			
			// retornamos
			return "/Vistas/ListadoMedicos";		
		}
		
		
		// Creamos el metodo para registrar datos
		
		@GetMapping("/RegistrarMedico")
		public String RegistrarMedico(Model modelo) {
			
			// realizamos la respectiva instancia
			TblMedico tblmed=new TblMedico();
			// enviuamoshacia la vista
			modelo.addAttribute("regmedico",tblmed);
			//retornamos al formulario
			return "/Vistas/FrmRegMedico";
			
		} // fin del metodo registrar
	
	
		// Realizamos el mapeo con postmapping		
		
		@PostMapping("/GuardarMedico")
		public String GuardarMedico(@ModelAttribute TblMedico tblmed, Model modelo) {
			
			imedicoservicio.RegistrarMedico(tblmed);
			//emitimos mensaje por consola
			System.out.println("dato registrado en la BD");
			// retornamos el listado
			return "redirect:/Vistas/ListadoMedicos";
			
		} // fin del metodo
		
		
		
		// Realizamos el metodo EDITAR
		@GetMapping("/editarmedico/{id}")
		public String Editar(@PathVariable("id") Integer idmedicot3, Model modelo) {
			
			// creamos un objeto tipo tblproducto
			TblMedico clmedico=imedicoservicio.buscarporId(idmedicot3);
			// enviamos hacia la vista
			modelo.addAttribute("regmedico", clmedico);
			
			return "/Vistas/FrmRegMedico";
			
		} // fin del metodo editar
		
		
		// creamos el metodo ELIMINAR
		
		@GetMapping("/eliminarmedico/{id}")
		public String eliminar(@PathVariable("id") Integer idmedicot3, Model modelo) {
			
			TblMedico tblmed=new TblMedico();
			tblmed.setIdmedicot3(idmedicot3);
			// aplicamos la inyeccion de dependencia
			imedicoservicio.EliminarMedico(tblmed);
			// actualizamos el listado
			List<TblMedico> listado=imedicoservicio.ListadoMedico();
			//enviamos hacia la vista
			modelo.addAttribute("listado", listado);
			//redireccionamos
			
			return "redirect:/Vistas/ListadoMedicos";		
			
		} // fin del metodo eliminar	
		

}
