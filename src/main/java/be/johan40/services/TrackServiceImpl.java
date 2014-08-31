package be.johan40.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.johan40.dao.TrackDAO;

@Service
@Transactional
public class TrackServiceImpl implements TrackService {

	private final TrackDAO trackDAO;

	@Autowired
	TrackServiceImpl(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}

}
