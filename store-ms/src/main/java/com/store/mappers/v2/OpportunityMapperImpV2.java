package com.store.mappers.v2;

import org.springframework.stereotype.Component;

import com.store.dtos.v2.opportunity.ResponseOpportunityDTOWithHateos;
import com.store.entities.Opportunity;
import com.store.mappers.v2.interfaces.OpportunityMapperWithHateos;

@Component
public class OpportunityMapperImpV2 implements OpportunityMapperWithHateos {

	@Override
	public ResponseOpportunityDTOWithHateos toDTOWithHateos(Opportunity opportunity) {
		return new ResponseOpportunityDTOWithHateos(opportunity.getUuid(), opportunity.getClientUUID(),
				opportunity.getDescription(), opportunity.getStartDate(), opportunity.getClosingDate(),
				opportunity.getCar().getUuid(), opportunity.getStore().getUuid(), opportunity.getAssitantUUID(),
				opportunity.getStatus());
	}

}
