package tech.saltandsugar;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import static tech.saltandsugar.Data_get.data_search;
import static tech.saltandsugar.Data_get.load_data;
import static tech.saltandsugar.Line_send.line_send;

//TODO static ってなんでついてるの？？？？？？

public class Main {
    final boolean DEBUG = true;
    public static void main(String[] args) {
        //時刻生成
        LocalDateTime ldt = LocalDateTime.now();
        //LocalDateTime ldt=LocalDateTime.of(2020,6,3,0,0,0);デバック
        //"多分"(ブラックボックス)日本時刻で生成(日本時刻"を"生成?)
        ZonedDateTime zoned = ldt.atZone(TimeZone.getTimeZone("Asia/Tokyo").toZoneId());
        Instant instant = zoned.toInstant();
        Date nowdate = Date.from(instant);

        ArrayList<String[]> data_kyuusyoku = load_data();
        System.out.println("元データ:"+ Arrays.deepToString(data_kyuusyoku.toArray()));
        System.out.println("検索結果 : " + Arrays.toString(data_search(nowdate,data_kyuusyoku)));
        if(args[0]!=null) {
            line_send(data_search(nowdate, data_kyuusyoku), args[0]);
        }else{
            System.out.println("チャンネルトークンを引数に入れてください");
        }
    }
}
