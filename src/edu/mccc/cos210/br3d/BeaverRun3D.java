package edu.mccc.cos210.br3d;
 import javax.media.j3d.BranchGroup;
 import java.net.URL;
 import javax.media.j3d.BoundingSphere;
 import javax.sound.sampled.AudioSystem;
 import javax.sound.sampled.Clip;
 import javax.sound.sampled.Line;
 import javax.vecmath.Point3d;


/**
 * Beaver Run (3D). Pure Zen.
 *
 * @author Brett Bruthers
 * @author  Samani Gikandi
 * @author Gary Patricelli
 *
 * @version 1.0
 */
 
public class BeaverRun3D {
	
	private static Clip[] clips = new Clip[1];
	private int lives;
	private int time;
	ILevel level;
	LevelBuilder lb;
	/**
	 * Takes in a string variable representing which level is to be played. If no string is given defaults to level 1.
	 */
	public static void main(String[] sa) throws Exception {
		int levelName = 0;
		BeaverRun3D j3db = new BeaverRun3D();
		j3db.loadClips();
		j3db.new AudioThread().start();
		if (sa.length == 0){
			levelName = 1;
		}
		else{
			levelName = Integer.parseInt(sa[0]);
		}
		j3db.doIt(levelName);
		
	}
	/**
	 * Initializes the requested level based on the string input.
	 */
	private void doIt(int levelName) throws Exception {
		switch (levelName) {
			case 1: Level_1 l1 = new Level_1();
					this.level = l1;
					break;
			case 2: Level_2 l2 = new Level_2();
					this.level = l2;
					break;
			case 3: Level_3 l3 = new Level_3();
					this.level = l3;
					break; 
			case 4:	Level_4 l4 = new Level_4();
					this.level = l4;
					break;
		}
		LevelBuilder lb = new LevelBuilder(level, this);
		lb.buildLevel();
		this.lb = lb;
		this.lives = level.getLives();
		this.time = level.getTimeLimit();
	}
	
	/**
	 * This method does nothing more than print the game has ended in the command window. It could however be expanded as it executes when the game ends. 
	 */
	public void gameLost(){
		System.out.println("Lost Game");
	}
	/**
	 * Similarly to gameLost() this method does nothing but could be expanded to do somthing usefull.
	 */
	public void gameWon(){
	
	}
	/**
	 * Decrements the number of lives and updates the text 2D. If there are no lives left it displays the death screen.
	 */
	public void gotHit(){
		lives--;
		lb.lives2D.setString(" " + lives);
		if(lives == 0){
			gameLost();
			lb.createScreen("death.jpg");
		}
		else{
			BranchGroup bg;
			bg = lb.getBeaverGroup();
			bg.addChild(lb.placeBeaver());
		}
		
	}
	private void loadClips() {
		try {
			clips[0] = (Clip) AudioSystem.getLine(
				new Line.Info(Clip.class)
			);
			clips[0].open(
				AudioSystem.getAudioInputStream(
					new URL(
						"file:splat.wav"
					)
				)
			);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void playClip(final int n) {
		new Thread() {
			public void run() {
				clips[n].stop();
				clips[n].setFramePosition(0);
				clips[n].start();
				while (clips[n].isRunning()) { }
			}
		}.start();
	}
	private class AudioThread extends Thread {
		public void run() {
			Clip clip;
			try {
				clip = (Clip) AudioSystem.getLine(
					new Line.Info(Clip.class)
				);
				clip.open(
					AudioSystem.getAudioInputStream(
						new URL(
							"file:bgsound.wav"
						)
					)
				);
				clip.stop();
				clip.setFramePosition(0);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				while (clip.isRunning()) { }
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
