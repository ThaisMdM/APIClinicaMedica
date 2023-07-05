package clinica.medica.service;


import clinica.medica.domain.medico.Medico;
import clinica.medica.dto.medico.DTOAtualizaMedico;
import clinica.medica.dto.medico.DTOConsultaMedico;
import clinica.medica.dto.medico.DTOMedico;
import clinica.medica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MedicoService {


    @Autowired
    private MedicoRepository medicoRepository;


    public DTOConsultaMedico cadastrar (DTOMedico dados){
        var medico = new Medico(dados);
        medicoRepository.save(medico);
        return new DTOConsultaMedico(medico);
    }

    public DTOConsultaMedico atualizar (DTOAtualizaMedico dados){
        var atualizar = medicoRepository.getReferenceById(dados.id());
        atualizar.atualizar(dados);
       return new DTOConsultaMedico(atualizar);
    }

    public Page<DTOConsultaMedico> listar (Pageable paginacao){
        var lista = medicoRepository.findAllByAtivoTrue(paginacao).map(DTOConsultaMedico::new);
        return lista;
    }

    public DTOConsultaMedico listarId (Long id){
        var medico = medicoRepository.getReferenceById(id);
        return new DTOConsultaMedico(medico);
    }

    public void excluir (Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir(id);
    }


}
