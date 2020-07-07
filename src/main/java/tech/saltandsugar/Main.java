package tech.saltandsugar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static tech.saltandsugar.Data_get.data_search;
import static tech.saltandsugar.Data_get.load_data;
import static tech.saltandsugar.Line_send.line_send;

//TODO static ってなんでついてるの？？？？？？

public class Main {
    public static void main(String[] args) {
        //時刻生成
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        /*
        * Q:なぜ1日足してるの??????
        * A:GitHubActionsの環境はUTC時刻のため、毎朝06:00に送信するとなるとUTC時刻では1日前の21:00。なので1日後のデータを取得するため
        * TODO あほ
        * */
        calendar.add(Calendar.DAY_OF_MONTH,1);

        Date nowdate = calendar.getTime();
        ArrayList<String[]> data_kyuusyoku = load_data();
        System.out.println("original-data:"+ Arrays.deepToString(data_kyuusyoku.toArray()));
        System.out.println("results : " + Arrays.toString(data_search(nowdate,data_kyuusyoku)));
        if(args[0]!=null) {
            line_send(data_search(nowdate, data_kyuusyoku), args[0]);
        }else{
            System.out.println("チャンネルトークンを引数に入れてください");
        }
    }
}
