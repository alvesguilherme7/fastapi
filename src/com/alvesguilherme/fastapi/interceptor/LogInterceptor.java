package com.alvesguilherme.fastapi.interceptor;

import com.alvesguilherme.fastapi.client.FastAPIClient;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public class LogInterceptor implements Interceptor {
    private final Logger logger = Logger.getLogger(FastAPIClient.class.getName());

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        final Request requestCopy = request.newBuilder().build();
        logger.info(String.format("Request: %s", bodyToString(requestCopy)));

        final Response response = chain.proceed(request);
        logger.info(bodyToString(response));

        return response;
    }

    private static String bodyToString(final Request request){
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            if (Objects.nonNull(copy.body())) {
                copy.body().writeTo(buffer);
                return buffer.readUtf8();
            }
        } catch (final IOException ignored) {}
        return "não foi possivel obter request";
    }

    private static String bodyToString(final Response response){
        try{
            return response.peekBody(Long.MAX_VALUE).string();
        }catch (final IOException e){
            return "não foi possivel obter response";
        }
    }
}
