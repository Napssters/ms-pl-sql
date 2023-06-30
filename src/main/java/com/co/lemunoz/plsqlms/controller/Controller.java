package com.co.lemunoz.plsqlms.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.lemunoz.plsqlms.service.ConsultaSqlService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@CrossOrigin
@RestController
@RequestMapping("/consultas")
public class Controller {
    
    @Autowired
    private ConsultaSqlService consultaSqlService;
    
    @ApiOperation(value = "Motodo para obtener las consultas sql", nickname = "obtenerMovimiento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "200", response = String.class),
            @ApiResponse(code = 400, message = "400")
    })
    @GetMapping(value = "/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> obtenerRespouesta(
            @Valid
            @PathVariable
            String query) throws SQLException {
            return new ResponseEntity<>(consultaSqlService.obtenerRespouesta(query), HttpStatus.OK);
    }
}
