package com.ef.medico.servicio;

import java.util.List;

import com.ef.medico.modelo.TblMedico;

public interface IMedicoServicio {
	
	// declaramos los metodos
	
	void RegistrarMedico(TblMedico tblmedico);
	void EliminarMedico(TblMedico tblmedico);
	List<TblMedico> ListadoMedico();
	TblMedico buscarporId(Integer id);

}
