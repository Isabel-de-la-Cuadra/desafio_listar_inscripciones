package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.entidades.CursoDTO;

public class CursoDao {
	
	public List obtieneCursos() throws SQLException, ClassNotFoundException {
		
		//crear la lista de objetos que devolveran los resultados
		List<CursoDTO> listaDeCursos = new ArrayList<CursoDTO>();
		
		//crear la consulta a la base de datos
		String consultaSql = " SELECT id_curso, descripcion, precio " 
				   		   + " FROM javaG6.curso ";
		
		//conexión a la base de datos y ejecución de la sentencia
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaG6","root","Admin1234");
		
		try(PreparedStatement stmt = conexion.prepareStatement(consultaSql)){
	
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				CursoDTO cursoDto = new CursoDTO();
				cursoDto.setIdCurso(resultado.getInt("id_curso"));
				cursoDto.setDescricion(resultado.getString("descripcion"));
				cursoDto.setPrecio(resultado.getDouble("precio"));
				listaDeCursos.add(cursoDto);
			}	
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return listaDeCursos;
	}
}
