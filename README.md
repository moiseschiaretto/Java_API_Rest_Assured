# _Em construção ..._

## Projeto "API REST com Rest Assured e TestNG"

Autor Moisés Ademir Chiaretto

Descrição das explicações de cada item da estrutura do projeto "API REST com Rest Assured" desenvolvido.

O objetivo é desenvolver cenários de testes em Java com API REST com Rest Assured e TestNG utilizando os métodos / verbos HTTP (Get, Post, Put, Patch, Delete).

### Consultar no final desta documentação o _tópico_ "Configuração do Ambiente de Trabalho" e o _subtópico_ "Pré-requisitos"


![01_Java](https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/c8f6e7b0-c6ec-47f3-a11f-17f62069c885)



![02_API_REST](https://github.com/moiseschiaretto/Java_API_Rest_Assured/assets/84775466/dabac376-7ec3-46ee-957c-32d88195f9bc)



<br>

## Estrutura do Projeto "API REST com Rest Assured e TestNG"

**_Em construção ..._**

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

### Explicações das palavras-chaves utilizadas no Rest Assured, semelhante a escrita do BDD em Gherkin.
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


### Métodos com Mesma Prioridade

**Pode haver uma chance de que os métodos contenham a mesma prioridade. Nesses casos, testng considera a ordem alfabética dos nomes dos métodos cuja prioridade é a mesma.**


```

public class ExemploTestNG {

	@Test (priority = 3)
	public void a_test() {
		System.out.println("Method A");
	}

	@Test (priority = 2)
	public void b_test() {
		System.out.println("Method B");
	}

	@Test (priority = 1)
	public void c_test() {
		System.out.println("Method C");
	}
	
	@Test (priority = 4)
	public void d_test() {
		System.out.println("Method D");
	}
	
}

```
<br>

**O resultado da execução neste exemplo acima será a seguinte.**

```

Method C
Method B
Method A
Method D

```
<br>

**Sem especificar o parâmtro _(priority = 1)_ por exemplo, a execução dos métodos "seria" em _ordem alfabética dos nomes dos métodos (letra inicial do nome)_, conforme o exemplo de resultado abaixo.**


```

Method A
Method B
Method C
Method D

```


<br>

***

## Configuração do Ambiente de Trabalho


### Pré-requisitos

### 1. Java JDK

### 2. IDE (Eclipse, IntelliJ, etc)

### 3. Maven

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

***


# _Em construção ..._

### 5. Criar um _"Maven Project"_







***


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



***

# _Em construção ..._

### 8. Adicionar a "Library TestNG" no Projeto em "Java Build Path"

### 9. Criar uma classe "TestNG class"

### 10. Testar nesta classe TestNG a opção "Run As" e verificar se têm a opção execução "TestNG Test"


***






