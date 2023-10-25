package org.example.API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    public static URI spotify = URI.create("https://api.spotify.com/");

    public static String requestToken(String id, String secret) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&client_id="
                        + id + "&client_secret=" + secret))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String token = response.body().split("\"")[3];
        return token;
    }

    public static String demoRequest(String token) throws IOException, InterruptedException {
        //créer un client HTTP
        HttpClient client = HttpClient.newBuilder().build();

        // Créer une requête HTTP
        //"BQBl1EfOlRTWjwod4_gpV5KqIGZnoxsTfe9Jb7-I4Osr_Zb0BtA2nVMbkKGPsOc0E3IStYUkAjVoudYBdsMQkfoVsqxzVMk33wgIleDAJMpcYpXCn6EcBCNUcVMpt8X3ZWyyLWqyfGiW39DZYvGN6ZF2KLrb9zVq5kRQrlbxdhT-MC7WSlFKAfQAUW-L-Tg7jsB_Piiq_fvGx81Gz_ufAciWvUBjX7v6NC5zWVVhzkbn3K2Iq1bz4VAl4yOlBdqZ3hWQfSLpHsoKn5D4qNC0bwAM";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(spotify + "v1/artists/4Z8W4fKeB5YxbusRsdQVPb"))
                .header("Authorization", "Bearer " + token)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // Envoyer la requête
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Afficher la réponse
        return response.body();
    }
}
