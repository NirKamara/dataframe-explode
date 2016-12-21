package taxi;

import org.apache.spark.Accumulator;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

/**
 * Created by Evegeny on 14/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("taxi");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> lines = sc.textFile("data/taxi/taxi_order.txt");
        System.out.println("file content");
        lines.collect().forEach(System.out::println);
        System.out.println("end of file");
        JavaRDD<Trip> trips = lines.map(String::toLowerCase)
                .map(Trip::convertLineToTrip);
        System.out.println("trip object");
        trips.collect().forEach(System.out::println);
        System.out.println("end of trip object");

        System.out.println("trips to boston");
        trips.filter(trip -> trip.getCity().equals("boston"))
                .collect().forEach(System.out::println);
        System.out.println("end trips to boston");

       /* lines.map(String::toLowerCase)
                .filter(line->line.split(" ")[1].equals("boston"))*/

       /* Trip reduceTrip = trips.filter(Trip::bostonFilter)
                .filter(trip -> trip.getKm() > 10)
                .reduce(Trip::summarizeTrips);
            not good way to to reduce!!!
*/

       /* Double allTripsSum = trips.filter(Trip::bostonFilter)
                .filter(trip -> trip.getKm() > 10)
                .mapToDouble(Trip::getKm).sum();*/

        Integer allKm = trips.filter(Trip::bostonFilter)
                .filter(trip -> trip.getKm() > 10)
                .map(Trip::getKm).reduce(Integer::sum);
        System.out.println("allKm = " + allKm);

        System.out.println("winners");

        JavaPairRDD<String, Integer> id2KmRdd =
                trips.mapToPair(trip -> new Tuple2<>(trip.getId(), trip.getKm()));
        JavaPairRDD<String, Integer> sortedDriversByKm = id2KmRdd.reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .mapToPair(Tuple2::swap);


        JavaPairRDD<String, String> driversDataRdd = sc.textFile("data/taxi/drivers.txt").
                mapToPair(line -> {
                    String[] split = line.split(",");
                    return new Tuple2<>(split[0], split[1]);
                }
        );

        sortedDriversByKm.collect().forEach(System.out::println);
        sc.parallelizePairs(sortedDriversByKm.take(3)).
                join(driversDataRdd).take(3).forEach(System.out::println);
//        sortedDriversByKm.join(driversDataRdd).take(3).forEach(System.out::println);

        Accumulator<Integer> smallTrips = sc.accumulator(0, "smallTrips");
        Accumulator<Integer> bigTrips = sc.accumulator(0, "bigTrips");


        trips.foreach(trip -> {
            if (trip.getKm() > 10) {
                bigTrips.add(1);
            }else {
                smallTrips.add(1);
            }
        });
        Integer value = bigTrips.value();

        System.out.println("winners");


    }
}

















