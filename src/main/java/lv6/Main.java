package lv6;


import lv6.config.Config;
import lv6.service.KioskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {


        KioskService kioskService = new Config().kioskService();
        log.info("===키오스크 서비스 시작===");
        kioskService.start();
    }

}
