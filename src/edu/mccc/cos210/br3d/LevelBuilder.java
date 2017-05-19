package edu.mccc.cos210.br3d;
import com.sun.j3d.utils.universe.ConfiguredUniverse;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.Text2D;
import java.awt.*;
import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;
import com.sun.j3d.utils.image.TextureLoader;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.net.URL;
import java.util.Random;
import javax.swing.Timer;

public class LevelBuilder{
	private int truckSpeed;
	private int numberOfLanes;
	private BeaverRun3D br3d;
	int z;	//laneWidth
	int x; //laneLength
	int y; //laneHeight
	int lives; //(Brett) lives var for text2D
	private String background;
	
	BranchGroup beaverGroup = new BranchGroup();
	private BoundingSphere bs = new BoundingSphere(
		new Point3d(0.0, 0.0, 0.0),
		Double.MAX_VALUE
	);

	/**
	 * This creates a new level builder.
	 *@param level A level class implimenting ILevel.
	 *@param br3d A reference to this classes creator for later use.
	 */
	public LevelBuilder(ILevel level, BeaverRun3D br3d){
		this.truckSpeed = level.getSpeedRange();
		this.numberOfLanes = level.getNumberOfLanes();
		this.x = (int)level.getLaneSize().getX();
		this.y = (int)level.getLaneSize().getY();
		this.z = (int)level.getLaneSize().getZ();	
		this.lives = level.getLives();
		this.br3d = br3d;
		this.background = level.getBackground();
	}
	/**
	 * Handels the users life display. The number of remaining lives is displayed useing text 2D.
	 */
	public BranchGroup headsDisplay(){
		BranchGroup headsDispBranchGRP = new BranchGroup();
		TransformGroup headsDispTransGRP = new TransformGroup();
		headsDispTransGRP.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		headsDispTransGRP.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
		Transform3D headsTransGroup3D = new Transform3D();
		headsDispTransGRP.setTransform(headsTransGroup3D);
		headsDispTransGRP.addChild(placeStats("Lives: ", 9.0, 27.0));
		headsDispTransGRP.addChild(showLives(13.0, 27.0));
		
		headsDispBranchGRP.addChild(headsDispTransGRP);
		return headsDispBranchGRP;
	}	
	
	
	/**
	 * This is used by headsUpDisplay() in order to place the text where it should be on the screen.
	 */
	private Node placeStats(String input, double x, double y){
		TransformGroup statsTransGrp = new TransformGroup();
		Transform3D stats3D = new Transform3D();
		stats3D.setTranslation(new Vector3d(x, y, 0.0));
		statsTransGrp.setTransform(stats3D);
		Text2D stat2DText = new Text2D(input, new Color3f(0.86f, 0.08f, 0.24f), "Helvetica", 384, Font.BOLD);
		statsTransGrp.addChild(stat2DText);
		
		return statsTransGrp;
	}
	Text2D lives2D = new Text2D(" " + lives, new Color3f(0.86f, 0.08f, 0.24f), "Helvetica", 384, Font.BOLD);
	/**
	 * Instantiates the text 2D to be used by headsUpDisplay() 
	 */
	public TransformGroup showLives(double x, double y){	//(Brett) text2D lives disp
		TransformGroup textTransGroup = new TransformGroup();
		textTransGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		textTransGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
		Transform3D trans3D = new Transform3D();
		trans3D.setTranslation(new Vector3d(x, y, 0.0));
		textTransGroup.setTransform(trans3D);
		lives2D.setString(" " + lives);
		textTransGroup.addChild(lives2D);
		return textTransGroup;
	}
	/**
	 * This method is responcible for building the scene graph. Based on presets x,y, and z it places the lanes and trucks in the scene properly spaced and allined.
	 */
	public void buildLevel() throws Exception {
		ConfiguredUniverse cu = new ConfiguredUniverse(
			new URL("file:j3dbump.conf")
		);
		BoundingBox endZone = new BoundingBox(
		new Point3d(-x/2, 0.0, -(numberOfLanes + 2) * z - 2),
		new Point3d(x/2, 10.0, -(numberOfLanes + 1) * z - 2)
	);
	
		
		
		
		BranchGroup bg = new BranchGroup();
		Background b = new Background(getIC2D(background));
		b.setImageScaleMode(Background.SCALE_FIT_MAX);
		b.setApplicationBounds(bs);
		bg.addChild(b);
		bg.addChild(setupLights());
		TransformGroup lanes = new TransformGroup();
		lanes = addLanes(numberOfLanes);
		bg.addChild(this.createGrassStrip());
		bg.addChild(this.createFinishLine());
		bg.addChild(lanes);
		FinishLineBehavior flb = new FinishLineBehavior(endZone, this); 
		flb.setSchedulingBounds(bs);
		bg.addChild(flb);
		cu.addBranchGraph(bg);
		beaverGroup.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
		beaverGroup.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
		beaverGroup.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
		beaverGroup.addChild(placeBeaver());
		beaverGroup.addChild(headsDisplay());
		cu.addBranchGraph(beaverGroup);
	}
	/**
	 * This is used by the BR3D class to reattach the beaver's branch to the scene graph after he is removed.
	 */
	public BranchGroup getBeaverGroup(){
		return this.beaverGroup;
	}
	/**
	 * This is used by the BR3D class to remove the beaver's branch from the scene graph during run time.
	 */
	public BranchGroup placeBeaver(){
		BranchGroup bg = new BranchGroup();
		bg.setCapability(BranchGroup.ALLOW_DETACH);
		TransformGroup bt = new TransformGroup();
		bt.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		bt.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		Transform3D bt3d = new Transform3D();
		Beaver b = new Beaver();
		Matrix3d roty = new Matrix3d();
		roty.rotY(Math.toRadians(180.0));
		Vector3d txtz = new Vector3d(0.0, 1.0, 2.0);
		double scale = 3.0;
		bt3d.set(roty, txtz, scale);
		bt.setTransform(bt3d);
		bt.addChild(b);
		BeaverKeyBehavior bkb = new BeaverKeyBehavior(bt);
		bkb.setSchedulingBounds(bs);
		BeaverCollisionBehavior bcb = new BeaverCollisionBehavior(b, bg, br3d);
		bcb.setSchedulingBounds(bs);
		bg.addChild(bcb);
		bg.addChild(bkb);
		bg.addChild(bt);
		return bg;
	}
	/**
	 * This method creates the death lose and win screen.
	 * @param texture This is passed into the method specifying which texture to attach to the screen.
	 */
	public void createScreen(String texture) {	
		QuadArray quadArray = new QuadArray(
			4,
			GeometryArray.COORDINATES |
			GeometryArray.NORMALS |
			GeometryArray.TEXTURE_COORDINATE_2
		);
		quadArray.setCoordinates(
			0,
			new Point3f[] {
				new Point3f(-5, 1, -10),
				new Point3f( -5, 1, 0),
				new Point3f( 5, 1, 0),
				new Point3f( 5, 1, -10)
			}
		);
		quadArray.setNormals(
			0,
			new Vector3f[] {
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f)
				}
		);
		quadArray.setTextureCoordinates(
			0,
			0,
			new TexCoord2f[] {
				new TexCoord2f(0.0f, 0.0f),
				new TexCoord2f(1.0f, 0.0f),
				new TexCoord2f(1.0f, 1.0f),
				new TexCoord2f(0.0f, 1.0f)
			}
		);
		TextureLoader textureLoader = new TextureLoader(texture, null);
		TextureAttributes textureAttributes = new TextureAttributes();
		textureAttributes.setTextureMode(
			TextureAttributes.MODULATE
		);
		Material material = new Material(
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(0.0f, 0.0f, 0.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			128f
		);
		Appearance appearance = new Appearance();
		appearance.setMaterial(material);
		appearance.setTexture(textureLoader.getTexture());
		appearance.setTextureAttributes(textureAttributes);
		Shape3D screen = new Shape3D();
		screen.addGeometry(quadArray);
		screen.setAppearance(appearance);
		Transform3D t3d = new Transform3D();
		TransformGroup tg = new TransformGroup();
		Matrix3d rotx = new Matrix3d();
		rotx.rotX(Math.toRadians(70.0));
		Vector3d txtz = new Vector3d(0.0, 19.0, 30.0);
		double scale = 1.25;
		t3d.set(rotx, txtz, scale);
		tg.setTransform(t3d);
		tg.addChild(screen);
		BranchGroup sbg = new BranchGroup();
		sbg.addChild(tg);
		beaverGroup.addChild(sbg);
	}
	
