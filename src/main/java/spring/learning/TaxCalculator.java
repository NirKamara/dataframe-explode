package spring.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 28/12/2016.
 */
@Service
public class TaxCalculator {
    @Autowired
    private MaamResolver maamResolver;

    @PostConstruct
    public void init() {
        System.out.println(maamResolver.getClass());
    }

    public void printPriceWithMaam(double price) {
        System.out.println(price+price*maamResolver.getMaam());
    }
}
