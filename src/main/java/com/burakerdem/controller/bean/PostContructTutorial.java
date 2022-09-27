package com.burakerdem.controller.bean;

import com.burakerdem.controller.BeanController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

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
