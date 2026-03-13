# BibSync

## Descrição

O **BibSync** é uma ferramenta desenvolvida em **Java (JDK 25)** para importação, análise e busca em bases bibliográficas `.bib` provenientes de repositórios científicos como IEEE e MDPI.

O sistema permite carregar múltiplas bases `.bib`, realizar buscas por diferentes critérios e executar consultas personalizadas sobre os artigos armazenados.

Os arquivos `.bib` devem ser colocados dentro do diretório:

```
data/bibs
```

---

# Funcionalidades

## 1. Importação de Bases Bibliográficas

O sistema permite gerenciar múltiplas bases `.bib`.

Operações disponíveis:

- Listar todas as bases disponíveis
- Importar todas as bases
- Importar uma base específica
- Listar bases já importadas
- Remover uma base específica
- Remover todas as bases

---

## 2. Análise de Dados Bibliográficos

Após importar as bases, o usuário pode realizar diferentes tipos de buscas:

- Buscar artigos por **Título**
- Buscar artigos por **Autor**
- Buscar artigos por **Ano de publicação**
- Executar **queries personalizadas**
- Consultar **histórico de buscas realizadas**

---

## 3. Sistema de Queries Personalizadas

O BibSync permite criar consultas personalizadas adicionando múltiplos parâmetros de busca.

Durante a criação da query:

- O usuário pode adicionar vários parâmetros
- Cada parâmetro representa um critério de busca
- A digitação de `0` encerra a criação da query

Também é possível:

- Listar queries criadas
- Remover queries existentes

---

## 4. Sistema de Logs

O sistema possui um módulo de notificações e logs, permitindo:

- Visualizar notificações do sistema
- Limpar notificações armazenadas

Esse módulo pode ser utilizado para acompanhar eventos importantes da aplicação.

---

# Estrutura de Menus

## Menu Principal

```
[1] Importar Base
[2] Analisar dados
[3] Log

[0] Sair
```

---

## Menu de Análise de Dados

```
[1] Buscar por Título
[2] Buscar por Autor
[3] Buscar por Ano
[4] Query personalizada
[5] Histórico de buscas

[0] Sair
```

---

## Menu de Importação de Bases

```
[1] Listar todas as bases
[2] Importar todas
[3] Importar específica
[4] Bases importadas
[5] Remover base específica
[6] Remover toda a base

[0] Sair
```

---

# Arquitetura do Sistema

O BibSync foi desenvolvido utilizando padrões clássicos de engenharia de software, garantindo modularidade e extensibilidade.

### Factory Pattern
Responsável pela criação das instâncias relacionadas às diferentes bases `.bib`.

### Singleton Pattern
Utilizado para garantir que certos componentes do sistema possuam apenas uma única instância ativa.

### Observer Pattern
Permite que componentes do sistema sejam notificados automaticamente quando eventos importantes ocorrem.

### Strategy Pattern
Utilizado para implementar diferentes estratégias de busca nos dados bibliográficos.

### View Pattern
Responsável pela separação da lógica de interface e interação com o usuário.

---

# Requisitos

- Java **JDK 25**
- Arquivos `.bib` contendo os artigos científicos

---

# Estrutura Esperada de Diretórios

```
project/
│
├── data/
│   └── bibs/
│       ├── ieee.bib
│       ├── mdpi.bib
│       └── outros.bib
│
├── src/
│   ├── factory/
│   ├── model/
│   ├── view/
│   └── ...
│
└── BibSync
```
