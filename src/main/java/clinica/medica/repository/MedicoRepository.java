package clinica.medica.repository;


import clinica.medica.domain.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicoRepository extends JpaRepository <Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select m.ativo
             from medicos m
             where m.id = :idMedico             
            """)
    Boolean findAtivoById(Long idMedico);

}
