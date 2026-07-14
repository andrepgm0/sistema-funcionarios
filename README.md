# Sistema de Funcionários

Sistema CRUD de funcionários desenvolvido em Java utilizando JDBC e MySQL.

## 📋 Sobre o projeto

Este projeto foi desenvolvido com o objetivo de praticar os conceitos de Java, Programação Orientada a Objetos, JDBC e banco de dados MySQL.

O sistema permite realizar operações de cadastro, consulta, atualização e exclusão de funcionários diretamente no banco de dados.

---

## 🚀 Funcionalidades

- ✅ Cadastrar funcionário
- ✅ Listar funcionários
- ✅ Atualizar funcionário
- ✅ Excluir funcionário

---

## 🛠️ Tecnologias utilizadas

- Java
- JDBC
- MySQL
- Eclipse IDE

---

## 📂 Estrutura do projeto

```
src
│
├── connection
│   └── Conexao.java
│
├── dao
│   └── FuncionarioDAO.java
│
├── model
│   └── Funcionario.java
│
└── main
    └── Main.java
```

---

## 🗄️ Banco de dados

Crie um banco chamado:

```sql
funcionarios
```

Depois execute o script SQL para criar a tabela.

Exemplo:

```sql
CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(100),
    cargo VARCHAR(100),
    salario DECIMAL(10,2)
);
```

---

## ⚙️ Configuração

Na classe `Conexao.java`, configure as informações do seu banco de dados.

Exemplo:

```java
String url = "jdbc:mysql://localhost:3306/funcionarios";
String usuario = "root";
String senha = "SUA_SENHA";
```

> **Importante:** substitua `"SUA_SENHA"` pela senha do seu MySQL.

---

## ▶️ Como executar

1. Clone o repositório.
2. Abra o projeto no Eclipse.
3. Crie o banco de dados MySQL.
4. Configure a classe `Conexao.java`.
5. Execute a classe `Main.java`.

---
