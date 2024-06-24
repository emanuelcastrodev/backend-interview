package com.store.services.v1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.store.dtos.v1.store.CreateStoreRequestDTO;
import com.store.entities.Store;
import com.store.infra.exceptions.store.StoreAlreadyExistsException;
import com.store.mappers.v1.StoreMapperImpl;
import com.store.repositories.StoreRepository;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class StoreServiceImplTV1Test {

	@Mock
	StoreRepository rep;

	@Mock
	StoreMapperImpl storeMapper;

	@InjectMocks
	StoreServiceImpl service;

	private CreateStoreRequestDTO createRequest;

	private Store existsStore;

	@BeforeEach
	public void setup() {
		createRequest = new CreateStoreRequestDTO("11.007.535/0001-00", "TestStore");
		existsStore = Store.Builder.of("11.007.535/0001-00", "TestStore").build();
	}

	@DisplayName("JUnit Test for detect exists Store by Social Name")
	@Test
	void testGivenExistsStoreBySocialName_WhenSaveStore_thenReturnException() {
		given(storeMapper.toEntity(createRequest)).willReturn(existsStore);
		given(rep.findBySocialName(anyString())).willReturn(Optional.of(existsStore));

		assertThrows(StoreAlreadyExistsException.class, () -> {
			service.createStore(createRequest);
		});

		verify(rep, never()).save(any(Store.class));
	}

	@DisplayName("JUnit Test for detect exists Store by CNPJ")
	@Test
	void testGivenExistsStoreByCNPJ_WhenSaveStore_thenReturnException() {
		given(storeMapper.toEntity(createRequest)).willReturn(existsStore);
		given(rep.findByCnpj(anyString())).willReturn(Optional.of(existsStore));

		assertThrows(StoreAlreadyExistsException.class, () -> {
			service.createStore(createRequest);
		});

		verify(rep, never()).save(any(Store.class));
	}
}
