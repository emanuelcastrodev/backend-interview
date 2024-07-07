# Mobiauto Backend Interview

![spring](https://github.com/emanuelcastrodev/backend-interview/assets/9869799/8a24313a-afb6-477d-a4a1-7857a6af0ae1)

> Este projeto é uma API destinada a ser um sistema capaz de registrar lojas, ofertas e carros. Para isso, utilizei Java e Spring Boot, combinando soluções criativas e mantendo a arquitetura do projeto fortemente embasada nos princípios SOLID, com aplicação de design patterns para manter a aplicação concisa.

## Resumo da Arquitetura do Projeto:
<table>
  <tr>
    <td>Implementações</td>
    <td>Recursos</td>
    <td>Arquiteturas | Design Patterns</td>
  </tr>
  <tr>
    <td>CRUD para Lojas</td>
    <td>Spring Security</td>
    <td>Stateful oauth</td>
  </tr>
  <tr>
    <td>CRUD para Oportunidades</td>
    <td>Authorization Server Oauth2</td>
    <td>Microsserviços</td>
  </tr>
  <tr>
    <td>CRUD para Carros</td>
    <td>Resource Server Oauth2</td>
    <td>Builder</td>
  </tr>
  <tr>
    <td>Utilização de DTOS para entrada e saida de dados</td>
    <td>Hateos</td>
    <td>Factory</td>
  </tr>
  <tr>
    <td>Conteúdo da coluna 1</td>
    <td>Validation API</td>
    <td>Chain of Responsability para validações de campos</td>
  </tr>
  <tr>
    <td>Controle de acesso baseado em permissões</td>
    <td>Swagger-UI</td>
    <td>SOLID</td>
  </tr>
  <tr>
    <td>Implementação do Swagger utilizando Authorization Grant Flow with PKCE</td>
    <td>Spring Data JPA</td>
    <td>MCV</td>
  </tr>
  <tr>
    <td>Validação de CNPJ utilizando Bean Validation API</td>
    <td>MySQL</td>
    <td></td>
  </tr>
  <tr>
    <td>Validação de campos na criação de entidades JPA</td>
    <td>Docker</td>
    <td></td>
  </tr>
  <tr>
    <td>Definir assistante para uma Oportunidade</td>
    <td>Mockito</td>
    <td></td>
  </tr>
  <tr>
    <td>Fechar Oportunidade</td>
    <td>jUnit5</td>
    <td></td>
  </tr>
  <tr>
    <td>Retorno de um RepresentationModel Hateoas na criação das entidades JPA</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Paginação ao obter todos os objetos retornados do repositório</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Utilização de Mappers</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Versionamento da API</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>jUnit Tests</td>
    <td></td>
    <td></td>
  </tr>
</table>

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente do `<Docker>`.
- Versão <Strong>17</strong> do `<Java>`.
- `<Spring Tools Suite>` ou qualquer IDE de sua preferência.

## 🚀 Build

Para executar o build siga estas etapas:

Execute o próximo comando na raiz do projeto:

```
docker compose up --build -d
```

![docker-build](https://github.com/emanuelcastrodev/backend-interview/assets/9869799/d5d1469d-afbd-4c23-b9ed-d419bfe92fc1)

![docker-build-finish](https://github.com/emanuelcastrodev/backend-interview/assets/9869799/c6959aa7-df96-4c8f-8eec-44b64124b517)


> Os testes criados com jUnit5 serão executados a partir do build da imagem do projeto.

## ☕ Usando a API

Para usar a API, siga estas etapas:

Acesse o Swagger (localhost:8080/swagger-ui/index.html):
![swagger](https://github.com/emanuelcastrodev/backend-interview/assets/9869799/aac2d093-dd2f-4828-81a1-92fdd127ea08)


Registre um carro:
![register_car](https://github.com/emanuelcastrodev/backend-interview/assets/9869799/16326339-c2f3-426f-aa98-216f87531c4d)

Registre uma loja:
![store_register](https://github.com/emanuelcastrodev/backend-interview/assets/9869799/559cae61-1743-44de-a7ce-7d74850f4be5)

Registre uma oportunidade:
![register_opportunity](https://github.com/emanuelcastrodev/backend-interview/assets/9869799/1a602581-6517-4434-b1e3-38292172d78e)

Caso a sua conta tenha uma permissão igual ou maior de um Assistente, registre sua conta como assistante da oportunidade:
![set_assistant](https://github.com/emanuelcastrodev/backend-interview/assets/9869799/aa43dc45-18fb-41a9-be7c-c5d7f2384fbb)

## 📝 Observações

Esse projeto foi criado em tres dias referente a um teste para um vaga de Desenvolvedor Backend na Mobiauto. E poderá ser utilizado para fins de estudo para qualquer pessoa que tenha interesse sobre as implentações realizadas nesse projeto.
Esse projeto ainda não chegou na sua versão final, devido ao prazo de entrega do teste. Porém todas as tecnologias que descrevi estão devidamente implementadas.


