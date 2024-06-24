package com.store.dtos.v2.opportunity;

import java.time.Instant;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store.enums.OpportunityStatus;

public class ResponseOpportunityDTOWithHateos extends RepresentationModel<ResponseOpportunityDTOWithHateos> {

	private UUID uuid;
	@JsonProperty("client_uuid")
	private UUID clientUUID;
	private String description;
	@JsonProperty("start_date")
	private Instant startDate;
	@JsonProperty("closing_date")
	private Instant closingDate;
	@JsonProperty("car_uuid")
	private UUID carUUID;
	@JsonProperty("store_uuid")
	private UUID storeUUID;
	@JsonProperty("assistant_uuid")
	private UUID assistantUUID;
	private OpportunityStatus status;

	public ResponseOpportunityDTOWithHateos() {
		super();
	}

	public ResponseOpportunityDTOWithHateos(UUID uuid, UUID clientUUID, String description, Instant startDate,
			Instant closingDate, UUID carUUID, UUID storeUUID, UUID assistantUUID, OpportunityStatus status) {
		super();
		this.uuid = uuid;
		this.clientUUID = clientUUID;
		this.description = description;
		this.startDate = startDate;
		this.closingDate = closingDate;
		this.carUUID = carUUID;
		this.storeUUID = storeUUID;
		this.assistantUUID = assistantUUID;
		this.status = status;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public UUID getClientUUID() {
		return clientUUID;
	}

	public void setClientUUID(UUID clientUUID) {
		this.clientUUID = clientUUID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public Instant getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Instant closingDate) {
		this.closingDate = closingDate;
	}

	public UUID getCarUUID() {
		return carUUID;
	}

	public void setCarUUID(UUID carUUID) {
		this.carUUID = carUUID;
	}

	public UUID getStoreUUID() {
		return storeUUID;
	}

	public void setStoreUUID(UUID storeUUID) {
		this.storeUUID = storeUUID;
	}

	public UUID getAssistantUUID() {
		return assistantUUID;
	}

	public void setAssistantUUID(UUID assistantUUID) {
		this.assistantUUID = assistantUUID;
	}

	public OpportunityStatus getStatus() {
		return status;
	}

	public void setStatus(OpportunityStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseOpportunityDTOWithHateos [uuid=" + uuid + ", clientUUID=" + clientUUID + ", description="
				+ description + ", startDate=" + startDate + ", closingDate=" + closingDate + ", carUUID=" + carUUID
				+ ", storeUUID=" + storeUUID + ", assistantUUID=" + assistantUUID + ", status=" + status + "]";
	}

}
