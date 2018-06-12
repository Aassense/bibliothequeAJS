package bibliothequeAJS.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bibliothequeAJS.service.Livre;

@Controller
@RequestMapping("/")
public class IndexControleur {

  @RequestMapping({ "index", "accueil" })
  public String index(Model model, HttpServletRequest request) {
    try {
      model.addAttribute("livres", getLivres());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "index";
  }

  public List<Livre> getLivres() throws IOException {
    return new Requetes().get();
  }
}
