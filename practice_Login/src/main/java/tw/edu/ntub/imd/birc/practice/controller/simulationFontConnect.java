package tw.edu.ntub.imd.birc.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@RestController
@RequestMapping("/google")
public class simulationFontConnect {
    @Value("${google.clientId}")
    private String clientid;
    @Value("${google.clientSecret}")
    private String clientsecret;
    @Value("${google.redirect-url}")
    private String redirecturi;

    // 第一步：產生 Google OAuth2 認證網址，前端導向過去
    @GetMapping("/step1")
    public String googleAuthUrl() {
        String url = "https://accounts.google.com/o/oauth2/v2/auth" +
                "?client_id=" + clientid +
                "&redirect_uri=" + redirecturi +
                "&response_type=code" +
                "&scope=openid%20email%20profile";
        return url;
    }

    // 第二步：Google 授權後會 redirect 回來，帶 code
    // 這裡交換 token，模擬之後的 /login
    @GetMapping("/step2")
    public Map<String, Object> googleLogin(@RequestParam("code") String code) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String body = "code=" + code +
                "&client_id=" + clientid +
                "&client_secret=" + clientsecret +
                "&redirect_uri=" + redirecturi +
                "&grant_type=authorization_code";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://oauth2.googleapis.com/token"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 解析 Google 回傳的 JSON
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> tokenResponse = mapper.readValue(response.body(), Map.class);

        // 這裡你可以選擇拿 access_token 去呼叫 Google UserInfo API，再做系統內的登入
        return tokenResponse;
    }
}
