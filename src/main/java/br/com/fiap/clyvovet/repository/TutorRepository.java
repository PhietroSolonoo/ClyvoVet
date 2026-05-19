package br.com.fiap.clyvovet.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.clyvovet.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    // Busca por nome contendo (ignorando maiúsculas/minúsculas)
    List<Tutor> findByNomeContainingIgnoreCase(String nome);

    // Busca por email (exato, para login/validação)
    Tutor findByEmail(String email);

    // Busca por CPF
    Tutor findByCpf(String cpf);

    // Busca paginada por nome contendo
    Page<Tutor> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    // JPQL: busca tutores que tenham pets com espécie específica
    @Query("SELECT DISTINCT t FROM Tutor t JOIN t.pets p WHERE p.especie = :especie")
    List<Tutor> findTutoresByPetEspecie(@Param("especie") String especie);
}