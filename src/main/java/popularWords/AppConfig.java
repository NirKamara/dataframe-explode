package popularWords;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Evegeny on 21/12/2016.
 */
@Configuration
@ComponentScan(basePackages = "popularWords")
@PropertySource("classpath:user.properties")
public class AppConfig {
    @Autowired
    private SparkConf sparkConf;

    @Bean
    public JavaSparkContext sc(){
        return new JavaSparkContext(sparkConf);
    }
}
