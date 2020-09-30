package tech.saltandsugar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //時刻生成
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        /*
        * Q:なぜ1日足してるの??????
        * A:GitHubActionsの環境はUTC時刻のため、毎朝06:00に送信するとなるとUTC時刻では1日前の21:00。なので1日後のデータを取得するため
        * //TODO あほまぬけ
        * */
        calendar.add(Calendar.DAY_OF_MONTH,1);
        String[] nowDate_Array = Data_get.DatetoArray(calendar.getTime());
//      String[] nowDate_Array = {"2020","07","8"}; //デバック用
        ArrayList<String[]> data_kyuusyoku = Data_get.load_data(nowDate_Array);
        System.out.println("original-data:"+ Arrays.deepToString(data_kyuusyoku.toArray()));
        System.out.println("results : " + Arrays.toString(Data_get.data_search(nowDate_Array,data_kyuusyoku)));
        if(args[0]!=null) {
            Line_send.line_send(Data_get.data_search(nowDate_Array, data_kyuusyoku), args[0]);
        }else{
            System.out.println("チャンネルトークンを引数に入れてください");
        }
    }
}
