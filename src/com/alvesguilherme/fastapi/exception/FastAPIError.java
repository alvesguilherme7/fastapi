package com.alvesguilherme.fastapi.exception;

import java.util.Objects;

public class FastAPIError extends RuntimeException {
    public FastAPIError(String s) {
        super(s);
    }

    public static FastAPIError from(Object... mensagens) {
        final StringBuilder retorno = new StringBuilder("\n");
        retorno.append("Comunica��o n�o estabelecida como esperado.").append("\n");
        retorno.append("Detalhes t�cnicos:").append("\n");
        for (Object m : mensagens) {
            retorno.append(m).append("\n");
        }
        return new FastAPIError(retorno.toString());
    }
}
