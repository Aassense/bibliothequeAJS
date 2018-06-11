package bibliothequeAJS;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BibliothequeControleur {

  private List<Livre> livres;

  @GetMapping(path = "/livres", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Livre> getLivres() {
    return livres;
  }

}
