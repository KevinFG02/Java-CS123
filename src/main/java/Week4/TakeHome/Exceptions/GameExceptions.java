package Week4.TakeHome.Exceptions;

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
