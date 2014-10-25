package be.johan40.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.johan40.dao.SportsmanDAO;
import be.johan40.entities.Sportsman;

@Service
@Transactional(readOnly = true)
public class SportsmanServiceImpl implements SportsmanService {

	private final SportsmanDAO sportsmanDAO;

	@Autowired
	SportsmanServiceImpl(SportsmanDAO sportsmanDAO) {
		this.sportsmanDAO = sportsmanDAO;
	}

	@Override
	@Transactional(readOnly = false)
	public void create(Sportsman sportsman) {
		sportsmanDAO.save(sportsman);
	}

	@Override
	public Sportsman read(Long id) {
		return sportsmanDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Sportsman sportsman) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(readOnly = false)
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<Sportsman> findAll() {		
		return sportsmanDAO.findAll(new Sort("lastName", "firstName"));
	}
}
