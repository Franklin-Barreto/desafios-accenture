package br.com.thundercoders.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.thundercoders.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${bankline.jwt.expiracao}")
	private String expiracao;

	@Value("${bankline.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication auth) {

		Date dataCriacao = new Date();
		Date dataExpiracao = new Date(dataCriacao.getTime() + Long.parseLong(expiracao));
		Usuario logado = (Usuario) auth.getPrincipal();

		return Jwts.builder().setIssuer("bank line").setSubject(logado.getId().toString()).setIssuedAt(dataCriacao)
				.setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret)
				.claim("conta", logado.getConta().getId()).compact();
	}

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Integer getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		Integer idUsuario = Integer.parseInt(claims.getSubject());
		return idUsuario;
	}
}
