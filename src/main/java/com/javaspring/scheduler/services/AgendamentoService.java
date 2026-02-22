package com.javaspring.scheduler.services;

import com.javaspring.scheduler.infrastructure.entity.Agendamento;
import com.javaspring.scheduler.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor // injeção de dependência da AgendamentoRepository

public class AgendamentoService {

    // Instância do repository
    private final AgendamentoRepository agendamentoRepository;

    // Método para salvar o agendamento verificando se não existe agenda já marcado para aquela dataHora
    public Agendamento salvarAgendamento(Agendamento agendamento){

        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();

        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(agendamento.getQuantidadeHoraServico());

       Agendamento agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico(), horaAgendamento, horaFim);

       if(Objects.nonNull(agendados)){
           throw new RuntimeException("O horário já está preenchido");
       }

       return agendamentoRepository.save(agendamento);

    }

    // Método para deleção de agendamentos
    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente){

        Agendamento agendamentoCliente = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

        if (Objects.isNull(agendamentoCliente)){
            throw new RuntimeException("Não existe agendamento nesse horário.");
        }

        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

    }

    // Método para buscar os agendamentos do dia
    public List<Agendamento> buscarAgendamentosDoDia(LocalDate data){
        LocalDateTime primeiraHoraDia = data.atStartOfDay();
        LocalDateTime horaFinalDia = data.atTime(23, 59, 59);

        return agendamentoRepository.findByDataHoraAgendamentoBetween(primeiraHoraDia, horaFinalDia);
    }

    public List<Agendamento> listarTodosAgendamentos(){
        return agendamentoRepository.findAll();
    }

    // Alteração de agendamento por cliente
    public Agendamento alterarAgendamento(Agendamento agendamento, LocalDateTime dataHoraAgendamento, String cliente){

        // Procurar o agendamento e guarda-lo em "agenda"
        Agendamento  agenda = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

        if(Objects.isNull(agenda)){
            throw new RuntimeException("Horário não está preenchido.");
        }

        agendamento.setId(agenda.getId());
        return agendamentoRepository.save(agendamento);

    }


}
