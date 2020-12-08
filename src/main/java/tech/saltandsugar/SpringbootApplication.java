package tech.saltandsugar;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tech.saltandsugar.ScheduledTasks.DataSearch;

import java.util.TimeZone;

@SpringBootApplication
@Slf4j
public class SpringbootApplication {
    @Autowired
    DataSearch dataSearch;
    public static void main(String[] args) {
        //起動
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringbootApplication.class, args);
        SpringbootApplication springbootApplication = configurableApplicationContext.getBean(SpringbootApplication.class);
        springbootApplication.Startup(args);
    }
    //起動時に実行したいことをここ書く(https://gist.github.com/kazz12211/2b9717a56f1a28623af30f8592727dc9)
    public void Startup(String[] args){
        //いらないやつ(いる)
        System.out.println("\u001B[37m"+
                "                                  ______\n" +
                " /'\\_/`\\                         /\\__  _\\          __\n" +
                "/\\      \\     __      ____     __\\/_/\\ \\/    __   /\\_\\  __  __    ___\n" +
                "\\ \\ \\__\\ \\  /'__`\\   /',__\\  /'__`\\ \\ \\ \\  /'__`\\ \\/\\ \\/\\ \\/\\ \\  / __`\\\n" +
                " \\ \\ \\_/\\ \\/\\ \\L\\.\\_/\\__, `\\/\\  __/  \\ \\ \\/\\ \\L\\.\\_\\ \\ \\ \\ \\_\\ \\/\\ \\L\\ \\\n" +
                "  \\ \\_\\\\ \\_\\ \\__/.\\_\\/\\____/\\ \\____\\  \\ \\_\\ \\__/.\\_\\\\ \\_\\/`____ \\ \\____/\n" +
                "   \\/_/ \\/_/\\/__/\\/_/\\/___/  \\/____/   \\/_/\\/__/\\/_/ \\/_/`/___/> \\/___/\n" +
                "                                                            /\\___/\n" +
                "                                                            \\/__/" + " \u001B[0m");

        System.out.println("\u001B[32m"+
                "                                      ::LINEBOT_HandaSchoolLunch::\n"+
                "                                             by Mase Taiyo"+"\u001B[0m");

        //TimeZoneが"Asia/Tokyo"か
        if(TimeZone.getDefault().toZoneId()==TimeZone.getTimeZone("Asia/Tokyo").toZoneId()){
            //初回検索
            dataSearch.doSearch();
        }else{
            //えらーーーー
            log.error("システム時刻がAsia/Tokyo以外になっています : "+TimeZone.getDefault().getID());
            System.exit(1);
        }
    }

}
