# 🐾 ClyvoVet API

API para centralização do histórico de saúde de pets e geração de alertas preventivos.  
Projeto desenvolvido como solução para o **Challenge FIAP 2026** – turma Java Advanced.

---

# 📋 Sumário

- [Sobre o projeto](#-sobre-o-projeto)
- [Tecnologias utilizadas](#-tecnologias-utilizadas)
- [Funcionalidades principais](#-funcionalidades-principais)
- [Pré-requisitos](#-pré-requisitos)
- [Configuração do banco de dados](#-configuração-do-banco-de-dados)
- [Como executar o projeto](#-como-executar-o-projeto)
- [Documentação da API (Swagger)](#-documentação-da-api-swagger)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Principais endpoints](#-principais-endpoints)
- [Contribuição](#-contribuição)
- [Equipe](#-equipe)

---

# 📖 Sobre o projeto

O **ClyvoVet** resolve o problema da fragmentação na jornada de saúde do pet.  
Tutores, clínicas e veterinários podem registrar e consultar:

- Tutores e seus pets
- Clínicas e veterinários
- Consultas
- Vacinas
- Medicamentos
- Exames
- Alertas de saúde (vacinas vencidas, retornos pendentes, etc.)

A API segue os princípios RESTful, utilizando:

- Paginação
- Cache
- Validação de dados
- Tratamento global de exceções

---

# 🛠️ Tecnologias utilizadas

- **Java 21**
- **Spring Boot 3.4.5**
- **Spring Data JPA + Hibernate**
- **Oracle Database** (19c/21c) – JDBC via ojdbc11
- **Spring Cache**
- **Spring Validation**
- **SpringDoc OpenAPI (Swagger UI)**
- **Lombok**
- **Gradle**
- **Postman / Insomnia**

---

# ✨ Funcionalidades principais

- CRUD completo de tutores, pets, clínicas e veterinários
- Agendamento e histórico de consultas
- Registro de vacinas, medicamentos e exames
- Geração automática de alertas de saúde
- Paginação e ordenação em todas as listagens
- Cache de consultas com `@Cacheable`
- Tratamento global de erros com `@ControllerAdvice`
- Documentação interativa via Swagger UI

---

# ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

- **JDK 21**
- **Oracle Database**
- **Gradle** (opcional)
- **Git**

> O projeto já inclui o **Gradle Wrapper**.

---

# 🗄️ Configuração do banco de dados

1. Certifique-se de que o Oracle Database está em execução.
2. Crie um usuário/schema com permissões para criar tabelas e sequences.
3. Configure o arquivo:

```properties
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

> O parâmetro `ddl-auto=update` criará automaticamente as tabelas e sequences ao iniciar a aplicação.

---

# 🚀 Como executar o projeto

## Clone o repositório

```bash
git clone https://github.com/PhietroSolonoo/ClyvoVet.git
cd ClyvoVet
```

## Execute a aplicação

### Linux / Mac

```bash
./gradlew bootRun
```

### Windows

```bash
gradlew.bat bootRun
```

Ou execute diretamente a classe:

```java
ClyvovetApplication.java
```

A aplicação iniciará em:

```text
http://localhost:8080
```

---

# 📚 Documentação da API (Swagger)

Com a aplicação em execução, acesse:

```text
http://localhost:8080/swagger-ui.html
```

No Swagger UI você poderá:

- Visualizar endpoints
- Testar requisições
- Ver exemplos de request/response
- Consultar parâmetros e validações

---

# 🧱 Estrutura do projeto

```text
src/main/java/br/com/fiap/clyvovet/
├── config/            # Configurações da aplicação
├── controller/        # Controllers REST
├── dto/
│   ├── request/       # DTOs de entrada
│   └── response/      # DTOs de saída
├── enums/             # Enums do sistema
├── exception/         # Tratamento global de exceções
├── mapper/            # Conversão entre entidades e DTOs
├── model/             # Entidades JPA
├── repository/        # Interfaces Spring Data JPA
└── service/           # Regras de negócio
```

---

# 🔌 Principais endpoints

| Recurso | Método | Endpoint | Descrição |
|---|---|---|---|
| Tutores | POST | `/tutores` | Cadastrar tutor |
| Tutores | GET | `/tutores` | Listar tutores |
| Tutores | GET | `/tutores/{id}` | Buscar tutor por ID |
| Tutores | PUT | `/tutores/{id}` | Atualizar tutor |
| Tutores | DELETE | `/tutores/{id}` | Remover tutor |
| Pets | POST | `/pets` | Cadastrar pet |
| Pets | GET | `/pets` | Listar pets |
| Pets | GET | `/pets/{id}/consultas` | Consultas do pet |
| Consultas | POST | `/consultas` | Agendar consulta |
| Consultas | GET | `/consultas` | Listar consultas |
| Vacinas | POST | `/vacinas` | Registrar vacina |
| Vacinas | GET | `/vacinas/vencidas` | Vacinas vencidas |
| Alertas | GET | `/alertas/nao-lidos` | Alertas não lidos |
| Alertas | PATCH | `/alertas/{id}/lido` | Marcar alerta como lido |

> A listagem completa está disponível no Swagger.

---

# 🤝 Contribuição

Projeto desenvolvido para fins acadêmicos.  
Sugestões e melhorias são bem-vindas via issues ou pull requests.

---

# 👥 Equipe

| Nome | RM |
|---|---|
| Phietro Solon Oliveira | RM563842 |
| Matheus Almeida Ribeiro | RM562980 |
| Gustavo Barrios de Araujo | RM563358 |

---
