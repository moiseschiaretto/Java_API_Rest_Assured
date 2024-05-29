# _Em construção ..._

## Projeto "API REST com Rest Assured e TestNG"

Autor Moisés Ademir Chiaretto

Descrição das explicações de cada item da 'estrutura do projeto "API REST com Rest Assured" desenvolvido'.

Objetivo é desenvolver cenários de testes em Java com API REST com Rest Assured e TestNG utilizando os métodos / verbos HTTP (Get, Post, Put, Patch, Delete).


![01_Java](https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/f67c7d91-841a-4291-a944-b7e8a68885e7)


![02_API_REST](https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/fd9b9f9f-12b2-4937-873f-071e506e6b5f)

<br>

## Estrutura do Projeto "API REST com Rest Assured e TestNG"

**_Em construção ..._**

<br>

## Arquivo "pom.xml"

Este arquivo contém todas as dependências do projeto, do **Apache Maven**, site do repositório de dependências:

https://mvnrepository.com


![06_Apache_Maven](https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/3e6a732a-00ef-4f76-a796-1f67bfc35fed)

<br>

### Dependências do Arquivo "pom.xml"

A dependência **"rest-assured"** é uma biblioteca Java que simplifica a automação de testes de API REST, oferecendo uma interface fluente para enviar requisições HTTP e validar respostas. Ela é amplamente utilizada para escrever testes automatizados que verificam a funcionalidade e integridade das APIs REST em aplicativos Java.

<br>

O **TestNG** é utilizado em testes de API REST para automatizar a execução de casos de teste, verificar a integridade das respostas da API (status HTTP, conteúdo do corpo) e gerar relatórios detalhados sobre os resultados dos testes, simplificando a garantia da qualidade do software.


```

<dependencies>

	<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
	<dependency>
		<groupId>io.rest-assured</groupId>
		<artifactId>rest-assured</artifactId>
		<version>5.4.0</version>
		<scope>test</scope>
	</dependency>

	<!-- https://mvnrepository.com/artifact/org.testng/testng -->
	<dependency>
		<groupId>org.testng</groupId>
		<artifactId>testng</artifactId>
		<version>7.10.2</version>
		<scope>test</scope>
	</dependency>

</dependencies>

```

<br>

## Cenários de Testes de API REST

CRUD com os verbos HTTP, métodos GetAll, GetId, Post, Put, Patch, Delete.


![04_Verbos_HTTP_API_REST](https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/1e91722e-6019-476e-93b7-cdd6fce30bc3)

<br>

![05_Piramide_Testes](https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/20cfe1e5-55e0-4111-b746-f4680227b86c)


<br>

## Script simples do Rest Assured

![03_API_REST_ASSURED_BDD](https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/6c608c72-5078-482f-8844-2111d69d0e6e)

### Sintaxe do Rest Assured.io é semelhante a escrita do BDD em Gherkin.


```

Given() 
        .param("a", "b") 
        .header("c", "d")
When()
        .method()
Then() 
        .statusCode(XXX)
        .body("e", ”f", equalTo("g"))
        .log().body()
;

```

<br>

### Explicações das palavras-chaves utilizadas no Rest Assured, semelhante a escrita do BDD em Gherkin.


<img width="915" alt="image" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/e78d0ddb-b724-4d92-8395-49eef3ec2966">

<br>

***

## Configuração do Ambiente de Trabalho


### Pré-requisitos

### 1. Java JDK

### 2. IDE (Eclipse, IntelliJ, etc)

### 3. Maven

### 4. TesteNG

***

### 1. Baixar e Instalar o "Java JDK Development".

https://www.oracle.com/java/technologies/downloads


<img width="175" alt="00_JDK" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/fa406197-a369-4d89-bcce-d8295e7ebacb">


**Após a instalação do "Java JDK" digitar no "Prompt de Comando no Modo Administrador" o seguinte comando.**

```

java --version

```

<img width="569" alt="12_Java_JDK_Version" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/c9319fe2-ccc3-419b-b407-0ffc14ae4e83">


<br>
<br>
<br>

### 2. Baixar e Instalar a "IDE Eclipse".

https://www.eclipse.org/downloads


<img width="329" alt="10_Logo_IDE_Eclipse" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/2e77ed9d-762a-4776-af0a-3c730c2e58c0">

<br>
<br>
<br>

### 3. Baixar e Instalar o "Apache Maven".


https://maven.apache.org/download.cgi


<img width="668" alt="13_Maven_Download" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/13b4393c-99be-43a8-a7cf-64e9bd3a8182">

<br>
<br>
<br>

### 3.1 Configurar as Variáveis de Ambiente para o "_Apache Maven_"

A dependência "rest-assured" é uma biblioteca Java que simplifica a automação de testes de API REST, oferecendo uma interface fluente para enviar requisições HTTP e validar respostas. Ela é amplamente utilizada para escrever testes automatizados que verificam a funcionalidade e integridade das APIs REST em aplicativos Java.

