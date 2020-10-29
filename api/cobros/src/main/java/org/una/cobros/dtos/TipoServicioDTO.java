/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cobros.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author farle_000
 */

@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString
public class TipoServicioDTO {
    private Long id; 
    private String Descripción; 
    private boolean estado; 
    private Date fechaRegistro; 
    private Date fechaModificacion;
    private List<MembresiaDTO> Membresias;
}
