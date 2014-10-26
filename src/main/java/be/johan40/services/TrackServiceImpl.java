package be.johan40.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	@Transactional(readOnly = false)
	public void create(Track track) {
		trackDAO.save(track);		
	}

	@Override
	public Track read(long id) {		
		return trackDAO.getOne(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Track track) {
		// TODO Auto-generated method stub		
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Track> findAll() {
		return trackDAO.findAll(new Sort("name"));
	}

}
