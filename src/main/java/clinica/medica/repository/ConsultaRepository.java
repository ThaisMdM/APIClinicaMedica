package clinica.medica.repository;

import clinica.medica.domain.consulta.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;


public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    boolean existsByPacienteIdAndData(Long idPaciente, LocalDateTime data);

   Page <Consulta> findAllByAtivoTrue(Pageable paginacao);



}
