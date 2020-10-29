/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cobros.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author farle_000
 */

@Entity
@Table(name = "exa_fun_cobros_pendientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroPendiente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @ManyToOne
//    @JoinColumn(name = "membresias_id")
//    private Membresia membresia;
    
    @Column(name = "monto")
    private double monto;
    
    @Column
    private boolean estado;
    
    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;
    
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    private Date fechaModificacion;
    
    @Column(name = "fecha_vencimiento", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    private Date fechaVencimiento;

    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    private Date fechaPago;
    
    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
        fechaModificacion = new Date();
        
    }

    @PreUpdate
    public void preUpdate() {
         fechaModificacion = new Date();
        if(!estado){
        fechaPago = new Date();
        }
    }
    
private final int dias=30;

 public Date GeneraFechaVencimiento(Date fecha){
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); // Configuramos la fecha que se recibe
      calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
      return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos	
 }
 
    
}
