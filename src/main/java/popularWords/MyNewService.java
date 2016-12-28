package popularWords;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 21/12/2016.
 */
@Service
public class MyNewService {
    @Autowired
    private SQLContext sqlContext;

    @PostConstruct
    public void doWork(){
        DataFrame dataFrame =
                sqlContext.read().json("data/linkedIn/*");
    }
}







