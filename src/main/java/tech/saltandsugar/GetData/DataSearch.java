//package tech.saltandsugar.GetData;
//
//import lombok.Getter;
//import lombok.NonNull;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.stereotype.Component;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.function.BiConsumer;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//@Slf4j
//@Component
//@EnableScheduling
//public class DataSearch {
//    @Autowired
//    DataProcessor dataProcessor;
//    @Value("${configuration.filepath}")
//    private String DATA_FOLDER_11111PATH;
//    /*各CSVファイルのヘッダ*/
////    @Getter
////    private Map<Integer, String> kondateDataCsvHeader = new HashMap<>();
////    @Getter
////    private Map<Integer, String> kyushokuAllergiesData_CsvHeader = new HashMap<>();
//    /*献立*/
////    @Getter解約
////    private HashMap<String, String> todayKyushokuKondate = new HashMap<>();
//    /*献立に対するアレルギー情報*/
////    @Getter
////    private Map<String, List<List<String>>> todayKyushokuAllergies_shou = new HashMap<>();
////    @Getter
////    private Map<String, List<List<String>>> todayKyushokuAllergies_chu = new HashMap<>();
//
////    /**
////     * 献立データ検索
////     * @param localDateTime 検索する対象の日付
////     * @return 指定された日付の献立リスト
////     **/
////    public static HashMap<String, String> searchKondateData(@NonNull LocalDateTime localDateTime) {
//////        HashMap<String, String> kondate = new HashMap<>();
//////        final Path CSV_FILE_LOCATION_KYUSHOKUDATA = Paths.get(DATA_FOLDER_PATH + "KondateData/" + "kyushoku_" + localDateTime.getYear() + String.format("%02d", localDateTime.getMonth().getValue()) + ".csv");
//////        final ArrayList<String[]> kyushokuData = dataProcessor.CSV_toArrayList(CSV_FILE_LOCATION_KYUSHOKUDATA);
////        final List<String[]> kyushokuSearchResult = dataProcessor.doSearchLine(kyushokuData, 4, String.valueOf(localDateTime.getDayOfMonth()));
////        kondateDataCsvHeader = dataProcessor.toHashMap(kyushokuData);
////        /*給食がない場合はデータが日付のみになっているため判定*/
////        if (kyushokuSearchResult.get(0).length > 5) {
////            /*主食*/
////            kondate.put(kondateDataCsvHeader.get(5), kyushokuSearchResult.get(0)[4]);
////            /*献立名1*/
////            kondate.put(kondateDataCsvHeader.get(6), kyushokuSearchResult.get(0)[5]);
////            /*献立名2*/
////            kondate.put(kondateDataCsvHeader.get(7), kyushokuSearchResult.get(0)[6]);
////            /*献立名3*/
////            kondate.put(kondateDataCsvHeader.get(8), kyushokuSearchResult.get(0)[7]);
////            /*献立名4*/
////            kondate.put(kondateDataCsvHeader.get(9), kyushokuSearchResult.get(0)[8]);
////            /*献立名5*/
////            kondate.put(kondateDataCsvHeader.get(10), kyushokuSearchResult.get(0)[9]);
////            /*献立名6*/
////            kondate.put(kondateDataCsvHeader.get(11), kyushokuSearchResult.get(0)[10]);
////            /*飲み物*/
////            kondate.put(kondateDataCsvHeader.get(12), kyushokuSearchResult.get(0)[11]);
////            /*カロリー(小学校)*/
////            kondate.put(kondateDataCsvHeader.get(13), kyushokuSearchResult.get(0)[12]);
////            /*カロリー(中学校)*/
////            kondate.put(kondateDataCsvHeader.get(14), kyushokuSearchResult.get(0)[13]);
////        }
////        log.info("献立検索処理完了");
////        return kondate;
////    }
//
//    /**
//     * 献立に対するアレルギーデータ検索(小学校、中学校データ同時)
//     * @param localDateTime 検索する対象の日付
//     * @param schoolClassType 中学校/小学校
//     * @return
//     **/
//    public Map<String,List<List<String>>> searchKondateAllergies(@NonNull LocalDateTime localDateTime, @NonNull SchoolClassType schoolClassType) {
//        if (schoolClassType.equals(SchoolClassType.SHOU)) {
//            /*アレルギーデータ(小学校)*/
//            final Path CSV_FILE_LOCATION_KONDATE_ALLERGIE_DATA_SHOU = Paths.get(DATA_FOLDER_PATH + "KondateAllergyData/" + "allergies_shou_" + localDateTime.getYear() + String.format("%02d", localDateTime.getMonth().getValue()) + ".csv");
//            final ArrayList<String[]> kondateAllergiesData_shou = dataProcessor.CSV_toArrayList(CSV_FILE_LOCATION_KONDATE_ALLERGIE_DATA_SHOU);
//            Map<Integer, String> kondateAllergiesData_shou_CsvHeader = dataProcessor.toHashMap(kondateAllergiesData_shou);
//            final List<String[]> dayKondateAllergiesData_shou = dataProcessor.doSearchLine(kondateAllergiesData_shou, 3, String.valueOf(localDateTime.getDayOfMonth()));
//
//            Map<String, List<List<String>>> kondateAllergies_shou = generateAllergiesHashMap.apply(kondateAllergiesData_shou_CsvHeader);
////        }else if(schoolClassType.equals(SchoolClassType.CHU)){
////            /*アレルギーデータ(中学校)*/
////            final Path CSV_FILE_LOCATION_KONDATE_ALLERGIE_DATA_CHU = Paths.get(DATA_FOLDER_PATH + "KondateAllergyData/" + "allergies_chu_" + localDateTime.getYear() + String.format("%02d", localDateTime.getMonth().getValue()) + ".csv");
////            final ArrayList<String[]> kondateAllergiesData_chu = dataProcessor.CSV_toArrayList(CSV_FILE_LOCATION_KONDATE_ALLERGIE_DATA_CHU);
////            Map<Integer, String> kondateAllergiesData_chu_CsvHeader = dataProcessor.toHashMap(kondateAllergiesData_chu);
////            final List<String[]> dayKondateAllergiesData_chu = dataProcessor.doSearchLine(kondateAllergiesData_chu, 3, String.valueOf(localDateTime.getDayOfMonth()));
////            Map<String,List<List<String>>> kondateAllergies_chu = generateAllergiesHashMap.apply(kondateAllergiesData_chu_CsvHeader);
////        }
//            /*初期化(KeyをCSVヘッダから引っ張ってくる)*/
//            Map<String, List<List<String>>> kondateAllergies_chu = generateAllergiesHashMap.apply(kyushokuAllergiesData_CsvHeader);
//            /*検索メソッド生成*/
//            final Consumer<SchoolClassType> searchAllergies = classType -> {
//                if (classType.equals(SchoolClassType.SHOU)){
//                    kondateAllergiesData_shou.forEach(line -> {
//                        String menuName = line[4];
//                        int columnNum = 0;
//                        for (String itemByLine : line) {
//                            columnNum++;
//                            if (5 < columnNum) {
//                                switch (itemByLine) {
//                                    /*該当のアレルギー対象食品を含む*/
//                                    case "1" -> kondateAllergies_shou.get(kondateAllergiesData_shou_CsvHeader.get(columnNum)).get(0).add(menuName);
//                                    /*使用されている調味料に該当のアレルギー対象食品を含む*/
//                                    case "2" -> kondateAllergies_shou.get(kondateAllergiesData_shou_CsvHeader.get(columnNum)).get(1).add(menuName);
//                                    /*"1"と"2"両方に該当のアレルギーが含まれる*/
//                                    case "3" -> {
//                                        kondateAllergies_shou.get(kondateAllergiesData_shou_CsvHeader.get(columnNum)).get(0).add(menuName);
//                                        kondateAllergies_shou.get(kondateAllergiesData_shou_CsvHeader.get(columnNum)).get(1).add(menuName);
//                                    }
//                                }
//                            }
//                        }
//                    };
//                }else if(classType.equals(SchoolClassType.CHU)){
//
//                }
//            };
//            //TODO これをDataProcessor.javaに移す or ここにメソッドで実装
////        BiConsumer<List<String[]>,Map<String, List<List<String>>>> searchAllergies = (data,target)-> data.forEach(line -> {
////            String menuName = line[4];
////            int columnNum = 0;
////            for (String itemByLine : line) {
////                columnNum++;
////                if (5 < columnNum) {
////                    switch (itemByLine) {
////                        /*該当のアレルギー対象食品を含む*/
////                        case "1" -> target.get(kyushokuAllergiesData_CsvHeader.get(columnNum)).get(0).add(menuName);
////                        /*使用されている調味料に該当のアレルギー対象食品を含む*/
////                        case "2" -> target.get(kyushokuAllergiesData_CsvHeader.get(columnNum)).get(1).add(menuName);
////                        /*"1"と"2"両方に該当のアレルギーが含まれる*/
////                        case "3" -> {
/*KyushokuAllergiesData_CSVHeaderをメソッド引数にしたい(バグ防止とかで)*/
////                            target.get(kyushokuAllergiesData_CsvHeader.get(columnNum)).get(0).add(menuName);
////                            target.get(kyushokuAllergiesData_CsvHeader.get(columnNum)).get(1).add(menuName);
////                        }
////                    }
////                }
////            }
////        });
//            /*アレルギーデータ検索(小)*/
////            searchAllergies.accept(todaykyushokuAllergiesData_shou, todayKyushokuAllergies_shou);
//            /*アレルギーデータ検索(中)*/
////            searchAllergies.accept(todayKondateAllergiesData_chu, todayKyushokuAllergies_chu);
//            log.info("アレルギーに対する献立名検索処理完了");
//        }
//    }
//
//    /**
//     * HashMap準備用
//     **/
//    final Function<Map<Integer, String>, Map<String, List<List<String>>>> generateAllergiesHashMap = csvHeader -> {
//        Map<String, List<List<String>>> map = new HashMap<>();
//        for (Map.Entry<Integer, String> entry : csvHeader.entrySet()) {
//            if (entry.getKey() > 5) {
//                map.put(entry.getValue(), new ArrayList<>());
//                map.get(entry.getValue()).add(new ArrayList<>());
//                map.get(entry.getValue()).add(new ArrayList<>());
//            }
//        }
//        return map;
//    };
//}