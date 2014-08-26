package be.johan40.web;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.johan40.services.EigenEntityService;

@Controller
@RequestMapping("/entities")
// @SessionAttributes("entity") voor session scope ipv request scope, wel maar
// in 1 controller!
// vergeet niet 'sessionStatus.setComplete();' als alles gebeurd is
// Session scoped bean is een object in een HttpSession variabele over alle
// controllers heen: p85 of google (annotatie op Object zelf)
public class EigenEntityController {
	private static final String ENTITIES_VIEW = "entities/entities";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/entities";
	// eigenlijk OfferteController ?
	// dit wordt overbodig als we met command objects (spring form) en
	// BindingResult werken
	private final static Logger logger = Logger
			.getLogger(EigenEntityController.class.getName());

	private final EigenEntityService entityService;

	@Autowired
	EigenEntityController(EigenEntityService entityService) {
		// Spring injecteert de parameter entityService met de bean die de
		// interface
		// EntityService implementeert: EntityServiceImpl
		this.entityService = entityService;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	ModelAndView findAll() {
//		return new ModelAndView(ENTITIES_VIEW, "entities",
//				entityService.findAll());
//	}

	@RequestMapping(method = RequestMethod.POST)
	String create() {
		// later voeg je een record toe aan de database
		logger.info("filiaal record toevoegen aan database");
		return REDIRECT_URL_NA_TOEVOEGEN;
	}

	/*
	 * bij een attribute @ModelAttribute zodat je dat niet zelf terug moet
	 * toevoegen aan je ModelAndView
	 * 
	 * @Valid bevat alle functionaliteit van @ModelAttribute en doet bean
	 * validatie
	 * 
	 * @PathVariable
	 */

}
