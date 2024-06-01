## Projeto "API REST com Rest Assured e TestNG"

Autor Moisés Ademir Chiaretto

Descrição das explicações de cada item da estrutura do projeto "API REST com Rest Assured" desenvolvido.

O objetivo é desenvolver cenários de testes em Java com TestNG, e a API REST com Rest Assured utilizando os métodos / verbos HTTP (Get, Post, Put, Patch, Delete).

### Consultar no final desta documentação o _tópico_ "Configuração do Ambiente de Trabalho" e o _subtópico_ "Pré-requisitos".
<br>

|Java		|Apache Maven	|TestNG		|API Rest Assured	|JSON		||IDE Eclipse	|
|---------------|---------------|---------------|-----------------------|---------------|---------------|
| <img width="175" alt="00_JDK" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/3235b5a0-52aa-4575-87ec-9979f860e169"> | ![06_Apache_Maven](https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/3fa7942c-ed5f-401d-92d1-023deb48e154) | <img width="172" alt="00_Logo_TestNG_JAVA" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/6256a00d-4359-4c02-bc12-15788c3ff6b2"> | ![03_API_REST_ASSURED_BDD](https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/62679ee5-6603-428b-9f5a-427036acc49f) | <img width="164" alt="04_JSON" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/59400abd-b499-433b-b332-989c0b2c6641"> | <img width="329" alt="10_Logo_IDE_Eclipse" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/920ea6a0-3239-476a-8de5-c380378206f5"> |
<br>


## Estrutura do Projeto "API REST com Rest Assured e TestNG"
<br>

<img width="195" alt="00_ESTRUTURA_PROJETO" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/8071ea79-8af1-4da3-ab92-5a7e1b0834d4">
<br>


## Cenários de Testes de API REST

CRUD com os verbos HTTP, métodos GetAll, GetId, Post, Put, Patch, Delete.
<br>

|Endpoint	|Método		|Ação		|
|---------------|---------------|---------------|
|/users		|GET		|Retorna a lista de usuários				|
|/users		|POST		|Insere um novo usuário					|
|/users{id}	|GET		|Retorna o usuário com id = {id}			|
|/users{id}	|PUT		|Substitui os dados do usuário com id = {id}		|
|/users{id}	|PATCH		|Altera itens dos dados do usuário com id = {id}	|
|/users{id}	|DELETE		|Remove o usuário com id = {id}				|

<br>

![05_Piramide_Testes](https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/9b2a370b-1b74-458e-b158-b281456d6055)

<br>

## Script simples do Rest Assured
<br>

![03_API_REST_ASSURED_BDD](https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/2376ed5a-9018-46f5-a7a4-7254944202f9)


### Sintaxe do Rest Assured.io é semelhante a escrita do BDD em Gherkin.


```

Given() 
        .param("a", "b") 
        .header("c", "d")
When()
        .method()
Then() 
        .statusCode(XXX)
        .body("y", equalTo("z"))
        .log().body()
;

```

<br>

### Explicações das palavras-chaves (keywords) utilizadas no Rest Assured, semelhante a escrita do BDD em Gherkin.
<br>

|Keyword	|Explicações das palavras-chaves utilizadas em Rest Assured.io	|
|---------------|---------------|
|**Dado()**	|**Given()** é um método usado em testes de API para configurar o estado inicial da solicitação HTTP, definindo parâmetros, cabeçalhos e autenticação antes de enviar a solicitação.		|
|**Quando()**	|**When()** é um método usado em testes de API para enviar uma solicitação HTTP com os parâmetros configurados anteriormente pelo método Given(), simulando uma interação com a API.		|
|**Método()**	|**Method()** é um método usado em testes de API para especificar o tipo de método HTTP (GET, POST, PUT, DELETE, etc.) a ser usado na solicitação. Ele define a ação a ser realizada na API durante o teste.		|
|**Então()**	|**Then()** é um método usado em testes de API para verificar o resultado da solicitação HTTP, como o código de status, o corpo da resposta ou outras condições esperadas, validando se a interação com a API ocorreu conforme o esperado.		|
<br>

