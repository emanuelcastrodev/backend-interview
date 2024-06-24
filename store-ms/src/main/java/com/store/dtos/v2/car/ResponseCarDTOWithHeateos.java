package com.store.dtos.v2.car;

import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store.dtos.v1.opportunity.ResponseOpportunityDTO;

public class ResponseCarDTOWithHeateos extends RepresentationModel<ResponseCarDTOWithHeateos> {
	private UUID uuid;
	private String brand;
	private String version;
	@JsonProperty("model_year")
	private Integer modelyear;
	private List<ResponseOpportunityDTO> opportunities;

	public ResponseCarDTOWithHeateos() {
		super();
	}

	public ResponseCarDTOWithHeateos(UUID uuid, String brand, String version, Integer modelyear,
			List<ResponseOpportunityDTO> opportunities) {
		super();
		this.uuid = uuid;
		this.brand = brand;
		this.version = version;
		this.modelyear = modelyear;
		this.opportunities = opportunities;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Integer getModelyear() {
		return modelyear;
	}

	public void setModelyear(Integer modelyear) {
		this.modelyear = modelyear;
	}

	public List<ResponseOpportunityDTO> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<ResponseOpportunityDTO> opportunities) {
		this.opportunities = opportunities;
	}

	@Override
	public String toString() {
		return "ResponseCarDTOWithHeateos [uuid=" + uuid + ", brand=" + brand + ", version=" + version + ", modelyear="
				+ modelyear + ", opportunities=" + opportunities + "]";
	}

}
