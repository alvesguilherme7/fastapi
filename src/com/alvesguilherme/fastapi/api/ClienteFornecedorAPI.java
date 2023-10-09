package com.alvesguilherme.fastapi.api;

import com.alvesguilherme.fastapi.client.FastAPIConfig;
import com.alvesguilherme.fastapi.exception.FastAPIError;
import com.alvesguilherme.fastapi.model.ClienteFornecedor;
import com.alvesguilherme.fastapi.utils.URLUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class ClienteFornecedorAPI extends ChamadaAPI {
    private final OkHttpClient client;
    private final String uri;

    public ClienteFornecedorAPI(OkHttpClient client, FastAPIConfig fastAPiConfig) {
        this.client = client;
        this.uri = new URLUtils(fastAPiConfig.getUrl())
                .addPath("clientefornecedor")
                .build();
    }

    public ClienteFornecedor enviar(ClienteFornecedor requestCliForn) throws IOException {
        Request request = new Request.Builder()
            .url(uri)
            .post(buildResquestBody(requestCliForn))
            .build();

        try(Response response = client.newCall(request).execute()) {

            if (response.isSuccessful()) {
                Objects.requireNonNull(response.body(), "Responsebody nulo inesperado.");
                ClienteFornecedor responseCliForn = gson.fromJson(response.body().string(), ClienteFornecedor.class);
                logger.info("Cadastrado com sucesso: " + responseCliForn);
                return responseCliForn;
            } else {
                throw FastAPIError.from(response, "Body: "+ getSafeResponseBody(response));
            }
        }
    }

    public ClienteFornecedor atualizar(ClienteFornecedor requestCliForn) throws IOException {
        Request request = new Request.Builder()
                .url(uri)
                .put(buildResquestBody(requestCliForn))
                .build();

        try(Response response = client.newCall(request).execute()) {

            if (response.isSuccessful()) {
                Objects.requireNonNull(response.body(), "Responsebody nulo inesperado.");
                ClienteFornecedor responseCliForn = gson.fromJson(response.body().string(), ClienteFornecedor.class);
                logger.info("Atualizado com sucesso: " + responseCliForn);
                return responseCliForn;
            } else {
                throw FastAPIError.from(response, "Body: "+ getSafeResponseBody(response));
            }
        }
    }



}
