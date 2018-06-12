package bibliothequeAJS.client;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bibliothequeAJS.service.Livre;

@Controller

@RequestMapping("bibliothequeIAA")
public class LivreControleur extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@RequestMapping({ "/detail" })
	public String index(Model model) {

		model.addAttribute("livre", new Livre(1, "Titre", 1990, "auteur", "editeur"));
		return "retraitLivre";
	}

	@RequestMapping({ "/retrait" })
	public String retrait() {
		return "redirect:/index";
	}

}
