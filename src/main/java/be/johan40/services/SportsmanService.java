package be.johan40.services;

import java.util.List;

import be.johan40.entities.Sportsman;

public interface SportsmanService {

	void create(Sportsman sportsman);

	Sportsman read(Long id);

	void update(Sportsman sportsman);

	void delete(long id);

	Iterable<Sportsman> findAll();
}
