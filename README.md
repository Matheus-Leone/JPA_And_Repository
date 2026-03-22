# 📘 API REST - Cadastro de Clientes (Spring Boot)

## 📌 Descrição

Este projeto consiste no desenvolvimento de uma API REST utilizando Spring Boot para gerenciamento de clientes.

A aplicação permite realizar operações básicas de CRUD, além de consultas específicas por nome e e-mail.

---

## 🛠️ Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Banco de Dados (H2, MySQL ou outro)
* Maven

---

## 📂 Estrutura do Projeto

```
src/
 ├── Controller
 │    └── ClienteController.java
 ├── Model
 │    └── Cliente.java
 ├── Repository
 │    └── ClienteRepository.java
```

---

## 📌 Entidade: Cliente

A classe Cliente possui os seguintes atributos:

* `id` (Long) — Identificador único (gerado automaticamente)
* `nome` (String) — Obrigatório, até 120 caracteres
* `email` (String) — Obrigatório
* `telefone` (String) — Opcional
* `cpf` (String) — Obrigatório e único

---

## 🔄 Funcionalidades

### ✅ Cadastrar cliente

* **POST** `/clientes`

**Exemplo JSON:**

```json
{
  "nome": "Matheus Leone",
  "email": "matheus@email.com",
  "telefone": "15999999999",
  "cpf": "12345678900"
}
```

---

### 📄 Listar todos os clientes

* **GET** `/clientes`

---

### 🔍 Buscar cliente por ID

* **GET** `/clientes/{id}`

---

### ❌ Remover cliente

* **DELETE** `/clientes/{id}`

---

### ✏️ Atualizar cliente

* **PUT** `/clientes/{id}`

---

### 🔎 Buscar por nome exato

* **GET** `/clientes/buscarPorNome?nome=...`

---

### 🔎 Buscar por e-mail

* **GET** `/clientes/buscarPorEmail?email=...`

---

### 🔎 Buscar clientes por início do nome

* **GET** `/clientes/buscarPorNomeInicio?nome=...`

---

## 🧪 Exemplos de Teste

### ✔️ Buscar clientes com nome iniciando em "Ana"

```
GET /clientes/buscarPorNomeInicio?nome=Ana
```

---

### ✔️ Buscar cliente por e-mail

```
GET /clientes/buscarPorEmail?email=ana@email.com
```

---

## ⚠️ Regras de Negócio

* Nome, email e CPF são obrigatórios
* CPF deve ser único
* ID é gerado automaticamente pelo banco
* Não é permitido cadastrar clientes com dados inválidos

---

## ▶️ Como Executar o Projeto

1. Clonar o repositório

```
git clone <url-do-repositorio>
```

2. Abrir no VS Code ou IDE de preferência

3. Executar a aplicação Spring Boot

4. Acessar:

```
http://localhost:8080/clientes
```

---

## 🧠 Observações

* O projeto segue o padrão MVC
* Utiliza Spring Data JPA para persistência
* Os endpoints podem ser testados com Postman ou Insomnia

---

## 👨‍💻 Autor

Matheus Leone
