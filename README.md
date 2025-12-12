
⸻

🏦 Mini Nubank – Sistema Bancário em Java

Projeto acadêmico desenvolvido para simular as funcionalidades básicas de um banco digital, inspirado no Nubank.
Todas as operações foram implementadas em Java, utilizando Orientação a Objetos, Map, listas, serialização e uma validação simples de login.

⸻

🚀 Funcionalidades Implementadas

👤 Clientes
	•	Cadastro de cliente com:
	•	ID
	•	Nome
	•	CPF
	•	Email
	•	Senha (para login simples)

💳 Contas
	•	Criação de conta vinculada ao cliente
	•	Operações básicas:
	•	Depósito
	•	Saque
	•	Transferência entre contas
	•	Consulta de saldo
	•	Lista de cartões vinculados

📜 Transações
	•	Registro de toda transação realizada
	•	Cada transação contém:
	•	Tipo (depósito, saque, transferência)
	•	Valor
	•	Data e hora
	•	Descrição

📄 Extrato
	•	Listagem completa das transações da conta

🔐 Segurança
	•	Sistema simples de login (ID + senha)
	•	Somente após autenticação o usuário vê sua conta e extrato

💾 Persistência
	•	Salvamento automático do estado do banco usando serialização Java
	•	Arquivo banco.dat armazenado localmente
	•	Carregamento automático ao iniciar o programa
miniNubank/
│
├── ModelCliente.java
├── ModelConta.java
├── Transacao.java
├── Cartao.java
│
├── NubankBanco.java              # Banco (Map<String, Conta>)
├── Serializacao.java             # Persistência
├── Principal.java                # Classe principal (login + menu)
│
└── banco.dat    
#🛠️ Tecnologias Utilizadas
	•	Java 17+
	•	Programação Orientada a Objetos
	•	Coleções Java (Map, List)
	•	Serialização (ObjectOutputStream / ObjectInputStream)
	•	Eclipse IDE
	•	Git & GitHub
Como Executar
	1.	Clone o repositório:
  git clone https://github.com/Aicha-Nac/mini-nubank.git
  2.	Abra o projeto no Eclipse
	3.	Execute a classe:
  Principal.java
  4.	Na primeira execução, o sistema:
	•	Cria o banco
	•	Cria um cliente padrão
	•	Cria uma conta inicial
	•	Salva tudo no arquivo banco.dat
	5.	Depois disso, sempre que rodar:
	•	O banco será carregado automaticamente
	•	Você poderá fazer login com seu ID + senha

⸻

🔑 Login de Exemplo

O programa cria inicialmente este usuário:
	•	ID: 1
	•	Senha: 1234
	•	Nome: Aïcha
	•	Email: aicha@email.com
	•	Saldo inicial: 1000

⸻

📌 O que poderia ser adicionado futuramente?
	•	Fatura e parcelamento
	•	Limite de crédito com juros
	•	Notificações
	•	Interface gráfica (JavaFX ou Swing)
	•	Login com múltiplos clientes (CRUD completo)
	•	API REST (Spring Boot)

⸻

📘 Licença

Projeto acadêmico — uso livre para aprendizado.
Arquivo gerado automaticamente
