package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.entidades.CursoDTO;
import com.desafiolatam.entidades.FormaDePagoDTO;

public class FormaDePagoDAO {
	
	public List obtieneFormasDePago() throws SQLException, ClassNotFoundException {
		
		//crear la lista de objetos que devolveran los resultados
		List<FormaDePagoDTO> formaDePago = new ArrayList<FormaDePagoDTO>();
		
		//crear la consulta a la base de datos
		String consultaSql = " SELECT id_forma_pago, descripcion, recarga " 
				   		   + " FROM javaG6.forma_pago ";
		
		//conexión a la base de datos y ejecución de la sentencia
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaG6","root","Admin1234");
		
		try(PreparedStatement stmt = conexion.prepareStatement(consultaSql)){
	
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				FormaDePagoDTO formaPago = new FormaDePagoDTO();
				formaPago.setIdFormaDePago(resultado.getInt("id_forma_pago"));
				formaPago.setDescripcion(resultado.getString("descripcion"));
				formaPago.setRecargo(resultado.getDouble("recarga"));
				formaDePago.add(formaPago);
			}	
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return formaDePago;
	}
}
