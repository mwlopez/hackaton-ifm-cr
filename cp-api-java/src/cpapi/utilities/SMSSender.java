package cpapi.utilities;

import okhttp3.*;

import java.io.IOException;

public class SMSSender {

    public static String send(String to, String msg) {
        String result;
        try {
            String url = "https://mbp.aao.cr/h-app/sms/sendAPI";
            OkHttpClient client = new OkHttpClient();

            RequestBody formBody = new FormBody.Builder()
                    .add("telefono", to)
                    .add("mensaje", msg)
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                result = response.body().string();
                System.out.println("RESULTADO " + result);
            }
        } catch (Exception ex) {
            result = "";
        }
        return result;
    }
}