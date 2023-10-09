package com.alvesguilherme.fastapi.api;

import com.alvesguilherme.fastapi.client.FastAPIClient;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public class ChamadaAPI {
    protected final Logger logger = Logger.getLogger(FastAPIClient.class.getName());
    protected final MediaType jsonMediaType = MediaType.parse("application/json");
    protected final Gson gson = new Gson();

    public RequestBody buildResquestBody(Object body){
        String json = gson.toJson(body);
        return RequestBody.create(jsonMediaType, json);
    }

    public String getSafeResponseBody(Response response) throws IOException {
        if(Objects.nonNull(response.body())){
            return response.body().string();
        }
        return "Sem response body.";
    }
}
