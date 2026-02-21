package com.javaspring.scheduler.services;

import com.javaspring.scheduler.infrastructure.entity.Agendamento;
import com.javaspring.scheduler.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor // injeção de dependência da AgendamentoRepository

public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento){

        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();

        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours((Long) agendamento.getQuantidadeHoraServico());

    }

}
