package be.johan40.dao;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import be.johan40.datasource.CreateTestDataSourceBean;
import be.johan40.entities.EigenEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CreateTestDataSourceBean.class,
CreateTestDAOBeans.class, }) 
// DataSource bean en DAO beans laden in IOC container
// CreateTestDAOBeans ipv CreateDAOBeans wegens in-memory databank om te testen
@Transactional 
// omringt elke test met een transactie, na de test rollback
public class EigenEntityDAOImplTest {
	
	@Autowired
	private EigenEntityDAO entityDAO;
	@Test
	public void create() {
	// EigenEntity entity=new EigenEntity();
	// EigenEntityDAO.create(entity);
	// Assert.assertNotEquals(0, entity.getId()); // id moet autonumber hebben:
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
