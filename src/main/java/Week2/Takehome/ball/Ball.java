package Week2.Takehome.ball;

import java.util.ArrayList;

public interface Ball<T> {
    /** Randomizes the value in the ball. */
    void shake();

    /**
     * Returns the current value in the ball
     * @return the current value
     */
    T show();

    /**
     * Returns a history of values after each shake().
     * @return a list of ball values
     */
    ArrayList<T> history();

    /**
     * Returns the number of values in the ball.
     * @return the value count
     */
    int size();
}
