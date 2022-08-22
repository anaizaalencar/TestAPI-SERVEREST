# Teste da API ServeRest utilizando REST Assured

## Script de teste para validar algumas funcionalidades dos módulos de usuário, produto e carrinho da API ServeRest.

### Tabela de conteúdos 

<!--ts-->
* [Sobre](#Sobre)
* [Tabela de Conteudo](#tabela-de-conteudo)
* [Como usar](#como-usar)
    * [Pre Requisitos](#pre-requisitos)
    * [Local files](#local-files)
* [Tecnologias](#tecnologias)
* [Autor](#autor)
* [Licença](#licença)
<!--te-->

### Como usar
#### Pre Requisito:
* Consumir o ServeRest
  * Localmente com Docker:
    * Execute o seguinte comando no terminal: "docker run -p 3000:3000 paulogoncalvesbh/serverest:latest"
* Fazer Download/clone do projeto;
* Antes de começar, você vai precisar ter instalado em sua máquina uma IDE.
* Importar o projeto;
* Executar as classes de teste
  * Para executar o teste "testCadastroDeUsuarioComSucesso" não deve existir usuário já cadastrado com o mesmo email inserido no "usuarioEmail".
  * Para executar o teste "testCadastroDeUsuarioComEmailJaUtilizado" deve existir usuário já cadastrado com o mesmo email inserido no "usuarioEmail".
  * Para executar o teste "testEdicaoDeDadosDeLoginDeUmUsuarioComSucesso" não deve existir usuário já cadastrado com o mesmo email inserido no "usuarioEmail".
  * Para executar o teste "testEdicaoDeUsuarioComIdInexistenteEComEmailExistente" deve existir usuário já cadastrado com o mesmo email inserido no "usuarioEmail" e não deve existir usuário com o mesmo ID inserido no caminho da URL. 
  * Para executar o teste <"x"> deve / não deve <"condição">...

Observação: Antes da criação do script de teste, toda a API foi analisada e testada utilizando  a ferramenta Postman, onde foi visto alguns erro na API ao tentar cadastrar, editar e excluir carrinho. Visto também que é possível buscar por produtos sem a autenticação de um usuário.

#### Local File:
Para executar os testes é preciso abrir as classes de teste, onde as classes estão separadas por funcionalidade:
C:...\serveRestAPIAutomacao\src\test\java\modulos\usuario\UsuarioTest.java
C:...\serveRestAPIAutomacao\src\test\java\modulos\produto\ProdutoTest.java
C:...\serveRestAPIAutomacao\src\test\java\modulos\carrinho\CarrinhoTest.java

### Tecnologias 
* Java
* JUnit 5
* Rest-Assured


### Autor
<a href="https://linkedin.com/in/ana-iza-alencar-b5a33b123">
 <sub><b>Ana Iza Alencar</b></sub></a> <a href="https://linkedin.com/in/ana-iza-alencar-b5a33b123" title="Rocketseat">🚀</a>
 <br />

### Licença
Este projeto esta sobe a licença <"Licença">

