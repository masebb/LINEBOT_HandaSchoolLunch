package tech.saltandsugar.Listener;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.action.PostbackAction;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.PostbackEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tech.saltandsugar.Generator.LineOfficialAccount_ErrorTextMessage;
import tech.saltandsugar.ScheduledTasks.DataGenerating;

import java.time.LocalDate;
import java.util.Arrays;

@Slf4j
@LineMessageHandler
public class EventListener {
    @Autowired
    LineMessagingClient lineMessagingClient;
    @Autowired
    DataGenerating dataGenerating;
    @Autowired
    LineOfficialAccount_ErrorTextMessage lineOfficialAccount_errorTextMessage;


    @EventMapping
    public void handleEvent(Event event) {
        /*ハンドルされてないイベントが来ると例外を吐くよくわからない仕様のため拾ってあげる*/
    }

    @EventMapping
    public Message handlePostbackEvent(PostbackEvent event) {
        try {
            String data = event.getPostbackContent().getData();
            String action = "";
            String secondArg = "";

            /*オプションの引数があるか確認*/
            if (data.contains("&")) {
                action = data.substring(data.indexOf("=") + 1, data.indexOf("&"));
                log.info(String.valueOf(action.length()));
                secondArg = data.substring(data.lastIndexOf("=") + 1, data.length());
            } else {
                action = data.substring(data.indexOf("=") + 1);
            }
            switch (action) {
                case "getAbout" -> {
                    /*TODO 定型文はpropertiesファイルから取得させる*/
                    return TextMessage.builder()
                            .text("説明文:公式アカウントについて")
                            .build();
                }
                case "getTodayKondate" -> {
                    /*TODO 平日にエラーを出す*/
                    return dataGenerating.getTodayKondate();
                }
                case "getThisWeekKondate" -> {
                    /*TODO 実装予定*/
                    return TextMessage.builder().text("未実装:今週の給食を教えて").build();
                }
                case "howToSettingNotify" -> {
                    return TextMessage.builder()
                            /*TODO 提携分はpropertiesファイルから取得させる*/
                            .text("説明文:毎日自動でその日の献立を送信して欲しい")
                            .build();
                }
                case "getTodayKondateAllergies" -> {
                    if (secondArg.equals("")) {
                        return TextMessage.builder()
                                .text("小学校か中学校かを選んでください")
                                .quickReply(QuickReply.items(
                                        Arrays.asList(
                                                QuickReplyItem.builder()
                                                        .action(PostbackAction.builder()
                                                                .label("小学校")
                                                                .displayText("小学校")
                                                                .data("action=getTodayKondateAllergies&type=shou")
                                                                .build())
                                                        .build(),
                                                QuickReplyItem.builder()
                                                        .action(PostbackAction.builder()
                                                                .label("中学校")
                                                                .displayText("中学校")
                                                                .data("action=getTodayKondateAllergies&type=chu")
                                                                .build())
                                                        .build()
                                        ))
                                )
                                .build();
                    } else {
                        if (secondArg.equals("shou")) {
                            return dataGenerating.getTodayKondateAllergies_shou();
                        } else if (secondArg.equals("chu")) {
                            return dataGenerating.getTodayKondateAllergies_chu();
                        }
                    }
                }
                case "getThisWeekKondateAllergies" -> {
                    if (secondArg.equals("")) {
                        return TextMessage.builder()
                                .text("小学校か中学校かを選んでください")
                                .quickReply(QuickReply.items(
                                        Arrays.asList(
                                                QuickReplyItem.builder()
                                                        .action(PostbackAction.builder()
                                                                .label("小学校")
                                                                .displayText("小学校")
                                                                .data("action=getThisWeekKondateAllergies&type=shou")
                                                                .build())
                                                        .build(),
                                                QuickReplyItem.builder()
                                                        .action(PostbackAction.builder()
                                                                .label("中学校")
                                                                .displayText("中学校")
                                                                .data("action=getThisWeekKondateAllergies&type=chu")
                                                                .build())
                                                        .build()
                                        ))
                                )
                                .build();
                    } else {
                        return TextMessage.builder().text("未実装 : 今週の献立アレルギー情報").build();
                    }
                }
                default -> {
                    log.error("サポートされていないアクション引数が発生しました!!!!!!!!!!!!!!!! : {}", action);
                    return LineOfficialAccount_ErrorTextMessage.internalErrorTextMessageSupplier("サポートされていないアクション引数の発生 : EventListener.java:133 \n" + LocalDate.now().toString());
                }
            }
        } catch (Exception e) {
            log.error("原因不明のエラー : ", e);
            return LineOfficialAccount_ErrorTextMessage.internalErrorTextMessageSupplier("EventListener.java:139でExceptionをキャッチ");
        }
        return null;
    }
}
