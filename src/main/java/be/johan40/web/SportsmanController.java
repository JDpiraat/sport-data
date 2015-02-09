package be.johan40.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.johan40.entities.Sportsman;
import be.johan40.services.EigenEntityService;
import be.johan40.services.SportsmanService;
import be.johan40.valueobjects.LengthInMeters;
import be.johan40.valueobjects.StartDateEndDate;
import be.johan40.valueobjects.WeightInKg;

@Controller
@RequestMapping("/sportsmen")
public class SportsmanController {

	private static final String SPORTSMAN_VIEW = "sportsmen/sportsman";
	private static final String SPORTSMEN_VIEW = "sportsmen/sportsmen";
	private static final String NEW_SPORTSMAN_VIEW = "sportsmen/new";
	private static final String SESSIONS_VIEW = "sessions/sessions";
	private static final String SESSION_VIEW = "sessions/session";
	private static final String NEW_SESSION_VIEW = "sessions/new";
	
	private final SportsmanService sportsmanService;
	
	@Autowired
	SportsmanController(SportsmanService sportsmanService) {		
		this.sportsmanService = sportsmanService;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {		
		return new ModelAndView(SPORTSMEN_VIEW, "sportsmen", sportsmanService.findAll());		
	}
	
	@RequestMapping(value = "{sportsman}", method = RequestMethod.GET)
	ModelAndView read(@PathVariable Sportsman sportsman) {		
		return new ModelAndView(SPORTSMAN_VIEW, "sportsman", sportsmanService.read(sportsman.getId()));		
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	ModelAndView createSportsmanForm() {
		SportsmanForm sportsman = new SportsmanForm();
		return new ModelAndView(NEW_SPORTSMAN_VIEW, "sportsmanForm", sportsman);
	}

	@RequestMapping(method = RequestMethod.POST, params = { "firstname",
			"lastname", "birthday" })
	ModelAndView createNewSportsman(@Valid SportsmanForm sportsmanForm, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()){
		StartDateEndDate startDateEndDate = new StartDateEndDate(LocalDate.now());
		LengthInMeters length = new LengthInMeters(startDateEndDate, sportsmanForm.getLengthinmeters());	
		WeightInKg weight = new WeightInKg(startDateEndDate, sportsmanForm.getWeightinkg());
		Sportsman sportsman = new Sportsman(sportsmanForm.getFirstname(), sportsmanForm.getLastname(), sportsmanForm.getBirthday(), weight, length);
		sportsmanService.create(sportsman);
		return new ModelAndView(SPORTSMAN_VIEW, "sportsman", sportsman);
		} else {
			return new ModelAndView(NEW_SPORTSMAN_VIEW);
		}
	}
}
