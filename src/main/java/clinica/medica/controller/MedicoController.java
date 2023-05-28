package clinica.medica.controller;

import clinica.medica.domain.medico.*;
import clinica.medica.dto.medico.DTOAtualizaMedico;
import clinica.medica.dto.medico.DTOConsultaMedico;
import clinica.medica.dto.medico.DTOMedico;
import clinica.medica.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DTOMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTOConsultaMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DTOConsultaMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DTOConsultaMedico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarId (@PathVariable Long id){
      var medico = repository.getReferenceById(id);
      return ResponseEntity.ok(new DTOConsultaMedico(medico));
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DTOAtualizaMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizar(dados);
        return ResponseEntity.ok(new DTOConsultaMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

}
