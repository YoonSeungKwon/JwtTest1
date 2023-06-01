package yoon.test.jwtTest1.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {

    private final int exp = 1000*60*60*24;
    private final String SECRET_KEY = "NJC12J3OJB4H534BUC3H4XM9823MX9P3M";

    public String build(String id, String password, String name){

        Date now = new Date();

        String jwt = Jwts.builder()
                .setHeaderParam("type","jwt")
                .claim("user_id", id)
                .claim("user_pwd", password)
                .claim("user_name", name)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        return jwt;
    }

}
