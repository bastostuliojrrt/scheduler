package com.javaspring.scheduler.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamento")

// Tabela Agendamento
public class Agendamento {

    // Configuração para geração automática do ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String servico, profissional, cliente, telefoneCliente;
    private Long quantidadeHoraServico;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataInsercao = LocalDateTime.now();

}
