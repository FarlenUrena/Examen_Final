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
import org.una.cobros.dtos.ClienteDTO;
import org.una.cobros.entities.Cliente;
import org.una.cobros.repositories.IClienteRepository;
import org.una.cobros.utils.MapperUtils;
import org.una.cobros.utils.ServiceConvertionHelper;

/**
 *
 * @author farle_000
 */
@Service
public class ClienteServiceImplementation implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClienteDTO>> findAll() {
    return ServiceConvertionHelper.findList(clienteRepository.findAll(), ClienteDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findById(Long id) {
    return ServiceConvertionHelper.oneToOptionalDto(clienteRepository.findById(id), ClienteDTO.class);
    }

    @Override
    @Transactional
    public ClienteDTO create(ClienteDTO clienteDto) {
        Cliente cliente = MapperUtils.EntityFromDto(clienteDto, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return MapperUtils.DtoFromEntity(cliente, ClienteDTO.class);
    }

    @Override
    @Transactional
    public Optional<ClienteDTO> update(ClienteDTO clienteDTO, Long id) {
    if (clienteRepository.findById(id).isPresent()) {
            Cliente cliente = MapperUtils.EntityFromDto(clienteDTO, Cliente.class);
            cliente = clienteRepository.save(cliente);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(cliente, ClienteDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
    clienteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
    clienteRepository.deleteAll();
    }
    
    
}
