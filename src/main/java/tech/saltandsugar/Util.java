package tech.saltandsugar;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Slf4j
public class Util {
    /**
     * List<String>のデータを要素ごとに句読点を付けてStringで返す
     * @param list 元データ
     * **/
    public static String toKutouten(@NonNull List<String> list){
        if(list.isEmpty()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String element : list) {
            i++;
            /*末尾に句読点が付くのを防ぐ*/
            if(list.size()==i) {
                stringBuilder.append(element);
            }else{
                stringBuilder.append(element).append("、");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * @param localDateTime 取得する週の任意の日付
     * @return 一週間分のLocalDateTimeの配列
     */
    public static LocalDate[] getWeekDays(LocalDate localDate){
        LocalDate[] oneWeek = new LocalDate[7];
        LocalDate weekOfMonday = localDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        for (int i = 0; i < 7; i++) {
            oneWeek[i] = weekOfMonday.plusDays(i);
        }
        return oneWeek;
    }
}