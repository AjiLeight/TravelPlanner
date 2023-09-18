package com.personal.TravelPlanner.service;

import com.personal.TravelPlanner.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails,Map<String, Object> extraClaims){

        long jwtExpiration= 30000;
        return buildToken(new HashMap<>(),userDetails,jwtExpiration);

    }
    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails,new HashMap<>());
    }

    public String generateRefreshToken(UserDetails userDetails) {

        long refreshExpiration =604800000;
        return buildToken(new HashMap<>(),userDetails,refreshExpiration);

    }

    public String buildToken(Map<String, Object> extraClaims, UserDetails userDetails,long expiration) {

        return Jwts
                .builder()
                .setClaims (extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration (new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignkey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimResolver){
        final Claims claims= extractClaims(token);
        return claimResolver.apply(claims);
    }
    public Claims extractClaims(String token){
        return Jwts.
                parserBuilder().
                setSigningKey(getSignkey()).
                build().
                parseClaimsJws(token).
                getBody();
    }

    private Key getSignkey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
