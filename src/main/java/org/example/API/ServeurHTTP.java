package org.example.API;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.Objects;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;

public class ServeurHTTP {

    public static void main(String[] args) throws IOException {
        // Créer un serveur HTTP sur le port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(3000), 0);

        // Définir un gestionnaire de requêtes
        server.createContext("/", new MonGestionnaireRequetes());
        //server.createContext("/start", new MonGestionnaireRequetes());

        // Démarrer le serveur
        server.start();
    }

}

class MonGestionnaireRequetes implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Traiter la requête
        String requete = exchange.getRequestURI().toString();
        System.out.println(requete);
        if (Objects.equals(requete, "/start")) {
            String[] args = new String[0];
            System.out.println("Starting auth");
            try {
                Main.main(args);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            String reponse = "hello world";

            // Envoyer la réponse
            exchange.sendResponseHeaders(200, reponse.length());
            PrintWriter writer = new PrintWriter(exchange.getResponseBody());
            writer.write(reponse);
            writer.flush();
        }
    }
}
