package com.alvesguilherme.fastapi.interceptor;

import com.alvesguilherme.fastapi.auth.AuthAPI;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

import java.io.IOException;
import java.util.Objects;

public class AuthInterceptor implements Interceptor {
    private final AuthAPI authAPI;
    public AuthInterceptor(AuthAPI authAPI) {
        this.authAPI = authAPI;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        Request.Builder requestBuilder = originalRequest.newBuilder()
                .header("Authorization", "Bearer " + authAPI.getToken().getAccessToken());

        Request newRequest = requestBuilder.build();

        Response response = chain.proceed(newRequest);

        if (response.code() == 401) {
            authAPI.pedirNovoToken();
            Request newAuthenticatedRequest = newRequest.newBuilder()
                    .header("Authorization", "Bearer " + authAPI.getToken().getAccessToken())
                    .build();
            return chain.proceed(newAuthenticatedRequest);
        }

        return response;
    }
}
