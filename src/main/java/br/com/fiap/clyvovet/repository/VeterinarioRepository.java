package br.com.fiap.clyvovet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.clyvovet.model.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
    List<Veterinario> findByNomeContainingIgnoreCase(String nome);
    Veterinario findByCrmv(String crmv);
    List<Veterinario> findByEspecialidadeContainingIgnoreCase(String especialidade);
    List<Veterinario> findByClinicaId(Long clinicaId);
}