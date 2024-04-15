package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PecmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringFrameworkApplication {

    public static void main(String[] args) {
//        SpringApplication.run(LearnSpringFrameworkApplication.class, args);
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PecmanGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }

}