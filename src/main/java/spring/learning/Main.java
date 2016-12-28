package spring.learning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 28/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("spring.learning");
        TaxCalculator taxCalculator = context.getBean(TaxCalculator.class);
        taxCalculator.printPriceWithMaam(100);
    }
}
