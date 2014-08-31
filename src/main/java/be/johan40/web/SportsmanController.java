package be.johan40.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sportsmen")
public class SportsmanController {

	private static final String SPORTSMAN_VIEW = "sportsmen/sportsman";
	private static final String SPORTSMEN_VIEW = "sportsmen/sportsmen";
	private static final String SESSIONS_VIEW = "sportsmen/sessions";
	private static final String NEW_SESSION_VIEW = "sportsmen/new-session";
	private static final String NEW_SPORTSMAN_VIEW = "sportsmen/new";

	@RequestMapping(method = RequestMethod.GET)
	String findAll() {
		return SPORTSMEN_VIEW;
	}
	
	@RequestMapping(value = "new", method = RequestMethod.GET)
	String createForm() {
	return NEW_SPORTSMAN_VIEW;
	}

}
