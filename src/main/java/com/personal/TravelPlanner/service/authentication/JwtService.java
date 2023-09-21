package com.personal.TravelPlanner.service.authentication;

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

    @Value("${jwt.jwtTokenExpiry}")
    private long JWT_TOKEN_EXPIRY;

    @Value("${jwt.jwtRefreshTokenExpiry}")
    private long JWT_REFRESH_TOKEN_EXPIRY;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails,Map<String, Object> extraClaims){


        return buildToken(new HashMap<>(),userDetails,JWT_TOKEN_EXPIRY);

    }
    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails,new HashMap<>());
    }

    public String generateRefreshToken(UserDetails userDetails) {


        return buildToken(new HashMap<>(),userDetails,JWT_REFRESH_TOKEN_EXPIRY);

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