## Anotações utilizadas no TestNG @Test
<br>

O **"TestNG"** executará os métodos **@Test** de duas formas sendo em **"ordem alfabética dos nomes dos métodos (letra inicial do nome)"** ou por **"prioridade especificada no parâmetro _(priority = 1)_"**, conforme o exmplo abaixo.

O método o qual esta anotação **_(priority = 3, enabled = false)_** é especificada com o parâmetro **(enabled = false)** por exemplo, não executa este método.


### Métodos com Mesma Prioridade

**Pode haver uma chance de que os métodos contenham a mesma prioridade. Nesses casos, _"TestNG"_ considera a ordem alfabética dos nomes dos métodos cuja prioridade é a mesma.**
<br>
<br>
<br>


```

public class ExemploTestNG {

	@Test (priority = 3, enabled = true, groups = {"2 - Inserir Usuário"})
	public void a_test() {
		System.out.println("Method A");
	}

	@Test (priority = 2, enabled = true, groups = {"1 - Listar Usuários"})
	public void b_test() {
		System.out.println("Method B");
	}

	@Test (priority = 1, enabled = true, groups = {"1 - Listar Usuários"})
	public void c_test() {
		System.out.println("Method C");
	}
	
	@Test (priority = 4, enabled = true, groups = {"3 - Atualizar Usuário"})
	public void d_test() {
		System.out.println("Method D");
	}

	@Test (priority = 5, enabled = true, groups = {"4 - Excluir Usuário"})
	public void e_test() {
		System.out.println("Method E");
	}
	
}

```
<br>

**O resultado da execução neste exemplo acima é a seguinte.**

```

Method C
Method B
Method A
Method D
Method E

```
<br>

**Sem especificar os parâmtros _(priority = 1, enabled = true)_ em todos os métodos, por exemplo, a execução dos métodos é em _ordem alfabética dos nomes dos métodos (letra inicial do nome)_, conforme o exemplo de resultado abaixo.**


```

Method A
Method B
Method C
Method D
Method E

```

**O método o qual esta anotação _(priority = 3, enabled = false)_ é especificada com o parâmetro (enabled = false) por exemplo, não executa este método, e com a _prioridade de execução_ o resultado é o exibido abaixo.**


```

Method C
Method B
Method D
Method E

```
<br>
<br>


### O parâmetro _groups_, por exemplo,   @Test (priority = 1, enabled = true, groups = {"1 - Listar Usuários"})

O parâmetro é utilizado para agrupar os cenários de testes executados no relatório gerado, conforme o exemplo abaixo.


<img width="959" alt="04_REPORT_GRUPOS" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/d60fd7e4-9ed5-4fc3-98e4-b57f6247dff7">


<br>
<br>


## Exemplo de um teste de API REST com Rest Assured em Java com TestNG

### Para demais testes de requisições utilizando os métodos / verbos HTTP (GetAll, GetId, Post, Put, Delete) consultar o arquivo / classe _TestAPI.java_ do projeto em:

**api_rest/src/test/java/com/autoamtion/api/TestAPI.java**
<br>

