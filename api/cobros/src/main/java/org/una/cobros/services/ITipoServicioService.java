/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cobros.services;

import java.util.List;
import java.util.Optional;
import org.una.cobros.dtos.TipoServicioDTO;

/**
 *
 * @author farle_000
 */
public interface ITipoServicioService {
    public Optional<List<TipoServicioDTO>> findAll();

    public Optional<TipoServicioDTO> findById(Long id);

    public TipoServicioDTO create(TipoServicioDTO tipoServicio);

    public Optional<TipoServicioDTO> update(TipoServicioDTO tipoServicio, Long id);

    public void delete(Long id);

    public void deleteAll();
}
