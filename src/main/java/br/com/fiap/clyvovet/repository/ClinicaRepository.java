package br.com.fiap.clyvovet.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.fiap.clyvovet.model.Clinica;

public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
    List<Clinica> findByNomeContainingIgnoreCase(String nome);
    Clinica findByCnpj(String cnpj);
    List<Clinica> findByCidadeIgnoreCase(String cidade);

    @Query("SELECT c FROM Clinica c JOIN c.veterinarios v WHERE v.especialidade = :especialidade")
    List<Clinica> findClinicasPorEspecialidadeVeterinario(String especialidade);
}