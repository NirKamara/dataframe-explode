package linkedIn;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 28/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("linkedIn");
        LinkedInService linkedInService = context.getBean(LinkedInService.class);
        linkedInService.printAll();
    }
}
