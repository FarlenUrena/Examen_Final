/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cobros.repositories;

import org.una.cobros.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author farle_000
 */
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    
}
