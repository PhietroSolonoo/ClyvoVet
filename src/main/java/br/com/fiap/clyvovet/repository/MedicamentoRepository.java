package br.com.fiap.clyvovet.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.fiap.clyvovet.model.Medicamento;
import br.com.fiap.clyvovet.enums.StatusMedicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    List<Medicamento> findByPetId(Long petId);
    List<Medicamento> findByStatusMedicamento(StatusMedicamento status);
    List<Medicamento> findByConsultaId(Long consultaId);

    @Query("SELECT m FROM Medicamento m WHERE m.statusMedicamento = 'ATIVO' AND m.dataFim < CURRENT_DATE")
    List<Medicamento> findMedicamentosAtivosExpirados();
}