package com.akshatr.travelportal.utility.jwt;

import com.akshatr.travelportal.model.dto.user.UserLoginDetails;
import com.akshatr.travelportal.model.entity.LoginDetails;
import com.akshatr.travelportal.model.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.sql.Timestamp;
import java.util.Date;

@Component
public class TokenUtility {
    private final SecretKey secretKey;
    private final Long expiration;

    public TokenUtility(@Value("${jwt.secret.key}") String secretKey, @Value("${jwt.token.expiration}") Long expiration){
        this.secretKey =  Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        this.expiration = expiration;
    }

    public UserLoginDetails generateToken(User user){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        Date expiryTime = new Date(currentTime.getTime() + expiration);
        return new UserLoginDetails(Jwts.builder()
                .claim("id", user.getUuid().toString())
                .issuedAt(new Date())
                .expiration(expiryTime)
                .signWith(secretKey)
                .compact(),
                currentTime,
                new Timestamp(expiryTime.getTime()));
    }
}
