package com.utm.jpacrud.Security;


import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@NoArgsConstructor
@Component
public class JWTUltil {
//    @Value("${jwt.secret}")
    private static final String secretKey = "Seceret Key";
//    @Value("${jwt.expiration}")
    private static final Long expiration = 8600000L;

    public String generateToken(String username, String role){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        //token will generate
    }
    //xác thực token
    public boolean validationToken(String token) {
        try{
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    //tách data ra khỏi 1 token

    public Claims getClaims(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
    //user
    public String getUsernameFromToken(String token){
        return getClaims(token).getSubject();
    }
    //role
    public String getRoleFromToken(String token){
       return getClaims(token).get("role",String.class);
    }
}
