package br.com.fiap.clyvovet.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.fiap.clyvovet.model.Consulta;
import br.com.fiap.clyvovet.enums.StatusConsulta;
import br.com.fiap.clyvovet.enums.TipoConsulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByPetId(Long petId);
    List<Consulta> findByVeterinarioId(Long veterinarioId);
    List<Consulta> findByStatusConsulta(StatusConsulta status);
    List<Consulta> findByTipoConsulta(TipoConsulta tipo);
    Page<Consulta> findByPetId(Long petId, Pageable pageable);

    @Query("SELECT c FROM Consulta c WHERE c.dataHora BETWEEN :inicio AND :fim")
    List<Consulta> findConsultasNoPeriodo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

    @Query("SELECT c FROM Consulta c WHERE c.statusConsulta = :status AND c.dataHora < :agora")
    List<Consulta> findConsultasAtrasadas(@Param("status") StatusConsulta status, @Param("agora") LocalDateTime agora);
}