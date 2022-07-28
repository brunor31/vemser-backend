package br.com.vemser.pessoaapi.security;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public String getToken(UsuarioEntity usuario){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiration = now.plusDays(1);
        Date dateNow = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        Date dateExpiration = Date.from(expiration.atZone(ZoneId.systemDefault()).toInstant());
        String token = Jwts.builder()
                .setIssuer("pessoaApi")
                .claim(Claims.ID, usuario.getIdUsuario())
                .setIssuedAt(dateNow)
                .setExpiration(dateExpiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return TokenAuthenticationFilter.BEARER + token;
    }

    public UsernamePasswordAuthenticationToken isValid(String token){
        if (token == null){
            return null;
        }
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        Integer idUsuario = body.get(Claims.ID, Integer.class);

        if(idUsuario != null){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            idUsuario,
                            null,
                            Collections.emptyList()
                    );
            return usernamePasswordAuthenticationToken;
        }
        return null;
    }
}
