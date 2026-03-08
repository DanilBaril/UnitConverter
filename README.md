# Trabalho 1 — Unit Converter

Curso: Licenciatura em Engenharia Informática e Multimédia (LEIM)
Aluno: a51812
Data: Março 2026
URL do Repositório: https://github.com/DanilBaril/UnitConverter

---

## 1. Introdução

Este trabalho é a secção 8 do Tutorial 1 (MIP - Missão Impossível Possível) que
consiste no desenvolvimento de uma aplicação Android com recurso a ferramentas de
geração de código assistida por IA. A aplicação desenvolvida é um Conversor de
Unidades que permite ao utilizador converter entre diferentes unidades de medida
em tempo real, sem necessidade de carregar em qualquer botão.

## 2. Visão Geral do Sistema

A aplicação é um Conversor de Unidades com interface simples e minimalista.
Suporta conversões de temperatura (Celsius/Fahrenheit), distância (Km/Milhas)
e peso (Kg/Libras). Inclui também um interruptor para alternar entre modo claro
e escuro.

Funcionalidades principais:
- Conversão de unidades em tempo real enquanto o utilizador escreve
- Conversões de temperatura, distância e peso
- Interruptor de modo claro/escuro

## 3. Arquitetura e Design

A aplicação segue uma arquitetura de Activity única utilizando o sistema de Views
padrão do Android com ConstraintLayout. Toda a lógica está contida no MainActivity.kt.

O layout está dividido em três secções, uma por categoria de unidade, cada uma com
dois campos EditText lado a lado. Um TextWatcher está associado a cada campo para
desencadear a conversão sempre que o valor é alterado.

Estrutura de pastas:
```
app/
├── manifests/
│   └── AndroidManifest.xml
├── java/
│   └── dam_a51812/unitconverter/
│       └── MainActivity.kt
└── res/
    ├── layout/
    │   └── activity_main.xml
    └── values/
        ├── strings.xml
        ├── colors.xml
        └── themes.xml
```

## 4. Implementação

O núcleo da implementação é a função `addWatcher`, que associa um `TextWatcher`
a um `EditText` de entrada e atualiza o `EditText` de saída com o valor convertido
sempre que o texto é alterado.

Uma variável booleana `isEditing` impede um ciclo infinito em que ambos os campos
estariam continuamente a desencadear os watchers um do outro.

Conversões implementadas:
- Celsius para Fahrenheit: `(C * 9/5) + 32`
- Fahrenheit para Celsius: `(F - 32) * 5/9`
- Quilómetros para Milhas: `km * 0.621371`
- Milhas para Quilómetros: `milhas * 1.60934`
- Quilogramas para Libras: `kg * 2.20462`
- Libras para Quilogramas: `libras * 0.453592`

O interruptor de modo claro/escuro utiliza `AppCompatDelegate.setDefaultNightMode()`
acionado por um componente Switch.

## 5. Testes e Validação

Testes manuais realizados no emulador Pixel 9 Pro AVD:

- 100°C → 212°F ✓
- 212°F → 100°C ✓
- 1 km → 0.62 milhas ✓
- 1 milha → 1.61 km ✓
- 1 kg → 2.20 libras ✓
- 1 libra → 0.45 kg ✓
- Campo vazio limpa o campo oposto ✓
- Interruptor de modo claro/escuro funciona corretamente ✓

Limitações conhecidas:
- Sem validação de entrada para caracteres não numéricos além do `toDoubleOrNull()`
- Layout não otimizado para orientação horizontal

## 6. Instruções de Utilização

Requisitos:
- Android Studio Ladybug ou superior
- Android SDK API 24 ou superior
- Kotlin 1.9 ou superior

Passos para executar:
1. Clonar o repositório: `git clone https://github.com/DanilBaril/UnitConverter`
2. Abrir o projeto no Android Studio
3. Executar num emulador ou dispositivo físico com API 24+
4. Escrever um valor em qualquer campo para ver a conversão atualizar em tempo real
5. Usar o interruptor no fundo para alternar entre modo claro e escuro

---

# Secções de Engenharia de Software Autónoma

## 7. Estratégia de Prompts

A ferramenta de IA utilizada foi o Claude (claude.ai). A estratégia de prompting
evoluiu ao longo do desenvolvimento:

- Primeiro foram pedidas ideias de aplicações simples sem API externa
- Depois foi pedido um passo a passo detalhado para implementar o conversor
- Por fim foram pedidos excertos de código específicos para integrar no projeto

## 8. Fluxo de Trabalho do Agente Autónomo

A IA contribuiu nas seguintes fases do desenvolvimento:

- Ideação: sugestão de tipos de aplicação adequados ao nível do trabalho
- Arquitetura: sugestão do padrão TextWatcher com variável isEditing
- Implementação: geração dos excertos de código para o MainActivity.kt
- Debugging: explicação do problema do ciclo infinito entre os dois watchers
- Documentação: apoio na escrita deste README

## 9. Verificação dos Artefactos Gerados pela IA

Todo o código gerado pela IA foi verificado da seguinte forma:

- Leitura e compreensão linha a linha antes de ser integrado
- Execução no emulador para confirmar o comportamento esperado
- Testes manuais com valores conhecidos para validar as fórmulas de conversão
- Confirmação de que a variável `isEditing` resolve corretamente o ciclo infinito

## 10. Contribuição Humana vs IA

| Layout XML -> Humana
| Fórmulas de conversão -> IA
| Padrão TextWatcher + isEditing -> Humana + IA
| Integração do código no projeto -> Humana
| Testes e validação -> Humana
| README -> Humana + IA

## 11. Uso Ético e Responsável

A IA foi utilizada como ferramenta de apoio e não como substituto do raciocínio
próprio. Todo o código gerado foi compreendido antes de ser integrado. Não foram
detetados outputs inapropriados ou enviesados por parte da ferramenta.

---

# Processo de Desenvolvimento

## 12. Controlo de Versão e Histórico de Commits

O projeto foi desenvolvido de forma incremental com commits em cada etapa:
- Inicialização do projeto
- Criação do layout com todos os campos EditText
- Implementação do interruptor de modo claro/escuro
- Implementação do TextWatcher para cada par de unidades

## 13. Dificuldades e Lições Aprendidas

O principal desafio foi evitar o ciclo infinito entre os dois TextWatchers de cada
par. A variável `isEditing` resolveu isto de forma simples mas foi necessário
compreender bem o problema antes de aceitar a solução sugerida pela IA.

Configurar o ConstraintLayout com elementos posicionados lado a lado também exigiu
alguma experimentação com as âncoras das constraints.

## 14. Melhorias Futuras

- Adicionar mais categorias de unidades como velocidade, volume e área
- Adicionar um histórico de conversões recentes
- Melhorar o layout para orientação horizontal
- Adicionar feedback tátil na conversão

---

## 15. Declaração de Utilização de IA

Ferramentas de IA utilizadas: Claude (claude.ai)
Utilização: ideação da aplicação, explicação do padrão TextWatcher, geração de
excertos de código para o MainActivity.kt e apoio na escrita do README.
Todo o código foi revisto, compreendido e é da total responsabilidade do aluno.