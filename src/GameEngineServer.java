import java.util.Random;
/*
 * This class is responsible for handling game logic
 * tasks such as generating random numbers and
 * handling guesses from clients
 */
public class GameEngineServer {
    /*
     * Method takes a client nu
     */
	public static int serverRandom(int clientNum) {
        Random r = new Random();
        int Low = clientNum;
        int High = 9 * clientNum;
        int result = r.nextInt(High-Low) + Low;
        return result;
    }
}
