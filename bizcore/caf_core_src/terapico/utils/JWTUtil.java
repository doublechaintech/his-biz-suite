package com.terapico.utils;

import java.util.Date;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
	
	
	public static final String HEADER_NAME = "Authorization";

	public static DecodedJWT decodeToken(String token) {
		if (TextUtil.isBlank(token)) {
			return null;
		}
		try {
		    Algorithm algorithm = Algorithm.HMAC256(getSecret());
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer(getIssuer())
		        .acceptLeeway(1)   //1 sec for nbf and iat
		        .acceptExpiresAt(5)
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    return jwt;
		} catch (JWTVerificationException exception){
			exception.printStackTrace();
			return null;
		}
	}
	
	@Deprecated
	/**
	 * replaced with getJwtToken(String userId, String userUploadHome, String envType, Date now);
	 * @param userId
	 * @param userUploadHome
	 * @param envType
	 * @return
	 */
	public static String getJwtToken(String userId, String userUploadHome, String envType) {
		return getJwtToken(userId, userUploadHome, envType, new Date());
	}
	
	public static String getJwtToken(String userId, String userUploadHome, String envType, Date now) {
		try {
			
		    Algorithm algorithm = Algorithm.HMAC256(getSecret());
		    String token = JWT.create()
		        .withIssuer(getIssuer())
		        .withKeyId(userId)
		        .withIssuedAt(now)
		        .withExpiresAt(DateTimeUtil.addDays(now, 7, false))
		        .withClaim("userUploadHome", userUploadHome)
		        .withClaim("envType", envType)
		        .withArrayClaim("tags", new String[] {userId})
		        .sign(algorithm);
		    return token;
		} catch (JWTCreationException exception){
			exception.printStackTrace();
			return null;
		}
	}

	private static String getSecret() {
		return TextUtil.getExtVariable("JWT_SECRET", "com.skynet.caf");
	}

	private static String getIssuer() {
		return TextUtil.getExtVariable("JWT_ISSUER", "clariones");
	}

	public static String trimJwtToken(String jwtToken) {
		if (jwtToken.trim().startsWith("Bearer")) {
			jwtToken = jwtToken.trim().substring("Bearer".length()).trim();
		}
		return jwtToken.trim();
	}
}
