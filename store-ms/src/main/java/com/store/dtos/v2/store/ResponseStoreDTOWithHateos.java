package com.store.dtos.v2.store;

import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.store.dtos.v1.opportunity.ResponseOpportunityDTO;

public class ResponseStoreDTOWithHateos extends RepresentationModel<ResponseStoreDTOWithHateos> {
	private UUID uuid;
	private String cnpj;
	@JsonProperty("social_name")
	private String socialName;
	private List<ResponseOpportunityDTO> opportunities;

	public ResponseStoreDTOWithHateos() {
		super();
	}

	public ResponseStoreDTOWithHateos(UUID uuid, String cnpj, String socialName,
			List<ResponseOpportunityDTO> opportunities) {
		super();
		this.uuid = uuid;
		this.cnpj = cnpj;
		this.socialName = socialName;
		this.opportunities = opportunities;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSocialName() {
		return socialName;
	}

	public void setSocialName(String socialName) {
		this.socialName = socialName;
	}

	public List<ResponseOpportunityDTO> getOpportunities() {
		return opportunities;
	}

	public void setOpportunities(List<ResponseOpportunityDTO> opportunities) {
		this.opportunities = opportunities;
	}

	@Override
	public String toString() {
		return "ResponseStoreDTOWithHateos [uuid=" + uuid + ", cnpj=" + cnpj + ", socialName=" + socialName
				+ ", opportunities=" + opportunities + "]";
	}

}