```

package com.automation.api;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import static org.testng.Assert.assertEquals;

public class TestAPI {
    
    // Documentação da API no site:   https://reqres.in
    private static final String BASE_URI = "https://reqres.in/api";
    private static final String ENDPOINT_USERS = "/users/";
    private static final int USER_ID = 1;
    private static final String AUTH_TOKEN = "Bearer b7e0f9be923eabf55779250a1266ee97af8c9a99adc308e0d1e5d920ba4d96aa";
    private static final long EXPECTED_RESPONSE_TIME = 2000;
    private String userId;

    // Exemplo de teste para não executar (enabled = false), ignorar e visualizar no report
    @Test(priority = 10, enabled = false, groups = {"10 - Não Executar"})
    public void testDisabled() {
    	System.out.println("@Test enabled = false");
    }

    @Test(priority = 2, enabled = true, groups = {"1 - Listar Usuários"})
    public void testGetUserId() {
        RestAssured.baseURI = BASE_URI;

        Response response =
	        given()
	            .log().method()
	            .log().uri()
	        .when()
	            .get(ENDPOINT_USERS + USER_ID)
	        .then()
	        	.log().body()
	            .extract().response()
	        ;
               
        assertStatusCodeGet(response.getStatusCode());
        assertResponseTime(response.getTime());
        assertUserDetails(response);
     }

     private void assertStatusCodeGet(int statusCode) {
        assert statusCode == 200 : "Teste de Status Code falhou! Status Code: " + statusCode;
        System.out.println("Status Code = " + statusCode);
     }

    private void assertResponseTime(long responseTime) {
        assert responseTime <= EXPECTED_RESPONSE_TIME : "Teste de Tempo de Resposta falhou! Tempo de Resposta: " + responseTime;
        System.out.println("Tempo de Resposta = " + responseTime);
     }
    
    
     private void assertUserDetails(Response response) {
	JsonPath jsonPath = response.jsonPath();
	assertEquals(jsonPath.getInt("data.id"), USER_ID, "ID do usuário não corresponde ao esperado");
	assertEquals(jsonPath.getString("data.email"), "george.bluth@reqres.in", "Email do usuário não corresponde ao esperado");
	assertEquals(jsonPath.getString("data.first_name"), "George", "Primeiro nome do usuário não corresponde ao esperado");
	assertEquals(jsonPath.getString("data.last_name"), "Bluth", "Último nome do usuário não corresponde ao esperado");
	assertEquals(jsonPath.getString("data.avatar"), "https://reqres.in/img/faces/1-image.jpg", "URL do avatar do usuário não corresponde ao esperado");
     }
    
}  


```
<br>


## Execução e o Report de execução das requisições HTTP da API REST
<br>

### Execução - resultados no Console e do TestNG

| Results of Console   | Results of running class TestAPI |
|----------------------|----------------------------------|
| <img width="528" alt="01_API_EXECUCAO" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/75f86aa6-8397-4323-8c56-9d61a436a46f"> | <img width="958" alt="02_API_EXECUCAO_TESTNG" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/4547f397-ab6a-4368-b9fe-fbfd1456325c"> |
<br>


### Report da execução das requisições HTTP

**Utilizando o **TestNG** é gerada a pasta **test-output** no projeto, e automaticamente gerado o report no arquivo **index.html**, que pode ser aberto em qualquer navegador Web (browser) para visualizar o report gerado em cada execução do projeto.


| Suíte de Testes  	 | Grupos		 | Times		| Métodos Ignorados	| Ordenação da Execução		
|------------------------|-----------------------|----------------------|-----------------------|-------------------------------
| <img width="607" alt="03_REPORT_1_SUITE_TESTES" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/f0dd217f-0cb4-4c20-b0e1-f7cc9d7f71cb"> | <img width="959" alt="04_REPORT_GRUPOS" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/dd4714a8-64d8-489f-94e8-d6a56ed6b92b"> | <img width="959" alt="05_REPORT_TIMES" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/4bc3e594-05ab-49f3-a8e3-7c98cb543a4c"> | <img width="958" alt="06_REPORT_METHOD_IGNOREDED" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/d8f2126b-b9f9-4d46-b18e-fbf34c5b4b87"> | <img width="959" alt="07_REPORT_ORDER_EXECUTION" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/b0aede47-5473-479f-a76f-5798d1f92ccf"> |
<br>
<br>

## Outras anotações utilizadas no TestNG são @BeforeTest e @AfterTest
<br>

