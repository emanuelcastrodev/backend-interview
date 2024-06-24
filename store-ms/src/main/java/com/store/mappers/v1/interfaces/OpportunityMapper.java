package com.store.mappers.v1.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import com.store.dtos.v1.opportunity.CreateOpportunityRequestDTO;
import com.store.dtos.v1.opportunity.ResponseOpportunityDTO;
import com.store.entities.Opportunity;

public interface OpportunityMapper {

	ResponseOpportunityDTO toDTO(Opportunity opportunity);

	Opportunity toEntity(CreateOpportunityRequestDTO dto);

	List<ResponseOpportunityDTO> toDTO(List<Opportunity> opportunities);

	Page<ResponseOpportunityDTO> toDTO(Page<Opportunity> opportunitiesPageable);
}
