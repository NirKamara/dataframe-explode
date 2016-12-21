package popularWords;

import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 21/12/2016.
 */
@Service
public class MyNewService {
    @Autowired
    private JavaSparkContext sc;
}
