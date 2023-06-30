package com.co.lemunoz.plsqlms.service;

import java.sql.SQLException;

public interface ConsultaSqlService {
	
	String obtenerRespouesta(String query) throws SQLException;

}
