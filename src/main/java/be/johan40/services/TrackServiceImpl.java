package be.johan40.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.johan40.dao.TrackDAO;
import be.johan40.entities.Track;

@Service
@Transactional(readOnly = true)
public class TrackServiceImpl implements TrackService {

	private final TrackDAO trackDAO;

	@Autowired
	TrackServiceImpl(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}

	@Override
	public void create(Track track) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Track read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Track track) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Track> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
