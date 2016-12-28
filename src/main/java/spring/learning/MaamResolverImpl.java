package spring.learning;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 28/12/2016.
 */
@Component
public class MaamResolverImpl implements MaamResolver {
    @Override
    public double getMaam() {
        return 0.17;
    }
}
