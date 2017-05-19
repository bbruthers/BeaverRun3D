package edu.mccc.cos210.br3d;
import javax.vecmath.Vector3d;
public interface ILevel{
	/**
	 * This returns the number of lives specified for the current level.
	 */
	public int getLives();
	/**
	 * This returns the time limit specified for the current level. Note this was not used in the current version.
	 */
	public int getTimeLimit();
	/**
	 * This returns time left in the the current level. Note this was not used in the current version.
	 */
	public int getSpeedRange();
	/**
	 * This the speed variable for the trucks specified for the current level.
	 */
	public int getNumberOfLanes();
	/**
	 * This returns the number of lanes specified for the current level.
	 */
	public Vector3d getLaneSize();
	/**
	 * This returns the background texture specified for the current level.
	 */
	public String getBackground();
}