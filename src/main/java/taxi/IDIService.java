package taxi;

import lombok.*;

import java.util.List;

/**
 * Created by Evegeny on 21/12/2016.
 */
@AllArgsConstructor
@Getter
@ToString
@Builder
public class IDIService {
    private int age;
    private int salary;
    @NonNull
    private Integer vetek;

    @Singular("oneFish")
    private List<String> fish;


}










