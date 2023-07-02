package clinica.medica.domain.consulta;

import clinica.medica.domain.medico.Medico;
import clinica.medica.domain.paciente.Paciente;
import clinica.medica.dto.consulta.DTOAtualizarConsulta;
import clinica.medica.dto.consulta.DTOConsulta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "consultas")
@Table(name = "consultas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    private LocalDateTime data;

      public void atualizar(DTOAtualizarConsulta dados) {
        if (dados.data() != null){
            this.data = dados.data();
        }
    }

}
