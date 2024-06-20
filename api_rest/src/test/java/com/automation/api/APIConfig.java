package com.automation.api;

public class APIConfig {
    // Documentação da API no site:   https://reqres.in 
    public static final String BASE_URI = "https://reqres.in/api";
    public static final String ENDPOINT_USERS = "/users/";
    public static final String AUTH_TOKEN = "Bearer " + System.getenv("AUTH_TOKEN");
    /* 
     * Criar a Variável de Ambiente no Windows
     * setx AUTH_TOKEN "valor_do_token"
     * Remover a Variável de Ambiente no Windows
     * setx AUTH_TOKEN "" 
     */
    public static final long EXPECTED_RESPONSE_TIME = 2000;
    public static final int USER_ID = 1;
}
