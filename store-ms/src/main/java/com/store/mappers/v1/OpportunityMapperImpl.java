package com.store.mappers.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.store.dtos.v1.opportunity.CreateOpportunityRequestDTO;
import com.store.dtos.v1.opportunity.ResponseOpportunityDTO;
import com.store.entities.Car;
import com.store.entities.Opportunity;
import com.store.entities.Store;
import com.store.mappers.v1.interfaces.OpportunityMapper;

@Component
public class OpportunityMapperImpl implements OpportunityMapper {

	@Override
	public ResponseOpportunityDTO toDTO(Opportunity opportunity) {
		ResponseOpportunityDTO responseOpportunityDTO = new ResponseOpportunityDTO(opportunity.getUuid(),
				opportunity.getClientUUID(), opportunity.getDescription(), opportunity.getStartDate(),
				opportunity.getClosingDate(), opportunity.getCar().getUuid(), opportunity.getStore().getUuid(),
				opportunity.getAssitantUUID(), opportunity.getStatus());
		return responseOpportunityDTO;
	}

	@Override
	public Opportunity toEntity(CreateOpportunityRequestDTO dto) {
		return Opportunity.Builder.of(dto.clientUUID())
				.setStore(Store.Builder.of(null, null).setUUID(dto.storeUUID()).build())
				.setCar(Car.Builder.of(null).setUUID(dto.carUUID()).build()).build();
	}

	@Override
	public List<ResponseOpportunityDTO> toDTO(List<Opportunity> opportunities) {
		return opportunities.stream().map(opportunity -> toDTO(opportunity)).collect(Collectors.toList());
	}

	@Override
	public Page<ResponseOpportunityDTO> toDTO(Page<Opportunity> opportunitiesPageable) {
		return opportunitiesPageable.map(opportunity -> toDTO(opportunity));
	}

}
