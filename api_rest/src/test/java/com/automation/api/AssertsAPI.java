package com.automation.api;

import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import static org.testng.Assert.assertEquals;

public class AssertsAPI {
  
	public static void assertStatusCodeDelete(int statusCode) {
		assert statusCode == 204 : "Teste de Status Code falhou! Status Code: " + statusCode;
		System.out.println("Status Code = " + statusCode);
	}
	
	public static void assertResponseTime(long responseTime) {
		assert responseTime <= ConfigAPI.EXPECTED_RESPONSE_TIME : "Teste de Tempo de Resposta falhou! Tempo de Resposta: " + responseTime;
		System.out.println("Tempo de Resposta = " + responseTime);
	}
	    
	public static void assertStatusCodeBadRequest(int statusCode) {
		assert statusCode == 400 : "Teste de Status Code falhou! Status Code: " + statusCode;
		System.out.println("Status Code = " + statusCode);
	}
	
	public static void assertStatusCodePost(int statusCode) {
		assert statusCode == 201 : "Teste de Status Code falhou! Status Code: " + statusCode;
		System.out.println("Status Code = " + statusCode);
	}
	
	public static void assertStatusCodeGet(int statusCode) {
		assert statusCode == 200 : "Teste de Status Code falhou! Status Code: " + statusCode;
		System.out.println("Status Code = " + statusCode);
	}
	
	public static void assertUserDetails(Response response) {
		JsonPath jsonPath = response.jsonPath();
		assertEquals(jsonPath.getInt("data.id"), ConfigAPI.USER_ID, "ID do usuário não corresponde ao esperado");
		assertEquals(jsonPath.getString("data.email"), "george.bluth@reqres.in", "Email do usuário não corresponde ao esperado");
		assertEquals(jsonPath.getString("data.first_name"), "George", "Primeiro nome do usuário não corresponde ao esperado");
		assertEquals(jsonPath.getString("data.last_name"), "Bluth", "Último nome do usuário não corresponde ao esperado");
		assertEquals(jsonPath.getString("data.avatar"), "https://reqres.in/img/faces/1-image.jpg", "URL do avatar do usuário não corresponde ao esperado");
	}   
	
}
