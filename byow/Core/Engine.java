package byow.Core;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class Engine {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 40;
    private int seed;
    private static final int NUM_SEED = 1000;

    /**
     * Method used for exploring a fresh world. This method should handle all inputs,
     * including inputs from the main menu.
     */
    public void interactWithKeyboard() {
    }

    /**
     * Method used for autograding and testing your code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The engine should
     * behave exactly as if the user typed these characters into the engine using
     * interactWithKeyboard.
     *
     * Recall that strings ending in ":q" should cause the game to quite save. For example,
     * if we do interactWithInputString("n123sss:q"), we expect the game to run the first
     * 7 commands (n123sss) and then quit and save. If we then do
     * interactWithInputString("l"), we should be back in the exact same state.
     *
     * In other words, both of these calls:
     *   - interactWithInputString("n123sss:q")
     *   - interactWithInputString("lww")
     *
     * should yield the exact same world state as:
     *   - interactWithInputString("n123sssww")
     *
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] interactWithInputString(String input) {
        // TODO: Fill out this method so that it run the engine using the input
        // passed in as an argument, and return a 2D tile representation of the
        // world that would have been drawn if the same inputs had been given
        // to interactWithKeyboard().
        //
        // See proj3.byow.InputDemo for a demo of how you can make a nice clean interface
        // that works for many different input types.


        // 0) Set random seed from input
        // 1) Fill everything with nothing (water XD)
        // 2) Given width and height, create a 2 dimensional int array of zones
        // n as number of rooms   --- dependency on distribution ?
        // 3) Parameters for room dimensions (by floor)   //master data
        // 4) Parameters for hallways between sectors     //master data
        // 5) Add floors  (to final world frame)
        // 6) Add walls (option for inefficiency)  helper adjacent  (to final world frame)
        // 7) Big flex owo

        int hashCode = Math.floorMod((input.hashCode() * 2017), NUM_SEED);  //2017 some prime p
        System.out.println(hashCode);

        TETile[][] finalWorldFrame = new TETile[WIDTH][HEIGHT];
        fillWater(finalWorldFrame);  // 1) done
        int[][] numRoomSector = numRoomSector();  // 2)
        Map<Integer, String> roomCoordinates = computeRoom(numRoomSector);  // 3)
        List<String> hallCoordinates = computeHall(roomCoordinates);  // 4)
        addFloors(finalWorldFrame);  // 5)
        addWalls(finalWorldFrame);  // 6)
        return finalWorldFrame;
    }

    private void fillWater(TETile[][] world) {
        int width = world.length;
        int height = world[0].length;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                world[x][y] = Tileset.EMPTY_A_0;
            }
        }
    }

    private int[][] numRoomSector() {
        return null;
    }

    private Map<Integer, String> computeRoom(int[][] numRoomSector) {
        return new HashMap<Integer, String>();
    }

    private List<String> computeHall(Map<Integer, String> roomCoordinates) {
        return new LinkedList<String>();
    }

    private void addFloors(TETile[][] finalWorldFrame) {
        return;
    }

    private void addWalls(TETile[][] finalWorldFrame) {
        return;
    }
}
