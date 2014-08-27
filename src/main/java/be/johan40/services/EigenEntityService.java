package be.johan40.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import be.johan40.entities.EigenEntity;

@Service
@Transactional(readOnly = true)
public interface EigenEntityService {

	// Iterable<EigenEntity> findAll();

	// TODO dit mag weg na ontkoppelongstestje

}
