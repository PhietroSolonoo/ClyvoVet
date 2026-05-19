package br.com.fiap.clyvovet.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.clyvovet.model.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {
    List<Exame> findByPetId(Long petId);
    List<Exame> findByTipoContainingIgnoreCase(String tipo);
    List<Exame> findByConsultaId(Long consultaId);
    List<Exame> findByDataRealizacaoBetween(LocalDate inicio, LocalDate fim);
}