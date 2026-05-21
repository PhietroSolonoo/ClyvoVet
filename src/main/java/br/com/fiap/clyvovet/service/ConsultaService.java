package br.com.fiap.clyvovet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.clyvovet.dto.request.ConsultaRequest;
import br.com.fiap.clyvovet.dto.response.ConsultaResponse;
import br.com.fiap.clyvovet.exception.ResourceNotFoundException;
import br.com.fiap.clyvovet.mapper.ConsultaMapper;
import br.com.fiap.clyvovet.model.Consulta;
import br.com.fiap.clyvovet.repository.ConsultaRepository;
import br.com.fiap.clyvovet.repository.PetRepository;
import br.com.fiap.clyvovet.repository.VeterinarioRepository;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private ConsultaMapper consultaMapper;

    @Transactional
    @CacheEvict(value = "consultas", allEntries = true)
    public ConsultaResponse create(ConsultaRequest request) {
        if (!petRepository.existsById(request.getPetId())) {
            throw new ResourceNotFoundException("Pet não encontrado com id: " + request.getPetId());
        }
        if (!veterinarioRepository.existsById(request.getVeterinarioId())) {
            throw new ResourceNotFoundException("Veterinário não encontrado com id: " + request.getVeterinarioId());
        }
        Consulta consulta = consultaMapper.toEntity(request);
        consulta = consultaRepository.save(consulta);
        return consultaMapper.toResponse(consulta);
    }

    @Cacheable(value = "consultas", key = "#id")
    public ConsultaResponse findById(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com id: " + id));
        return consultaMapper.toResponse(consulta);
    }

    @Cacheable(value = "consultas")
    public Page<ConsultaResponse> findAll(Pageable pageable) {
        return consultaRepository.findAll(pageable)
                .map(consultaMapper::toResponse);
    }

    @Transactional
    @CacheEvict(value = "consultas", allEntries = true)
    public ConsultaResponse update(Long id, ConsultaRequest request) {
        if (!consultaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Consulta não encontrada para atualização com id: " + id);
        }
        if (!petRepository.existsById(request.getPetId())) {
            throw new ResourceNotFoundException("Pet não encontrado com id: " + request.getPetId());
        }
        if (!veterinarioRepository.existsById(request.getVeterinarioId())) {
            throw new ResourceNotFoundException("Veterinário não encontrado com id: " + request.getVeterinarioId());
        }
        Consulta consulta = consultaMapper.toEntity(request);
        consulta.setId(id);
        consulta = consultaRepository.save(consulta);
        return consultaMapper.toResponse(consulta);
    }

    @Transactional
    @CacheEvict(value = "consultas", allEntries = true)
    public void delete(Long id) {
        if (!consultaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Consulta não encontrada para exclusão com id: " + id);
        }
        consultaRepository.deleteById(id);
    }
}