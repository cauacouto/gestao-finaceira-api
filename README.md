# 📊 API de Gestão Financeira

API REST desenvolvida em **Java com Spring Boot** para controle financeiro pessoal, permitindo o cadastro de **receitas e despesas**, organização por **categorias fixas** e geração de **relatórios financeiros**.

Este projeto foi desenvolvido com foco em **boas práticas de backend**, clareza de arquitetura e simplicidade, sendo ideal para **faculdade, portfólio e estudos de Java/Spring**.

---

## 🎯 Objetivo do Projeto

O objetivo da API é permitir que o usuário:

* Registre **entradas (receitas)** e **saídas (despesas)** financeiras
* Classifique cada lançamento por **categoria**
* Consulte **relatórios financeiros**, como saldo e totais
* Tenha uma base sólida para evolução futura do sistema

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **Banco de Dados H2** (desenvolvimento)
* **Maven**
* **Lombok**
* **Swagger / OpenAPI**

---

## 🧩 Modelagem do Domínio

### 📌 Lançamento

Representa uma movimentação financeira, podendo ser uma **receita** ou **despesa**.

Campos principais:

* `id`
* `descricao`
* `valor`
* `data`
* `tipo` → RECEITA ou DESPESA
* `categoria`

---

### 📌 Tipo de Lançamento (Enum)

```java
RECEITA
DESPESA
```

* **RECEITA**: valores que entram no sistema
* **DESPESA**: valores que saem do sistema

---

### 📌 Categoria (Enum)

As categorias são **fixas** e definidas como `enum`, evitando a complexidade de CRUD separado.

```java
ALIMENTACAO
TRANSPORTE
MORADIA
LAZER
SAUDE
EDUCACAO
OUTROS
```

Essa decisão mantém o projeto simples e focado na regra de negócio.

---

## 🗂️ Estrutura do Projeto

```
src/main/java
└── com.exemplo.gestaofinanceira
    ├── controller
    │   ├── LancamentoController
    │   └── RelatorioController
    ├── service
    │   ├── LancamentoService
    │   └── RelatorioService
    ├── repository
    │   └── LancamentoRepository
    ├── model
    │   ├── Lancamento
    │   ├── TipoLancamento
    │   └── Categoria
    └── GestaoFinanceiraApplication
```

---

## 🔗 Endpoints Principais

### 📍 Lançamentos

* `POST /lancamentos` → Cadastrar lançamento
* `GET /lancamentos` → Listar lançamentos
* `GET /lancamentos/{id}` → Buscar por ID
* `PUT /lancamentos/{id}` → Atualizar lançamento
* `DELETE /lancamentos/{id}` → Remover lançamento

---

### 📍 Relatórios

* `GET /relatorios/resumo`

  * Total de receitas
  * Total de despesas
  * Saldo final

* `GET /relatorios/periodo?inicio=YYYY-MM-DD&fim=YYYY-MM-DD`

  * Relatório filtrado por período

* `GET /relatorios/categoria`

  * Total por categoria

---

## 📊 Regras de Negócio

* **Receita** sempre soma no saldo
* **Despesa** sempre subtrai do saldo
* O saldo é calculado por:

```
saldo = totalReceitas - totalDespesas
```

---

## 🧠 Decisões Arquiteturais

* Categorias modeladas como **enum** para reduzir complexidade
* Regra de negócio centralizada no **Service**
* Separação clara entre **Controller**, **Service** e **Repository**
* Projeto preparado para evolução futura (JWT, banco relacional, frontend)

---

## 🚀 Possíveis Evoluções

* Autenticação com **JWT**
* Categorias dinâmicas (entidade)
* Exportação de relatórios em **PDF**
* Dashboard frontend
* Testes unitários com **JUnit e Mockito**
* Dockerização da aplicação

---

## ▶️ Como Executar o Projeto

1. Clone o repositório
2. Importe o projeto na IDE
3. Execute a classe `GestaoFinanceiraApplication`
4. Acesse:

   * API: `http://localhost:8080`
   * Swagger: `http://localhost:8080/swagger-ui.html`

---

## 👨‍💻 Autor

**Cauã da Silva Couto**
Estudante de Análise e Desenvolvimento de Sistemas
Backend Developer (Java / Spring Boot)

---

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais e de portfólio.
