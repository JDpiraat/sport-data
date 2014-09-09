package be.johan40.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.johan40.entities.Sportsman;

@Service
@Transactional(readOnly = true)
public interface SportsmanService {

	void create(Sportsman sportsman);

	Sportsman read(Long id);

}
