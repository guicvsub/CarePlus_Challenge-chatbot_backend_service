# CarePlus_Challenge-chatbot_backend_service

Serviço de back-end para registro de conversas em um chatbot

## Integrantes

- rm553187 - Gabriel Borba
- rm553842 - Gustavo Gouvêa Soares
- rm553945 - Henrique Rafael Gomes de Souza
- rm554223 - Pedro Henrique Mello

## MySQL

- iniciar servidor por cmd
  ```powershell
      net start mysql95
  ```
- Alterar Username e Password em application.properties
- Manipulação do banco pelo MySQL Workbench
  - criar banco de dados
    - Drop Database chatbot;
    - Create Database chatbot;

## Dados para POSTMAN

- Logins Registrados para Autenticação
  - Postman

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

## Endpoints

- usuarios
  - get geral
  - get geral ativo
  - get id
  - post
  - delete
- mensagens
  - get geral
  - get id
  - get id_usuarios
  - post
- auth_logins
  - get geral
  - get id
  - post
  - delete
