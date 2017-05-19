package edu.mccc.cos210.br3d;

import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Geometry;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Group;
import javax.media.j3d.Material;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.TexCoord2f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.image.TextureLoader;
public class Truck extends Group {
	public Truck() {
		QuadArray[] qa = new QuadArray[10];
		for (int i = 0; i < qa.length; i++) {
			qa[i] = new QuadArray(
				4,
				QuadArray.COORDINATES |
				QuadArray.NORMALS |
				QuadArray.TEXTURE_COORDINATE_2
			);
			qa[i].setCapability(Geometry.ALLOW_INTERSECT);
			qa[i].setCapability(GeometryArray.ALLOW_COUNT_READ);
			qa[i].setCapability(GeometryArray.ALLOW_FORMAT_READ);
			qa[i].setCapability(GeometryArray.ALLOW_COORDINATE_READ);
		}
		//right side big box 0
		Point3f[] p3fR1 = new Point3f[4];
		p3fR1[0] = new Point3f(-4.0f, 2.0f, 2.0f);
		p3fR1[1] = new Point3f(-4.0f, -2.0f, 2.0f);
		p3fR1[2] = new Point3f(2.0f, -2.0f, 2.0f);
		p3fR1[3] = new Point3f(2.0f, 2.0f, 2.0f);
		//right side small box 1
		Point3f[] p3fR2 = new Point3f[4];
		p3fR2[0] = new Point3f(2.0f, 0.0f, 2.0f);
		p3fR2[1] = new Point3f(2.0f, -2.0f, 2.0f);
		p3fR2[2] = new Point3f(4.0f, -2.0f, 2.0f);
		p3fR2[3] = new Point3f(4.0f, 0.0f, 2.0f);
 		//left side big box 2
		Point3f[] p3fL1 = new Point3f[4];
		p3fL1[0] = new Point3f(2.0f, 2.0f, -2.0f);
		p3fL1[1] = new Point3f(2.0f, -2.0f, -2.0f);
		p3fL1[2] = new Point3f(-4.0f, -2.0f, -2.0f);
		p3fL1[3] = new Point3f(-4.0f, 2.0f, -2.0f);
 		//left side small box 3
		Point3f[] p3fL2 = new Point3f[4];
		p3fL2[0] = new Point3f(4.0f, 0.0f, -2.0f);
		p3fL2[1] = new Point3f(4.0f, -2.0f, -2.0f);
		p3fL2[2] = new Point3f(2.0f, -2.0f, -2.0f);
		p3fL2[3] = new Point3f(2.0f, 0.0f, -2.0f);
 		//top left box 4
		Point3f[] p3fTL = new Point3f[4];
		p3fTL[0] = new Point3f(-4.0f, 2.0f, -2.0f);
		p3fTL[1] = new Point3f(-4.0f, 2.0f, 2.0f);
		p3fTL[2] = new Point3f(2.0f, 2.0f, 2.0f);
		p3fTL[3] = new Point3f(2.0f, 2.0f, -2.0f);
 		//top right box (hood) 5
		Point3f[] p3fTR = new Point3f[4];
		p3fTR[0] = new Point3f(2.0f, 0.0f, -2.0f);
		p3fTR[1] = new Point3f(2.0f, 0.0f, 2.0f);
		p3fTR[2] = new Point3f(4.0f, 0.0f, 2.0f);
		p3fTR[3] = new Point3f(4.0f, 0.0f, -2.0f);
 		//bottom 6
		Point3f[] p3fB = new Point3f[4];
		p3fB[0] = new Point3f(-4.0f, -2.0f, 2.0f);
		p3fB[1] = new Point3f(-4.0f, -2.0f, -2.0f);
		p3fB[2] = new Point3f(4.0f, -2.0f, -2.0f);
		p3fB[3] = new Point3f(4.0f, -2.0f, 2.0f);
 		//back 7
		Point3f[] p3fBack = new Point3f[4];
		p3fBack[0] = new Point3f(-4.0f, 2.0f, -2.0f);
		p3fBack[1] = new Point3f(-4.0f, -2.0f, -2.0f);
		p3fBack[2] = new Point3f(-4.0f, -2.0f, 2.0f);
		p3fBack[3] = new Point3f(-4.0f, 2.0f, 2.0f);
 		//front top (windshield) 8
		Point3f[] p3fFT = new Point3f[4];
		p3fFT[0] = new Point3f(2.0f, 2.0f, 2.0f);
		p3fFT[1] = new Point3f(2.0f, 0.0f, 2.0f);
		p3fFT[2] = new Point3f(2.0f, 0.0f, -2.0f);
		p3fFT[3] = new Point3f(2.0f, 2.0f, -2.0f);
 		//front bottom (grill) 9
		Point3f[] p3fFB = new Point3f[4];
		p3fFB[0] = new Point3f(4.0f, 0.0f, 2.0f);
		p3fFB[1] = new Point3f(4.0f, -2.0f, 2.0f);
		p3fFB[2] = new Point3f(4.0f, -2.0f, -2.0f);
		p3fFB[3] = new Point3f(4.0f, 0.0f, -2.0f);
		qa[0].setCoordinates(0, p3fR1);
		qa[1].setCoordinates(0, p3fR2);
		qa[2].setCoordinates(0, p3fL1);
		qa[3].setCoordinates(0, p3fL2);
		qa[4].setCoordinates(0, p3fTL);
		qa[5].setCoordinates(0, p3fTR);
		qa[6].setCoordinates(0, p3fB);
		qa[7].setCoordinates(0, p3fBack);
		qa[8].setCoordinates(0, p3fFT);
		qa[9].setCoordinates(0, p3fFB);
		Vector3f[] npx = new Vector3f[4];
		for (int i = 0; i < 4; i++) {
			npx[i] = new Vector3f(1.0f, 0.0f, 0.0f);
		}
		Vector3f[] nmx = new Vector3f[4];
		for (int i = 0; i < 4; i++) {
			nmx[i] = new Vector3f(-1.0f, 0.0f, 0.0f);
		}
		Vector3f[] npy = new Vector3f[4];
		for (int i = 0; i < 4; i++) {
			npy[i] = new Vector3f(0.0f, 1.0f, 0.0f);
		}
		Vector3f[] nmy = new Vector3f[4];
		for (int i = 0; i < 4; i++) {
			nmy[i] = new Vector3f(0.0f, -1.0f, 0.0f);
		}
		Vector3f[] npz = new Vector3f[4];
		for (int i = 0; i < 4; i++) {
			npz[i] = new Vector3f(0.0f, 0.0f, 1.0f);
		}
		Vector3f[] nmz = new Vector3f[4];
		for (int i = 0; i < 4; i++) {
			nmz[i] = new Vector3f(0.0f, 0.0f, -1.0f);
		}
		Material m = new Material(
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(0.0f, 0.0f, 0.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			80.0f
		);
		TexCoord2f[] t0 = new TexCoord2f[4];
		t0[0] = new TexCoord2f(0.25f, 0.5f);
		t0[1] = new TexCoord2f(0.25f, 0.25f);
		t0[2] = new TexCoord2f(0.625f, 0.25f);
		t0[3] = new TexCoord2f(0.625f, 0.5f);
		TexCoord2f[] t1 = new TexCoord2f[4];
		t1[0] = new TexCoord2f(0.75f, 0.375f);
		t1[1] = new TexCoord2f(0.875f, 0.375f);
		t1[2] = new TexCoord2f(0.875f, 0.5f);
		t1[3] = new TexCoord2f(0.75f, 0.5f);
		TexCoord2f[] t2 = new TexCoord2f[4];
		t2[0] = new TexCoord2f(0.625f, 0.75f);
		t2[1] = new TexCoord2f(0.625f, 1.0f);
		t2[2] = new TexCoord2f(0.25f, 1.0f);
		t2[3] = new TexCoord2f(0.25f, 0.75f);
		TexCoord2f[] t3 = new TexCoord2f[4];
		t3[0] = new TexCoord2f(0.875f, 0.75f);
		t3[1] = new TexCoord2f(0.875f, 0.875f);
		t3[2] = new TexCoord2f(0.75f, 0.875f);
		t3[3] = new TexCoord2f(0.75f, 0.75f);
		TexCoord2f[] t4 = new TexCoord2f[4];
		t4[0] = new TexCoord2f(0.25f, 0.75f);
		t4[1] = new TexCoord2f(0.25f, 0.5f);
		t4[2] = new TexCoord2f(0.625f, 0.5f);
		t4[3] = new TexCoord2f(0.625f, 0.75f);
		TexCoord2f[] t5 = new TexCoord2f[4];
		t5[0] = new TexCoord2f(0.75f, 0.75f);
		t5[1] = new TexCoord2f(0.75f, 0.5f);
		t5[2] = new TexCoord2f(0.875f, 0.5f);
		t5[3] = new TexCoord2f(0.875f, 0.75f);
		TexCoord2f[] t6 = new TexCoord2f[4];
		t6[0] = new TexCoord2f(0.25f, 0.25f);
		t6[1] = new TexCoord2f(0.25f, 0.0f);
		t6[2] = new TexCoord2f(0.75f, 0.0f);
		t6[3] = new TexCoord2f(0.75f, 0.25f);
		TexCoord2f[] t7 = new TexCoord2f[4];
		t7[0] = new TexCoord2f(0.25f, 0.75f);
		t7[1] = new TexCoord2f(0.0f, 0.75f);
		t7[2] = new TexCoord2f(0.0f, 0.5f);
		t7[3] = new TexCoord2f(0.25f, 0.5f);
		TexCoord2f[] t8 = new TexCoord2f[4];
		t8[0] = new TexCoord2f(0.625f, 0.5f);
		t8[1] = new TexCoord2f(0.75f, 0.5f);
		t8[2] = new TexCoord2f(0.75f, 0.75f);
		t8[3] = new TexCoord2f(0.625f, 0.75f);
		TexCoord2f[] t9 = new TexCoord2f[4];
		t9[0] = new TexCoord2f(0.875f, 0.5f);
		t9[1] = new TexCoord2f(1.0f, 0.5f);
		t9[2] = new TexCoord2f(1.0f, 0.75f);
		t9[3] = new TexCoord2f(0.875f, 0.75f);
		qa[0].setNormals(0, npz);
		qa[1].setNormals(0, npz);
		qa[2].setNormals(0, nmz);
		qa[3].setNormals(0, nmz);
		qa[4].setNormals(0, npy);
		qa[5].setNormals(0, npy);
		qa[6].setNormals(0, nmy);
		qa[7].setNormals(0, nmx);
		qa[8].setNormals(0, npx);
		qa[9].setNormals(0, npx);
		qa[0].setTextureCoordinates(0, 0, t0);
		qa[1].setTextureCoordinates(0, 0, t1);
		qa[2].setTextureCoordinates(0, 0, t2);
		qa[3].setTextureCoordinates(0, 0, t3);
		qa[4].setTextureCoordinates(0, 0, t4);
		qa[5].setTextureCoordinates(0, 0, t5);
		qa[6].setTextureCoordinates(0, 0, t6);
		qa[7].setTextureCoordinates(0, 0, t7);
		qa[8].setTextureCoordinates(0, 0, t8);
		qa[9].setTextureCoordinates(0, 0, t9);
		Appearance a = new Appearance();
		a.setMaterial(m);
		Shape3D s3d = new Shape3D();
		s3d.setCapability(Shape3D.ALLOW_GEOMETRY_READ);
		for (int i = 0; i < qa.length; i++) {
			s3d.addGeometry(qa[i]);
		}
		int counter = (int)(Math.random() * 10);
		while (counter > 4){
			counter = (int)(Math.random() * 10);
		}
		TextureLoader tl = new TextureLoader("truck" + counter + ".jpg", null);
		a.setTexture(tl.getTexture());
		TextureAttributes ta = new TextureAttributes();
		ta.setTextureMode(
			TextureAttributes.MODULATE
		);
		a.setTextureAttributes(ta);
		s3d.setAppearance(a);
		addChild(s3d);
		//right front tire
		TransformGroup tgt = new TransformGroup();
		Transform3D tt = new Transform3D();
		tgt.getTransform(tt);
		tt.setRotation(new AxisAngle4f(1.0f, 0.0f, 0.0f, (float) (Math.PI / 2.0)));
		tt.setTranslation(new Vector3f(3.0f, -2.0f, 2.25f));
		tgt.setTransform(tt);
		Appearance atire = new Appearance();
		atire.setColoringAttributes(new ColoringAttributes(new Color3f(), ColoringAttributes.FASTEST));
		Cylinder c = new Cylinder(0.75f, 0.5f, Primitive.ENABLE_GEOMETRY_PICKING, atire);
		tgt.addChild(c);
		addChild(tgt);
		//right rear tire
		TransformGroup tgt2 = new TransformGroup();
		Transform3D tt2 = new Transform3D();
		tgt2.getTransform(tt2);
		tt2.setRotation(new AxisAngle4f(1.0f, 0.0f, 0.0f, (float) (Math.PI / 2.0)));
		tt2.setTranslation(new Vector3f(-2.0f, -2.0f, 2.25f));
		tgt2.setTransform(tt2);
		Cylinder c2 = new Cylinder(0.75f, 0.5f, Primitive.ENABLE_GEOMETRY_PICKING, atire);
		tgt2.addChild(c2);
		addChild(tgt2);
		//left front tire
		TransformGroup tgt3 = new TransformGroup();
		Transform3D tt3 = new Transform3D();
		tgt3.getTransform(tt3);
		tt3.setRotation(new AxisAngle4f(1.0f, 0.0f, 0.0f, (float) (Math.PI / 2.0)));
		tt3.setTranslation(new Vector3f(3.0f, -2.0f, -2.25f));
		tgt3.setTransform(tt3);
		Cylinder c3 = new Cylinder(0.75f, 0.5f, Primitive.ENABLE_GEOMETRY_PICKING, atire);
		tgt3.addChild(c3);
		addChild(tgt3);
		//left rear tire
		TransformGroup tgt4 = new TransformGroup();
		Transform3D tt4 = new Transform3D();
		tgt4.getTransform(tt4);
		tt4.setRotation(new AxisAngle4f(1.0f, 0.0f, 0.0f, (float) (Math.PI / 2.0)));
		tt4.setTranslation(new Vector3f(-2.0f, -2.0f, -2.25f));
		tgt4.setTransform(tt4);
		Cylinder c4 = new Cylinder(0.75f, 0.5f, Primitive.ENABLE_GEOMETRY_PICKING, atire);
		tgt4.addChild(c4);
		addChild(tgt4);
		Material msp = new Material(
			new Color3f(0.7f, 0.7f, 0.7f),
			new Color3f(0.0f, 0.0f, 0.0f),
			new Color3f(0.7f, 0.7f, 0.7f),
			new Color3f(1.0f, 1.0f, 1.0f),
			128.0f
		);
		Appearance asp = new Appearance();
		asp.setMaterial(msp);
		TransformGroup tgsp1 = new TransformGroup();
		Box sp1 = new Box(0.1f, 0.1f, 2f, Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS | Primitive.ENABLE_GEOMETRY_PICKING, asp);
		Transform3D t3dsp1 = new Transform3D();
		tgsp1.getTransform(t3dsp1);
		t3dsp1.setTranslation(new Vector3f(-3.9f, 2.3f, 0.0f));
		tgsp1.setTransform(t3dsp1);
		tgsp1.addChild(sp1);
		addChild(tgsp1);
		TransformGroup tgsp2 = new TransformGroup();
		Box sp2 = new Box(0.1f, 0.1f, 0.1f, Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS | Primitive.ENABLE_GEOMETRY_PICKING, asp);
		Transform3D t3dsp2 = new Transform3D();
		tgsp2.getTransform(t3dsp2);
		t3dsp2.setTranslation(new Vector3f(-3.9f, 2.1f, 1.9f));
		tgsp2.setTransform(t3dsp2);
		tgsp2.addChild(sp2);
		addChild(tgsp2);
		TransformGroup tgsp3 = new TransformGroup();
		Box sp3 = new Box(0.1f, 0.1f, 0.1f, Primitive.GENERATE_NORMALS | Primitive.GENERATE_TEXTURE_COORDS | Primitive.ENABLE_GEOMETRY_PICKING, asp);
		Transform3D t3dsp3 = new Transform3D();
		tgsp3.getTransform(t3dsp3);
		t3dsp3.setTranslation(new Vector3f(-3.9f, 2.1f, -1.9f));
		tgsp3.setTransform(t3dsp3);
		tgsp3.addChild(sp3);
		addChild(tgsp3);
	}
}
