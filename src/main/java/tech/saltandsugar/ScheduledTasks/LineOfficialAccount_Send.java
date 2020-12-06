package tech.saltandsugar.ScheduledTasks;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.Broadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tech.saltandsugar.Generator.LineOfficialAccount_KondateInfomationFlexMessage;

@Component
@EnableScheduling
public class LineOfficialAccount_Send{
//    @Value("${line.bot.channel-token}")
//    private String channel_token;

    @Autowired
    LineMessagingClient lineMessagingClient;
//    @Scheduled(cron = "0 * * * * *", zone = "Asia/Tokyo")//デバック
    @Scheduled(cron = "0 0 06 * * MON-FRI", zone = "Asia/Tokyo")
    public void SchaduledSend() {
        if(!(DataSearch.todayKyushokuKondate.length<5)){
            //平日(データがある)
            LineOfficialAccount_KondateInfomationFlexMessage lineOfficialAccount_kondateInfomationFlexMessage = new LineOfficialAccount_KondateInfomationFlexMessage();
            lineMessagingClient.broadcast(new Broadcast(lineOfficialAccount_kondateInfomationFlexMessage.flexmessage));
        }else{
            //休日(データがない)
        }
    }
}
