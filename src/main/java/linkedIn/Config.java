package linkedIn;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Evegeny on 28/12/2016.
 */
@Configuration
public class Config {
    @Bean
    public SQLContext sqlContext(){
        SQLContext sqlContext = new SQLContext(sc());
        return sqlContext;
    }


    @Bean
    public JavaSparkContext sc(){
        SparkConf sparkConf = sparkConf();
        JavaSparkContext sc = new JavaSparkContext(sparkConf());
        return sc;
    }

    @Bean
    public SparkConf sparkConf() {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local").setAppName("linkedIn");
        return sparkConf;
    }
}