	private Node placeTruck(double offset, long time) {
       int startUp = (int)(Math.random() * 1000);
	
	if (startUp <= 500){
		startUp = 500;
	} else if (startUp > 500){
		startUp = 1000;
	}
		
		Truck truck = new Truck();
        TransformGroup tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        Transform3D t3d = new Transform3D();
        t3d.setTranslation(new Vector3d(0.0, 2.75, -offset));
        tg.setTransform(t3d);
        tg.addChild(truck);
        Transform3D t3drppi = new Transform3D();
        Quat4f[] quats = new Quat4f[5];
        quats[0] = new Quat4f();
        quats[1] = new Quat4f();
        quats[2] = new Quat4f();
        quats[3] = new Quat4f();
        quats[4] = new Quat4f();
        quats[0].set(new AxisAngle4d(0.0, 1.0, 0.0, 0.0));
        quats[1].set(new AxisAngle4d(0.0, 1.0, 0.0, 0.0));
        quats[2].set(new AxisAngle4d(0.0, 1.0, 0.0, Math.PI));
        quats[3].set(new AxisAngle4d(0.0, 1.0, 0.0, Math.PI));
        quats[4].set(new AxisAngle4d(0.0, 1.0, 0.0, 0.0));
        Alpha alpha = new Alpha(
                -1,
                startUp,
                4000,
                time,
                0,
                0
        );
        RotPosPathInterpolator rppi = new RotPosPathInterpolator(
                alpha,
                tg,
                t3drppi,
                new float[] { 0.0f, 0.4f, 0.5f, 0.9f, 1.0f},
                quats,
                new Point3f[] { 
                    new Point3f(-x/2.0f, 2.8f, (float) (0.0f - offset)),
                    new Point3f(x/2f, 2.8f, (float) (0.0f - offset)),
                    new Point3f(x/2f, 2.8f, (float) (0.0f - offset)),
                    new Point3f(-x/2f, 2.8f, (float) (0.0f - offset)),
                    new Point3f(-x/2f, 2.8f, (float) (0.0f - offset))
                }
			
        );
        rppi.setSchedulingBounds(bs);
        tg.addChild(rppi);
        return tg;
    }
	
