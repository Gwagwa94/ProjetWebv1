package org.example.API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    public static URI spotify = URI.create("https://api.spotify.com/");

    public static void demoRequest() throws IOException, InterruptedException {
        //créer un client HTTP
        HttpClient client = HttpClient.newBuilder().build();

        // Créer une requête HTTP
        //"BQBl1EfOlRTWjwod4_gpV5KqIGZnoxsTfe9Jb7-I4Osr_Zb0BtA2nVMbkKGPsOc0E3IStYUkAjVoudYBdsMQkfoVsqxzVMk33wgIleDAJMpcYpXCn6EcBCNUcVMpt8X3ZWyyLWqyfGiW39DZYvGN6ZF2KLrb9zVq5kRQrlbxdhT-MC7WSlFKAfQAUW-L-Tg7jsB_Piiq_fvGx81Gz_ufAciWvUBjX7v6NC5zWVVhzkbn3K2Iq1bz4VAl4yOlBdqZ3hWQfSLpHsoKn5D4qNC0bwAM";
        String token = "BQAO2kq-GOUGX8FjrzaSHb9VBGoGbso9Q9fUN5qGK7w0DaHiGKpLE6Pf655hZbRu7ZuHl4QKuBXdeLP-7leodjJ06HHqFFcy_mVYpfAhUSjKqHM-xk7IUcK41-TZRCM8FlXWNX6bXLrvsF2600RQgOfVBXHR8JZUYxQH0Fjz7_LTo16O84KiKfHKjLBFxi4qGFGwUzNQVJtKytKA2SvP1u0xMhSycP9thhhaYf4vu-6Dvduk_Na-iClyUS7X-7jHZScrUSOtP8Q9uoNArrlIiyIEJwjFTWXbuerMufDVgnsQhj_UAtjUX7fBb7_CXCqIul_-a_kbc4yXu0S-1ZQvlqSwguTN";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(spotify + "v1/browse/categories/Latin"))
                .header("Authorization", "Bearer " + token)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        // Envoyer la requête
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Afficher la réponse
        System.out.println(response.body());
    }
}
