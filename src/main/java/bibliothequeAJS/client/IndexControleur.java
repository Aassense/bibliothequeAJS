package bibliothequeAJS.client;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexControleur {
  Requetes requetes = new Requetes();

  @RequestMapping({ "index", "accueil" })
  public String index(Model model, HttpServletRequest request) {
    try {
      model.addAttribute("livres", requetes.get());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "index";
  }

}