|Anotação TestNG  |Explicações das Anotações TestNG 	|
|-----------------|-------------------------------------|
|@BeforeTest	  | os métodos sob esta anotação serão executados **antes** do primeiro caso de teste no arquivo TestNG. |
|@AfterTest	  | os métodos sob esta anotação serão executados **após** todos os casos de teste no arquivo TestNG serem executados. |
<br>

### Exemplo de uso de _teste Web_ das anotações TestNG com @BeforeTest e @AfterTest
<br>

### Código Java TestNG no projeto, caminho:

**api_rest/src/test/java/com/autoamtion/web/TestWeb.java**


```

package com.automation.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class TestWeb {
    public String baseUrl = "https://bradescosaudeconvenios.com.br";
    public WebDriver driver;
    
    @BeforeTest
    public void setBaseUrl() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
    }
    
    @Test(priority=1, enabled = true)
    public void verifyTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Bradesco Saúde"));
        
        String expectedTitle = "Bradesco Saúde";
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title: " + actualTitle);
        assert actualTitle.contains(expectedTitle) : "Title verification failed!";
    }
    
    @AfterTest
    public void endSession() {
        driver.quit();
    }
}


```
<br>
<br>


***

## Configuração do Ambiente de Trabalho


### Pré-requisitos

### 1. Instalar o Java JDK

### 2. Instalar uma IDE (Eclipse, IntelliJ, etc)

### 3. Instalar o Apache Maven

### 4. Configurar as Variáveis de Ambiente "JAVA_HOME" e "M2_HOME"

### 5. Criar um _"Maven Project"_

### 6. Adicionar as dependências no arquivo "pom.xml" do _"Maven Project"_

### 7. Instalar o "TesteNG" plugin

### 8. Adicionar a "Library TestNG" no _"Maven Project"_ em "Java Build Path"

### 9. Criar uma classe _"TestNG class"_

### 10. Testar nesta classe TestNG a opção _"Run As"_ e verificar se têm a opção execução _"TestNG Test"_


***

### 1. Baixar e Instalar o "Java JDK Development".

https://www.oracle.com/java/technologies/downloads


<img width="175" alt="00_JDK" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/0f84f83b-8fdd-4723-8b49-fd01bc10381f">



**Após a instalação do "Java JDK" digitar no "Prompt de Comando no Modo Administrador" o seguinte comando.**

```

java --version

```

<img width="569" alt="12_Java_JDK_Version" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/50103efb-11c0-4e46-a68f-049d548fc050">



<br>
<br>
<br>

### 2. Baixar e Instalar a "IDE Eclipse".

https://www.eclipse.org/downloads


<img width="329" alt="10_Logo_IDE_Eclipse" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/6e6886d1-5986-4e75-a319-640332cd6249">



<br>
<br>
<br>

### 3. Baixar e Instalar o "Apache Maven".


https://maven.apache.org/download.cgi


<img width="668" alt="13_Maven_Download" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/ac223baf-b7f7-475a-be75-41cd30f22c32">


<br>
<br>
<br>

### 4 Configurar as Variáveis de Ambiente para o "_Apache Maven_" e o _"Java JDK"_

No sistema operacional Windows acessar a opção **"Editar as variáveis de ambiente do sistema".**

<br>

<img width="308" alt="15_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/46bad5e1-39e5-433d-abf9-3f9875d030d1">


<br>
<br>
<br>

<img width="442" alt="16_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/d96af7e6-af91-4a2e-8f47-21c88cf1ff42">


<br>
<br>
<br>

### Variável de Ambiente do Java JDK "JAVA_HOME"

<img width="467" alt="17_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/f9cf7ded-40d1-41d9-b617-1bd56f81d855">


<br>
<br>
<br>

### Variável de Ambiente Apache Maven "M2_HOME"


<img width="467" alt="18_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/418c9c76-ef6c-430a-8fbe-a5ab3a1a92fa">


<br>
<br>
<br>

