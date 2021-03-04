package br.com.pietrobondioli.processstorageapi;

import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

public class Constants {

    public static final Key API_SECRET_KEY = secretKeyFor(SignatureAlgorithm.HS512);

    // In milliseconds
    public static final long TOKEN_VALIDITY = 3 * 60 * 60 * 1000;

}
