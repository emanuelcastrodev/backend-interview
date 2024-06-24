package com.oauth.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails {
	private static final long serialVersionUID = -5998840214479871505L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid = UUID.randomUUID();

	private String username;

	private String password;

	@OneToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;

	private Set<? extends GrantedAuthority> roles;

	private boolean isAccountNonExpired = true;
	private boolean isAccountNonLocked = true;
	private boolean isCredentialsNonExpired = true;
	private boolean isEnabled = true;

	public User() {
	}

	public User(Long id, String username, String password, Profile profile, Set<? extends GrantedAuthority> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.profile = profile;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Profile getProfile() {
		return profile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uuid=" + uuid + ", username=" + username + ", profile=" + profile.getName()
				+ ", roles=" + roles + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabled;
	}

	public static class Builder {
		private Long id;
		private String username;
		private String password;
		private Profile profile;
		private Set<SimpleGrantedAuthority> roles = new HashSet<>();

		public Builder(String username) {
			this.username = username;
		}

		public static Builder of(String username) {
			return new Builder(username);
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder setProfileId(Long id) {
			this.profile.setId(id);
			return this;
		}

		public Builder setProfile(Profile profile) {
			this.profile = profile;
			return this;
		}

		public Builder addAuthority(SimpleGrantedAuthority authority) {
			roles.add(authority);
			return this;
		}

		public User build() {
			User user = new User(id, username, password, profile, roles);
			profile.setUser(user);
			return user;
		}
	}

}
