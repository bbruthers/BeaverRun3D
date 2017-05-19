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

public class BeaverCollisionBehavior extends Behavior {

	Beaver b;
	WakeupCondition wuc;
	BranchGroup bg;
	BeaverRun3D br3d;
	/**
	 * This constructor creates a new BeaverCollisionBehavior with references to the required objects for operation.
	 *@param b this is a referene to the beaver 3D shape currently in the scene.
	 *@param bg this is a reference to the beavers branch group so that it's detach method may be called to remove it from the scene.
	 *@param br3d this is a reference to the main BeaverRun3D main class so its gotHit() method may be called.
	 */
	public BeaverCollisionBehavior(Beaver b, BranchGroup bg, BeaverRun3D br3d) {
		this.b = b;
		this.bg = bg;
		this.br3d = br3d;
	}
	@Override
	/**
	 * This is simply the initialization of the behavior as per the Java 3D specifications. It will trigger when the beaver collides with anything in the scene.
	 */
	public void initialize() {
		wuc = new WakeupOnCollisionEntry(b);
		wakeupOn(wuc);
	}

	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * This will call the main classes gotHit(), play the splat sound and detaches the beaver branch graph from the scene.
	 */
	public void processStimulus(Enumeration arg0) {
		BeaverRun3D.playClip(0);
		br3d.gotHit();
		bg.detach();
		wakeupOn(wuc);
	}

}