<img width="442" alt="19_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/93aa4a14-67c6-4697-bf19-35a9b3fbe866">


<br>
<br>
<br>

<img width="377" alt="20_Variavel_Ambiente_SO_Windows" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/61af79d5-4082-4fd6-b05a-1dba1a656156">


<br>
<br>
<br>


**Validar se o "Apache Maven" foi configurado corretamente.**

**Acessar o "Prompt de Comando no Modo Administrador" e digitar o seguinte comando.**

```

mvn --version

```

<br>

<img width="568" alt="14_Maven_Download" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/ac6ac7a0-5afb-4dbb-8a9b-4634185f8ed5">


<br>
<br>
<br>


### 5. Criar um _"Maven Project"_

Ao acessar a **"IDE Eclipse"** clicar no painel "Package Explorer" à esquerda na opção **_"Create a Maven project"_**, outra forma é seguir os passos abaixo.

**1.** Acessar o Menu File >> New > **Maven Project**

**2.** Na tela **"New Maven Project"**, selecionar a opção **_"Create a simple project (skip archetype selection)"_**

**3.** Clicar no botão **Next**

**4.** Informar no campo **_Group Id_** é a identificação única do grupo do projeto, exemplo [com.automation.api]

**5.** Informar no campo **_Artifact Id_** é o nome único do artefato do projeto (geralmente um JAR, WAR ou EAR), exemplo [test_api]

**6.** Clicar no botão **Finish**.
<br>
<br>

<img width="429" alt="27_Criar_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/0717055c-963b-4d70-b69a-7463ec4af10a">
<br>
<br>

<img width="429" alt="28_Criar_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/a5b7a4d0-0bb3-4d48-9181-7f759a3010ec">
<br>
<br>

<img width="177" alt="29_Criar_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/98e61fcd-81ba-4c28-aef1-8271a084f4a2">
<br>
<br>


### 6. Adicionar as dependências no Arquivo "pom.xml" do Projeto

Abaixo consta o link do **repositório do "Apache Maven"** para pesquisar e copiar as dependências do projeto que serão adicionadas ao **arquivo "pom.xml"** do projeto criado.
<br>

https://mvnrepository.com


![06_Apache_Maven](https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/96204bf9-affd-421d-8ff9-9778189f58e8)


<br>

### Dependência do Arquivo "pom.xml", _"rest-assured"_
<br>

A dependência **"rest-assured"** é uma biblioteca Java que simplifica a automação de testes de API REST, oferecendo uma interface fluente para enviar requisições HTTP e validar respostas. Ela é amplamente utilizada para escrever testes automatizados que verificam a funcionalidade e integridade das APIs REST em aplicativos Java.
<br>

### Dependência do Arquivo "pom.xml", _"TestNG"_

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
<br>


### 7. Instalar o "TesteNG" plugin
<br>

O **TestNG** é utilizado em testes de API REST para automatizar a execução de casos de teste, verificar a integridade das respostas da API (status HTTP, conteúdo do corpo) e gerar relatórios detalhados sobre os resultados dos testes, simplificando a garantia da qualidade do software.
<br>

### Instalar o TestNG plugin na IDE Eclipse
<br>

**_Para obter a documentação do TestNG acessar a URL._**

https://github.com/testng-team/testng-eclipse
<br>

<img width="172" alt="00_Logo_TestNG_JAVA" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/36595bac-a3da-40d0-b29a-f742c54a2019">


<br>
<br>

**1** Na IDE Eclipse, acessar o Menu Help, opção Install New Software.
<br>

**2** No campo **"Work with:"** digitar a seguinte URL de instação do TestNG.
<br>
https://testng.org/testng-eclipse-update-site
<br>

**3** Clicar no botão **"ADD"**

**4** Informar o campo **"Nome" igual a "TestNG"**

**5** Informar o campo **"Location:" igual a "https://testng.org/testng-eclipse-update-site"**

