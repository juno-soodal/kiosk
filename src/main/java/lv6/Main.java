package lv6;


import lv6.config.Config;
import lv6.service.KioskService;

public class Main {
    public static void main(String[] args) {

        KioskService kioskService = new Config().kioskService();
        kioskService.start();
    }
}
