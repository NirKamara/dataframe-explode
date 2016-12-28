package linkedIn;

import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 28/12/2016.
 */
@Service
public class LinkedInService {
    @Autowired
    private SQLContext sqlContext;

    public void printAll() {
        DataFrame dataFrame = sqlContext.read().json("data/linkedIn/*.json");
        dataFrame.show();
    }
}










