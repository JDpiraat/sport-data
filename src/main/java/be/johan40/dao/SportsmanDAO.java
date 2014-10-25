package be.johan40.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import be.johan40.entities.Sportsman;

public interface SportsmanDAO extends JpaRepository<Sportsman, Long> {	

}
