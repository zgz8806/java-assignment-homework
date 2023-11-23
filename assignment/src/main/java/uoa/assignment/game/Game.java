package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;


import static uoa.assignment.game.GameLogic.moveCharacter;

public class Game {

    // Define a variable of type map
    private Map map;

    // Define a constructor of type Game with parameters height and width
    Game (int height, int width) {
        map = new Map(height, width);
        map.printLayout();
    }
    // Define a getMap method of type public, which returns map
    public Map getMap() {
        return map;
    }



   public boolean nextRound (String input) {
        GameLogic gamelogic = new GameLogic();
       // Define a variable to determine if a monster exists
        boolean livingMonster = false;
        System.out.println(map.characters[0].sayName() + "is moving" + input);
        gamelogic.moveCharacter(input, map, map.characters[0]);
       // Walk through the map.characters array to see if any monsters exist
        for (int i = 1; i < map.characters.length; i++) {
            if (map.characters[i].getHealth() > 0) {
                livingMonster = true;
                Monster monster = new Monster("monster");
                System.out.println(map.characters[i].sayName() + "is moving" + monster.decideMove());
                // Call GameLogic's moveCharacter method to move the monster
                gamelogic.moveCharacter(monster.decideMove(), map, map.characters[i]);
            }
        }
       // Walk through the map.characters array and print out the player's health
        for (GameCharacter character : map.characters) {
            System.out.println("Health " + character.sayName() + ":" + character.getHealth());
        }
       // Determine if there are monsters
        if (!livingMonster) {
            System.out.println("YOU HAVE WON!");
            return true;
        }
       // Determine if the player's health is less than or equal to 0
        if (map.characters[0].getHealth() <= 0) {
            System.out.println("YOU HAVE DIED!");
            return true;
        }
        return false;
    }
   
}