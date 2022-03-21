package com.desafiolatam.facade;

import java.sql.SQLException;
import java.util.List;

import com.desafiolatam.daos.CursoDao;
import com.desafiolatam.daos.FormaDePagoDAO;
import com.desafiolatam.daos.InscripcionDAO;
import com.desafiolatam.entidades.CursoDTO;
import com.desafiolatam.entidades.FormaDePagoDTO;
import com.desafiolatam.entidades.InscripcionDTO;

public class Facade {
	
	public int registrarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
		InscripcionDAO dao = new InscripcionDAO();
		return dao.insertarInscripcion(dto);
	}
	
	public List<CursoDTO> obtenerCursos() throws SQLException, ClassNotFoundException{
		CursoDao dao = new CursoDao();
		return dao.obtieneCursos();
	}
	
	public List<FormaDePagoDTO> obtenerFormasDePago() throws SQLException, ClassNotFoundException{
		FormaDePagoDAO dao = new FormaDePagoDAO();
		return dao.obtieneFormasDePago();
	}
	
	/*
	 1. Implementar en la clase Facade.java un metodo de nombre obtieneInscripciones que no
	reciba parámetros. Este método debe llamar al método de la clase InscripcionDAO que
	usted debe crear obtieneInscripciones. El retorno de este método debe ser una lista de
	tipo InscripcionDTO.
	*/
	
	
	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException{
		InscripcionDAO dao = new InscripcionDAO();
		return dao.obtieneInscripciones();
	}
}

