Este é um projeto de backend para gerenciamento de um sistema de supermercado, desenvolvido em **Java com Spring Boot** seguindo a **arquitetura hexagonal (Ports and Adapters)**. Ele simula operações comuns de um supermercado, como cadastro de produtos, gerenciamento de pedidos, controle de clientes e autenticação de usuários.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3+**
- **Spring Web**
- **Spring Data MongoDB**
- **Spring Security (com autenticação básica)**
- **Swagger/OpenAPI 3 (springdoc-openapi)**
- **MongoDB** (banco NoSQL)
- **Lombok**
- **Maven**
- **JUnit / Spring Boot Test**
- **REST Client do VS Code (.http)**

---

## 🧱 Arquitetura Hexagonal

O projeto segue a arquitetura hexagonal (Ports and Adapters), separando as responsabilidades em:

- **Domain**: regras de negócio (entidades, serviços, interfaces)
- **Application**: lógica de aplicação (casos de uso)
- **Adapters**:
  - `inbound`: Controllers REST
  - `outbound`: Repositórios (MongoDB)
- **Configuration**: beans, segurança e Swagger

---

## 🔐 Segurança

A aplicação utiliza **Spring Security com autenticação básica (sem JWT)**. Usuários estão definidos em memória para testes:

| Usuário | Senha | Perfil |
|--------|-------|--------|
| admin  | 123   | ADMIN  |

---

## 📚 Documentação da API

A documentação interativa da API pode ser acessada após rodar a aplicação:

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 📦 Endpoints Principais

### Produtos

- `GET /api/produtos`: lista todos os produtos
- `POST /api/produtos`: cria um novo produto
- `PUT /api/produtos/{id}`: atualiza um produto
- `DELETE /api/produtos/{id}`: remove um produto

### Clientes

- `GET /api/clientes`
- `POST /api/clientes`
- `PUT /api/clientes/{id}`
- `DELETE /api/clientes/{id}`

### Pedidos

- `GET /api/pedidos`
- `POST /api/pedidos`: cria um novo pedido baseado no cliente e itens do carrinho

---

## 🧪 Testes

Os testes são feitos com **JUnit e Spring Boot Test**, cobrindo:

- Repositórios
- Serviços
- Controladores

Você pode rodar os testes com:

```bash
./mvnw test
🧪 Testes com REST Client (.http)
