# Padrão Observer - Central de Ameaças e Analistas

Implementação do padrão de projeto **Observer** (Comportamental) em Java, demonstrando como notificar múltiplos observadores automaticamente quando o estado de um objeto (sujeito) muda.

## Descrição

Este projeto implementa o padrão Observer para modelar um **sistema de monitoramento de segurança**. Quando a `CentralDeAmeacas` (Sujeito/Observable) detecta uma nova ameaça, ela notifica automaticamente todos os `AnalistaSeguranca` (Observadores/Observer) inscritos, sem que os analistas precisem consultar a central constantemente.

### Contexto
O sistema utiliza as classes nativas do Java (`java.util.Observable` e `java.util.Observer`) para gerenciar a relação de dependência um-para-muitos:

**Sujeito (Observable):**
- **CentralDeAmeacas**: Detecta ameaças e notifica os inscritos.

**Observadores (Observer):**
- **AnalistaSeguranca**: Recebe alertas em tempo real sobre novas ameaças.

## Estrutura do Projeto
```bash
src/
├── main/
│ └── padroescomportamentais/observer/
│ ├── CentralDeAmeacas.java (Sujeito Concreto)
│ └── AnalistaSeguranca.java (Observador Concreto)
│
└── test/
└── padroescomportamentais/observer/
└── CentralDeAmeacasTest.java (Casos de teste)
```

## Padrão Observer

### Problema Resolvido
Sem o Observer, os analistas teriam que ficar consultando a central de ameaças periodicamente (polling), o que é ineficiente e consome recursos. Com o padrão, a central **empurra** (push) a notificação para os analistas assim que o estado muda.

### Vantagens
- **Desacoplamento**: O sujeito conhece apenas a interface do observador, não suas classes concretas.
- **Comunicação broadcast**: Notificações automáticas para todos os inscritos.
- **Extensibilidade**: Novos tipos de observadores podem ser adicionados sem modificar o sujeito.
- **Princípio Aberto/Fechado (OCP)**: Aberto para extensão, fechado para modificação.

### Componentes
- **Observable (java.util)**: Classe base que mantém a lista de observadores e gerencia as notificações.
- **Observer (java.util)**: Interface que define o método `update()` para receber notificações.
- **Sujeito Concreto (`CentralDeAmeacas`)**: Estende `Observable` e chama `setChanged()` e `notifyObservers()` quando o estado muda.
- **Observador Concreto (`AnalistaSeguranca`)**: Implementa `Observer` e define a ação a ser tomada no método `update()`.

## Testes

O projeto possui **2 casos de teste** implementados com **JUnit 5**, validando:

- Notificação de um único analista quando uma ameaça é detectada.
- Notificação simultânea de múltiplos analistas inscritos na mesma central.

### Como Executar os Testes

1. Abra o projeto no **IntelliJ IDEA**
2. Clique com o botão direito na pasta `test`
3. Selecione **Run 'All Tests'**
4. Verifique se todos os testes passam (barra verde)

## Diagrama de Classes
O diagrama UML está disponível na imagem `diagrama-observer.png` e mostra a relação de herança com `Observable` e implementação de `Observer`.

## Diferença entre os Padrões Comportamentais e Estruturais
| Categoria | Padrão | Foco Principal | Exemplo no Projeto |
| :--- | :--- | :--- | :--- |
| **Estrutural** | **Decorator** | Adicionar comportamentos dinamicamente | Empilhar camadas de segurança (Criptografia, IDS) |
| **Comportamental** | **Observer** | Gerenciar comunicação e dependências entre objetos | Notificar analistas quando a central detecta ameaças |

## Tecnologias
- Java 21
- JUnit 5 (JUnit Jupiter)
- IntelliJ IDEA
- Maven (gerenciamento de dependências)
- Draw.io (diagrama UML)

## Conceitos Aplicados
- Padrão Comportamental Observer
- Classes nativas do Java (java.util.Observable / Observer)
- Desacoplamento entre Sujeito e Observador
- Princípio Aberto/Fechado (OCP)
- Testes Unitários com JUnit
