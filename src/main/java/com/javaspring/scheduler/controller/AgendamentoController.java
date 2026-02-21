package com.javaspring.scheduler.controller;

import com.javaspring.scheduler.infrastructure.entity.Agendamento;
import com.javaspring.scheduler.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento){
        return  ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam LocalDateTime dataHoraAgendamento, @RequestParam String cliente){
        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> buscarAgendamentosDoDia(LocalDate data){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDoDia(data));
    }

    @PutMapping
    public ResponseEntity<Agendamento> alterarAgendamento(@RequestBody Agendamento agendamento, @RequestParam LocalDateTime dataHoraAgendamento, @RequestParam String cliente){

        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamento, dataHoraAgendamento, cliente));

    }

}
