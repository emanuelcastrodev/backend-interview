package com.store.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private UUID uuid;

	@Column(length = 255)
	private String brand;

	@Column(length = 255)
	private String version;

	private Integer modelYear;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Opportunity> opportunities = new ArrayList<>();

	public Car() {
	}

	public Car(Long id, String brand, String version, Integer modelYear, UUID uuid) {
		super();
		this.id = id;
		this.brand = brand;
		this.version = version;
		this.modelYear = modelYear;
		this.uuid = uuid;
	}

	public Long getId() {
		return id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getBrand() {
		return brand;
	}

	public String getVersion() {
		return version;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public List<Opportunity> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<Opportunity> opportunities) {
		this.opportunities = opportunities;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	public void addOpportunities(Opportunity... opportunities) {
		for (Opportunity opportunity : opportunities) {
			opportunity.setCar(this);
			this.opportunities.add(opportunity);
		}
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", uuid=" + uuid + ", brand=" + brand + ", version=" + version + ", modelYear="
				+ modelYear + "]";
	}

	public static class Builder {
		private Long id;

		private String brand;

		private String version;

		private Integer modelYear;

		private UUID uuid = UUID.randomUUID();

		public Builder(String brand) {
			this.brand = brand;
		}

		public static Builder of(String brand) {
			return new Builder(brand);
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setUUID(UUID uuid) {
			this.uuid = uuid;
			return this;
		}

		public Builder setVersion(String version) {
			this.version = version;
			return this;
		}

		public Builder setModelYear(Integer year) {
			this.modelYear = year;
			return this;
		}

		public Car build() {
			return new Car(id, brand, version, modelYear, uuid);
		}
	}
}
