package com.store.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.store.utils.Masks;
import com.store.utils.validations.interfaces.CNPJ;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private UUID uuid;

	@CNPJ
	@Column(unique = true)
	private String cnpj;

	@Column(unique = true)
	private String socialName;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Opportunity> opportunities = new ArrayList<>();

	public Store() {

	}

	public Store(Long id, String cnpj, String socialName, UUID uuid) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.socialName = socialName;
		this.uuid = uuid;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getSocialName() {
		return socialName;
	}

	public List<Opportunity> getOpportunities() {
		return opportunities;
	}

	public void addOpportunities(Opportunity... opportunities) {
		for (Opportunity opportunity : opportunities) {
			opportunity.setStore(this);
			this.opportunities.add(opportunity);
		}
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", uuid=" + uuid + ", cnpj=" + cnpj + ", socialName=" + socialName + "]";
	}

	public static class Builder {
		private Long id;

		private String cnpj;

		private String socialName;

		private UUID uuid = UUID.randomUUID();

		public Builder() {
		}

		public Builder(String cnpj, String socialName) {
			this.cnpj = Masks.formatCNJP(cnpj);
			this.socialName = socialName;
		}

		public static Builder of(String cnpj, String socialName) {
			return new Builder(cnpj, socialName);
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setUUID(UUID uuid) {
			this.uuid = uuid;
			return this;
		}

		public Store build() {
			return new Store(id, cnpj, socialName, uuid);
		}

	}

}
