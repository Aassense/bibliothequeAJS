package bibliothequeAJS.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bibliothequeIAA/detail")
public class LivreControleur {

  @RequestMapping({ "/index", "/accueil" })
  public String index() {
    return "angleterre/index";
  }

  @RequestMapping({ "/offre" })
  public String offre() {
    return "angleterre/offre";
  }

}
