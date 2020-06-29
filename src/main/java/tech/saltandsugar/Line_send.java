package tech.saltandsugar;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.Broadcast;
import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.Box;
import com.linecorp.bot.model.message.flex.component.Text;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.unit.FlexAlign;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

import java.net.URI;

import static java.util.Arrays.asList;

public class Line_send {
    public static void line_send(String[] final_data, String channelToken) {
        //TODO 絶対消す
        LineMessagingClient client = LineMessagingClient.builder(channelToken).build();
        //LineMessagingClient client = LineMessagingClient.builder("YOUR_CHANNEL_TOKEN").build();
        if (!(final_data == null) && !(final_data.length < 5)) {
            //画像取得
//            final Image heroBlock =
//                    Image.builder()
//                            .url(URI.create("https://placehold.jp/70/757575/ffffff/900x900.png?text=%E7%94%BB%E5%83%8F%E3%81%8C%E3%81%82%E3%82%8A%E3%81%BE%E3%81%9B%E3%82%93%0A"))
//                            .size(Image.ImageSize.FULL_WIDTH)
//                            .aspectRatio(Image.ImageAspectRatio.R20TO13)
//                            .aspectMode(Image.ImageAspectMode.Cover)
//                            .build();

            //ブロードキャスト(送信)
            client.broadcast(new Broadcast(new FlexMessage("献立",
                    Bubble.builder()
                            /*.hero(heroBlock)*/.body(
                            Box.builder()
                                    .layout(FlexLayout.VERTICAL)
                                    .margin(FlexMarginSize.SM)
                                    .spacing(FlexMarginSize.SM)
                                    .contents(asList(
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .spacing(FlexMarginSize.SM)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("主食")
                                                                    .color("#aaaaaa")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[4] + " ")//インチキ(空白("")だと怒られる)
                                                                    .color("#666666")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .flex(3)
                                                                    .build()
                                                    )).build()
                                            ,
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .spacing(FlexMarginSize.SM)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("献立名1")
                                                                    .color("#aaaaaa")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[5] + " ")//インチキ(空白("")だと怒られる)
                                                                    .color("#666666")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .flex(3)
                                                                    .build()
                                                    )).build()
                                            ,
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .spacing(FlexMarginSize.SM)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("献立名2")
                                                                    .color("#aaaaaa")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[6] + " ")//インチキ(空白("")だと怒られる)
                                                                    .color("#666666")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .flex(3)
                                                                    .build()
                                                    )).build()
                                            ,
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .spacing(FlexMarginSize.SM)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("献立名3")
                                                                    .color("#aaaaaa")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[7] + " ")//インチキ(空白("")だと怒られる)
                                                                    .color("#666666")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .flex(3)
                                                                    .build()
                                                    )).build()
                                            ,
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .spacing(FlexMarginSize.SM)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("献立名4")
                                                                    .color("#aaaaaa")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[8] + " ")//インチキ(空白("")だと怒られる)
                                                                    .color("#666666")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .flex(3)
                                                                    .build()
                                                    )).build()
                                            ,
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .spacing(FlexMarginSize.SM)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("献立名5")
                                                                    .color("#aaaaaa")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[9] + " ")//インチキ(空白("")だと怒られる)
                                                                    .color("#666666")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .flex(3)
                                                                    .build()
                                                    )).build()
                                            ,
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .spacing(FlexMarginSize.SM)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("献立名6")
                                                                    .color("#aaaaaa")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[10] + " ")//インチキ(空白("")だと怒られる)
                                                                    .color("#666666")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .flex(3)
                                                                    .build()
                                                    )).build()
                                            ,
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .spacing(FlexMarginSize.SM)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("飲み物")
                                                                    .color("#aaaaaa")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[11] + " ")//インチキ(空白("")だと怒られる)
                                                                    .color("#666666")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .flex(3)
                                                                    .build()
                                                    )).build()
                                            ,
                                            Box.builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .content(
                                                            Text.builder()
                                                                    .size(FlexFontSize.XXS)
                                                                    .text("献立名についている「★」は加工食品を表しています")
                                                                    .align(FlexAlign.END)
                                                                    .build()
                                                    ).build()
                                            ,
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.HORIZONTAL)
                                                    .margin(FlexMarginSize.XXL)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("カロリー(小学校)")
                                                                    .color("#555555")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .align(FlexAlign.START)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[12] + "kcal")//インチキ(空白("")だと怒られる)
                                                                    .color("#111111")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .align(FlexAlign.END)
                                                                    .build()
                                                    )).build()
                                            ,
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.HORIZONTAL)
                                                    .margin(FlexMarginSize.XXL)
                                                    .contents(asList(
                                                            Text.builder()
                                                                    .text("カロリー(中学校)")
                                                                    .color("#555555")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .align(FlexAlign.START)
                                                                    .build(),
                                                            Text.builder()
                                                                    .text(final_data[13] + "kcal")//インチキ(空白("")だと怒られる)
                                                                    .color("#111111")
                                                                    .size(FlexFontSize.Md)
                                                                    .wrap(true)
                                                                    .align(FlexAlign.END)
                                                                    .build()
                                                    )).build()
                                    ))
                                    .build()
                    ).footer(
                            Box
                                    .builder()
                                    .layout(FlexLayout.VERTICAL)
                                    .content(
                                            Box
                                                    .builder()
                                                    .layout(FlexLayout.BASELINE)
                                                    .margin(FlexMarginSize.NONE)
                                                    .content(
                                                            Text.builder()
                                                                    .size(FlexFontSize.XXS)
                                                                    .text("データ提供:半田市")
                                                                    .action(new URIAction(null, URI.create("https://www.city.handa.lg.jp/kikaku/shise/johoseisaku/opendata/data_kyushoku.html"), null))
                                                                    .align(FlexAlign.END)
                                                                    .build()
                                                    ).build()
                                    ).build()
                    ).build()
            )));
//            client.broadcast(new Broadcast(new TextMessage(Arrays.toString(final_data))));
        }
    }
}
