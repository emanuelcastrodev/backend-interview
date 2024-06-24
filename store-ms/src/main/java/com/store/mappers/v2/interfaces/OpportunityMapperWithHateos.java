package com.store.mappers.v2.interfaces;

import com.store.dtos.v2.opportunity.ResponseOpportunityDTOWithHateos;
import com.store.entities.Opportunity;

public interface OpportunityMapperWithHateos {

	ResponseOpportunityDTOWithHateos toDTOWithHateos(Opportunity opportunity);
}
