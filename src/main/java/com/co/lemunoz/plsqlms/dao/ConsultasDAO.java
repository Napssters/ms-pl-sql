package com.co.lemunoz.plsqlms.dao;

import java.sql.SQLException;

public interface ConsultasDAO {
	
	String obtenerRespouesta(String query) throws SQLException;
	
	String obtenerRespouestaExecute(String query) throws SQLException;
	
	String obtenerRespouestaUpdate(String query) throws SQLException;
	
}