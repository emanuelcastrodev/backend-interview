package com.store.utils;

import java.util.UUID;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

	public UUID getProfileUUIDFromJWT(Jwt jwt) {
		return UUID.fromString((String) jwt.getClaims().get("profile_uuid"));
	}
}
