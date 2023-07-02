package clinica.medica.repository;

import clinica.medica.domain.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select p.ativo
            from pacientes p
            where p.id = :idPaciente
            """)
    Boolean findAtivoById(Long idPaciente);
}
