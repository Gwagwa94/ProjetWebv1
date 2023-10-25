package org.example.API;

import java.io.IOException;

import static org.example.API.API.demoRequest;
import static org.example.API.API.requestToken;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String token = requestToken("591b04f0114a409788ecacb24546d247", "2dcaacb0535b4ec6a2d12956fabab4e5");
        System.out.println(token);
        String response = demoRequest(token);
        System.out.println(response);
    }
}
