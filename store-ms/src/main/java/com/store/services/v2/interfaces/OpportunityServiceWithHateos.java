package com.store.services.v2.interfaces;

import com.store.dtos.v1.opportunity.CreateOpportunityRequestDTO;
import com.store.dtos.v2.opportunity.ResponseOpportunityDTOWithHateos;

public interface OpportunityServiceWithHateos {

	ResponseOpportunityDTOWithHateos create(CreateOpportunityRequestDTO dto);

}
