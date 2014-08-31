package be.johan40.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import be.johan40.entities.Track;

public interface TrackDAO extends JpaRepository<Track, Long> {

}
