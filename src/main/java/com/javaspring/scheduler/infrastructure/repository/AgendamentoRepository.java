package com.javaspring.scheduler.infrastructure.repository;

import com.javaspring.scheduler.infrastructure.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository  extends JpaRepository<Agendamento, Long> {
}
