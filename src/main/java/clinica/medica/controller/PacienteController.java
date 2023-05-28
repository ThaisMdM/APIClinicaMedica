package clinica.medica.controller;


import clinica.medica.domain.paciente.*;
import clinica.medica.dto.paciente.DTOAtualizaPaciente;
import clinica.medica.dto.paciente.DTOConsultaPaciente;
import clinica.medica.dto.paciente.DTOPaciente;
import clinica.medica.repository.PacienteRepository;
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
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DTOPaciente dados, UriComponentsBuilder uriBuilder){
       var paciente = new Paciente(dados);
       repository.save(paciente);
       var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
       return ResponseEntity.created(uri).body(new DTOConsultaPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DTOConsultaPaciente>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DTOConsultaPaciente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarID (@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DTOConsultaPaciente(paciente));
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DTOAtualizaPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizar(dados);
        return ResponseEntity.ok(new DTOConsultaPaciente(paciente));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }

}
