package com.oauth.entities;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_profile")
public class Profile implements Serializable {
	private static final long serialVersionUID = 3404984861493278590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid = UUID.randomUUID();

	private String name;

	private String email;

	private String phoneNumber;

	private UUID storeUUID;

	@OneToOne(mappedBy = "profile")
	private User user;

	public Profile() {

	}

	public Profile(Long id, String name, String email, String phoneNumber, UUID storeUUID, User user) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.storeUUID = storeUUID;
		this.user = user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public UUID getStoreUUID() {
		return storeUUID;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", uuid=" + uuid + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", storeUUID=" + storeUUID + ", user=" + user + "]";
	}

	public static class Builder {
		private Long id;
		private String name;
		private String email;
		private String phoneNumber;
		private UUID storeUUID;
		private User user;

		public Builder() {
		}

		public Builder(String name, String email, String phoneNumber) {
			this.name = name;
			this.email = email;
			this.phoneNumber = phoneNumber;
		}

		public static Builder of(String name, String email, String phoneNumber) {
			return new Builder(name, email, phoneNumber);
		}

		public static Builder of() {
			return new Builder();
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setStoreUUID(UUID storeUUID) {
			this.storeUUID = storeUUID;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public Builder setUser(User user) {
			this.user = user;
			return this;
		}

		public Profile build() {
			return new Profile(id, name, email, phoneNumber, storeUUID, user);
		}

	}

}
