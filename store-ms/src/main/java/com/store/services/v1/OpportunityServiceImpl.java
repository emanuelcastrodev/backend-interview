package com.store.services.v1;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store.dtos.v1.opportunity.CreateOpportunityRequestDTO;
import com.store.dtos.v1.opportunity.ResponseOpportunityDTO;
import com.store.dtos.v1.opportunity.UpdateOpportunityDescriptionDTO;
import com.store.entities.Car;
import com.store.entities.Opportunity;
import com.store.entities.Store;
import com.store.enums.OpportunityStatus;
import com.store.infra.exceptions.opportunity.OpportunityNotFoundException;
import com.store.infra.exceptions.opportunity.OpportunityUpdateException;
import com.store.mappers.v1.OpportunityMapperImpl;
import com.store.repositories.OpportunityRepository;
import com.store.services.v1.interfaces.OpportunityService;

@Service
public class OpportunityServiceImpl implements OpportunityService {

	@Autowired
	OpportunityRepository rep;

	@Autowired
	StoreServiceImpl storeService;

	@Autowired
	CarServiceImpl carService;

	@Autowired
	OpportunityMapperImpl opportunityMapper;

	@Override
	public ResponseOpportunityDTO findByUUID(UUID uuid) {
		return opportunityMapper.toDTO(findOpportunityByUUID(uuid));
	}

	@Override
	public void createOpportunity(CreateOpportunityRequestDTO dto) {
		createOpportunityAndReturn(dto);
	}

	@Override
	public void updateAssistante(UUID opportunityUUID, UUID assistantUUID) {
		Opportunity opportunity = findOpportunityByUUID(opportunityUUID);
		opportunity.setAssitantUUID(assistantUUID);
		opportunity.setStatus(OpportunityStatus.IN_SERVICE);
		rep.save(opportunity);
	}

	@Override
	public void closeOpportunity(UUID opportunityUUID, UUID assistantUUID, UpdateOpportunityDescriptionDTO dto) {
		Opportunity opportunity = findOpportunityByUUID(opportunityUUID);
		if (!opportunity.getAssitantUUID().equals(assistantUUID))
			throw new OpportunityUpdateException(
					String.format("You cant close this Opportunity (%s)", opportunity.getUuid()));
		opportunity.setAssitantUUID(assistantUUID);
		opportunity.setStatus(OpportunityStatus.CLOSED);
		opportunity.setDescription(dto.description());
		rep.save(opportunity);
	}

	@Override
	public Opportunity createOpportunityAndReturnEntity(CreateOpportunityRequestDTO dto) {
		return createOpportunityAndReturn(dto);
	}

	@Override
	public Page<ResponseOpportunityDTO> findAll(Pageable pageable) {
		return opportunityMapper.toDTO(rep.findAll(pageable));
	}

	private Opportunity findOpportunityByUUID(UUID uuid) {
		return rep.findByUuid(uuid).orElseThrow(
				() -> new OpportunityNotFoundException(String.format("Opportunity with UUID(%s) not found.", uuid)));
	}

	private Opportunity createOpportunityAndReturn(CreateOpportunityRequestDTO dto) {
		Opportunity opportunity = opportunityMapper.toEntity(dto);
		Store store = storeService.getStoreByUUID(opportunity.getStore().getUuid());
		Car car = carService.getCarByUUID(opportunity.getCar().getUuid());

		opportunity.setStore(store);
		opportunity.setCar(car);

		rep.save(opportunity);

		store.addOpportunities(opportunity);
		car.addOpportunities(opportunity);

		storeService.save(store);
		carService.save(car);
		return opportunity;
	}

}
