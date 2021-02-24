package com.limyel.utils;


import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

import java.util.HashMap;
import java.util.Map;

public class SecurityUtil {
    private static RsaJsonWebKey JWK = null;
    private static JwtConsumer JWTCSM = null;
    private static final String ALGORITHM = "RS256";

    public static String createJWT(String username) {
        if (JWK == null) {
            try {
                JWK = RsaJwkGenerator.generateJwk(2048);
            } catch (JoseException e) {
                e.printStackTrace();
                return "";
            }
        }
        JwtClaims claims = new JwtClaims();         // payload
        claims.setExpirationTimeMinutesInTheFuture(60 * 8);
        claims.setClaim("username", username);

        JsonWebSignature jws = new JsonWebSignature();
        jws.setKey(JWK.getPrivateKey());
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue("RS256");
        try {
            String jwt = jws.getCompactSerialization();
            return jwt;
        } catch (JoseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Map<String, String> parseJWT(String jwt) {
        if (JWTCSM == null) {
            JWTCSM = new JwtConsumerBuilder()
                    .setRequireExpirationTime()
                    .setAllowedClockSkewInSeconds(30)
                    .setVerificationKey(JWK.getKey())
                    .setJwsAlgorithmConstraints(AlgorithmConstraints.ConstraintType.PERMIT, ALGORITHM)
                    .build();
        }
        Map<String, String> result = new HashMap<>();

        try {
            JwtClaims jwtClaims = JWTCSM.processToClaims(jwt);
            result.put("username", jwtClaims.getStringClaimValue("username"));
            return result;
        } catch (InvalidJwtException e) {
            e.printStackTrace();
            if (e.hasExpired()) {
                System.out.println("超时");
            }
        } catch (MalformedClaimException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String jwt = createJWT("limyel");
        System.out.println(jwt);
        Map<String, String> result = parseJWT(jwt);
        System.out.println(result.get("username"));
    }
}
