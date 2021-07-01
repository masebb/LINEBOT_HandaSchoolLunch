//package tech.saltandsugar.ScheduledTasks;
//
//import com.linecorp.bot.model.message.FlexMessage;
//import lombok.Getter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import tech.saltandsugar.Generator.LineOfficialAccount_AllergiesInfoFlexMsgSupplier;
//import tech.saltandsugar.Generator.LineOfficialAccount_KondateInfoFlexMsgSupplier;
//import tech.saltandsugar.GetData.DataSearch;
//import tech.saltandsugar.GetData.SchoolClassType;
//import tech.saltandsugar.GetData.TodayKondate;
//
//import java.time.DayOfWeek;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//
//@EnableScheduling
//@Component
//@Slf4j
//public class DataGenerating {
//    @Autowired
//    DataSearch dataSearch;
//    @Autowired
//    LineOfficialAccount_AllergiesInfoFlexMsgSupplier lineOfficialAccount_allergiesInfoFlexMsgSupplier;
//    @Autowired
//    LineOfficialAccount_KondateInfoFlexMsgSupplier lineOfficialAccount_kondateInfoFlexMsgSupplier;
//    @Autowired
//    TodayKondate todayKondate;
//    @Getter
////    private FlexMessage todayKondate;
//    @Getter
//    private FlexMessage todayKondateAllergies_shou;
//    @Getter
//    private FlexMessage todayKondateAllergies_chu;
//    @Getter
//    private FlexMessage thisWeekKondate;
//    @Getter
//    private FlexMessage thisWeekKondateAllergies_shou;
//    @Getter
//    private FlexMessage thisWeekKondateAllergies_chu;
//
//    LocalDateTime localDateTime;
//
//    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Tokyo")
//    /*日付生成*/
//    public void run() {
//        localDateTime = LocalDateTime.now();
//        try {
//            /*今日の給食*/
//            /*データ検索*/
//            dataSearch.searchKondateData(localDateTime);
//            dataSearch.searchKondateAllergies(localDateTime);
//            /*FlexMessage生成*/
//            todayKondate = lineOfficialAccount_kondateInfoFlexMsgSupplier.flexMessageGenerate(dataSearch.getTodayKyushokuKondate(), dataSearch.getKondateDataCsvHeader());
//            todayKondateAllergies_shou = lineOfficialAccount_allergiesInfoFlexMsgSupplier.flexMessageGenerate(SchoolClassType.SHOU, dataSearch.getTodayKyushokuAllergies_chu());
//            todayKondateAllergies_chu = lineOfficialAccount_allergiesInfoFlexMsgSupplier.flexMessageGenerate(SchoolClassType.CHU, dataSearch.getTodayKyushokuAllergies_chu());
//
//            /*今週の給食*/
//            /*月曜日 OR 初回起動時*/
//            if (localDateTime.getDayOfWeek().equals(DayOfWeek.MONDAY) | thisWeekKondate == null) {
//                ArrayList thisWeekKondate = new ArrayList<String>();
//                for (int i = 0; i < 6; i++) {
//                    dataSearch.searchKondateData(localDateTime.plusDays(i));
//                }
//                }
//        } catch (Exception e) {
//            log.error("データ検索に失敗しましたのでシステムを終了します", e);
//            /*ヘンテコデータを送信しないように終了させる*/
//            System.exit(1);
//        }
//        log.info("検索処理終了");
//    }
//}
