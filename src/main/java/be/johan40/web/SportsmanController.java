package be.johan40.web;

import java.util.GregorianCalendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	private static final String SESSIONS_VIEW = "sportsmen/sessions";
	private static final String NEW_SESSION_VIEW = "sportsmen/new-session";
	private static final String NEW_SPORTSMAN_VIEW = "sportsmen/new";
	
	private final SportsmanService sportsmanService;
	
	@Autowired
	SportsmanController(SportsmanService sportsmanService) {		
		this.sportsmanService = sportsmanService;
	}


	@RequestMapping(method = RequestMethod.GET)
	String findAll() {
		return SPORTSMEN_VIEW;
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	ModelAndView createSportsmanForm() {
		SportsmanForm sportman = new SportsmanForm();
		return new ModelAndView(NEW_SPORTSMAN_VIEW, "sportsmanForm", sportman);
	}

	@RequestMapping(method = RequestMethod.POST, params = { "firstname",
			"lastname", "birthday" })
	ModelAndView createNewSportsman(@Valid SportsmanForm sportsmanForm, BindingResult bindingResult) {
		if(!bindingResult.hasErrors()){
		StartDateEndDate startDateEndDate = new StartDateEndDate(GregorianCalendar.getInstance());
		LengthInMeters length = new LengthInMeters(startDateEndDate, sportsmanForm.getLengthinmeters());	
		WeightInKg weight = new WeightInKg(null, sportsmanForm.getWeightinkg());
		Sportsman sportman = new Sportsman(sportsmanForm.getFirstname(), sportsmanForm.getLastname(), sportsmanForm.getBirthday(), weight, length);
		return new ModelAndView(SPORTSMAN_VIEW, "sportsman", sportman);
		} else {
			return new ModelAndView(NEW_SPORTSMAN_VIEW);
		}
	}

}
