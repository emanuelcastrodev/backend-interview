package com.oauth;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oauth.entities.Profile;
import com.oauth.entities.User;
import com.oauth.repositories.ProfileRepository;
import com.oauth.repositories.UserRepository;

@SpringBootApplication
public class OauthMsApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRep;

	@Autowired
	ProfileRepository profileRep;

	@Autowired
	PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(OauthMsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Profile profile = profileRep
				.save(Profile.Builder.of("Emanuel Silva de Moraes Castro", "emanuelsmcastro3@gmail.com", "21976125835")
						.setStoreUUID(UUID.randomUUID()).build());
		Profile profileAssistant = profileRep.save(Profile.Builder
				.of("Emanuel Silva de Moraes Castro | Assistant", "emanuelsmcastro3@gmail.com", "21976125835")
				.setStoreUUID(UUID.randomUUID()).build());
		Profile profileAdmin = profileRep.save(Profile.Builder
				.of("Emanuel Silva de Moraes Castro | Admin", "emanuelsmcastro3@gmail.com", "21976125835")
				.setStoreUUID(UUID.randomUUID()).build());
		Profile profileOwner = profileRep.save(Profile.Builder
				.of("Emanuel Silva de Moraes Castro | Store Owner", "emanuelsmcastro3@gmail.com", "21976125835")
				.setStoreUUID(UUID.randomUUID()).build());

		User user = User.Builder.of("emanuel").setPassword(encoder.encode("123")).setProfile(profile)
				.addAuthority(new SimpleGrantedAuthority("USER")).build();
		User userAssistant = User.Builder.of("emanuel_assistant").setPassword(encoder.encode("123"))
				.setProfile(profileAssistant).addAuthority(new SimpleGrantedAuthority("ASSISTANT")).build();
		User userAdmin = User.Builder.of("emanuel_admin").setPassword(encoder.encode("123")).setProfile(profileAdmin)
				.addAuthority(new SimpleGrantedAuthority("ADMIN")).build();
		User userOwner = User.Builder.of("emanuel_owner").setPassword(encoder.encode("123")).setProfile(profileOwner)
				.addAuthority(new SimpleGrantedAuthority("OWNER")).build();

		userRep.saveAll(Arrays.asList(user, userAssistant, userAdmin, userOwner));
	}

}
