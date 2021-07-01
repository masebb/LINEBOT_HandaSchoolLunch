package tech.saltandsugar.Generator;

import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.Box;
import com.linecorp.bot.model.message.flex.component.FlexComponent;
import com.linecorp.bot.model.message.flex.component.Separator;
import com.linecorp.bot.model.message.flex.component.Text;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.unit.FlexAlign;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Component
@Slf4j
public class LineOfficialAccount_KondateInfoFlexMsgSupplier {

    public FlexMessage flexMessageGenerate(@NonNull HashMap<String, String> kyushokuData , Map<Integer, String> kyushokuCsvHeaderData) {
        //TODO アレルギーの方とおんなじ機構にしてコード量削減したい
        List<FlexComponent> contents = asList(Text.builder()
                        .text("今日の給食")
                        .margin(FlexMarginSize.XXL)
                        .size(FlexFontSize.XXL)
                        .weight(Text.TextWeight.BOLD)
                        .build(),
                Separator.builder()
                        .margin(FlexMarginSize.LG)
                        .build()
                ,
                Box
                        .builder()
                        .layout(FlexLayout.BASELINE)
                        .spacing(FlexMarginSize.SM)
                        .margin(FlexMarginSize.XXL)
                        .contents(asList(
                                Text.builder()
                                        .text("主食")
                                        .color("#aaaaaa")
                                        .size(FlexFontSize.Md)
                                        .wrap(true)
                                        .build(),
                                Text.builder()
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(5)) + " ")//インチキ(空白("")だと怒られる)
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
                                        .text("献立名")
                                        .color("#aaaaaa")
                                        .size(FlexFontSize.Md)
                                        .wrap(true)
                                        .build(),
                                Text.builder()
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(6)) + " ")
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
                        .contents(
                                Text.builder()
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(7)) + " ")
                                        .color("#666666")
                                        .size(FlexFontSize.Md)
                                        .wrap(true)
                                        .flex(3)
                                        .offsetStart("68px")
                                        .build()
                        ).build()
                ,
                Box
                        .builder()
                        .layout(FlexLayout.BASELINE)
                        .spacing(FlexMarginSize.SM)
                        .contents(
                                Text.builder()
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(8)) + " ")
                                        .color("#666666")
                                        .size(FlexFontSize.Md)
                                        .wrap(true)
                                        .flex(3)
                                        .offsetStart("68px")
                                        .build()
                        ).build()
                ,
                Box
                        .builder()
                        .layout(FlexLayout.BASELINE)
                        .spacing(FlexMarginSize.SM)
                        .contents(
                                Text.builder()
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(9)) + " ")
                                        .color("#666666")
                                        .size(FlexFontSize.Md)
                                        .wrap(true)
                                        .flex(3)
                                        .offsetStart("68px")
                                        .build()
                        ).build()
                ,
                Box
                        .builder()
                        .layout(FlexLayout.BASELINE)
                        .spacing(FlexMarginSize.SM)
                        .contents(
                                Text.builder()
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(10)) + " ")
                                        .color("#666666")
                                        .size(FlexFontSize.Md)
                                        .wrap(true)
                                        .flex(3)
                                        .offsetStart("68px")
                                        .build()
                        ).build()
                ,
                Box
                        .builder()
                        .layout(FlexLayout.BASELINE)
                        .spacing(FlexMarginSize.SM)
                        .contents(
                                Text.builder()
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(11)) + " ")
                                        .color("#666666")
                                        .size(FlexFontSize.Md)
                                        .wrap(true)
                                        .flex(3)
                                        .offsetStart("68px")
                                        .build()
                        ).build()
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
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(12)) + " ")
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
                                        .text("献立名にある★は、加工食品を表しています。すべての食材を表記しているものではありません。")
                                        .align(FlexAlign.END)
                                        .wrap(true)
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
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(13)) + "kcal")//インチキ(空白("")だと怒られる)
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
                                        .text(kyushokuData.get(kyushokuCsvHeaderData.get(14)) + "kcal")//インチキ(空白("")だと怒られる)
                                        .color("#111111")
                                        .size(FlexFontSize.Md)
                                        .wrap(true)
                                        .align(FlexAlign.END)
                                        .build()
                        )).build()
        );

        return new FlexMessage("今日の学校給食",
                Bubble.builder()
                        /*.hero(heroBlock)*/.body(
                        Box.builder()
                                .layout(FlexLayout.VERTICAL)
                                .margin(FlexMarginSize.SM)
                                .spacing(FlexMarginSize.MD)
                                .contents(
                                        contents
                                )
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
                ).build().toBuilder().build());
    }
