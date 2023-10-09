package com.alvesguilherme.fastapi.api;

import com.alvesguilherme.fastapi.client.FastAPIConfig;
import com.alvesguilherme.fastapi.exception.FastAPIError;
import com.alvesguilherme.fastapi.model.Lancamento;
import com.alvesguilherme.fastapi.utils.HttpMethod;
import com.alvesguilherme.fastapi.utils.URLUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

@SuppressWarnings("unused")
public class LancamentoAPI extends API {
    public static final String ENDPOINT_LANCAMENTO = "lancamento";
    private final OkHttpClient client;
    private final String uri;

    public LancamentoAPI(OkHttpClient client, FastAPIConfig fastAPiConfig) {
        this.client = client;
        this.uri = new URLUtils(fastAPiConfig.getUrl())
                .addPath(ENDPOINT_LANCAMENTO)
                .build();
    }

    public void cadastrar(Lancamento lancamento) throws IOException {
        enviar(lancamento, HttpMethod.POST);
        logger.info("Lançamento cadastrado com sucesso: " + lancamento.getId());
    }

    public void atualizar(Lancamento lancamento) throws IOException {
        enviar(lancamento, HttpMethod.PUT);
        logger.info("Lançamento cadastrado com sucesso: " + lancamento.getId());
    }

    private void enviar(Lancamento lancamento, HttpMethod method) throws IOException {
        Request request = new Request.Builder()
                .url(uri)
                .method(method.name(), buildResquestBody(lancamento))
                .build();

        try(Response response = client.newCall(request).execute()) {

            if (response.isSuccessful()) {
                Objects.requireNonNull(response.body(), "Responsebody nulo inesperado.");
                Lancamento resp = gson.fromJson(response.body().string(), Lancamento.class);
                lancamento.setId(resp.getId());
            } else {
                throw FastAPIError.from(response, "Body: "+ getSafeResponseBody(response));
            }
        }
    }
}
