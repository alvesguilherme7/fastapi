package com.alvesguilherme.fastapi.client;

import com.alvesguilherme.fastapi.model.Token;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FastAPIConfig {
    private final String url;
    private final String user;
    private final String pass;
    private Supplier<String> funcGetToken;
    private Consumer<Token> funcSalvarToken;

    public FastAPIConfig(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public Supplier<String> getFuncGetToken() {
        return funcGetToken;
    }

    public void setFuncGetToken(Supplier<String> funcGetToken) {
        this.funcGetToken = funcGetToken;
    }

    public Consumer<Token> getFuncSalvarToken() {
        return funcSalvarToken;
    }

    public void setFuncSalvarToken(Consumer<Token> funcSalvarToken) {
        this.funcSalvarToken = funcSalvarToken;
    }
}
