package com.alvesguilherme.fastapi.client;

import com.alvesguilherme.fastapi.api.PostClienteFornecedor;
import com.alvesguilherme.fastapi.auth.AuthAPI;
import com.alvesguilherme.fastapi.interceptor.AuthInterceptor;
import com.alvesguilherme.fastapi.interceptor.LogInterceptor;
import com.alvesguilherme.fastapi.model.ClienteFornecedor;
import com.alvesguilherme.fastapi.model.Token;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FastAPIClient {
    private static final Gson gson = new Gson();
    private final OkHttpClient client;
    private final FastAPIConfig fastAPiConfig;

    protected FastAPIClient(FastAPIConfig fastAPiConfig) {
        final AuthAPI authAPI = new AuthAPI(fastAPiConfig);

        this.client = new OkHttpClient.Builder()
                .callTimeout(30L, TimeUnit.SECONDS)
                .addInterceptor(new AuthInterceptor(authAPI))
                .addInterceptor(new LogInterceptor())
                .build();

        this.fastAPiConfig = fastAPiConfig;
    }

    public static Gson getInstanceGson(){
        return gson;
    }

    public void cadastrarClienteForncedor(ClienteFornecedor clienteFornecedor) throws IOException {
        PostClienteFornecedor postClienteFornecedor = new PostClienteFornecedor(client, fastAPiConfig);
        postClienteFornecedor.enviar(clienteFornecedor);
    }

    public static class Builder {
        private String url;
        private String user;
        private String pass;
        private Supplier<String> funcGetToken;
        private Consumer<Token> funcSalvarToken;

        public Builder setUrl(String url){
            this.url = url;
            return this;
        }

        public Builder setCredenciais(String user, String pass){
            this.user = user;
            this.pass = pass;
            return this;
        }

        @SuppressWarnings("unused")
        /*
         * Função capaz de retornar um token em armazenamento durável.
         * Use em conjunto com [setFunctionGetTokenArmazenado]
         */
        public Builder setFunctionGetTokenArmazenado(Supplier<String> function){
            this.funcGetToken = function;
            return this;
        }


        /*
         * Função capaz de armazenar o token para em armazenamento durável.
         * Use em conjunto com [setFunctionGetTokenArmazenado]
         */
        @SuppressWarnings("unused")
        public Builder setFunctionSalvarTokenArmazenado(Consumer<Token> consumer){
            this.funcSalvarToken = consumer;
            return this;
        }

        public FastAPIClient build(){
            final FastAPIConfig config = new FastAPIConfig(this.url, this.user, this.pass);
            config.setFuncGetToken(funcGetToken);
            config.setFuncSalvarToken(funcSalvarToken);
            return new FastAPIClient(config);
        }


    }
}
