package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {
    public String[][] layout;
    public GameCharacter[] characters;

    Map(int height, int width) {
        characters = new GameCharacter[4];
        layout = new String[height][width];
        initialiseArray();
        Player player = new Player("Player");
        Monster monster1 = new Monster("Monster1");
        Monster monster2 = new Monster("Monster2");
        Monster monster3 = new Monster("Monster3");
        player.row = height - 1;
        player.column = width - 1;
        monster1.row = 0;
        monster1.column = width - 1;
        monster2.row = height - 1;
        monster2.column = 0;
        monster3.row = 0;
        monster3.column = 0;
        layout[player.row][player.column] = "*";
        layout[monster1.row][monster1.column] = "%";
        layout[monster2.row][monster2.column] = "%";
        layout[monster3.row][monster3.column] = "%";
        characters[0] = player;
        characters[1] = monster1;
        characters[2] = monster2;
        characters[3] = monster3;
    }

    private void initialiseArray() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                layout[i][j] = ".";
            }
        }
    }

    public void printLayout() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                System.out.print(layout[i][j]);
            }
            System.out.println();
        }
    }

}
