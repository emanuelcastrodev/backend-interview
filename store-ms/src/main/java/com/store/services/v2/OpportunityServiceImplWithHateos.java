package com.store.services.v2;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.controllers.v1.opportunity.OpportunityController;
import com.store.dtos.v1.opportunity.CreateOpportunityRequestDTO;
import com.store.dtos.v2.opportunity.ResponseOpportunityDTOWithHateos;
import com.store.entities.Opportunity;
import com.store.mappers.v2.OpportunityMapperImpV2;
import com.store.services.v1.OpportunityServiceImpl;
import com.store.services.v2.interfaces.OpportunityServiceWithHateos;

@Service
public class OpportunityServiceImplWithHateos implements OpportunityServiceWithHateos {

	@Autowired
	OpportunityServiceImpl opportunityServiceV1;

	@Autowired
	OpportunityMapperImpV2 opportunityMapper;

	@Override
	public ResponseOpportunityDTOWithHateos create(CreateOpportunityRequestDTO dto) {
		Opportunity opportunity = opportunityServiceV1.createOpportunityAndReturnEntity(dto);
		ResponseOpportunityDTOWithHateos responseHateos = opportunityMapper.toDTOWithHateos(opportunity);
		responseHateos
				.add(linkTo(methodOn(OpportunityController.class).findByUuid(responseHateos.getUuid())).withSelfRel());
		return responseHateos;
	}

}
