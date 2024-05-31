package cn.u313.bot.listener;

import cn.u313.bot.service.SignInService;
import cn.u313.bot.service.TestService;
import cn.u313.message.annotation.BotListener;
import cn.u313.message.annotation.OnPrivate;
import cn.u313.message.bean.PrivateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: botv2
 * @Package: cn.u313.bot.listener
 * @ClassName: SignListener
 * @Author: 柳苏言
 * @Description:
 * @Date: 2024/5/27 21:15
 * @Version: 1.0
 */
@Component
@BotListener
public class SignListener {

    @Autowired
    SignInService signInService;
    @Autowired
    TestService testService;
    @OnPrivate
    public void signIn(PrivateMessage privateMessage){
        System.out.println(signInService);
        System.out.println(testService);
        System.out.println(privateMessage);

    }
}
