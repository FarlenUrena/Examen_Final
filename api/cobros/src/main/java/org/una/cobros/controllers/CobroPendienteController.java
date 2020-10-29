/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cobros.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.una.cobros.dtos.CobroPendienteDTO;
import org.una.cobros.services.ICobroPendienteService;

/**
 *
 * @author farle_000
 */
@RestController
@RequestMapping("/cobros_pendientes")
public class CobroPendienteController {
    
    @Autowired
    private ICobroPendienteService cobroPendienteService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity(cobroPendienteService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<>(cobroPendienteService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody CobroPendienteDTO cobroPendiente) {
        try {
            return new ResponseEntity(cobroPendienteService.create(cobroPendiente), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody CobroPendienteDTO cobroPendienteDTO) {
        
            try {
                Optional<CobroPendienteDTO> cobroPendienteUpdated = cobroPendienteService.update(cobroPendienteDTO, id);
                if (cobroPendienteUpdated.isPresent()) {
                    return new ResponseEntity(cobroPendienteUpdated, HttpStatus.OK);
                } else {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
}
