package bibliothequeAJS.client;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("bibliothequeIAA")
public class LivreControleur extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @RequestMapping({ "/detail" })
  public String index(Model model, HttpServletRequest request) {
    // System.out.println(request.getAttribute("livre"));
    // model.addAttribute("livre", );
    return "retraitLivre";
  }

  @RequestMapping({ "/retrait" })
  public String retrait() {
    return "redirect:/index";
  }

}
