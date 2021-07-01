package tech.saltandsugar.RichMenu;

import com.linecorp.bot.client.LineBlobClient;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.action.PostbackAction;
import com.linecorp.bot.model.richmenu.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
public class CreateRichMenu {
    @Autowired
    private LineMessagingClient lineMessagingClient;
    @Autowired
    private LineBlobClient lineBlobClient;

    @Value("${configuration.richmenu_img}")
    private String RICHMENU_IMG_PATH;
    public void createDefaultRichMenu() {
        //リッチメニューの作成

        RichMenu richMenu = RichMenu.builder()
                .chatBarText("メニュー")
                .name("メニュー")
                .areas(
                        Arrays.asList(
                                // px単位のはずなのになぜか座標、幅+高さすべて値を2xしないといけない
//                                上段
                                /*案内:この公式アカウントについて*/
                                new RichMenuArea(new RichMenuBounds(0, 0, 800, 900), new PostbackAction("この公式アカウントについて","action=getAbout","この公式アカウントについて")),
                                /*今日:献立*/
                                new RichMenuArea(new RichMenuBounds(800, 0, 800, 900), new PostbackAction("今日の給食を教えて","action=getTodayKondate","今日の給食を教えて")),
                                /*今週:献立*/
                                new RichMenuArea(new RichMenuBounds(1600, 0, 800, 900), new PostbackAction("今週の献立を教えて","action=getThisWeekKondate","今週の献立を教えて")),
//                                //下段
                                /*案内:毎日自動でその日の献立を送信して欲しい*/
                                new RichMenuArea(new RichMenuBounds(0, 900, 800, 900), new PostbackAction("毎日自動でその日の献立を送信して欲しい","action=howToSettingNotify","毎日自動でその日の献立を送信して欲しい")),
                                /*今日:献立アレルギー情報*/
                                new RichMenuArea(new RichMenuBounds(800, 900, 800, 900), new PostbackAction("今日の献立アレルギー情報を教えて","action=getTodayKondateAllergies","今日の献立アレルギー情報を教えて")),
                                /*今週:献立アレルギー情報*/
                                new RichMenuArea(new RichMenuBounds(1600, 900, 800, 900), new PostbackAction("今週の献立アレルギー情報を教えて","action=getThisWeekKondateAllergies","今週の献立アレルギー情報を教えて"))
                        )
                )
                .selected(true)
                .size(RichMenuSize.FULL)
                .build();

        {
            try {
                //リッチメニューの登録+リッチメニューIDの取得
                RichMenuIdResponse richMenuIdResponse1 = lineMessagingClient.createRichMenu(richMenu).get();
                //画像取得
                Path richMenuImgPath = Paths.get(RICHMENU_IMG_PATH);
                byte[] richMenuImg = Files.readAllBytes(richMenuImgPath);
                //リッチメニュー画像送信
                lineBlobClient.setRichMenuImage(richMenuIdResponse1.getRichMenuId(), "image/png", richMenuImg).get();
                //デフォルトリッチメニューにに適応
                lineMessagingClient.setDefaultRichMenu(richMenuIdResponse1.getRichMenuId());

            } catch (InterruptedException | ExecutionException | IOException e) {
                log.error("リッチメニュー初期化失敗",e);
                System.exit(1);
            }
            log.info("リッチメニュー初期化処理終了");
        }
    }
}
