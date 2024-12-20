package com.idris.bank.constants;

import java.util.UUID;

public class ApiKeyGenerator {
    public static  String generateApiKey(){
        return "WAYA-" + UUID.randomUUID().toString();
    }
}
