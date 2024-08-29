# Greve API

Bem-vindo à API Greve! Esta API fornece endpoints para gerenciar informações sobre greves, incluindo detalhes como datas, motivos, categorias de trabalhadores e muito mais.

## Endpoints

A API está documentada no Swagger e você pode visualizar todos os detalhes dos endpoints [aqui](https://greve-dieese.onrender.com/swagger-ui/index.html#/).

## Tecnologias

- **Spring Boot**: Framework para construção de aplicações Java.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional.

## Endpoints Principais

#### 1. **Listar todas as greves**

- **URL:** `/greves`
- **Método:** `GET`
- **Descrição:** Recupera uma lista de todas as greves registradas.
- **Resposta:** Uma lista de objetos `Greve`.

#### 2. **Obter detalhes de uma greve**

- **URL:** `/greves/{id}`
- **Método:** `GET`
- **Descrição:** Recupera os detalhes de uma greve específica usando o `id`.
- **Parâmetros:**
  - `id` (Path): ID da greve.
- **Resposta:** Um objeto `Greve` com os detalhes da greve solicitada.

#### 3. **Criar uma nova greve**

- **URL:** `/greves`
- **Método:** `POST`
- **Descrição:** Cria uma nova greve com as informações fornecidas.
- **Corpo da Requisição:** Um objeto `Greve` com os detalhes da greve a ser criada.
- **Resposta:** O objeto `Greve` criado com um `id` gerado.

#### 4. **Atualizar uma greve existente**

- **URL:** `/greves/{id}`
- **Método:** `PUT`
- **Descrição:** Atualiza as informações de uma greve existente.
- **Parâmetros:**
  - `id` (Path): ID da greve a ser atualizada.
- **Corpo da Requisição:** Um objeto `Greve` com as informações atualizadas.
- **Resposta:** O objeto `Greve` atualizado.

#### 5. **Excluir uma greve**

- **URL:** `/greves/{id}`
- **Método:** `DELETE`
- **Descrição:** Remove uma greve específica do sistema.
- **Parâmetros:**
  - `id` (Path): ID da greve a ser excluída.
- **Resposta:** Mensagem de confirmação da exclusão.

### Camada de Usuário

A API também gerencia usuários para controlar o acesso e as permissões. Os endpoints relacionados a usuários são descritos abaixo.

#### 1. **Listar todos os usuários**

- **URL:** `/usuarios`
- **Método:** `GET`
- **Descrição:** Recupera uma lista de todos os usuários registrados.
- **Resposta:** Uma lista de objetos `Usuario`.

#### 2. **Obter detalhes de um usuário**

- **URL:** `/usuarios/{id}`
- **Método:** `GET`
- **Descrição:** Recupera os detalhes de um usuário específico usando o `id`.
- **Parâmetros:**
  - `id` (Path): ID do usuário.
- **Resposta:** Um objeto `Usuario` com os detalhes do usuário solicitado.

#### 3. **Criar um novo usuário**

- **URL:** `/usuarios`
- **Método:** `POST`
- **Descrição:** Cria um novo usuário com as informações fornecidas.
- **Corpo da Requisição:** Um objeto `Usuario` com os detalhes do usuário a ser criado.
- **Resposta:** O objeto `Usuario` criado com um `id` gerado.

#### 4. **Atualizar um usuário existente**

- **URL:** `/usuarios/{id}`
- **Método:** `PUT`
- **Descrição:** Atualiza as informações de um usuário existente.
- **Parâmetros:**
  - `id` (Path): ID do usuário a ser atualizado.
- **Corpo da Requisição:** Um objeto `Usuario` com as informações atualizadas.
- **Resposta:** O objeto `Usuario` atualizado.

#### 5. **Excluir um usuário**

- **URL:** `/usuarios/{id}`
- **Método:** `DELETE`
- **Descrição:** Remove um usuário específico do sistema.
- **Parâmetros:**
  - `id` (Path): ID do usuário a ser excluído.
- **Resposta:** Mensagem de confirmação da exclusão.

## Modelo de Dados

### Greve

- **dataInicio** (String): Data de início da greve (formato YYYY-MM-DD).
- **dataFim** (String): Data de término da greve (formato YYYY-MM-DD).
- **motivo** (String): Motivo da greve.
- **categoriasTrabalhadores** (Array of Strings): Categorias de trabalhadores envolvidos.
- **numeroTrabalhadores** (Integer): Número total de trabalhadores envolvidos.
- **local** (String): Local onde a greve ocorreu.

### Usuario

- **id** (Integer): ID único do usuário.
- **nome** (String): Nome completo do usuário.
- **email** (String): Endereço de e-mail do usuário.
- **senha** (String): Senha do usuário (armazenada de forma segura).

## Execução Local

Para executar a API localmente, siga os passos abaixo:

1. **Clone o repositório:**
```
   git clone https://github.com/amayararocha/greve-dieese.git
``` 
2. **Navegue até o diretório do projeto:**
```
   cd greve-dieese
```
3. **Configure o arquivo application.properties para o ambiente de desenvolvimento:**
```
  spring.profiles.active=dev
``` 
4. **Execute a aplicação.**

5. **Acesse a API em http://localhost:8080.**

## Autenticação

A API pode exigir autenticação para acessar alguns endpoints. Verifique a configuração de segurança no Swagger para detalhes.
