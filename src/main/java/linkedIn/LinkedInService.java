package linkedIn;

import org.apache.spark.sql.Column;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import javax.annotation.PostConstruct;

import static org.apache.spark.sql.functions.*;

/**
 * Created by student12 on 28/12/2016.
 */
@Service
public class LinkedInService {

    @Autowired
    private LinkedInDataFrameCreator creator;

    private DataFrame dataFrame;

    @PostConstruct
    public void initDataFrame() {
        dataFrame = creator.createDataFrame();
    }


    // Q1
    public void printAll() {
        dataFrame.show();

    }

    // Q2
    public void printSchema() {
        dataFrame.printSchema();
    }

    public void printColumnTypes() {

        Tuple2<String, String>[] columnTypes = dataFrame.dtypes();
        for (Tuple2<String, String> columnType : columnTypes) {
            System.out.println("ColumnName: " + columnType._1() + "; ColumnType: " + columnType._2());
        }
    }

    public void addSalary() {
        // DataFrame dataFrame = creator.createDataFrame();
        dataFrame = dataFrame.withColumn("salary",
                size(col("keywords"))
                .multiply(col("age")
                .multiply(10)));

    }

    public void findDev(){
        DataFrame dataFrame2 = dataFrame.withColumn("Tech", explode(col("keywords")));
        Row[] take = dataFrame2.groupBy(col("Tech")).count().orderBy(col("count").desc()).take(1);
        String mostPopular = take[0].get(0).toString();

        dataFrame = dataFrame
                .filter("salary>1200")
                .filter(functions.array_contains(col("keywords"),mostPopular));
    }
}
