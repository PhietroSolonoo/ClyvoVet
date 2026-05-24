# 🐾 ClyvoVet API

API para centralização do histórico de saúde de pets e geração de alertas preventivos.  
Projeto desenvolvido como solução para o **Challenge FIAP 2026** – turma Java Advanced.

---

## 📋 Sumário

- [📖 Sobre o projeto](#-sobre-o-projeto)
- [🛠️ Tecnologias utilizadas](#️-tecnologias-utilizadas)
- [⚙️ Pré-requisitos](#️-pré-requisitos)
- [🗄️ Configuração do banco de dados](#️-configuração-do-banco-de-dados)
- [🚀 Como executar o projeto](#-como-executar-o-projeto)
- [🧪 Testando a API](#-testando-a-api)
- [📚 Documentação da API (Swagger)](#-documentação-da-api-swagger)
- [🧱 Estrutura do projeto](#-estrutura-do-projeto)
- [📂 Artefatos de documentação](#-artefatos-de-documentação)
- [👥 Equipe](#-equipe)

---

## 📖 Sobre o projeto

O **ClyvoVet** resolve o problema da fragmentação na jornada de saúde do pet.  
Tutores, clínicas e veterinários podem registrar e consultar:

- Tutores e seus pets
- Clínicas e veterinários
- Consultas, vacinas, medicamentos e exames
- Alertas de saúde (vacinas vencidas, retornos pendentes, etc.)

A API segue os princípios RESTful, utiliza:

- Paginação
- Cache
- Validação de dados
- Tratamento global de exceções

---

## 🛠️ Tecnologias utilizadas

- **Java 21**
- **Spring Boot 3.4.5**
- **Spring Data JPA** + **Hibernate**
- **Oracle Database** (19c/21c) – JDBC via ojdbc11
- **Spring Cache** (simple)
- **Spring Validation** (Bean Validation)
- **SpringDoc OpenAPI** (Swagger UI)
- **Lombok**
- **Gradle** (build tool)
- **Postman / Insomnia** (testes de API)

---

## ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **JDK 21** (ou superior compatível)
- **Oracle Database** (local ou remoto)
- **Gradle** (opcional – o projeto inclui o Gradle Wrapper)
- **Git**
- **Postman** (opcional)

---

## 🗄️ Configuração do banco de dados

1. Certifique-se de que o Oracle Database está ativo.
2. Crie um usuário/schema com privilégios para criar tabelas e sequences.
3. Altere o arquivo `src/main/resources/application.properties` com as suas credenciais:

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update

> **Nota:** O parâmetro `spring.jpa.hibernate.ddl-auto=update` criará automaticamente as tabelas e sequences ao iniciar a aplicação.

---

# 🚀 Como executar o projeto

## 1. Clone o repositório

```bash
git clone https://github.com/PhietroSolonoo/ClyvoVet.git
cd ClyvoVet
```

## 2. Execute a aplicação via Gradle Wrapper

### Linux / Mac

```bash
./gradlew bootRun
```

### Windows

```bash
gradlew.bat bootRun
```

Ou via IntelliJ IDEA: abra o projeto e execute a classe `ClyvovetApplication`.

A aplicação iniciará na porta `8080`.

Você verá no console:

```text
Started ClyvovetApplication ...
```

---

# 🧪 Testando a API

## ✅ 1. Usando o Swagger UI (recomendado)

Acesse:

```text
http://localhost:8080/swagger-ui.html
```

Lá você pode:

- Visualizar todos os endpoints
- Ver parâmetros e exemplos
- Executar requisições diretamente no navegador

---

## ✅ 2. Usando a coleção Postman

A coleção Postman com todos os endpoints está disponível na pasta `documents/`.

### Como importar

1. Abra o Postman
2. Clique em **File → Import**
3. Vá na aba **Upload Files**
4. Selecione o arquivo:

```text
documents/ClyvoVet API.postman_collection.json
```

A coleção aparecerá automaticamente na barra lateral.

---

### Ordem recomendada para testes

Execute as requisições nesta ordem:

1. Tutores
2. Pets
3. Clínicas
4. Veterinários
5. Consultas
6. Vacinas
7. Medicamentos
8. Exames
9. Alertas

---

### Observações

Para endpoints `GET`, utilize filtros como:

```http
GET /pets?especie=CACHORRO
```

Para `POST`, `PUT` e `DELETE`, garanta que os IDs relacionados existam no banco.

---

## ✅ 3. Exemplos de endpoints

```http
POST   /tutores
GET    /tutores
GET    /tutores/{id}
PUT    /tutores/{id}
DELETE /tutores/{id}

GET    /pets?tutorId=1

GET    /vacinas/vencidas

PATCH  /alertas/{id}/lido
```

---

## ✅ 4. Populando o banco

O banco será criado vazio.

Você pode:

- Inserir dados manualmente via Postman
- Executar scripts SQL da pasta `documents/` (caso existam)

### Recomendação mínima de dados

- 2 tutores
- 2 pets
- 1 clínica
- 1 veterinário
- 1 consulta

---

# 📚 Documentação da API (Swagger)

Com a aplicação em execução, acesse:

```text
http://localhost:8080/swagger-ui.html
```

A interface Swagger permite:

- Navegar pelos endpoints
- Ver exemplos de request/response
- Testar a API diretamente

---

# 🧱 Estrutura do projeto

```text
src/main/java/br/com/fiap/clyvovet/
├── config/            # Configurações (Cache, Swagger)
├── controller/        # 9 controllers REST
├── dto/
│   ├── request/       # DTOs de entrada com validação
│   └── response/      # DTOs de saída
├── enums/             # Enums do sistema
├── exception/         # Exceptions e handler global
├── mapper/            # Conversores DTO ↔ Entity
├── model/             # Entidades JPA
├── repository/        # Interfaces Spring Data JPA
└── service/           # Regras de negócio e cache
```

---

# 📂 Artefatos de documentação

A pasta `documents/` contém:

| Arquivo | Descrição |
|---|---|
| `ClyvoVet API.postman_collection.json` | Coleção completa do Postman |
| `der.png` | DER gerado no Oracle SQL Developer |
| `diagrama-classes.png` | Diagrama UML gerado no IntelliJ IDEA |
| `cronograma.md` | Cronograma detalhado do projeto |

---

# 👥 Equipe

| Nome | RM |
|---|---|
| Phietro Solon Oliveira | RM563842 |
| Matheus Almeida Ribeiro | RM562980 |
| Gustavo Barrios de Araujo | RM563358 |
