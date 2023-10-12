package com.alvesguilherme.fastapi.api;

import com.alvesguilherme.fastapi.client.FastAPIConfig;
import com.alvesguilherme.fastapi.exception.FastAPIError;
import com.alvesguilherme.fastapi.model.ClienteFornecedor;
import com.alvesguilherme.fastapi.utils.HttpMethod;
import com.alvesguilherme.fastapi.utils.URLUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class ClienteFornecedorAPI extends API {
    public static final String ENDPOINT_CLIENTE_FORNECEDOR = "clientefornecedor";
    private final OkHttpClient client;
    private final String uri;

    public ClienteFornecedorAPI(OkHttpClient client, FastAPIConfig fastAPiConfig) {
        this.client = client;
        this.uri = new URLUtils(fastAPiConfig.getUrl())
                .addPath(ENDPOINT_CLIENTE_FORNECEDOR)
                .build();
    }

    public void enviar(ClienteFornecedor clienteFornecedor) throws IOException {
        enviar(clienteFornecedor, HttpMethod.POST);
        logger.info("Cliente/Fornecedor cadastrado com sucesso: " + clienteFornecedor.getId());
    }

    public void atualizar(ClienteFornecedor clienteFornecedor) throws IOException {
        enviar(clienteFornecedor, HttpMethod.PUT);
        logger.info("Cliente/Fornecedor atualizado com sucesso: " + clienteFornecedor.getId());
    }

    private void enviar(ClienteFornecedor requestCliForn, HttpMethod method) throws IOException {
        Request request = new Request.Builder()
                .url(uri)
                .method(method.name(), buildResquestBody(requestCliForn))
                .build();

        try(Response response = client.newCall(request).execute()) {

            if (response.isSuccessful()) {
                Objects.requireNonNull(response.body(), "Responsebody nulo inesperado.");
                ClienteFornecedor resp = gson.fromJson(response.body().string(), ClienteFornecedor.class);
                requestCliForn.setId(resp.getId());
            } else {
                throw FastAPIError.from(response, "Body: "+ getSafeResponseBody(response));
            }
        }
    }



}
