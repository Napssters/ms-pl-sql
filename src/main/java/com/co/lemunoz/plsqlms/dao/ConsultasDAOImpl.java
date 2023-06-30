package com.co.lemunoz.plsqlms.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultasDAOImpl implements ConsultasDAO {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String obtenerRespouesta(String query) throws SQLException {
    	
    	String mesagge = "";
    	
        try {
        	mesagge = jdbcTemplate.query(query, (rs, rowNum) -> {
                StringBuilder sb = new StringBuilder();
                int columnCount = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    sb.append(rs.getString(i));
                    if (i < columnCount) {
                        sb.append(", ");
                    }
                }
                return sb.toString();
            }).toString();
        } catch (DataAccessException e) {
        	String detailMessage = e.getMessage().replace("StatementCallback;", "");
        	mesagge = "Error reaizando consulta:" + detailMessage;
        }
        
        return mesagge;
        
    }

	@Override
	public String obtenerRespouestaExecute(String query) throws SQLException {
		
		String mesagge = "";
		
		try {
			
			jdbcTemplate.execute(query);
			
			mesagge = "Consulta ejecutada exitosamente";
			
        } catch (DataAccessException e) {
        	String detailMessage = e.getMessage().replace("StatementCallback;", "");
        	mesagge = "Error reaizando consulta:" + detailMessage;
        }
		
		return mesagge;
	}

	@Override
	public String obtenerRespouestaUpdate(String query) throws SQLException {

		String mesagge = "";
		
		try {
			
			jdbcTemplate.update(query);
			
			mesagge = "Consulta ejecutada exitosamente";
			
        } catch (DataAccessException e) {
        	String detailMessage = e.getMessage().replace("StatementCallback;", "");
        	mesagge = "Error reaizando consulta:" + detailMessage;
        	
        }
		
		return mesagge;
	}

}
