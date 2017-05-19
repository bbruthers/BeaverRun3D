package edu.mccc.cos210.br3d;
import javax.vecmath.Vector3d;
public class Level_2 implements ILevel{
	
	private int lives = 2;
	private int timeLimit = 500;
	private int truckSpeed = 5000; //should be in a range from 2500-1500
	private int lanes = 7;
	private Vector3d laneSize = new Vector3d(128, 0, 8); //DO NOT TOUCH
	private String Background = "wallpaper2.jpg";
	
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
		return Background;
	}
}