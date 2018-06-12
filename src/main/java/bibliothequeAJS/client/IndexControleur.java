package bibliothequeAJS.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexControleur {

  @RequestMapping({ "index", "accueil" })
  public String index() {
    return "index";
  }

}
