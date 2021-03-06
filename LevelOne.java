import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOne implements Scene {
	/** Has defined boundaries and objects, enemies, etc. */
	
	private BGM bgm = new BGM();
	
	// 'sprites' are the sprites that are somewhere in this level, even if not visible or on the screen right now
	private List<Sprite> sprites = new ArrayList<Sprite>(),
		visibleSprites = new LinkedList<Sprite>();
	
	private int playerStartPosX = 0, playerStartPosY = 0, 
		boundaryX = 0, boundaryY = 0, 		// map boundaries
		cameraStartX = 0, cameraStartY = 0; // change if the camera doesn't start in the top-left corner of the map
	
	
	/** Returns a list of the visible sprites.
	 */
	public List<Sprite> getSprites() {
		return visibleSprites;
	}
	
	/** Updates the game information. Checks collisions and moves sprites. 
	 */
	public void timerEvent() {
		moveSprites();
		checkCollisions();
	}
	
	/** Moves all sprites in 'sprites' by calling their move method.
	 */
	private void moveSprites() {
		for (Sprite i : sprites) {
			i.move();
		}
	}
	
	/** Checks if sprites collide. For those that do, calls the collided method.
	 */
	private void checkCollisions() {
		int i, j, tot;
		Sprite a, b;
		for (i=0, tot = visibleSprites.size(); i<tot; i++) {
			for (j=i; j<tot; j++) {
				a = visibleSprites.get(i);
				b = visibleSprites.get(j);
				if (a.collidesWith(b)) {
					collided(a, b);
				}
			}
		} 
	}
	
	private void collided(Sprite a, Sprite b) {
		// do something
	}
}
