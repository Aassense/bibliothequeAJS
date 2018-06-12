package bibliothequeAJS;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import bibliothequeAJS.client.Requetes;
import bibliothequeAJS.service.Transfert;

@SpringBootApplication
public class Application {

  @Value("${views.path:'erreur'}")
  private String prefix;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public UrlBasedViewResolver getViewResolver() {
    UrlBasedViewResolver vr = new InternalResourceViewResolver();
    vr.setPrefix(prefix);
    vr.setSuffix(".jsp");
    vr.setViewClass(JstlView.class);
    return vr;
  }

  @Bean
  public Transfert getTransfert() {
    return new Transfert();
  }

  @Bean
  public Requetes getRequetes() {
    return new Requetes();
  }
}
