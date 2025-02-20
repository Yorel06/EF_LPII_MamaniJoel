package com.ef.medico.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.ef.medico.modelo.TblMedico;

public interface IMedicoRepositorio extends CrudRepository<TblMedico,Integer> {

}
