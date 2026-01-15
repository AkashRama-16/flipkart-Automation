package utils;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class GridUtil {

    public static boolean isGridRunning(String gridUrl) {
        try {
            URI uri = URI.create(gridUrl + "/status");
            URL url = uri.toURL();

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(2000);
            connection.connect();

            return connection.getResponseCode() == 200;
        } catch (Exception e) {
            return false;
        }
    }
}
