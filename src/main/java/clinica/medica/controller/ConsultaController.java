package clinica.medica.controller;

import clinica.medica.dto.consulta.DTOExcluirConsulta;
import clinica.medica.dto.consulta.DTOAtualizarConsulta;
import clinica.medica.dto.consulta.DTOConsulta;
import clinica.medica.service.ConsultaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consulta;


    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DTOConsulta dados){
       var body = consulta.agendar(dados);
        return ResponseEntity.ok(body);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
      var lista = consulta.listar(paginacao);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarId (@PathVariable Long id){
        var lista = consulta.listarId(id);
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DTOAtualizarConsulta dados){
        var atualiza = consulta.atualizar(dados);
        return ResponseEntity.ok(atualiza);
    }

    @DeleteMapping()
    @Transactional
    public ResponseEntity excluir (@RequestBody DTOExcluirConsulta dados){
        consulta.excluir(dados);
        return ResponseEntity.noContent().build();
    }

}
