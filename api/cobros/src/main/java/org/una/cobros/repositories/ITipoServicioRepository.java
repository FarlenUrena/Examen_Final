/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cobros.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.una.cobros.entities.TipoServicio;

/**
 *
 * @author farle_000
 */
public interface ITipoServicioRepository extends JpaRepository<TipoServicio, Long> {
   
}
