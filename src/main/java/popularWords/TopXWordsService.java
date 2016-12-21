package popularWords;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 21/12/2016.
 */
@Service
public class TopXWordsService implements Serializable {
    @Autowired
    private UserConfig userConfig;



    public List<String> topX(JavaRDD<String> rdd, int topX) {
        JavaRDD<String> words = rdd.map(String::toLowerCase).flatMap(WordsUtil::getWords);
        words = words.filter(word -> !this.userConfig.garbage.contains(word));
        return words.mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .map(Tuple2::_2).take(topX);

    }
}



