package edu.mccc.cos210.br3d;
import javax.vecmath.Vector3d;
public class Level_1 implements ILevel{
	
	private int lives = 5;
	private int timeLimit = 200;
	private int truckSpeed = 2500; //should be in a range from 2500-1500
	private int lanes = 5;
	private Vector3d laneSize = new Vector3d(128, 0, 8);
	private String background = "wallpaper1.jpg";
	
	public int getLives() {
		return this.lives;
	}
	public int getTimeLimit() {
		return this.timeLimit;
	}
	public int getSpeedRange() {
		return truckSpeed;
	}
	public int getNumberOfLanes() {
		return lanes;
	}
	public Vector3d getLaneSize() {
		return laneSize;
	}
	public String getBackground(){
		return background;
	}
}