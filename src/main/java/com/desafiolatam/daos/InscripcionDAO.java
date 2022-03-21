package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.entidades.CursoDTO;
import com.desafiolatam.entidades.InscripcionDTO;
import com.desafiolatam.entidades.FormaDePagoDTO;

public class InscripcionDAO {
	public int insertarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
		int max = 0;
		//Query para obtener una secuencia y asignar un id. La función MAX solo obtiene el valor de id_inscripción
		//y le suma 1, con eso hacemos el incremento
		//String consultaProximoId = " SELECT MAX(id_inscripcion)+1 FROM DESAFIO.inscripcion ";
		//Query que insertará el valor
		String insertarInscripcion = " INSERT INTO javaG6.inscripcion("
				                   + " nombre, telefono, id_curso, id_forma_pago )"
				                   + " VALUES (?,?,?,?) ";
		//conexión a la base de datos y ejecución de la sentencia
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaG6","root","Admin1234");
		
		try(
				//PreparedStatement stmt1 = conexion.prepareStatement(consultaProximoId);
				PreparedStatement stmt2 = conexion.prepareStatement(insertarInscripcion);
		   ){
	
			//ResultSet resultado = stmt1.executeQuery();
			//if(resultado.next()) {
				//max = resultado.getInt(1);
				//stmt2.setInt(1, max);
				stmt2.setString(1, dto.getNombre());
				stmt2.setString(2, dto.getCelular());
				stmt2.setInt(3, dto.getIdCurso());
				stmt2.setInt(4, dto.getIdFormaDePago());
				
				if(stmt2.executeUpdate() != 1) {
					throw new RuntimeException("¡UPS! Ha ocurrido un error inesperado");
				}
			//}	
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("¡UPS! Ha ocurrido un error inesperado" + ex);
		}
		return max;
	}
	
	/*2. Implementar en la clase InscripcionDAO el método obtieneInscripciones, el cual debe
	conectarse a la base de datos (tip: siguiendo la misma estructura del método
	insertarInscripcion) y devolver una lista de tipo InscripcionDTO.
	*/
public List obtieneInscripciones() throws SQLException, ClassNotFoundException {
		
		//crear la lista de objetos que devolveran los resultados
		List<InscripcionDTO> inscripciones = new ArrayList<InscripcionDTO>();
		
		//crear la consulta a la base de datos
		String consultaSql = " SELECT * " 
				   		   + " FROM javaG6.inscripcion ";
		
		//conexión a la base de datos y ejecución de la sentencia
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaG6","root","Admin1234");
		
		try(PreparedStatement stmt = conexion.prepareStatement(consultaSql)){
	
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				InscripcionDTO inscripcion = new InscripcionDTO();
				inscripcion.setIdCurso(resultado.getInt("id_curso"));
				inscripcion.setIdInsc(resultado.getInt("id_inscripcion"));
				inscripcion.setNombre(resultado.getString("nombre"));
				inscripcion.setCelular(resultado.getString("telefono"));
				inscripcion.setIdFormaDePago(resultado.getInt("id_forma_pago"));
				inscripciones.add(inscripcion);
			}	
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return inscripciones;
	}
	
}
