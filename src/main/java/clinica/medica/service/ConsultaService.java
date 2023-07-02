package clinica.medica.service;

import clinica.medica.domain.consulta.Consulta;
import clinica.medica.dto.consulta.DTOConsulta;
import clinica.medica.dto.consulta.DTODetalhesConsulta;
import clinica.medica.regrasNegocio.ValidadorLista;
import clinica.medica.repository.ConsultaRepository;
import clinica.medica.repository.MedicoRepository;
import clinica.medica.repository.PacienteRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
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
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
        return new DTODetalhesConsulta(consulta);
    }




}
