# JavaBank - Sistema de Gerenciamento de Contas Bancárias

![JavaBank_Logo](/logo_javaBank.png)

Este é um projeto de sistema bancário em Java que demonstra o uso de herança, polimorfismo, classes abstratas e enums para criar contas bancárias.

## Visão Geral

Este projeto foi desenvolvido como parte do aprendizado de Java e inclui as seguintes funcionalidades:

- Criação de contas correntes e poupança.
- Depósito e saque de dinheiro em contas.
- Exibição de informações da conta.
- Cálculo de saldo de acordo com as regras de cada tipo de conta.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- `entities`: Pacote contendo as classes Java para as entidades do projeto.
  - `Account`: Classe abstrata que serve como base para contas bancárias.
  - `CheckingAccount`: Classe que representa contas correntes.
  - `SavingsAccount`: Classe que representa contas poupança.
  - `enums`: Pacote contendo a enumeração para tipos de conta.
    - `AccountType`: Enum para representar tipos de conta (CORRENTE e POUPANCA).
- `application`: Pacote contendo a classe principal do programa.
  - `Program`: Classe principal que executa o programa e interage com o usuário.

## Funcionalidades

O JavaBank oferece as seguintes funcionalidades:

1. **Criar nova conta**: O programa permite ao usuário criar novas contas correntes ou poupança.
2. **Depósito**: É possível adicionar valores às contas criadas com o método de depósito.
3. **Saque**: O método de saque passar por uma validação se há saldo disponível em cada conta antes de efetuar a transação. Além disso, segue as regras de negócio para cada tipo de conta, como por exemplo o comportamento de objetos 'CheckingAccount' possuírem um saldo extra como limite de saque.
4. **Dados da conta**: As informações da conta, incluindo saldo, são exibidas.

## Como Usar

Para executar o programa, siga estas etapas:

1. Compile os arquivos do projeto em sua IDE Java favorita ou use um compilador Java.
2. Execute a classe `Program` para iniciar o programa.
3. Siga as instruções no menu para criar contas, depositar, sacar e visualizar informações da conta.

## Melhorias Futuras

Este projeto pode ser expandido com as seguintes melhorias:

- Adição de tratamento de exceções para lidar com erros.
- Melhor formatação de saída para as informações da conta.
- Implementação de autenticação de usuário.
- Persistência de dados em um banco de dados.

## Contribuições

Contribuições são bem-vindas! Se você deseja melhorar este projeto, sinta-se à vontade para criar um fork e enviar um pull request.