	private Node setupLights() {
		AmbientLight ambientLight = new AmbientLight(
			true,
			new Color3f(1.0f, 1.0f, 1.0f)
		);
		ambientLight.setInfluencingBounds(bs);
		return ambientLight;
	}
	private ImageComponent2D getIC2D(String s) {
		ImageComponent2D ic2d = new ImageComponent2D(ImageComponent.FORMAT_RGB, 1, 1);
		try {
			BufferedImage bi = ImageIO.read(new URL("file:" + s));
			ic2d = new ImageComponent2D(
				ImageComponent.FORMAT_RGB,
				bi
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ic2d;
	}
	private Node createGrassStrip() {	
		QuadArray quadArray = new QuadArray(
			4,
			GeometryArray.COORDINATES |
			GeometryArray.NORMALS |
			GeometryArray.TEXTURE_COORDINATE_2
		);
		quadArray.setCoordinates(
			0,
			new Point3f[] {
				new Point3f(-x/2, y, 0),
				new Point3f(x/2, y, 0),
				new Point3f(x/2, y, -z),
				new Point3f(-x/2, y, -z)
			}
		);
		quadArray.setNormals(
			0,
			new Vector3f[] {
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f)
				}
		);
		quadArray.setTextureCoordinates(
			0,
			0,
			new TexCoord2f[] {
				new TexCoord2f(0.0f, 0.0f),
				new TexCoord2f(1.0f, 0.0f),
				new TexCoord2f(1.0f, 1.0f),
				new TexCoord2f(0.0f, 1.0f)
			}
		);
		TextureLoader textureLoader = new TextureLoader("grass.jpg", null);
		TextureAttributes textureAttributes = new TextureAttributes();
		textureAttributes.setTextureMode(
			TextureAttributes.MODULATE
		);
		Material material = new Material(
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(0.0f, 0.0f, 0.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			128f
		);
		Appearance appearance = new Appearance();
		appearance.setMaterial(material);
		appearance.setTexture(textureLoader.getTexture());
		appearance.setTextureAttributes(textureAttributes);
		Shape3D grass = new Shape3D();
		grass.addGeometry(quadArray);
		grass.setAppearance(appearance);
		return grass;
	}
	private Node createFinishLine() {	
		TransformGroup tg = new TransformGroup();
		int offset = ((numberOfLanes * z) + z);
		QuadArray quadArray = new QuadArray(
			4,
			GeometryArray.COORDINATES |
			GeometryArray.NORMALS |
			GeometryArray.TEXTURE_COORDINATE_2
		);
		quadArray.setCoordinates(
			0,
			new Point3f[] {
				new Point3f(-x/2, 0, 0 - offset),
				new Point3f(x/2, 0, 0 - offset),
				new Point3f(x/2, 0, -z - offset),
				new Point3f(-x/2, 0, -z - offset)
			}
		);
		quadArray.setNormals(
			0,
			new Vector3f[] {
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f)
				}
		);
		quadArray.setTextureCoordinates(
			0,
			0,
			new TexCoord2f[] {
				new TexCoord2f(0.0f, 0.0f),
				new TexCoord2f(1.0f, 0.0f),
				new TexCoord2f(0.0f, 0.0f),
				new TexCoord2f(1.0f, 0.0f)
			}
		);
		TextureLoader textureLoader = new TextureLoader("grass.jpg", null);
		TextureAttributes textureAttributes = new TextureAttributes();
		textureAttributes.setTextureMode(
			TextureAttributes.MODULATE
		);
		Material material = new Material(
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(0.0f, 0.0f, 0.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			128f
		);
		Appearance appearance = new Appearance();
		appearance.setMaterial(material);
		appearance.setTexture(textureLoader.getTexture());
		appearance.setTextureAttributes(textureAttributes);
		Shape3D s3d = new Shape3D();
		s3d.addGeometry(quadArray);
		s3d.setAppearance(appearance);
		return s3d;
	}
	private Node createLane(int offset) {	
		QuadArray quadArray = new QuadArray(
			4,
			GeometryArray.COORDINATES |
			GeometryArray.NORMALS |
			GeometryArray.TEXTURE_COORDINATE_2
		);
		quadArray.setCoordinates(
			0,
			new Point3f[] {
				new Point3f(-x/2, y, 0 - offset),
				new Point3f(x/2, y, 0 - offset),
				new Point3f(x/2, y, -z - offset),
				new Point3f(-x/2, y, -z - offset)
			}
		);
		quadArray.setNormals(
			0,
			new Vector3f[] {
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f),
					new Vector3f(0.0f, 1.0f, 0.0f)
				}
		);
		quadArray.setTextureCoordinates(
			0,
			0,
			new TexCoord2f[] {
				new TexCoord2f(0.0f, 0.0f),
				new TexCoord2f(1.0f, 0.0f),
				new TexCoord2f(1.0f, 1.0f),
				new TexCoord2f(0.0f, 1.0f)
			}
		);
		TextureLoader textureLoader = new TextureLoader("8x36.jpg", null);
		TextureAttributes textureAttributes = new TextureAttributes();
		textureAttributes.setTextureMode(
			TextureAttributes.MODULATE
		);
		Material material = new Material(
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(0.0f, 0.0f, 0.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			128f
		);
		Appearance appearance = new Appearance();
		appearance.setMaterial(material);
		appearance.setTexture(textureLoader.getTexture());
		appearance.setTextureAttributes(textureAttributes);
		Shape3D lane = new Shape3D();
		lane.addGeometry(quadArray);
		lane.setAppearance(appearance);
		return lane;
	}
	private TransformGroup addLanes(int numberOfLanes){
		TransformGroup lanes = new TransformGroup();
		int offset = z;
		for(int i = 1; i <= numberOfLanes; i++){
			lanes.addChild(createLane(offset * i));
			lanes.addChild(placeTruck((z/2 + (i) * 8 ), getSpeed(this.truckSpeed)));
		}
		return lanes;
	}
	private long getSpeed(int speedRange){
	int number = (int) (Math.random() * 10);
	while (number == 0){
		number = (int)(Math.random() * 10);
	}
	long speed = (long) (speedRange * number);
	return speed;
	}
}