package docker;

import java.net.HttpURLConnection;
import java.net.URL;

public class DockerNetworkUtils {

    public static String detectSelenoidUrl() {
        String[] possibleUrls = {
                "http://host.docker.internal:4444/wd/hub",
                "http://gateway.docker.internal:4444/wd/hub",
                "http://172.17.0.1:4444/wd/hub",
                "http://localhost:4444/wd/hub"
        };

        for (String url : possibleUrls) {
            if (isSelenoidAvailable(url)) {
                System.out.println("✅ Found Selenoid at: " + url);
                return url;
            }
        }

        throw new RuntimeException("❌ Selenoid not found on any known addresses");
    }

    private static boolean isSelenoidAvailable(String url) {
        try {
            String statusUrl = url.replace("/wd/hub", "/status");
            URL selenoidUrl = new URL(statusUrl);
            HttpURLConnection connection = (HttpURLConnection) selenoidUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.connect();
            return connection.getResponseCode() == 200;
        } catch (Exception e) {
            System.out.println("❌ " + url + " - " + e.getMessage());
            return false;
        }
    }
}