<br>

<img width="308" alt="15_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/4a5bee81-2d5f-43b3-949f-96706e72440b">

<br>
<br>
<br>

<img width="442" alt="16_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/ebd443e3-22df-480c-b0a8-a51cc7b6b552">

<br>
<br>
<br>

### Variável de Ambiente do Java JDK "JAVA_HOME"

<img width="467" alt="17_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/24b60433-9698-4d59-8b11-e1d92e58a5e3">

<br>
<br>
<br>

### Variável de Ambiente Apache Maven "M2_HOME"

<img width="467" alt="18_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/9ceb7b93-a8b9-48d2-ace2-ffdb5e71c727">

<br>
<br>
<br>

<img width="442" alt="19_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/03671114-ae00-4313-8614-ba67d4c4dabf">

<br>
<br>
<br>

<img width="377" alt="20_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/a37b48d5-6f11-49ea-ac41-5a7a57f56dc6">

<br>
<br>
<br>

**Validar se o "Apache Maven" foi configurado corretamente.**

**Acessar o "Prompt de Comando no Modo Administrador" e digitar o seguinte comando.**

```

mvn --version

```

<br>

<img width="568" alt="14_Maven_Download" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/1ef56a5b-8e46-4a60-9363-4f2a5803afee">


<br>
<br>
<br>

### 3.2 Configurar as dependências do Arquivo "pom.xml".

https://mvnrepository.com

![06_Apache_Maven](https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/99cb7143-063b-4801-91cf-ef8553f5d993)

<br>

### 3.3 Dependência do Arquivo "pom.xml", _"rest-assured"_
<br>

A dependência **"rest-assured"** é uma biblioteca Java que simplifica a automação de testes de API REST, oferecendo uma interface fluente para enviar requisições HTTP e validar respostas. Ela é amplamente utilizada para escrever testes automatizados que verificam a funcionalidade e integridade das APIs REST em aplicativos Java.

<br>

```

<dependencies>

	<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
	<dependency>
		<groupId>io.rest-assured</groupId>
		<artifactId>rest-assured</artifactId>
		<version>5.4.0</version>
		<scope>test</scope>
	</dependency>


</dependencies>

```

<br>
<br>

### 4. TestNG
<br>

O **TestNG** é utilizado em testes de API REST para automatizar a execução de casos de teste, verificar a integridade das respostas da API (status HTTP, conteúdo do corpo) e gerar relatórios detalhados sobre os resultados dos testes, simplificando a garantia da qualidade do software.

<br>

### 4.1 Dependência do Arquivo "pom.xml", _"TestNG"_

<br>

```

<dependencies>

	<!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
	<dependency>
		<groupId>io.rest-assured</groupId>
		<artifactId>rest-assured</artifactId>
		<version>5.4.0</version>
		<scope>test</scope>
	</dependency>

	<!-- https://mvnrepository.com/artifact/org.testng/testng -->
	<dependency>
		<groupId>org.testng</groupId>
		<artifactId>testng</artifactId>
		<version>7.10.2</version>
		<scope>test</scope>
	</dependency>

</dependencies>

```

<br>

### 4.2 Adicionar o TestNG plugin na IDE Eclipse
<br>

**1** Na IDE Eclipse, acessar o Menu Help, opção Install New Software.
<br>

**2** No campo **"Work with:"** digitar a seguinte URL de instação do TestNG.
<br>
https://testng.org/testng-eclipse-update-site

**_Para obter a documentação do TestNG acessar a URL._**

https://github.com/testng-team/testng-eclipse

<br>

**3** Clicar no botão **"ADD"**

**4** Informar o campo **"Nome" igual a "TestNG"**

**5** Informar o campo **"Location:" igual a "https://testng.org/testng-eclipse-update-site"**

**6** Clicar no botão **"Add"**

**7** Selecionar a **flag "TestNG"**

**8** Clicar no botão **"Next",** para iniciar a instalação do plugin.
<br>
<br>

<img width="676" alt="21_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/1b16c8d5-8c76-4c2a-95d3-d43dff00e18e">

<br>
<br>

<img width="672" alt="22_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/be1a7bf0-4410-49b8-8ec3-05a6b5d31867">

<br>
<br>

<img width="676" alt="23_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/4bdcfe54-df34-4418-af94-9ed40f67c053">

<br>
<br>

<img width="676" alt="24_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/bd572f56-2b02-4fc2-b0db-1f8189b5c001">

<br>
<br>

<img width="676" alt="25_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/513e94e4-d24e-49ea-a9b8-6bb75072e6d1">


<br>
<br>

<img width="572" alt="26_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_REST/assets/84775466/f37b8401-4219-4e38-9a76-eeef1bc79165">

<br>
<br>

