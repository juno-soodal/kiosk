package lv7;


import lv7.cart.Cart;
import lv7.menu.Menu;
import lv7.service.KioskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {


        Menu menu = new Menu();
        Cart cart = new Cart();
        KioskService kioskService = new KioskService(menu,cart);
        log.info("===키오스크 서비스 시작===");
        kioskService.start();
    }

}
