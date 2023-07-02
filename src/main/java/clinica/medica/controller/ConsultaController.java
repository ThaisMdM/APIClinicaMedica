package clinica.medica.controller;

import clinica.medica.dto.consulta.DTOAtualizarConsulta;
import clinica.medica.dto.consulta.DTOConsulta;
import clinica.medica.dto.consulta.DTODetalhesConsulta;
import clinica.medica.dto.medico.DTOAtualizaMedico;
import clinica.medica.dto.medico.DTOConsultaMedico;
import clinica.medica.repository.ConsultaRepository;
import clinica.medica.service.ConsultaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consulta;
    @Autowired
    private ConsultaRepository consultaRepository;


    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DTOConsulta dados){
       var body = consulta.agendar(dados);
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity<Page<DTODetalhesConsulta>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = consultaRepository.findAll(paginacao).map(DTODetalhesConsulta::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarId (@PathVariable Long id){
        var consulta = consultaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DTODetalhesConsulta(consulta));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DTOAtualizarConsulta dados){
        var consulta = consultaRepository.getReferenceById(dados.id());
        consulta.atualizar(dados);
        return ResponseEntity.ok(new DTODetalhesConsulta(consulta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id){
        consultaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
