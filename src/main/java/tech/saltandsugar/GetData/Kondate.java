package tech.saltandsugar.GetData;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

@EnableScheduling
@Component
public abstract class Kondate{
    @Value("${configuration.filepath}")
    String DATA_FOLDER_PATH;

    Path CSV_FILE_LOCATION;
    LoadCSV data;

    abstract ArrayList<HashMap<String, String>> search(LocalDate localDate);
    abstract ArrayList<HashMap<String,?>> search(LocalDate localDate,SchoolClassType schoolClassType);

    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Tokyo")
    abstract void doSearch();
}
