/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cobros.services;

import java.util.List;
import java.util.Optional;
import org.una.cobros.dtos.CobroPendienteDTO;

/**
 *
 * @author farle_000
 */
public interface ICobroPendienteService {
    public Optional<List<CobroPendienteDTO>> findAll();

    public Optional<CobroPendienteDTO> findById(Long id);

    public CobroPendienteDTO create(CobroPendienteDTO cobroPendiente);

    public Optional<CobroPendienteDTO> update(CobroPendienteDTO cobroPendiente, Long id);

    public void delete(Long id);

    public void deleteAll();
}
