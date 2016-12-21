package popularWords;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by Evegeny on 21/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("popularWords");
        MusicJudgeService musicJudgeService = context.getBean(MusicJudgeService.class);
        List<String> topXWords = musicJudgeService.topX("beatles", 3);
        System.out.println(topXWords);
    }
}
