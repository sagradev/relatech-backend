# 🎫 RelaTech — Backend

API REST desenvolvida com Spring Boot para servir o sistema de máscaras de atendimento RelaTech.

## 🛠️ Tecnologias

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Maven

## 📦 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | /api/masks | Lista todas as máscaras |
| GET | /api/masks/{id} | Busca uma máscara |
| POST | /api/masks | Cria uma máscara |
| PUT | /api/masks/{id} | Atualiza uma máscara |
| DELETE | /api/masks/{id} | Deleta uma máscara |

## 🚀 Como rodar localmente

### Pré-requisitos
- Java 21
- PostgreSQL instalado e rodando
- Banco de dados `relatech` criado

### Configuração
Em `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/relatech
spring.datasource.username=postgres
spring.datasource.password=sua-senha
```

### Rodando
```bash
# Clone o repositório
git clone https://github.com/sagradev/relatech-backend.git

# Abra no IntelliJ e rode o BackendApplication.java
```

## 🌐 Deploy

Hospedado no Railway com PostgreSQL.

## 📌 Projeto

Backend do RelaTech, desenvolvido como projeto de portfólio para praticar Spring Boot e integração com frontend React.