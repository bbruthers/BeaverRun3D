package edu.mccc.cos210.br3d;

import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import java.awt.*;
import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;

import java.util.Enumeration;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.Behavior;
import javax.media.j3d.BoundingBox;
import javax.media.j3d.WakeupCondition;
import javax.media.j3d.WakeupOnCollisionEntry;
import com.sun.j3d.utils.universe.ConfiguredUniverse;

public class FinishLineBehavior extends Behavior {

	BoundingBox finishLine;
	LevelBuilder lb;
	WakeupCondition wuc;
	/**
	 * This will create a new FinishLineBehavior.
	 *@param finishLine this is a reference to the bounding box that is created when the last lane is created. 
	 *@param lb this is a reference to the levelBuilder that created this object.
	 */
	public FinishLineBehavior(BoundingBox finishLine, LevelBuilder lb) {
		this.finishLine = finishLine;
		this.lb = lb;
	}
	@Override
	/**
	 * This is simply the initialization of the behavior as per the Java 3D specifications. It will trigger when the finish line bounding box is collided with by any object.
	 */
	public void initialize() {
		wuc = new WakeupOnCollisionEntry(finishLine);
		wakeupOn(wuc);
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * When triggered this method will call the level builder's create screen with the win texture.
	 */
	public void processStimulus(Enumeration arg0) {
		lb.createScreen("win.jpg");
		wakeupOn(wuc);
	}

}

