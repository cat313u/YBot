package cn.u313.bot.bot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class BotApplicationTests {

    @Test
    void contextLoads() {
        var data = new Data();
        data.setT1("666");
        System.out.println(data.getT1());
    }

}
