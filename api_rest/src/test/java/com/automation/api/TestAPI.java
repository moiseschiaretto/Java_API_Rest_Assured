package com.automation.api;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import static org.testng.Assert.assertEquals;

public class TestAPI {
    
    @SuppressWarnings("unused")	
    private String userId;

    // Exemplo de teste para não executar (enabled = false), ignorar e visualizar no report
    @Test(priority = 10, enabled = false, groups = {"10 - Não Executar"})
    public void testDisabled() {
    	System.out.println("@Test enabled = false");
    }
   
    @Test(priority = 1, enabled = true, groups = {"1 - Listar Usuários"})
    public void testGetAllUsers() {
    	RestAssured.baseURI = APIConfig.BASE_URI;
        String endPoint = APIConfig.ENDPOINT_USERS;
        Response response =
	        given()
	                .log().method()
	                .log().uri()
	        .when()
	                .get(endPoint)
	        .then()
	        		.log().body()
	                .extract().response()
	        ;
        assertStatusCodeGet(response.getStatusCode());
        assertResponseTime(response.getTime());
    }
    
    @Test(priority = 2, enabled = true, groups = {"1 - Listar Usuários"})
    public void testGetUserId() {
    	RestAssured.baseURI = APIConfig.BASE_URI;
        Response response =
	        given()
	            .log().method()
	            .log().uri()
	        .when()
	            .get(APIConfig.ENDPOINT_USERS + APIConfig.USER_ID)
	        .then()
	        	.log().body()
	            .extract().response()
	        ;   
        assertStatusCodeGet(response.getStatusCode());
        assertResponseTime(response.getTime());
        assertUserDetails(response);
     }

     @Test(priority = 3, enabled = true, groups = {"2 - Inserir Usuário"})
     public void testPostUser() {
    	 RestAssured.baseURI = APIConfig.BASE_URI;
		String requestBody = "{ \"name\": \"Novo Usuário\", \"email\": \"novo@usuario.com\", \"age\": 31 }";
		Response response =
			given()
			    .header("Authorization", APIConfig.AUTH_TOKEN)
			    .header("Content-Type", "application/json")
			    .header("Accept", "application/json")
			    .body(requestBody)
			.when()
			    .post(APIConfig.ENDPOINT_USERS)
			.then()
			    .log().body()
			    .extract().response()
			;
		assertStatusCodePost(response.getStatusCode());
		assertResponseTime(response.getTime());
		
		// Extrair o ID do usuário do corpo da resposta
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		userId = jsonPath.getString("id");
     }

     @Test(priority = 4, enabled = true, groups = {"2 - Inserir Usuário"})
     public void testPostUserBadRequest() {
    	 RestAssured.baseURI = APIConfig.BASE_URI;
		// Corpo de requisição com os dados em formato inválido
		String requestBody = "\\\"name\\\": \\\"Novo Usuário\\\", \\\"email\\\": \\\"novo@usuario.com\\\", \\\"age\\\": 31 ";
		Response response =
			given()
			    .header("Authorization", APIConfig.AUTH_TOKEN)
			    .header("Content-Type", "application/json")
			    .header("Accept", "application/json")
			    .body(requestBody)
			.when()
			    .post(APIConfig.ENDPOINT_USERS)
			.then()
			    .log().body()
			    .extract().response()
			;
		 assertStatusCodeBadRequest(response.getStatusCode());
		 assertResponseTime(response.getTime());
     }

      @Test(priority = 5, enabled = true, groups = {"3 - Atualizar Usuário"})
      public void testPutUser() {
    	  RestAssured.baseURI = APIConfig.BASE_URI;
		 String requestBody = "{ \"name\": \"Novo Usuário2\", \"email\": \"novo2@usuario.com\" }";
		 Response response =
			given()
			    .header("Authorization", APIConfig.AUTH_TOKEN)
			    .header("Content-Type", "application/json")
			    .header("Accept", "application/json")
			    .body(requestBody)
			.when()
			    .put(APIConfig.ENDPOINT_USERS + APIConfig.USER_ID)
			.then()
			    .log().body()
			    .extract().response()
			;
		 assertStatusCodeGet(response.getStatusCode());
		 assertResponseTime(response.getTime());
      }
	    
      @Test(priority = 6, enabled = true, groups = {"4 - Excluir Usuário"})
      public void testDeleteUser() {
    	 RestAssured.baseURI = APIConfig.BASE_URI;
	 	 Response response =
			given()
			    .header("Authorization", APIConfig.AUTH_TOKEN)
			    .header("Content-Type", "application/json")
			    .header("Accept", "application/json")
			.when()
			    .delete(APIConfig.ENDPOINT_USERS + APIConfig.USER_ID)
			.then()
			    .log().body()
			    .extract().response()
			;
		  assertStatusCodeDelete(response.getStatusCode());
		  assertResponseTime(response.getTime());
	       }

	private void assertStatusCodeDelete(int statusCode) {
		assert statusCode == 204 : "Teste de Status Code falhou! Status Code: " + statusCode;
		System.out.println("Status Code = " + statusCode);
	}
	    
	private void assertStatusCodeBadRequest(int statusCode) {
		assert statusCode == 400 : "Teste de Status Code falhou! Status Code: " + statusCode;
		System.out.println("Status Code = " + statusCode);
	}
	
	private void assertStatusCodePost(int statusCode) {
		assert statusCode == 201 : "Teste de Status Code falhou! Status Code: " + statusCode;
		System.out.println("Status Code = " + statusCode);
	}
	
	private void assertStatusCodeGet(int statusCode) {
		assert statusCode == 200 : "Teste de Status Code falhou! Status Code: " + statusCode;
		System.out.println("Status Code = " + statusCode);
	}
	
	private void assertResponseTime(long responseTime) {
		assert responseTime <= APIConfig.EXPECTED_RESPONSE_TIME : "Teste de Tempo de Resposta falhou! Tempo de Resposta: " + responseTime;
		System.out.println("Tempo de Resposta = " + responseTime);
	}
	
	private void assertUserDetails(Response response) {
		JsonPath jsonPath = response.jsonPath();
		assertEquals(jsonPath.getInt("data.id"), APIConfig.USER_ID, "ID do usuário não corresponde ao esperado");
		assertEquals(jsonPath.getString("data.email"), "george.bluth@reqres.in", "Email do usuário não corresponde ao esperado");
		assertEquals(jsonPath.getString("data.first_name"), "George", "Primeiro nome do usuário não corresponde ao esperado");
		assertEquals(jsonPath.getString("data.last_name"), "Bluth", "Último nome do usuário não corresponde ao esperado");
		assertEquals(jsonPath.getString("data.avatar"), "https://reqres.in/img/faces/1-image.jpg", "URL do avatar do usuário não corresponde ao esperado");
	}   
}    
