package com.alvesguilherme.fastapi.api;

import com.alvesguilherme.fastapi.client.FastAPIClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public class API {
    protected final Logger logger = Logger.getLogger(FastAPIClient.class.getName());
    protected final MediaType jsonMediaType = MediaType.parse("application/json");

    protected final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd")
            .serializeNulls()
            .create();

    public RequestBody buildResquestBody(Object body){
        String json = gson.toJson(body);
        String jsonSemIdNulo = retirarIdNulo(json);
        return RequestBody.create(jsonMediaType, jsonSemIdNulo);
    }

    /**
     * Recurso: A API obriga o campo data_conciliado seja passado mesmo se nulo
     * Em contrapartida, não aceita o id nulo.
     * Como o GSON eh 8 ou 80 - ou sempre passa nulo ou nunca passa "serializeNulls", foi necessário este recurso.
     */
    private static String retirarIdNulo(String json) {
        return json.replace("\"id\":null,", "");
    }

    public String getSafeResponseBody(Response response) throws IOException {
        if(Objects.nonNull(response.body())){
            return response.body().string();
        }
        return "Sem response body.";
    }
}
