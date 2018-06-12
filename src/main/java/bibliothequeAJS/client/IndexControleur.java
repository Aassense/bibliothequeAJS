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

  @RequestMapping({ "index", "accueil" })
  public String index(Model model, HttpServletRequest request) {
    try {
      model.addAttribute("livres", requetes.getLivres());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "index";
  }

  @RequestMapping("getLivre/{index}")
  public String getdetail(@PathVariable("index") int index,
      HttpServletRequest request) {
    try {
      System.out.println(requetes.getLivres().get(index));
      request.setAttribute("livre", requetes.getLivres().get(index));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "forward:/bibliothequeIAA/detail";
  }

}
