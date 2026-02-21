package com.javaspring.scheduler.infrastructure.repository;

import com.javaspring.scheduler.infrastructure.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface AgendamentoRepository  extends JpaRepository<Agendamento, Long> {

    Agendamento findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFinal);

    // DELETE
    @Transactional
    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

    //GET por dia
    Agendamento findByDataHoraAgendamentoBetween(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);

    // Alteração do agendamento
    Agendamento findByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

}