//    public Supplier<FlexMessage> flexMessageSupplier = () -> {
//        FlexMessage flexmessage = new FlexMessage("今日の学校給食",
//                Bubble.builder()
//                        /*.hero(heroBlock)*/.body(
//                        Box.builder()
//                                .layout(FlexLayout.VERTICAL)
//                                .margin(FlexMarginSize.SM)
//                                .spacing(FlexMarginSize.MD)
//                                .contents(asList(
//                                        Text.builder()
//                                                .text("今日の給食")
//                                                .margin(FlexMarginSize.XXL)
//                                                .size(FlexFontSize.XXL)
//                                                .weight(Text.TextWeight.BOLD)
//                                                .build(),
//                                        Separator.builder()
//                                                .margin(FlexMarginSize.LG)
//                                                .build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .spacing(FlexMarginSize.SM)
//                                                .margin(FlexMarginSize.XXL)
//                                                .contents(asList(
//                                                        Text.builder()
//                                                                .text("主食")
//                                                                .color("#aaaaaa")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .build(),
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(5)) + " ")//インチキ(空白("")だと怒られる)
//                                                                .color("#666666")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .flex(3)
//                                                                .build()
//                                                )).build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .spacing(FlexMarginSize.SM)
//                                                .contents(asList(
//                                                        Text.builder()
//                                                                .text("献立名")
//                                                                .color("#aaaaaa")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .build(),
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(6)) + " ")
//                                                                .color("#666666")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .flex(3)
//                                                                .build()
//                                                )).build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .spacing(FlexMarginSize.SM)
//                                                .contents(
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(7)) + " ")
//                                                                .color("#666666")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .flex(3)
//                                                                .offsetStart("68px")
//                                                                .build()
//                                                ).build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .spacing(FlexMarginSize.SM)
//                                                .contents(
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(8)) + " ")
//                                                                .color("#666666")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .flex(3)
//                                                                .offsetStart("68px")
//                                                                .build()
//                                                ).build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .spacing(FlexMarginSize.SM)
//                                                .contents(
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(9)) + " ")
//                                                                .color("#666666")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .flex(3)
//                                                                .offsetStart("68px")
//                                                                .build()
//                                                ).build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .spacing(FlexMarginSize.SM)
//                                                .contents(
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(10)) + " ")
//                                                                .color("#666666")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .flex(3)
//                                                                .offsetStart("68px")
//                                                                .build()
//                                                ).build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .spacing(FlexMarginSize.SM)
//                                                .contents(
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(11)) + " ")
//                                                                .color("#666666")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .flex(3)
//                                                                .offsetStart("68px")
//                                                                .build()
//                                                ).build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .spacing(FlexMarginSize.SM)
//                                                .contents(asList(
//                                                        Text.builder()
//                                                                .text("飲み物")
//                                                                .color("#aaaaaa")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .build(),
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(12)) + " ")
//                                                                .color("#666666")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .flex(3)
//                                                                .build()
//                                                )).build()
//                                        ,
//                                        Box.builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .content(
//                                                        Text.builder()
//                                                                .size(FlexFontSize.XXS)
//                                                                .text("献立名にある★は、加工食品を表しています。すべての食材を表記しているものではありません。")
//                                                                .align(FlexAlign.END)
//                                                                .wrap(true)
//                                                                .build()
//                                                ).build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.HORIZONTAL)
//                                                .margin(FlexMarginSize.XXL)
//                                                .contents(asList(
//                                                        Text.builder()
//                                                                .text("カロリー(小学校)")
//                                                                .color("#555555")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .align(FlexAlign.START)
//                                                                .build(),
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(13)) + "kcal")//インチキ(空白("")だと怒られる)
//                                                                .color("#111111")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .align(FlexAlign.END)
//                                                                .build()
//                                                )).build()
//                                        ,
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.HORIZONTAL)
//                                                .margin(FlexMarginSize.XXL)
//                                                .contents(asList(
//                                                        Text.builder()
//                                                                .text("カロリー(中学校)")
//                                                                .color("#555555")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .align(FlexAlign.START)
//                                                                .build(),
//                                                        Text.builder()
//                                                                .text(dataSearch.getTodayKyushokuKondate().get(dataSearch.getKyushokuDataCsvHeader().get(14)) + "kcal")//インチキ(空白("")だと怒られる)
//                                                                .color("#111111")
//                                                                .size(FlexFontSize.Md)
//                                                                .wrap(true)
//                                                                .align(FlexAlign.END)
//                                                                .build()
//                                                )).build()
//                                ))
//                                .build()
//                ).footer(
//                        Box
//                                .builder()
//                                .layout(FlexLayout.VERTICAL)
//                                .content(
//                                        Box
//                                                .builder()
//                                                .layout(FlexLayout.BASELINE)
//                                                .margin(FlexMarginSize.NONE)
//                                                .content(
//                                                        Text.builder()
//                                                                .size(FlexFontSize.XXS)
//                                                                .text("データ提供:半田市")
//                                                                .action(new URIAction(null, URI.create("https://www.city.handa.lg.jp/kikaku/shise/johoseisaku/opendata/data_kyushoku.html"), null))
//                                                                .align(FlexAlign.END)
//                                                                .build()
//                                                ).build()
//                                ).build()
//                ).build()
//        ).toBuilder().build();
//        return flexmessage;
//    };
}
