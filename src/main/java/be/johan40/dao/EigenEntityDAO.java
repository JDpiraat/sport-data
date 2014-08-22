package be.johan40.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.johan40.entities.EigenEntity;

public interface EigenEntityDAO extends JpaRepository<EigenEntity, Long>{

	// met spring data zet je hier de 'lege' methodes in
	
	// zaken die je niet direct via spring data kan zet je in de orm.xml 
	// en dan hier de method 'ietsDatJeNietViaSpringDataKan'
	
}
