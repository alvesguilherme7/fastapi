package com.alvesguilherme.fastapi.api;

import com.alvesguilherme.fastapi.client.FastAPIConfig;
import com.alvesguilherme.fastapi.exception.FastAPIError;
import com.alvesguilherme.fastapi.model.ClienteFornecedor;
import com.alvesguilherme.fastapi.utils.URLUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class PostClienteFornecedor extends ChamadaAPI {
    private final OkHttpClient client;
    private final String uri;

    public PostClienteFornecedor(OkHttpClient client, FastAPIConfig fastAPiConfig) {
        this.client = client;
        this.uri = new URLUtils(fastAPiConfig.getUrl())
                .addPath("clientefornecedor")
                .build();
    }

    public void enviar(ClienteFornecedor clienteFornecedor) throws IOException {
        Request request = new Request.Builder()
            .url(uri)
            .post(buildResquestBody(clienteFornecedor))
            .build();

        try(Response response = client.newCall(request).execute()) {

            if (response.isSuccessful()) {
                logger.info("Cadastrado com sucesso: " + clienteFornecedor);
            } else {
                throw FastAPIError.from(response, "Body: "+ getSafeResponseBody(response));
            }
        }
    }

}
