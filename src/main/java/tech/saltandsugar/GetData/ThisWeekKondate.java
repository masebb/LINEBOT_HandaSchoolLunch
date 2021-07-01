package tech.saltandsugar.GetData;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static tech.saltandsugar.Util.getWeekDays;

public class ThisWeekKondate extends TodayKondate{
    @Getter
    private ArrayList<HashMap<String, String>> weekKondates;
    /**
     * @param localDate 取得する日付の週(一週間のどこでもよい)
     * @return 配列番号 月～金の献立=0～6
     */
    @Override
    ArrayList<HashMap<String, String>> search(@NonNull LocalDate localDate) {
        LocalDate[] localDates = getWeekDays(localDate);
        ArrayList<HashMap<String, String>> kondates = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            kondates.add(super.search(localDates[i]).get(0));
        }
        return kondates;

    }

    @Override
    void doSearch() {
        this.weekKondates = search(LocalDate.now());
    }
}