package clinica.medica.service;

import clinica.medica.domain.consulta.Consulta;
import clinica.medica.dto.consulta.DTOAtualizarConsulta;
import clinica.medica.dto.consulta.DTOExcluirConsulta;
import clinica.medica.dto.consulta.DTOConsulta;
import clinica.medica.dto.consulta.DTODetalhesConsulta;
import clinica.medica.dto.medico.DTOConsultaMedico;
import clinica.medica.regrasNegocio.ValidadorLista;
import clinica.medica.repository.ConsultaRepository;
import clinica.medica.repository.MedicoRepository;
import clinica.medica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidadorLista> validadores;


    public DTODetalhesConsulta agendar(DTOConsulta dados){
        validadores.forEach(v -> v.validar(dados));
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = medicoRepository.findById(dados.idMedico()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data(), true, null);
        consultaRepository.save(consulta);
        return new DTODetalhesConsulta(consulta);
    }

    public DTODetalhesConsulta atualizar (DTOAtualizarConsulta dados){
        var consulta = consultaRepository.getReferenceById(dados.id());
        consulta.atualizar(dados);
        return new DTODetalhesConsulta(consulta);
    }

    public Page<DTODetalhesConsulta> listar (Pageable paginacao){
        var lista = consultaRepository.findAllByAtivoTrue(paginacao).map(DTODetalhesConsulta::new);
        return lista;
    }

    public DTODetalhesConsulta listarId (Long id){
        var consulta = consultaRepository.getReferenceById(id);
        return new DTODetalhesConsulta(consulta);
    }

    public void excluir(DTOExcluirConsulta dados) {
        var deletar = consultaRepository.getReferenceById(dados.id());
        deletar.excluir(dados);

    }

}
