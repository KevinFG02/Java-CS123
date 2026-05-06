package Week4.takedown.Exceptions;

public class GameExceptions extends RuntimeException{

    public GameExceptions(String message)
        {
            super(message);
        }

	public GameExceptions()
        {
            super("Error running game...");
        }
}
