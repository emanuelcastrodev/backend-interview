package com.store.services.v1.interfaces;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.store.dtos.v1.opportunity.CreateOpportunityRequestDTO;
import com.store.dtos.v1.opportunity.ResponseOpportunityDTO;
import com.store.dtos.v1.opportunity.UpdateOpportunityDescriptionDTO;
import com.store.entities.Opportunity;

public interface OpportunityService {

	ResponseOpportunityDTO findByUUID(UUID uuid);

	void createOpportunity(CreateOpportunityRequestDTO dto);

	Opportunity createOpportunityAndReturnEntity(CreateOpportunityRequestDTO dto);

	void updateAssistante(UUID opportunityUUID, UUID assistantUUID);

	void closeOpportunity(UUID opportunityUUID, UUID assistantUUID, UpdateOpportunityDescriptionDTO dto);

	Page<ResponseOpportunityDTO> findAll(Pageable pageable);
}
