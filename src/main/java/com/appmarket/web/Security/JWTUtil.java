package com.appmarket.web.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static final  String KEY = "contra";

    public String generateToken(UserDetails userDetails){

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() +1000 *60 *60 * 10 ))
                .signWith(SignatureAlgorithm.HS256,KEY).compact();


    }

    public boolean validedToken(String token, UserDetails userDetails){

        return userDetails.getUsername().equals(extractUserName(token)) && !isTokenExpired(token);

    }

    public String extractUserName (String token ){

        return getClaims(token).getSubject();

    }

    public boolean isTokenExpired(String token ){

        return getClaims(token).getExpiration().before(new Date());

    }





    private Claims getClaims (String  token){

        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();

    }

}
