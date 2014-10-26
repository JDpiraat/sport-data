package be.johan40.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	ModelAndView findAll() {
		return new ModelAndView(TRACKS_VIEW, "tracks", trackService.findAll());
	}

	@RequestMapping(value = "{track}", method = RequestMethod.GET)
	ModelAndView read(@PathVariable Track track) {
		return new ModelAndView(TRACK_VIEW, "track", trackService.read(track.getId()));
	}
	
	@RequestMapping(value = "new", method = RequestMethod.GET)
	ModelAndView createTrack() {		
		return new ModelAndView(NEW_TRACK_VIEW, "trackForm", new TrackForm());
	}

	@RequestMapping(method = RequestMethod.POST, params = { "name",
			"activity", "kilometer" })
	String createNewTrack(@Valid TrackForm trackForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (!bindingResult.hasErrors()) {
		//TODO vast erin nu dat elk nieuw track tot sportsmanId 1 behoort ..., wijzigen naar dege die ingelogd is
			Track track = new Track(trackForm.getName(), trackForm.getActivity(), trackForm.getKilometer(), 
					trackForm.getDescription(), trackForm.getRemark(), trackForm.getStatus());
			trackService.create(track);
			redirectAttributes.addAttribute("id", track.getId());
			return REDIRECT_AFTER_NEW_TRACK_VIEW;
		} else {
			return NEW_TRACK_VIEW;
		}
	}
}
