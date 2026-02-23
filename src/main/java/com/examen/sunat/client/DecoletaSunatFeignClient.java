package com.examen.sunat.client;

import com.examen.sunat.dto.SunatRucResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "sunatClient",
        url ="${decoleta.base-url}",
        configuration = com.examen.sunat.config.FeignErrorConfig.class

)
public interface DecoletaSunatFeignClient {

    @GetMapping("/v1/sunat/ruc")
    SunatRucResponse getRuc(
            @RequestParam("numero") String numero
    );
}