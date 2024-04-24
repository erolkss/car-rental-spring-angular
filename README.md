# Car Rental Service
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/devsuperior/sds1-wmazoni/blob/master/LICENSE) 

## Sobre o projeto

Projeto FullStack, é um sistema de uma locadora de carros onde o cliente pode reservar um carro durante um período e o admin decide se vai aprovar essa locação ou não, além de oferecer carros de diversos tipos.



## Índice
- [Detalhes da Aplicação](#detalhes-da-aplicação)
- [Tecnologias Usadas](#tecnologias-usadas)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Autor e Contato](#autor-e-contato)



## Detalhes da Aplicação
- A aplicação possui dois tipos de usuários **CUSTOMER** e **ADMIN**.
- A autenticação do usuário é via Bearer Token


### INICIO
Temos a tela de **Sign up** que possibilita fazer o cadastro de um **customer**, ele informa um email, senha e seu nome.

![](./car_rental_angular/src/assets/img/2%20-%20Sign%20up%20-%20register.png)

Tela de **Login** onde o usuário deve informar o e-mail e sua senha.

![](./car_rental_angular/src/assets/img/1%20-%20Login.png)


### PERFIL CUSTOMER

A primeira página é o **Dashboard** onde apresenta os carros disponíveis. E você fazer uma reserva clicando no botão **book**

![](./car_rental_angular/src/assets/img/3%20-%20Dashboard%20-%20Customer.png)



A ao clicar em **book** você pode fazer uma solicitação de reserva informando as datas de que você pretende alugar o carro.

![](./car_rental_angular/src/assets/img/3.3%20-%20Book%20a%20Car%20-%20Customer.png)



A segunda opção do menu do customer é a **My Bookings** onde é mostra as reservas que você solicitou e seu status, note que existem o status: 'PENDING', 'APPROVED' and 'REJECTED'.

![](./car_rental_angular/src/assets/img/3.1%20-%20My%20Bookings%20-%20Customer.png)



A terceira opção do menu do customer é a **Search** onde você pode pesquisar um carro pelas seguintes características: Brand, Type, Color and Transmission.

![](./car_rental_angular/src/assets/img/3.2%20-%20Search%20-%20Customer.png)


&nbsp;



&nbsp;



### PERFIL ADMIN

A primeira página é o **Dashboard** onde você pode ver os carros que estão disponíveis. E como você está como **admin** você tem a opção de **Update** e **Delete**.

![](./car_rental_angular/src/assets/img/4%20-%20Dashboard%20-%20Admin.png)

Tela de **Update'/Editar**

![](./car_rental_angular/src/assets/img/4.4.1-%20Update%20Car%20-%20Admin.gif)


A segunda opção do menu é **Post Car/Cadastrar Novo Carro** onde o admin pode cadastrar um novo carro que estará disponível para a locação.

![](./car_rental_angular/src/assets/img/4.1.1%20-%20Post%20Car%20-%20Admin.gif)



A terceira opção é a **Bookings** onde é mostrado as reservas solicitadas pelos customers e seu status e caso o status seja 'PENDING' você pode **Approve** ou **Reject**

![](./car_rental_angular/src/assets/img/4.2%20-%20Bookings%20-%20Admin.png)


A quarta opção do menu  é a mesma do customer é a **Search** onde você pode pesquisar um carro pelas seguintes características: Brand, Type, Color and Transmission.

![](./car_rental_angular/src/assets/img/4.3%20-%20Search%20-%20Admin.png)


&nbsp;



&nbsp;


## Tecnologias Usadas

### Backend: 
- Java 17
- Spring Boot (3.2.4)
- Spring Web
- JPA/Hibernate
- Spring Security 
- JSON Web Token
- Lombok

### Frontend: 

- TypeScript (5.4.5)
- Angular 17 (No standalone)
- HTML
- SCSS

### Dados

- MySQL




&nbsp;



&nbsp;


## Instalação 
### Pré-requisitos

- Java 17
- Angular 17
- Pré-requisitos: Banco de Dados MySQL

&nbsp;



&nbsp;

## Configuração

### Banco de Dados

```
Nessa aplicação foi usado o MySQL, mas você pode usar qualquer outro Banco Dados SQL. Você terá que configurar somente o Drive no Spring e a credencial para acessar o seu Banco de dados.

# Criar o Banco de dados
CREATE DATABASE car_rental_db;

# Alterar a configuração de conexão no arquivo 'application.yml' para o seu Banco de Dados:
url: jdbc:mysql://localhost:3306/car_rental_db
username: root
password: root@pass
```

### Backend

```
# clonar repositório
git clone https://github.com/erolkss/car-rental-spring-angular.git

# entrar na pasta do projeto backend
cd car-rentel-spring

# executar o projeto
./mvnw spring-boot:run
```

### Frontend

```
# clonar repositório
git clone https://github.com/erolkss/car-rental-spring-angular.git

# entrar na pasta do projeto Frontend
cd car_rental_angular

# instalar dependências
npm install

# executar o projeto
ng serve | npm start

```

&nbsp;



&nbsp;
## Autor e Contato
Lucas Eduardo Lima -  [LinkedIn](https://www.linkedin.com/in/lucaserolima)

Para enviar feedback ou entrar em contato, por favor, envie um e-mail para `lucaserolima@gmail.com`.