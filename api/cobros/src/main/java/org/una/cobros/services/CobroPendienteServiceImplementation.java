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
import org.una.cobros.dtos.CobroPendienteDTO;
import org.una.cobros.entities.CobroPendiente;
import org.una.cobros.entities.CobroPendiente;
import org.una.cobros.repositories.ICobroPendienteRepository;
import org.una.cobros.utils.MapperUtils;
import org.una.cobros.utils.ServiceConvertionHelper;

/**
 *
 * @author farle_000
 */
@Service
public class CobroPendienteServiceImplementation implements ICobroPendienteService{

   @Autowired
    private ICobroPendienteRepository cobroPendienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroPendienteDTO>> findAll() {
    return ServiceConvertionHelper.findList(cobroPendienteRepository.findAll(), CobroPendienteDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CobroPendienteDTO> findById(Long id) {
    return ServiceConvertionHelper.oneToOptionalDto(cobroPendienteRepository.findById(id), CobroPendienteDTO.class);
    }

    @Override
    @Transactional
    public CobroPendienteDTO create(CobroPendienteDTO cobroPendienteDto) {
        CobroPendiente cobroPendiente = MapperUtils.EntityFromDto(cobroPendienteDto, CobroPendiente.class);
        cobroPendiente = cobroPendienteRepository.save(cobroPendiente);
        return MapperUtils.DtoFromEntity(cobroPendiente, CobroPendienteDTO.class);
    }

    @Override
    @Transactional
    public Optional<CobroPendienteDTO> update(CobroPendienteDTO cobroPendienteDTO, Long id) {
    if (cobroPendienteRepository.findById(id).isPresent()) {
            CobroPendiente cobroPendiente = MapperUtils.EntityFromDto(cobroPendienteDTO, CobroPendiente.class);
            cobroPendiente = cobroPendienteRepository.save(cobroPendiente);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cobroPendiente, CobroPendienteDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
    cobroPendienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
    cobroPendienteRepository.deleteAll();
    }
    
}
