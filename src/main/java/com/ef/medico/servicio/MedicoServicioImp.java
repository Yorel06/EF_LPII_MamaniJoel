package com.ef.medico.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ef.medico.modelo.TblMedico;
import com.ef.medico.repositorio.IMedicoRepositorio;

@Service
public class MedicoServicioImp implements IMedicoServicio {

	// Aplicamos la inyeccion de dependencia...
	
	@Autowired  // esto habilita la inyeccion de las dependencias
	private IMedicoRepositorio imedicorepositorio;
	
	
	
	@Override
	public void RegistrarMedico(TblMedico tblmedico) {
		// invocamos el metodo registrar
		
		imedicorepositorio.save(tblmedico);
		
	}

	@Override
	public void EliminarMedico(TblMedico tblmedico) {
		// invocamos el metodo eliminar
		
		imedicorepositorio.deleteById(tblmedico.getIdmedicot3());
		
	}

	@Override
	public List<TblMedico> ListadoMedico() {
		// invocamos el metodo listado	
					
		return (List<TblMedico>) imedicorepositorio.findAll();
	}

	@Override
	public TblMedico buscarporId(Integer id) {
		// // invocamos el metodo buscar	
		
		return imedicorepositorio.findById(id).orElse(null);
	}
		

}
