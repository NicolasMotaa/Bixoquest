# BixoQuest: Da Matrícula à Formatura
RPG de simulação universitária desenvolvido em Java como projeto da disciplina MI Programação (EXA863) da Universidade Estadual de Feira de Santana (UEFS).

## Sobre o jogo
O jogador assume o papel de um calouro de Engenharia de Computação e deve sobreviver a cada semestre até a formatura. Ao longo do jogo, gerencia atributos como energia, motivação, saúde, dinheiro e conhecimento acadêmico, tomando decisões que impactam seu desempenho e progresso no curso.

Entre as ações disponíveis: assistir aulas, fazer provas, explorar o campus, interagir com NPCs (professores, colegas, animais) e gerenciar o tempo entre as atividades do dia.

## Proposta de aprendizado
O projeto foi desenvolvido em três fases progressivas com foco em:

- **Programação Orientada a Objetos** — modelagem de entidades do jogo com classes, herança, encapsulamento e polimorfismo
- **Arquitetura MVC** — separação entre Model, View e Controller, com camadas de Service e Repository
- **Persistência de dados** — serialização de objetos em Java para salvar e carregar partidas
- **Padrões de projeto GoF** — Singleton (SceneManager e Controller), Facade (PersistenciaFacade) e Strategy (interações na sala de aula)
- **Interface gráfica com JavaFX** — construção de telas com Scene Builder, navegação entre cenas e estilização com CSS

## Tecnologias

- Java 25
- JavaFX 21
- Maven
- JUnit 5
- Scene Builder

## Fases de desenvolvimento
- **Fase 1** — Diagramação, implementação do Model e testes unitários
- **Fase 2** — Persistência de dados e protótipos de interface
- **Fase 3** — Interface gráfica com JavaFX e padrões de projeto
