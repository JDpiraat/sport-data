package be.johan40.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.johan40.entities.Track;
import be.johan40.services.TrackService;

@Controller
@RequestMapping("/tracks")
public class TrackController {

	private static final String NEW_TRACK_VIEW = "tracks/new";
	private static final String REDIRECT_AFTER_NEW_TRACK_VIEW = "redirect:/tracks/{id}";
	private static final String TRACK_VIEW = "tracks/track";
	private static final String TRACKS_VIEW = "tracks/tracks";

	private final TrackService trackService;

	@Autowired
	TrackController(TrackService trackService) {
		this.trackService = trackService;
	}

	@RequestMapping(method = RequestMethod.GET)
	String findAll() {
		return TRACKS_VIEW;
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	ModelAndView createTrack() {
		Track track = new Track();
		return new ModelAndView(TRACK_VIEW, "track", track);
	}

	@RequestMapping(method = RequestMethod.POST, params = { "firstname",
			"lastname", "birthday" })
	ModelAndView createNewTrack(@Valid Track track, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			trackService.create(track);
			return new ModelAndView(REDIRECT_AFTER_NEW_TRACK_VIEW, "id", track.getId());
		} else {
			return new ModelAndView(NEW_TRACK_VIEW);
		}
	}
}
