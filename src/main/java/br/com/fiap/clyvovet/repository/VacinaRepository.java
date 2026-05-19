package br.com.fiap.clyvovet.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.fiap.clyvovet.model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    List<Vacina> findByPetId(Long petId);
    List<Vacina> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT v FROM Vacina v WHERE v.dataProximaDose < :hoje")
    List<Vacina> findVacinasVencidas(@Param("hoje") LocalDate hoje);

    @Query("SELECT v FROM Vacina v WHERE v.dataProximaDose BETWEEN :hoje AND :limite")
    List<Vacina> findVacinasProximas(@Param("hoje") LocalDate hoje, @Param("limite") LocalDate limite);
}