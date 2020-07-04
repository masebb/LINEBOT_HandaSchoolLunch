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
    final boolean DEBUG = true;
    public static void main(String[] args) {
        //時刻生成
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,1);

        Date nowdate = calendar.getTime();
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
