package com.burakerdem.tutorials.dto.controller.bean;

import com.burakerdem.tutorials.dto.controller.BeanController;
import org.springframework.stereotype.Controller;

@Controller
public class PostContructTutorial {


    /*@Autowired
    Logger LOG;
*/

    //Paramatresiz Constructor
    // because "this.LOG" is null
    /*public void BeanController() {
        LOG.info("Log info çağırıldı");
    }*/


    // bean henüz başlamadığından null alıyoruz ve burada bağımlılığı enjekte edemiyoruz.
    // Görevi: Bir bean nesnesi oluşturulduğunda hemen oluşur.

  /*  @PostConstruct
    public void init(){
        LOG.info("Log info çağırıldı");
    }
*/

    public static void main(String[] args) {
        BeanController beanController = new BeanController();
        System.out.println(beanController);
    }

}
