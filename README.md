# CarePlus_Challenge-chatbot_backend_service

Serviço de back-end para registro de conversas em um chatbot

## Integrantes

- rm553187 - Gabriel Borba
- rm553842 - Gustavo Gouvêa Soares
- rm553945 - Henrique Rafael Gomes de Souza
- rm554223 - Pedro Henrique Mello

## Tecnologias

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- MySQL
- Flyway
- Lombok

## Pré-requisitos

- JDK 17+

- Maven

- MySQL rodando localmente
  - iniciar servidor por cmd

  ```powershell
      net start mysql95
  ```

  - Alterar Username e Password em application.properties

  ```properties
  spring.datasource.url=jdbc:mysql://localhost/chatbot
  spring.datasource.username=root
  spring.datasource.password=sua_senha
  api.security.token.secret=${JWT_TOKEN:seu_secret}
  ```

  - criar banco de dados
    - Drop Database chatbot;
    - Create Database chatbot;

A aplicação sobe na porta `8080`.

## Logins Registrados para Autenticação

```json
{
  "login": "ownerLogin",
  "senha": "owner"
}
```

```json
{
  "login": "adminLogin",
  "senha": "admin"
}
```

```json
{
  "login": "commonLogin",
  "senha": "common"
}
```

## Controle de Acesso
 
A API utiliza autenticação via **Bearer Token JWT**. As permissões por rota são:
 
| Rota | Método | Acesso |
|------|--------|--------|
| `/login` | `POST` | Público |
| `/health-check` | `GET` | Público |
| `/mensagens/**` | `GET` | Público |
| `/mensagens/**` | demais | ADMIN ou OWNER |
| `/usuarios/**` | todos | ADMIN ou OWNER |
| `/auth-logins/**` | todos | OWNER |
 
## Endpoints
 
### Autenticação
 
| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/login` | Efetuar login e obter token JWT |

Body da requisição:
```json
{
    "login": "ownerLogin",
    "senha": "owner"
}
```
 
### Health Check
 
| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/health-check` | Verificar se a aplicação está no ar |
 
### Usuários
 
| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/usuarios` | Cadastrar novo usuário |
| `GET` | `/usuarios` | Listar todos os usuários ativos |
| `GET` | `/usuarios/all` | Listar todos os usuários |
| `GET` | `/usuarios/id/{id}` | Buscar usuário por ID |
| `DELETE` | `/usuarios/{id}` | Excluir usuário |
 
Body para cadastro:
```json
{
    "celular": "5511942426769"
}
```
 
### Mensagens
 
| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/mensagens` | Cadastrar nova mensagem |
| `GET` | `/mensagens` | Listar todas as mensagens |
| `GET` | `/mensagens/usuario/{id}` | Listar mensagens de um usuário |
| `GET` | `/mensagens/mensagem/{id}` | Buscar mensagem por ID |
| `DELETE` | `/mensagens/{id}` | Excluir mensagem |
 
Corpo para cadastro:
```json
{
    "role": "user",
    "content": "olá",
    "usuario_id": "1"
}
```
 
### Logins de Autenticação
 
| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/auth-logins` | Cadastrar novo login |
| `GET` | `/auth-logins` | Listar todos os logins |
| `GET` | `/auth-logins/{id}` | Buscar login por ID |
| `DELETE` | `/auth-logins/{id}` | Excluir login |
 
Corpo para cadastro:
```json
{
    "login": "ownerLogin",
    "senha": "$2a$10$hash_bcrypt_aqui",
    "perfil": "OWNER"
}
```
 
> A senha deve ser enviada já encriptada com BCrypt. Para gerar um hash, execute a classe `EncriptadorDeSenha` localizada em `src\test\java\br\com\chatbot\EncriptadorDeSenha.java/`.
 
## Migrations
 
As migrations do banco de dados são gerenciadas pelo Flyway e ficam em `src/main/resources/db/migration`. Ao subir a aplicação, o Flyway aplica automaticamente todas as migrations pendentes.