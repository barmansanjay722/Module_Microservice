package com.example.User_Service.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtUtils {
    @Value("$(jwt.secret)")
    private String secret;
    @Value("$(jwt.expiration)")
    private String expiration;
    private Key key;
    @Autowired
    public JwtUtils(){
        this.key= Keys.hmacShaKeyFor(secret.getBytes());
    }
    public Claims getClaims(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token).getBody();

    }

    public Date getDateExpiration(String token){
        return  getClaims(token).getExpiration();
    }

   public String generate(String userId,String role,String tokenType){
       Map<String,String> claims=Map.of("id",userId,"role",role);
       long expiMillis="ACCESS".equalsIgnoreCase(tokenType) ? Long.parseLong(expiration)*1000
               : Long.parseLong(expiration)* 1000 * 5;
       final Date now =new Date();
       final Date exp = new Date(now.getTime()*expiMillis);

       return Jwts.builder().setClaims(claims).setSubject(claims.get("id")).setIssuedAt(now)
               .setExpiration(exp).signWith(key).compact();
   }

    private Boolean isExpired(String token){
        return getDateExpiration(token).before(new Date());
    }
}
