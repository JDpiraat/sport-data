package be.johan40.services;

import be.johan40.entities.Track;

public interface TrackService {

	void create(Track track);

	Track read(long id);

	void update(Track track);

	void delete(long id);

	Iterable<Track> findAll();

}