**6** Clicar no botão **"Add"**

**7** Selecionar a **flag "TestNG"**

**8** Clicar no botão **"Next",** para iniciar a instalação do plugin.
<br>
<br>

<img width="676" alt="21_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/4ea68219-0ef3-4ff1-bbf8-649743984851">


<br>
<br>

<img width="672" alt="22_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/ada2cf5a-9f2d-4e3a-91ae-b210e2768edb">


<br>
<br>

<img width="676" alt="23_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/b80120d6-25fa-475b-a189-09c21c6e61d6">


<br>
<br>

<img width="676" alt="24_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/15a0f211-767d-4e21-9045-2cb1668df0d8">


<br>
<br>


<img width="676" alt="25_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/33516f23-7de2-47cf-92c7-af163e8844f0">


<br>
<br>

<img width="572" alt="26_TestNG_Plugin" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/2b8fbc18-12ae-4137-b618-e69e3f583abf">


<br>
<br>


### 8. Adicionar a "Library TestNG" no Projeto em "Java Build Path"

Selecionar o _"Maven Project"_ criado e seguir o passo a passo abaixo.

**1.** Clicar com o botão direito do mouse sobre o **nome do projeto Maven criado**

**2.** Clicar na opção **"Properties"**

**3.** Na tela **"Properties for _nome do projeto_"** clicar em **"Java Build Path"** no painel à esquerda

**4.** Clicar na **"Guia Libraries"**

**5.** Clicar no botão **"Add Library"**

**6.** Selecionar a opção **"TestNG"**

**7.** Clicar nos botões **"Next", "Finish", "Apply and Close"**
<br>
<br>
<img width="717" alt="34_ADD_Library_TestNG_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/1986f1b3-4051-4e12-b6aa-fbb3352a348f">

<br>
<br>
<img width="404" alt="35_ADD_Library_TestNG_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/79a1d38c-3af0-4ead-a3e6-02d8b7f6208a">

<br>
<br>
<img width="404" alt="36_ADD_Library_TestNG_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/b07bd304-3721-45aa-8aab-f9438596a18e">

<br>
<br>
<img width="177" alt="37_ADD_Library_TestNG_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/9d90a250-ae42-4a21-93ec-5119dfc45845">

<br>
<br>


### 9. Criar uma classe "TestNG class"

Selecionar a pasta **"/test_api/src/test/java"** do _"Maven Project"_ e seguir o passo a passo abaixo.

**1.** Acessar o Menu File >> New > **Other**

**2.** Na tela **"Select a wizard"**, selecionar a opção **_"TestNG class"_**

**3.** Clicar no botão **Next**

**4.** Informar no campo **_Source folder_** a pasta do **Maven Project**

**5.** Informar no campo **_Package name_** o nome do pacote, exemplo [automation.api]

**6.** Informar no campo **_Class name_** o nome do "classe TestNG"

**7.** Clicar no botão **Finish**
<br>
<br>

<img width="468" alt="31_Library_TestNG_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/afedeb17-67ed-4a7a-b975-9e9ac5a2140d">
<br>
<br>

<img width="447" alt="32_Library_TestNG_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/25ae0fa3-0d22-4c12-91a6-7607956ad127">
<br>
<br>

<img width="399" alt="33_Library_TestNG_Maven_Project" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/d1483b85-17b1-4568-8443-41be36ce0b12">
<br>
<br>


### 10. Testar nesta classe TestNG a opção "Run As" e verificar se têm a opção execução "TestNG Test"
<br>

Selecionar a **_"classe TestNG"_** criada, clicar com o botão direito do mouse sobre a classe, opção **"Run As''** e validar se existe a opção de execução com o **TestNG Test**, conforme a imagem abaixo.

<br>
<br>
<img width="863" alt="38_Run_As_TestNG" src="https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/2cb1b536-2c35-42ba-900b-27cefd152cf8">





