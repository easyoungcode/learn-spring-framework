package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PecmanGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App01GamingBasicJava {

    public static void main(String[] args) {
//        SpringApplication.run(LearnSpringFrameworkApplication.class, args);
//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PecmanGame();    // 1. Object Creation
        var gameRunner = new GameRunner(game);
        // 2. Object Creation + Wiring of Dependencies (종속성연결)
        // Game is a Dependency of GameRunner
        gameRunner.run();
    }

}
