package campus.valence.demineur;

public class Main {

    public static void main(String[] args) {
        Game game;
        if (args.length!=0) {
            String difficulte = args[0];
            if (difficulte.equals("facile")) {
                game = new Game(5);
            } else if (difficulte.equals("difficile")) {
                game = new Game(40);
            } else {
                game = new Game(30);
            }
        } else {
            game = new Game(30);
        }
        game.launch(game);
    }

}
