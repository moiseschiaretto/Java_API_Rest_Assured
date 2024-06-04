package com.automation.api;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;

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
    	RestAssured.baseURI = ConfigAPI.BASE_URI;
        String endPoint = ConfigAPI.ENDPOINT_USERS;
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
        AssertsAPI.assertStatusCodeGet(response.getStatusCode());
        AssertsAPI.assertResponseTime(response.getTime());
    }
    
    @Test(priority = 2, enabled = true, groups = {"1 - Listar Usuários"})
    public void testGetUserId() {
    	RestAssured.baseURI = ConfigAPI.BASE_URI;
        Response response =
	        given()
	            .log().method()
	            .log().uri()
	        .when()
	            .get(ConfigAPI.ENDPOINT_USERS + ConfigAPI.USER_ID)
	        .then()
	        	.log().body()
	            .extract().response()
	        ;   
        AssertsAPI. assertStatusCodeGet(response.getStatusCode());
        AssertsAPI.assertResponseTime(response.getTime());
        AssertsAPI.assertUserDetails(response);
     }

     @Test(priority = 3, enabled = true, groups = {"2 - Inserir Usuário"})
     public void testPostUser() {
    	 RestAssured.baseURI = ConfigAPI.BASE_URI;
		String requestBody = "{ \"name\": \"Novo Usuário\", \"email\": \"novo@usuario.com\", \"age\": 31 }";
		Response response =
			given()
			    .header("Authorization", ConfigAPI.AUTH_TOKEN)
			    .header("Content-Type", "application/json")
			    .header("Accept", "application/json")
			    .body(requestBody)
			.when()
			    .post(ConfigAPI.ENDPOINT_USERS)
			.then()
			    .log().body()
			    .extract().response()
			;
		AssertsAPI.assertStatusCodePost(response.getStatusCode());
		AssertsAPI.assertResponseTime(response.getTime());
		
		// Extrair o ID do usuário do corpo da resposta
		String responseBody = response.getBody().asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		userId = jsonPath.getString("id");
     }

     @Test(priority = 4, enabled = true, groups = {"2 - Inserir Usuário"})
     public void testPostUserBadRequest() {
    	 RestAssured.baseURI = ConfigAPI.BASE_URI;
		// Corpo de requisição com os dados em formato inválido
		String requestBody = "\\\"name\\\": \\\"Novo Usuário\\\", \\\"email\\\": \\\"novo@usuario.com\\\", \\\"age\\\": 31 ";
		Response response =
			given()
			    .header("Authorization", ConfigAPI.AUTH_TOKEN)
			    .header("Content-Type", "application/json")
			    .header("Accept", "application/json")
			    .body(requestBody)
			.when()
			    .post(ConfigAPI.ENDPOINT_USERS)
			.then()
			    .log().body()
			    .extract().response()
			;
		 AssertsAPI.assertStatusCodeBadRequest(response.getStatusCode());
		 AssertsAPI.assertResponseTime(response.getTime());
      }

      @Test(priority = 5, enabled = true, groups = {"3 - Atualizar Usuário"})
      public void testPutUser() {
    	  RestAssured.baseURI = ConfigAPI.BASE_URI;
		 String requestBody = "{ \"name\": \"Novo Usuário2\", \"email\": \"novo2@usuario.com\" }";
		 Response response =
			given()
			    .header("Authorization", ConfigAPI.AUTH_TOKEN)
			    .header("Content-Type", "application/json")
			    .header("Accept", "application/json")
			    .body(requestBody)
			.when()
			    .put(ConfigAPI.ENDPOINT_USERS + ConfigAPI.USER_ID)
			.then()
			    .log().body()
			    .extract().response()
			;
		  AssertsAPI.assertStatusCodeGet(response.getStatusCode());
		  AssertsAPI.assertResponseTime(response.getTime());
      }
	    
      @Test(priority = 6, enabled = true, groups = {"4 - Excluir Usuário"})
      public void testDeleteUser() {
    	 RestAssured.baseURI = ConfigAPI.BASE_URI;
	 	 Response response =
			given()
			    .header("Authorization", ConfigAPI.AUTH_TOKEN)
			    .header("Content-Type", "application/json")
			    .header("Accept", "application/json")
			.when()
			    .delete(ConfigAPI.ENDPOINT_USERS + ConfigAPI.USER_ID)
			.then()
			    .log().body()
			    .extract().response()
			;
	 	 AssertsAPI.assertStatusCodeDelete(response.getStatusCode());
	 	 AssertsAPI.assertResponseTime(response.getTime());
       }

}    
