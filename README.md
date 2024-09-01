# Greve API

Bem-vindo à API Greve! Esta API fornece endpoints para gerenciar informações sobre greves, incluindo detalhes como datas, motivos, categorias de trabalhadores e muito mais.

## 📚 Endpoints

A API está documentada no Swagger e você pode visualizar todos os detalhes dos endpoints [aqui](https://greve-dieese.onrender.com/swagger-ui/index.html#/).

## 🛠 Tecnologias

- **Spring Boot**: Framework para construção de aplicações Java.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional.

## 🚀 Endpoints Principais

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

#### 6. **Listar greves por sindicato**

- **URL:** `/greves/sindicato/{sindicato}`
- **Método:** `GET`
- **Descrição:** Recupera uma lista de greves associadas a um sindicato específico.
- **Parâmetros:**
  - `sindicato` (Path): Nome do sindicato.
- **Resposta:** Uma lista de objetos `Greve` associadas ao sindicato fornecido.

#### 7. **Listar greves por categoria**

- **URL:** `/greves/categoria/{categoria}`
- **Método:** `GET`
- **Descrição:** Recupera uma lista de greves associadas a uma categoria específica de trabalhadores.
- **Parâmetros:**
  - `categoria` (Path): Categoria de trabalhadores.
- **Resposta:** Uma lista de objetos `Greve` associadas à categoria fornecida.

### 👥 Camada de Usuário

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

#### 3. **Cadastrar um novo usuário**

- **URL:** `/usuarios/cadastrar`
- **Método:** `POST`
- **Descrição:** Cria um novo usuário com as informações fornecidas.
- **Corpo da Requisição:** Um objeto `Usuario` com os detalhes do usuário a ser criado.
- **Resposta:** O objeto `Usuario` criado com um `id` gerado.

#### 4. **Logar um usuário**

- **URL:** `/usuarios/logar`
- **Método:** `POST`
- **Descrição:** Realiza o login de um usuário com as credenciais fornecidas.
- **Corpo da Requisição:** Um objeto com `email` e `senha` do usuário.
- **Resposta:** Dados do usuário logado ou mensagem de erro.

#### 5. **Atualizar um usuário existente**

- **URL:** `/usuarios/{id}`
- **Método:** `PUT`
- **Descrição:** Atualiza as informações de um usuário existente.
- **Parâmetros:**
  - `id` (Path): ID do usuário a ser atualizado.
- **Corpo da Requisição:** Um objeto `Usuario` com as informações atualizadas.
- **Resposta:** O objeto `Usuario` atualizado.

## 🗃️ Modelo de Dados

### Greve

- **id** (Long): ID único da greve.
- **dataInicio** (String): Data de início da greve (formato YYYY-MM-DD).
- **dataFim** (String): Data de término da greve (formato YYYY-MM-DD).
- **motivo** (String): Motivo da greve.
- **categoriasTrabalhadores** (String): Categorias de trabalhadores envolvidos.
- **numeroTrabalhadores** (int): Número total de trabalhadores envolvidos.
- **local** (String): Local onde a greve ocorreu.
- **sindicato** (String): Nome do sindicato responsável pela greve.
- **usuario** (Object): Objeto `Usuario` associado à greve.

### Usuario

- **id** (int): ID único do usuário.
- **nome** (String): Nome completo do usuário.
- **usuário** (String): Endereço de e-mail do usuário.
- **localização** (String): Localização do usuário.
- **senha** (String): Senha do usuário (armazenada de forma segura).

## ⚙️ Execução Local

Para executar a API localmente, siga os passos abaixo:

1. **Clone o repositório:**
```
   git clone https://github.com/amayararocha/greve-dieese.git
``` 
2. **Abra o projeto na IDE de sua preferência**

3. **Configure o arquivo application.properties para o ambiente de desenvolvimento:**
```
  spring.profiles.active=dev
``` 
4. **Execute a aplicação.**

5. **Acesse a API em http://localhost:8080.**
