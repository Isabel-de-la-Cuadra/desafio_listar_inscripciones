package com.desafiolatam.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.entidades.InscripcionDTO;
import com.desafiolatam.facade.Facade;


/*
 * 3. Crear un servlet de nombre PreListarInscripciones, el cual llamará al Facade y a su
	método obtieneInscripciones. Este servlet debe redireccionar al JSP ListaInscripciones
	el cual debe desplegar una tabla con los registros insertados. Ver imagen de ejemplo.
 */

@WebServlet("/preListarInscripciones")
public class PreListarInscripciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<InscripcionDTO> inscripciones;
		
		Facade facade = new Facade();
		
		try {
			inscripciones = facade.obtieneInscripciones();
			request.setAttribute("inscripciones", inscripciones);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("ListaInscripciones.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
