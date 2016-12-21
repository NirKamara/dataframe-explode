package taxi;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 21/12/2016.
 */
public class IDIMain {
    public static void main(String[] args) {
        IDIService service = IDIService.builder()
                .age(40).salary(20000).build();
        System.out.println(service);

    }
}
