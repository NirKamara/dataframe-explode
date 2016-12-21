package popularWords;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Evegeny on 21/12/2016.
 */
@Configuration
@Profile("DEV")
public class DevConfig {
    @Bean
    public SparkConf sparkConf() {
        SparkConf conf = new SparkConf().setAppName("topx").setMaster("local");
        return conf;
    }
}
