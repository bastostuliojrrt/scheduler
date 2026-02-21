# 🚀 API REST de Agendamentos  
### Backend em Java com Spring Boot | Arquitetura em Camadas | Boas Práticas

Este projeto foi desenvolvido com foco em demonstrar competências essenciais para atuação como **Desenvolvedor Java Júnior**, aplicando fundamentos sólidos de backend, organização de código e arquitetura.

A aplicação consiste em uma API REST completa para gerenciamento de agendamentos, implementando um CRUD estruturado com separação clara de responsabilidades.

---

## 💼 O que este projeto demonstra para recrutadores

✔ Capacidade de estruturar uma aplicação backend real  
✔ Entendimento de arquitetura em camadas (Controller → Service → Repository)  
✔ Aplicação prática de Spring Boot e Spring Data JPA  
✔ Organização e legibilidade de código  
✔ Uso correto de injeção de dependência 

---

## 🛠️ Stack Tecnológica

- **Java**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Banco de dados H2**

---

## 🏗️ Arquitetura Aplicada

A aplicação segue o padrão de arquitetura em camadas:

### 🔹 Controller
Responsável pelo mapeamento dos endpoints REST e tratamento das requisições HTTP.

### 🔹 Service
Camada de regras de negócio, centralizando a lógica da aplicação e garantindo organização.

### 🔹 Repository
Interface responsável pelo acesso ao banco de dados utilizando Spring Data JPA.

### 🔹 Model (Entity)
Classe `Agendamento` mapeada com JPA para persistência em banco relacional.

---

## 🔎 Funcionalidades Implementadas

- ✅ Criar agendamento
- ✅ Listar todos os agendamentos
- ✅ Buscar por nome do serviço e data do agendamento
- ✅ Atualizar agendamento
- ✅ Deletar agendamento

CRUD completo seguindo padrão REST.

---

## 📂 Estrutura do Projeto
```text
src/main/java/
 ├── controller/
 │     └── AgendamentoController.java
 ├── service/
 │     └── AgendamentoService.java
 ├── repository/
 │     └── AgendamentoRepository.java
 ├── model/
 │     └── Agendamento.java
```
---

## ▶️ Como Executar

Faça um fork do repositório
```
https://github.com/bastostuliojrrt/scheduler.git
```
Execute o projeto usando o IntelliJ

## 🗄️ Acessando Banco de Dados

Após subir o projeto, acesse: 
```
http://localhost:8080/h2-console/
```

## 🌐 Utilize o Postman/Insomnia

Exemplo de requisições:

---
POST Body:
```
{
	"servico" : "Tatuagem",
	"profissional" : "Marcelo",
	"cliente": "João",
	"telefoneCliente" : "(99) 99999-9999",
	"quantidadeHoraServico" : 2,
	"dataHoraAgendamento" : "2026-02-25T19:00"
}
```
---
GET Params: 
```
data: 2026-02-25
```
---
PUT Params:
```
dataHoraAgendamento: 2026-02-25T19:00:00
cliente: João
```
PUT Body:
```
{
	"servico" : "Tatuagem",
	"profissional" : "Igor",
	"cliente": "Felipe",
	"telefoneCliente" : "(99) 99999-9999",
	"quantidadeHoraServico" : 4,
	"dataHoraAgendamento" : "2026-02-25T15:00"	
}
```
---
DELETE Params:
```
dataHoraAgendamento: 2026-02-25T15:00
cliente: Felipe
```
---

## 📚 Conceitos Aplicados

- **Programação Orientada a Objetos (POO)**
- **Injeção de Dependência**
- **API RESTful**
- **CRUD completo**
- **Separação de responsabilidades**
- **Organização de código para manutenção futura**
