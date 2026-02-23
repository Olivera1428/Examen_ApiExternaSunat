package com.examen.sunat.client;

import com.examen.sunat.dto.ProviderErrorResponse;
import com.examen.sunat.exception.ProviderException;
import feign.Response;
import feign.codec.ErrorDecoder;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class FeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {

        String message = "Error consultando proveedor";

        try {
            if (response.body() != null) {
                InputStream is = response.body().asInputStream();
                ProviderErrorResponse error =
                        mapper.readValue(is, ProviderErrorResponse.class);
                message = error.message();
            }
        } catch (Exception ignored) {
        }

        if (response.status() == 401) {
            message = "Token inválido o expirado";
        }

        if (response.status() >= 500) {
            message = "Proveedor no disponible";
        }

        return new ProviderException(message, response.status());
    }
}