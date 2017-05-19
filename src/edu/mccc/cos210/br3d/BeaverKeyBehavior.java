package edu.mccc.cos210.br3d;

import java.awt.AWTEvent;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import javax.media.j3d.Behavior;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.WakeupCondition;
import javax.media.j3d.WakeupCriterion;
import javax.media.j3d.WakeupOnAWTEvent;
import javax.media.j3d.WakeupOr;
import javax.vecmath.Vector3d;

public class BeaverKeyBehavior extends Behavior {
	
	TransformGroup bT = new TransformGroup();
	private Transform3D t3d = new Transform3D();
	private WakeupCondition wake;
	private int forwardKey = KeyEvent.VK_UP;
	private int backKey = KeyEvent.VK_DOWN;
	private int leftKey = KeyEvent.VK_LEFT;
	private int rightKey = KeyEvent.VK_RIGHT;
	
	protected static final double FAST = 0.4;
	protected static final double NORMAL = 0.2;
	protected double speed = NORMAL;
	protected double rotAmount = Math.PI / 360.0 * 10.0;
	protected double direction = 0.0;
	/**
	 * Creates a new BeaverKeyBehavior.
	 *@param bT This is a reference to the beaver's branch group.
	 */
	public BeaverKeyBehavior(TransformGroup bT) {
		super();
		this.bT = bT;
	}
	@Override
	/**
	 * This initializes the event wake up when a key is pressed.
	 */
	public void initialize() {
		WakeupCriterion[] wca = new WakeupCriterion[2];
		wca[0] = new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED);
		wca[1] = new WakeupOnAWTEvent(KeyEvent.KEY_RELEASED);
		wake = new WakeupOr(wca);
		wakeupOn(wake);
	}
	@SuppressWarnings("rawtypes")
	@Override
	/**
	 * This translates the specified key presses into translation of the beaver shape 3D wich allows the player to move it through the level.
	 */
	public void processStimulus(Enumeration e) {
		WakeupCriterion wc;
		AWTEvent[] awtea;
		while (e.hasMoreElements()) {
			wc = (WakeupCriterion) e.nextElement();
			if (!(wc instanceof WakeupOnAWTEvent)) {
				continue;
			}
			awtea = ((WakeupOnAWTEvent) wc).getAWTEvent();
			for (int i = 0; i < awtea.length; i++) {
				if (awtea[i].getID() == KeyEvent.KEY_PRESSED) {
					processKeyEvent((KeyEvent) awtea[i]);
				}
			}
		}
		wakeupOn(wake);
	}
		protected void standardTransform(int kc) {
		if (kc == forwardKey) {
			moveForward();
		
		} else {
			if (kc == backKey) {
				moveBackward();
			} else {
				if (kc == leftKey) {
					moveLeft();
				} else {
					if (kc == rightKey) {
						moveRight();
					}
				} 
			}
		} 
	}
	
	protected void processKeyEvent(KeyEvent ke) {
		int kc = ke.getKeyCode();
		if (ke.isShiftDown()) {
			speed = FAST;
		} else {
			speed = NORMAL;
		}
		standardTransform(kc);
		bT.setTransform(t3d);
	}

	protected void moveForward() {
		move(new Vector3d(-speed * Math.sin(direction), 0.0, -speed * Math.cos(direction)));
	}
	protected void moveBackward() {
		move(new Vector3d(+speed * Math.sin(direction), 0.0, +speed * Math.cos(direction)));
	}
	
	protected void moveLeft(){
		move(new Vector3d(-speed * Math.cos(direction), 0.0, -speed * Math.sin(direction)));	
	}
	
	protected void moveRight(){
		move(new Vector3d(+speed * Math.cos(direction), 0.0, +speed * Math.sin(direction)));
	}

	protected void move(Vector3d v3d) {
		bT.getTransform(t3d);
		Vector3d v3dx = new Vector3d();
		t3d.get(v3dx);
		v3dx.add(v3d);
		t3d.setTranslation(v3dx);
	}
}
