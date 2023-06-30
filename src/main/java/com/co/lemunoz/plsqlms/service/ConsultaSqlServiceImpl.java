package com.co.lemunoz.plsqlms.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.lemunoz.plsqlms.dao.ConsultasDAO;
import com.co.lemunoz.plsqlms.utils.ConsultaSqlUtils;

@Service
public class ConsultaSqlServiceImpl implements ConsultaSqlService {

    @Autowired
    private ConsultasDAO consultasDao;

    @Override
    public String obtenerRespouesta(String query) throws SQLException {

    	String response = "";
    	
    	String[] request = query.toUpperCase().split(" ");
        try {
        	
        	if(ConsultaSqlUtils.UPDATE.contains(request[0])) {
        		response = consultasDao.obtenerRespouestaUpdate(query);
        	} else if (ConsultaSqlUtils.EXECUTE.contains(request[0])) {
        		response = consultasDao.obtenerRespouestaExecute(query);
        	} else {
        		response = consultasDao.obtenerRespouesta(query);
        	}
            
        } catch (SQLException e) {
        	response = "Error reaizando consulta:" + e;
        }
        
        return response;
    }

}

