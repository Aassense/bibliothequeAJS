package bibliothequeAJS.client;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bibliothequeAJS.service.Livre;
import bibliothequeAJS.service.Transfert;

@Controller

@RequestMapping("bibliothequeIAA")
public class LivreControleur extends HttpServlet {
  Livre livre;

  private static final long serialVersionUID = 1L;

  @RequestMapping({ "/detail" })
  public String index(Model model, HttpServletRequest request) {
    livre = (Livre) request.getAttribute("livre");
    return "retraitLivre";
  }

  @RequestMapping({ "/retrait/{index}" })
  public String retrait(@PathVariable("index") int index) {
    try {
      Transfert transfert = new Transfert();
      transfert.addLivre(livre);
      Requetes requetes = new Requetes();
      requetes.delete(index);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:/index";
  }

}
