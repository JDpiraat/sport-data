package be.johan40.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.johan40.dao.SportsmanDAO;
import be.johan40.entities.Sportsman;

@Service
@Transactional
public class SportsmanServiceImpl implements SportsmanService {

	private final SportsmanDAO sportsmanDAO;

	@Autowired
	SportsmanServiceImpl(SportsmanDAO sportsmanDAO) {
		this.sportsmanDAO = sportsmanDAO;
	}

	@Override
	public void create(Sportsman sportsman) {
		sportsmanDAO.save(sportsman);
	}

	@Override
	public Sportsman read(Long id) {
		return sportsmanDAO.findOne(id);
	}

}
