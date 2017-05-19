package edu.mccc.cos210.br3d;
import javax.vecmath.Vector3d;
public class Level_4 implements ILevel{
	
	private int lives = 9;
	private int timeLimit = 750;
	private int truckSpeed = 4000; //should be in a range from 2500-1500
	private int lanes = 8;
	private Vector3d laneSize = new Vector3d(128, 0, 8); //DO NOT TOUCH
	private String Background = "wallpaperr4.jpg";
	
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