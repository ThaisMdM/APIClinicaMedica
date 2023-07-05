package clinica.medica.controller;

import clinica.medica.dto.medico.DTOAtualizaMedico;
import clinica.medica.dto.medico.DTOMedico;
import clinica.medica.repository.MedicoRepository;
import clinica.medica.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MedicoService medico;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DTOMedico dados, UriComponentsBuilder uriBuilder){
       var dadosMedico = medico.cadastrar(dados);
       var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(dadosMedico.id()).toUri();
       return ResponseEntity.created(uri).body(dadosMedico);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var lista = medico.listar(paginacao);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarId (@PathVariable Long id){
      var lista = medico.listarId(id);
      return ResponseEntity.ok(lista);
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DTOAtualizaMedico dados){
        var atualiza = medico.atualizar(dados);
        return ResponseEntity.ok(atualiza);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id){
        medico.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
