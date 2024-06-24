package com.store.entities;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import com.store.enums.OpportunityStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_opportunity")
public class Opportunity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private UUID uuid = UUID.randomUUID();

	private OpportunityStatus status;

	private UUID clientUUID;

	private UUID assitantUUID;

	@Column(length = 255)
	private String description;

	private Instant startDate = Instant.now();

	private Instant closingDate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Store store;

	@ManyToOne(fetch = FetchType.EAGER)
	private Car car;

	public Opportunity() {
		super();
	}

	public Opportunity(Long id, UUID uuid, OpportunityStatus status, UUID clientUUID, String description,
			Instant startDate, Instant closingDate, Store store, Car car) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.status = status;
		this.clientUUID = clientUUID;
		this.description = description;
		this.startDate = startDate;
		this.closingDate = closingDate;
		this.store = store;
		this.car = car;
	}

	public OpportunityStatus getStatus() {
		return status;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getDescription() {
		return description;
	}

	public UUID getClientUUID() {
		return clientUUID;
	}

	public UUID getAssitantUUID() {
		return assitantUUID;
	}

	public Instant getStartDate() {
		return startDate;
	}

	public Instant getClosingDate() {
		return closingDate;
	}

	public Store getStore() {
		return store;
	}

	public Car getCar() {
		return car;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setClosingDate(Instant closingDate) {
		this.closingDate = closingDate;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setStatus(OpportunityStatus status) {
		this.status = status;
	}

	public void setAssitantUUID(UUID assitantUUID) {
		this.assitantUUID = assitantUUID;
	}

	@Override
	public String toString() {
		return "Opportunity [id=" + id + ", uuid=" + uuid + ", status=" + status + ", clientUUID=" + clientUUID
				+ ", description=" + description + ", startDate=" + startDate + ", closingDate=" + closingDate
				+ ", store=" + store + ", car=" + car + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opportunity other = (Opportunity) obj;
		return Objects.equals(id, other.id) && Objects.equals(uuid, other.uuid);
	}

	public static class Builder {
		private Long id;

		private UUID uuid = UUID.randomUUID();

		private OpportunityStatus status = OpportunityStatus.NEW;

		private UUID clientUUID;

		private String description;

		private Instant startDate = Instant.now();

		private Instant closingDate;

		private Store store;

		private Car car;

		public Builder() {
			super();
		}

		public Builder(UUID clientUUID) {
			this.clientUUID = clientUUID;
		}

		public static Builder of(UUID clientUUID) {
			return new Builder(clientUUID);
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setStore(Store store) {
			this.store = store;
			return this;
		}

		public Builder setCar(Car car) {
			this.car = car;
			return this;
		}

		public Opportunity build() {
			return new Opportunity(id, uuid, status, clientUUID, description, startDate, closingDate, store, car);
		}

	}

}
