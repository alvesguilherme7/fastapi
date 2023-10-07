package com.alvesguilherme.fastapi.model;

import java.util.Objects;

public class ResponseGeral {
    private boolean sucesso;
    private ClienteFornecedor clienteFornecedor;
    private HTTPValidationError error;
    private ValidationError validationError;

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public void setRetornoErro(Object retorno){
        if (retorno instanceof ClienteFornecedor){
            this.clienteFornecedor = (ClienteFornecedor) retorno;
            return;
        }
        if (retorno instanceof HTTPValidationError){
            this.error = (HTTPValidationError) retorno;
        }
    }
    public ClienteFornecedor getClienteFornecedor() {
        return clienteFornecedor;
    }

    public void setClienteFornecedor(ClienteFornecedor clienteFornecedor) {
        this.clienteFornecedor = clienteFornecedor;
    }

    @Override
    public String toString() {
        return "ResponseGeral{" +
                "sucesso=" + sucesso +
                ", clienteFornecedor=" + clienteFornecedor +
                ", error=" + error +
                ", validationError=" + validationError +
                '}';
    }
}
