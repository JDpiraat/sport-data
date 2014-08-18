package be.johan40.web;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.johan40.entities.EigenEntity;
import be.johan40.services.EigenEntityService;

public class EigenEntityControllerTest {

	private EigenEntityController entityController;
	private Iterable<EigenEntity> entities;
	private EigenEntityService entityService;

	@Before
	public void setUp() {
		entities = Collections.emptyList();
		entityService = Mockito.mock(EigenEntityService.class);
		Mockito.when(entityService.findAll()).thenReturn(entities);
		entityController = new EigenEntityController(entityService);
	}

	@Test
	public void findAllActiveertJuisteView() {
		Assert.assertEquals("entities/entities", entityController.findAll()
				.getViewName());
	}

	@Test
	public void findAllMaakRequestAttribuutFilialen() {
		Assert.assertSame(entities, entityController.findAll().getModelMap()
				.get("entities"));
	}

}
