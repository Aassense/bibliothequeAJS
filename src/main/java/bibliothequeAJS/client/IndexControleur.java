package bibliothequeAJS.client;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexControleur {
  Requetes requetes = new Requetes();
  String message = "";

  @RequestMapping({ "/", "index", "accueil" })
  public String index(Model model, HttpServletRequest request) {
    try {
      model.addAttribute("message", message);
      model.addAttribute("livres", requetes.getLivres());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "index";
  }

  @RequestMapping("getLivre/{indexListe}")
  public String getdetail(@PathVariable("indexListe") int indexListe,
      HttpServletRequest request) {
    try {
      request.setAttribute("livre", requetes.getLivres().get(indexListe - 1));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "forward:/bibliothequeIAA/detail";
  }

  @RequestMapping("message")
  public String getMessage(HttpServletRequest request) {
    message = (String) request.getAttribute("message");

    return "redirect:/";
  }

}
