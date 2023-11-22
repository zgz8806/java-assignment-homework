package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;


import static uoa.assignment.game.GameLogic.moveCharacter;

public class Game {

    private Map map;
    
    Game (int height, int width) {
        map = new Map(height, width); // 实例化并初始化一个 Map 对象
        map.printLayout(); // 打印地图布局到控制台
    }
    			
    public Map getMap() {
        return map;
    }

    public boolean nextRound (String input) {
        GameLogic gamelogic = new GameLogic();
        boolean livingMonster = false;
        System.out.println(map.characters[0].sayName() + "is moving" + input);
        gamelogic.moveCharacter(input, map, map.characters[0]);
        for (int i = 1; i < map.characters.length; i++) {
            if (map.characters[i].getHealth() > 0) {
                livingMonster = true;
                Monster monster = new Monster("monster");
                System.out.println(map.characters[i].sayName() + "is moving" + monster.decideMove());
                gamelogic.moveCharacter(monster.decideMove(), map, map.characters[i]);
            }
        }
        for (GameCharacter character : map.characters) {
            System.out.println("Health " + character.sayName() + ":" + character.getHealth());
        }
        if (!livingMonster) {
            System.out.println("YOU HAVE WON!");
            return true;
        }
        if (map.characters[0].getHealth() <= 0) {
            System.out.println("YOU HAVE DIED!");
            return true;
        }
        return false;
    }
   
}