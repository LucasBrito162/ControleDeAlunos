# ControleDeAlunos

![Java](https://img.shields.io/badge/Java-8+-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green.svg)
![H2 Database](https://img.shields.io/badge/H2%20Database-in%20memory-orange.svg)
![Lombok](https://img.shields.io/badge/Lombok-enabled-purple.svg)

## 📚 Sobre o Projeto

O `ControleDeAlunos` é um sistema robusto e eficiente desenvolvido em **Spring Boot** para gerenciar informações de alunos e cursos. Este projeto exemplifica uma arquitetura bem definida, com separação clara de responsabilidades, utilizando as melhores práticas do desenvolvimento moderno de aplicações Java.

## ✨ Funcionalidades

-   **Gerenciamento de Alunos**: CRUD completo para informações de estudantes (nome, idade, email, curso).
-   **Gerenciamento de Cursos**: CRUD completo para detalhes de cursos (nome, descrição, datas de início e fim, nível).
-   **API RESTful**: Endpoints bem definidos para todas as operações, facilitando a integração com outras aplicações.
-   **Camada de Serviço**: Lógica de negócio encapsulada em serviços dedicados, promovendo reusabilidade e testabilidade.
-   **Persistência de Dados**: Utilização de Spring Data JPA para interação simplificada com o banco de dados.
-   **Validação de Dados**: Validação básica de entrada para garantir a integridade dos dados.

## 🚀 Tecnologias Utilizadas

-   **Java 17**: Linguagem de programação.
-   **Spring Boot 3.x**: Framework para construção de aplicações Java robustas e escaláveis.
-   **Spring Data JPA**: Abstração para acesso a dados, facilitando a interação com bancos de dados relacionais.
-   **Hibernate**: Implementação JPA padrão.
-   **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
-   **Lombok**: Biblioteca para reduzir o código boilerplate em classes Java.
-   **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
-   **RESTful API**: Padrão de arquitetura para comunicação entre sistemas.

## ⚙️ Como Rodar o Projeto

Siga os passos abaixo para configurar e executar o projeto em sua máquina local:

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

-   [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
-   [Maven](https://maven.apache.org/download.cgi)
-   Uma IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

### Clonando o Repositório

```bash
git clone https://github.com/LucasBrito162/ControleDeAlunos.git
cd ControleDeAlunos
```

### Compilando e Executando

1.  **Compilar o projeto com Maven:**

    ```bash
    mvn clean install
    ```

2.  **Executar a aplicação Spring Boot:**

    ```bash
    mvn spring-boot:run
    ```

    A aplicação estará disponível em `http://localhost:8080`.

## 💻 Endpoints da API

Os seguintes endpoints estão disponíveis:

### Alunos

-   **GET /estudantes**: Lista todos os estudantes.
-   **GET /estudantes/{id}**: Busca um estudante pelo ID.
-   **POST /estudantes**: Cria um novo estudante.
-   **PUT /estudantes/{id}**: Atualiza um estudante existente.
-   **DELETE /estudantes/{id}**: Deleta um estudante pelo ID.

### Cursos

-   **GET /cursos**: Lista todos os cursos.
-   **GET /cursos/{id}**: Busca um curso pelo ID.
-   **POST /cursos**: Cria um novo curso.
-   **PUT /cursos/{id}**: Atualiza um curso existente.
-   **DELETE /cursos/{id}**: Deleta um curso pelo ID.

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## 📄 Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
