# 🎫 RelaTech — Backend

API REST desenvolvida com Spring Boot para o sistema de máscaras de atendimento RelaTech.

## 🛠️ Tecnologias

- Java 21
- Spring Boot 3.5
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Maven

## 📦 Endpoints

### Autenticação (público)
| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /api/auth/register | Cadastro de usuário |
| POST | /api/auth/login | Login e geração de token |

### Máscaras (autenticado)
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | /api/masks | Lista máscaras do usuário |
| GET | /api/masks/{id} | Busca uma máscara |
| POST | /api/masks | Cria uma máscara |
| PUT | /api/masks/{id} | Atualiza uma máscara |
| DELETE | /api/masks/{id} | Deleta uma máscara |

## 🔐 Autenticação

Todas as rotas de máscaras exigem token JWT no header:
```
Authorization: Bearer SEU_TOKEN
```

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
spring.jpa.hibernate.ddl-auto=update
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