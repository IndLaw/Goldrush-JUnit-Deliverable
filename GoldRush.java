public class GoldRush {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // checks number of arguments
        if (args.length != 2) {
            System.out.println("Two arguments are required");
            System.exit(0);
        } else {
            // error handling in case arguments are not integers
           if(!(Integer.parseInt(args[0])%1 == 0) || !(Integer.parseInt(args[1])%1 == 0)) {
                System.out.println("The first or second argument is not an integer.");
                System.exit(0);
            }

            Game game = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            game.start();
        }
    }

}
