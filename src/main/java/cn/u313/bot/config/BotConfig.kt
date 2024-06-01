package cn.u313.bot.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("cn.u313.message")
class BotConfig{
    val signCoin = 20;
}
