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
    @Test(priority = 10, enabled = false, groups = {"Grupo 10 - Não Executar o Método"})
    public void testDisabled() {
    	System.out.println("@Test enabled = false");
    }
    
    
    @Test(priority = 1, enabled = true, groups = {"Grupo 1 - Listar todos os Usuários"})
    public void testGetAllUsers() {
        
        RestAssured.baseURI = BASE_URI;
        String endPoint = "/users/";

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
    
    
    @Test(priority = 2, enabled = true, groups = {"Grupo 2 - Listar Usuário Id"})
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


    @Test(priority = 3, enabled = true, groups = {"Grupo 3 - Inserir Usuário"})
    public void testPostUser() {
        RestAssured.baseURI = BASE_URI;

        String requestBody = "{ \"name\": \"Novo Usuário\", \"email\": \"novo@usuario.com\", \"age\": 31 }";

        Response response =
                given()
                    .header("Authorization", AUTH_TOKEN)
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(requestBody)
                .when()
                    .post(ENDPOINT_USERS)
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

    
	    @Test(priority = 4, enabled = true, groups = {"Grupo 4 - Inserir Usuário com Dados Inválidos - Bad Request = 400"})
	    public void testPostUserBadRequest() {
		    RestAssured.baseURI = BASE_URI;
	        String requestBody = "\\\"name\\\": \\\"Novo Usuário\\\", \\\"email\\\": \\\"novo@usuario.com\\\", \\\"age\\\": 31 ";
		    
	        // Corpo de requisição com os dados inválidos (por exemplo, campo obrigatório ausente = e-mail)
		    Response response =
	                given()
	                    .header("Authorization", AUTH_TOKEN)
	                    .header("Content-Type", "application/json")
	                    .header("Accept", "application/json")
	                    .body(requestBody)
	                .when()
	                    .post(ENDPOINT_USERS)
	                .then()
	                    .log().body()
	                    .extract().response()
	                ;
	
	        assertStatusCodeBadRequest(response.getStatusCode());
	        assertResponseTime(response.getTime());
	    }
    
	    
	    @Test(priority = 5, enabled = true, groups = {"Grupo 5 - Atualizar Usuário"})
	    public void testPutUser() {
	        RestAssured.baseURI = BASE_URI;

	        String requestBody = "{ \"name\": \"Novo Usuário2\", \"email\": \"novo2@usuario.com\" }";

	        Response response =
	                given()
	                    .header("Authorization", AUTH_TOKEN)
	                    .header("Content-Type", "application/json")
	                    .header("Accept", "application/json")
	                    .body(requestBody)
	                .when()
	                    .put(ENDPOINT_USERS + userId)
	                .then()
	                    .log().body()
	                    .extract().response()
	                ;

	        assertStatusCodeGet(response.getStatusCode());
	        assertResponseTime(response.getTime());
	    }
	    
	    
	    
	    
	    @Test(priority = 6, enabled = true, groups = {"Grupo 6 - Excluir Usuário"})
	    public void testDeleteUser() {
	        RestAssured.baseURI = BASE_URI;
       

	        Response response =
	                given()
	                    .header("Authorization", AUTH_TOKEN)
	                    .header("Content-Type", "application/json")
	                    .header("Accept", "application/json")
	                .when()
	                    .delete(ENDPOINT_USERS + userId)
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



