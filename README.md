 README — Mini Nubank

Mini Nubank – Simulação de Conta Digital
Visão Geral
O projeto Mini Nubank é uma aplicação em Java que simula as funcionalidades básicas de uma conta digital, inspirada no modelo de bancos digitais como o Nubank.
O sistema permite o gerenciamento de clientes, contas, cartões e transações, com foco em orientação a objetos, coleções, persistência, segurança simples, testes unitários e documentação.
Este projeto foi desenvolvido como atividade acadêmica, seguindo rigorosamente as especificações propostas pelo professor.

Objetivos do Projeto


-Aplicar conceitos de Programação Orientada a Objetos (POO)


-Utilizar Collections (Map e List)


-Implementar operações bancárias básicas


-Trabalhar com serialização de dados


-Implementar validação simples de login


-Criar testes unitários com JUnit


-Documentar o código com JavaDoc



 Funcionalidades Implementadas
 Cliente


Cadastro de cliente com:


ID


Nome


CPF


Email


Usuário e senha




Conta Corrente


Criação de contas vinculadas a clientes


Armazenamento das contas em Map<ID, Conta>


Operações:


Depósito


Saque


Transferência entre contas




Verificação de saldo


🧾 Transações


Registro de todas as operações


Extrato bancário por conta utilizando List<Transacao>


 Cartão


Cartão vinculado a uma conta


Registro de transações realizadas por cartão


 Segurança (Simples)


Login via ID + senha


Validação antes do acesso às funcionalidades


Apenas usuários autenticados acessam as contas


 Persistência


Salvamento e leitura dos dados utilizando serialização


Dados preservados entre execuções do programa


 Testes Unitários


Testes implementados com JUnit


Verificação das principais operações da conta (ex: depósito e saque)



 Tecnologias Utilizadas


Java


Eclipse IDE


JUnit 5


Git & GitHub



 Estrutura do Projeto 
miniNubank/
 mini-nubank/
│
├── src/
│   └── miniNubank/
│       │
│       ├── ModelConta.java          # Modelo da conta bancária
│       ├── ModelCliente.java        # Modelo do cliente
│       ├── Cartao.java              # Cartão vinculado à conta
│       ├── Transacao.java           # Representa uma transação
│       │
│       ├── ContaRepositorio.java    # Repositório de contas
│       ├── ClienteRepositorio.java  # Repositório de clientes
│       ├── RepositorioCartao.java   # Repositório de cartões
│       │
│       ├── NubankBanco.java         # Lógica principal do banco
│       ├── Principal.java           # Classe main (execução)
│       │
│       ├── Serializacao.java        # Salvamento e leitura de dados
│       │
│       ├── ModelContaTest.java      # Testes da conta (JUnit)
│       └── TransacaoTest.java       # Testes de transação
│
├── .classpath
├── .project
├── .settings/
│
├── README.md
└── .gitignore


 Funcionalidades Futuras (Stretch Goals)


Fatura de cartão


Parcelamento de compras


Notificações simplificadas de transações



 Autoras
Aïcha Nacambo e Aline De Brito Guimaraes
Projeto acadêmico – Curso de Tecnologia em Telematica


 
