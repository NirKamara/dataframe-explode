package popularWords;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 21/12/2016.
 */
public class TopXWordsServiceTest {



    @Test
    public void testTopXIsWorkingCorrectly() throws Exception {
        SparkConf conf = new SparkConf().setAppName("topx").setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("java is the best", "scala is the best", "groovy is the best"
                , "java cool", "java like the God", "java java java"));
        TopXWordsService topXWordsService = new TopXWordsService();
        List<String> list = topXWordsService.topX(rdd, 1);
        Assert.assertEquals(1,list.size());
        Assert.assertEquals("java",list.get(0));
    }

}






