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
import org.una.cobros.dtos.MembresiaDTO;
import org.una.cobros.entities.Membresia;
import org.una.cobros.repositories.IMembresiaRepository;
import org.una.cobros.utils.MapperUtils;
import org.una.cobros.utils.ServiceConvertionHelper;

/**
 *
 * @author farle_000
 */
@Service
public class MembresiaServiceImplementation implements IMembresiaService {
@Autowired
    private IMembresiaRepository membresiaRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<MembresiaDTO>> findAll() {
    return ServiceConvertionHelper.findList(membresiaRepository.findAll(), MembresiaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MembresiaDTO> findById(Long id) {
    return ServiceConvertionHelper.oneToOptionalDto(membresiaRepository.findById(id), MembresiaDTO.class);
    }

    @Override
    @Transactional
    public MembresiaDTO create(MembresiaDTO membresiaDto) {
        Membresia membresia = MapperUtils.EntityFromDto(membresiaDto, Membresia.class);
        membresia = membresiaRepository.save(membresia);
        return MapperUtils.DtoFromEntity(membresia, MembresiaDTO.class);
    }

    @Override
    @Transactional
    public Optional<MembresiaDTO> update(MembresiaDTO membresiaDTO, Long id) {
    if (membresiaRepository.findById(id).isPresent()) {
            Membresia membresia = MapperUtils.EntityFromDto(membresiaDTO, Membresia.class);
            membresia = membresiaRepository.save(membresia);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(membresia, MembresiaDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
    membresiaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
    membresiaRepository.deleteAll();
    }
}
