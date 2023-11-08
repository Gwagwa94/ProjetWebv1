package org.example.API;

import java.io.IOException;

import static org.example.API.API.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String token = requestToken("591b04f0114a409788ecacb24546d247", "2dcaacb0535b4ec6a2d12956fabab4e5");
        System.out.println("token: " + token);
//        String response = search("", token);
//        System.out.println("response: " + response);
        String response = createPlaylist("Test playlist", token);
//        String response = getUser(token);
        System.out.println("response: " + response);
        response = search("", token);
        System.out.println("response: " + response);
    }
}
