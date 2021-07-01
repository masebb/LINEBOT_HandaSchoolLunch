package tech.saltandsugar.GetData;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static tech.saltandsugar.Util.getWeekDays;

public class ThisWeekKondateAllergies extends TodayKondateAllergies{
    @Getter
    private ArrayList<HashMap<String,?>> weekKondateAllergies_shou;
    @Getter
    private ArrayList<HashMap<String,?>> weekKondateAllergies_chu;

    @Override
    ArrayList<HashMap<String, ?>> search(@NonNull LocalDate localDate, @NonNull SchoolClassType schoolClassType) {
        LocalDate[] localDates = getWeekDays(localDate);
        ArrayList kondateAllergies = new ArrayList<HashMap<String, ?>>();
        for (int i = 0; i < 7 ; i++) {
            kondateAllergies.add(super.search(localDates[i],schoolClassType));
        }
        return kondateAllergies;
    }
    @Override
    void doSearch() {
        weekKondateAllergies_shou = this.search(LocalDate.now(),SchoolClassType.SHOU);
        weekKondateAllergies_chu = this.search(LocalDate.now(),SchoolClassType.CHU);
    }
}
