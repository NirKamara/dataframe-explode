package popularWords;

import lombok.Setter;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Evegeny on 21/12/2016.
 */
@Service
@Setter
public class MusicJudgeService {

    @Autowired
    private TopXWordsService topXWordsService;

    @Autowired
    private JavaSparkContext sc;


    public List<String> topX(String artistName, int topX) {
        String pathToFile = "data/songs/" + artistName + "/*";
        JavaRDD<String> rdd = sc.textFile(pathToFile);
        List<String> list = topXWordsService.topX(rdd, topX);
        return list;
    }
}









