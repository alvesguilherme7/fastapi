package com.alvesguilherme.fastapi.auth;

import com.alvesguilherme.fastapi.api.ChamadaAPI;
import com.alvesguilherme.fastapi.client.FastAPIConfig;
import com.alvesguilherme.fastapi.model.Token;
import com.alvesguilherme.fastapi.utils.URLUtils;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class AuthAPI extends ChamadaAPI {
    private final OkHttpClient clientAuth;
    private final FastAPIConfig config;
    private Token token;
    public AuthAPI(FastAPIConfig config) {
        this.config = config;
        this.clientAuth = new OkHttpClient.Builder()
            .callTimeout(20L, TimeUnit.SECONDS)
            .build();

        if(Objects.isNull(config.getFuncGetToken())){
            pedirNovoToken();
        }else{
            this.token = new Token();
            this.token.setAccessToken(config.getFuncGetToken().get());
        }
    }

    public void pedirNovoToken(){
        logger.info("Iniciando busca por token...");

        RequestBody requestBody = new FormBody.Builder()
            .add("username", config.getUser())
            .add("password", config.getPass())
            .add("remember", "true")
            .build();

        String uri = new URLUtils(config.getUrl())
                .addPath("token")
                .build();

        Request request = new Request.Builder()
            .url(uri)
            .method("POST", requestBody)
            .build();

        try(Response response = clientAuth.newCall(request).execute()){
            if (response.isSuccessful() && Objects.nonNull(response.body())){

                this.token = gson.fromJson(response.body().string(), Token.class);

                salvarTokenArmazenamentoDuravel();

                logger.info("Token coletado com sucesso...");
            }else{
                logger.warning(response.toString());
            }
        } catch (IOException e) {
            logger.severe("Erro ao coletar o token."+ e.getMessage());
        }
    }

    private void salvarTokenArmazenamentoDuravel() {
        Consumer<Token> funcSalvarToken = config.getFuncSalvarToken();
        if (Objects.nonNull(funcSalvarToken)){
            funcSalvarToken.accept(token);
        }
    }

    public Token getToken(){
        if(Objects.nonNull(this.token)){
            return token;
        }
        throw new IllegalStateException("Token não obtido.");
    }
}
