/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.cobros.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.cobros.dtos.TipoServicioDTO;
import org.una.cobros.entities.TipoServicio;
import org.una.cobros.repositories.ITipoServicioRepository;
import org.una.cobros.utils.MapperUtils;
import org.una.cobros.utils.ServiceConvertionHelper;

/**
 *
 * @author farle_000
 */
@Service
public class TipoServicioServiceImplementation implements ITipoServicioService{

    @Autowired
    private ITipoServicioRepository tipoServicioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TipoServicioDTO>> findAll() {
    return ServiceConvertionHelper.findList(tipoServicioRepository.findAll(), TipoServicioDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoServicioDTO> findById(Long id) {
    return ServiceConvertionHelper.oneToOptionalDto(tipoServicioRepository.findById(id), TipoServicioDTO.class);
    }

    @Override
    @Transactional
    public TipoServicioDTO create(TipoServicioDTO tipoServicioDto) {
        TipoServicio tipoServicio = MapperUtils.EntityFromDto(tipoServicioDto, TipoServicio.class);
        tipoServicio = tipoServicioRepository.save(tipoServicio);
        return MapperUtils.DtoFromEntity(tipoServicio, TipoServicioDTO.class);
    }

    @Override
    @Transactional
    public Optional<TipoServicioDTO> update(TipoServicioDTO tipoServicioDTO, Long id) {
    if (tipoServicioRepository.findById(id).isPresent()) {
            TipoServicio tipoServicio = MapperUtils.EntityFromDto(tipoServicioDTO, TipoServicio.class);
            tipoServicio = tipoServicioRepository.save(tipoServicio);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tipoServicio, TipoServicioDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
    tipoServicioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
    tipoServicioRepository.deleteAll();
    }
    
}
