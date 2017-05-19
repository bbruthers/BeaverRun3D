package edu.mccc.cos210.br3d;
import javax.media.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Bounds;
import javax.media.j3d.Geometry;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Group;
import javax.media.j3d.Material;
import javax.media.j3d.PositionInterpolator;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.TexCoord2f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.image.TextureLoader;
public class Beaver extends Group {
	TransformGroup tgl;
	TransformGroup tgr;
	private Bounds infiniteBounds = new BoundingSphere(
		new Point3d(0.0, 0.0, 0.0),
		Double.MAX_VALUE
	);
	public Beaver() {
		QuadArray[] qa = new QuadArray[29];
		for (int i = 0; i < qa.length; i++) {
			qa[i] = new QuadArray(
				4,
				QuadArray.COORDINATES |
					QuadArray.NORMALS |
					GeometryArray.TEXTURE_COORDINATE_2
			);
			qa[i].setCapability(Geometry.ALLOW_INTERSECT);
			qa[i].setCapability(GeometryArray.ALLOW_COUNT_READ);
			qa[i].setCapability(GeometryArray.ALLOW_FORMAT_READ);
			qa[i].setCapability(GeometryArray.ALLOW_COORDINATE_READ);
		}
		QuadArray[] qal = new QuadArray[10];
		for (int i = 0; i < qal.length; i++) {
			qal[i] = new QuadArray(
				4,
				QuadArray.COORDINATES |
					QuadArray.NORMALS |
					GeometryArray.TEXTURE_COORDINATE_2
			);
			qal[i].setCapability(Geometry.ALLOW_INTERSECT);
			qal[i].setCapability(GeometryArray.ALLOW_COUNT_READ);
			qal[i].setCapability(GeometryArray.ALLOW_FORMAT_READ);
			qal[i].setCapability(GeometryArray.ALLOW_COORDINATE_READ);
		}
		QuadArray[] qar = new QuadArray[10];
		for (int i = 0; i < qar.length; i++) {
			qar[i] = new QuadArray(
				4,
				QuadArray.COORDINATES |
					QuadArray.NORMALS |
					GeometryArray.TEXTURE_COORDINATE_2
			);
			qar[i].setCapability(Geometry.ALLOW_INTERSECT);
			qar[i].setCapability(GeometryArray.ALLOW_COUNT_READ);
			qar[i].setCapability(GeometryArray.ALLOW_FORMAT_READ);
			qar[i].setCapability(GeometryArray.ALLOW_COORDINATE_READ);
		}
		//front body 0
		Point3f[] p3fFB = new Point3f[4];
		p3fFB[0] = new Point3f(-0.3f, 0.8f, 0.1f);
		p3fFB[1] = new Point3f(-0.3f, 0.2f, 0.1f);
		p3fFB[2] = new Point3f(0.3f, 0.2f, 0.1f);
		p3fFB[3] = new Point3f(0.3f, 0.8f, 0.1f);
		//back body 1
		Point3f[] p3fBB = new Point3f[4];
		p3fBB[0] = new Point3f(0.3f, 0.8f, -0.1f);
		p3fBB[1] = new Point3f(0.3f, 0.2f, -0.1f);
		p3fBB[2] = new Point3f(-0.3f, 0.2f, -0.1f);
		p3fBB[3] = new Point3f(-0.3f, 0.8f, -0.1f);
		//body right side 2
		Point3f[] p3fBRS = new Point3f[4];
		p3fBRS[0] = new Point3f(-0.3f, 0.8f, -0.1f);
		p3fBRS[1] = new Point3f(-0.3f, 0.2f, -0.1f);
		p3fBRS[2] = new Point3f(-0.3f, 0.2f, 0.1f);
		p3fBRS[3] = new Point3f(-0.3f, 0.8f, 0.1f);
		//body left side 3
		Point3f[] p3fBLS = new Point3f[4];
		p3fBLS[0] = new Point3f(0.3f, 0.8f, 0.1f);
		p3fBLS[1] = new Point3f(0.3f, 0.2f, 0.1f);
		p3fBLS[2] = new Point3f(0.3f, 0.2f, -0.1f);
		p3fBLS[3] = new Point3f(0.3f, 0.8f, -0.1f);
		//body top 4
		Point3f[] p3fBT = new Point3f[4];
		p3fBT[0] = new Point3f(-0.3f, 0.8f, -0.1f);
		p3fBT[1] = new Point3f(-0.3f, 0.8f, 0.1f);
		p3fBT[2] = new Point3f(0.3f, 0.8f, 0.1f);
		p3fBT[3] = new Point3f(0.3f, 0.8f, -0.1f);
		//body bottom 5
		Point3f[] p3fBBot = new Point3f[4];
		p3fBBot[0] = new Point3f(0.3f, 0.2f, -0.1f);
		p3fBBot[1] = new Point3f(0.3f, 0.2f, 0.1f);
		p3fBBot[2] = new Point3f(-0.3f, 0.2f, 0.1f);
		p3fBBot[3] = new Point3f(-0.3f, 0.2f, -0.1f);
		//head front 6
		Point3f[] p3fHF = new Point3f[4];
		p3fHF[0] = new Point3f(-0.1f, 1.0f, 0.2f);
		p3fHF[1] = new Point3f(-0.1f, 0.8f, 0.2f);
		p3fHF[2] = new Point3f(0.1f, 0.8f, 0.2f);
		p3fHF[3] = new Point3f(0.1f, 1.0f, 0.2f);
		//head back 7
		Point3f[] p3fHB = new Point3f[4];
		p3fHB[0] = new Point3f(0.1f, 1.0f, -0.2f);
		p3fHB[1] = new Point3f(0.1f, 0.8f, -0.2f);
		p3fHB[2] = new Point3f(-0.1f, 0.8f, -0.2f);
		p3fHB[3] = new Point3f(-0.1f, 1.0f, -0.2f);
		//head right side 8
		Point3f[] p3fHRS = new Point3f[4];
		p3fHRS[0] = new Point3f(-0.1f, 1.0f, -0.2f);
		p3fHRS[1] = new Point3f(-0.1f, 0.8f, -0.2f);
		p3fHRS[2] = new Point3f(-0.1f, 0.8f, 0.2f);
		p3fHRS[3] = new Point3f(-0.1f, 1.0f, 0.2f);
		//head left side 9
		Point3f[] p3fHLS = new Point3f[4];
		p3fHLS[0] = new Point3f(0.1f, 1.0f, 0.2f);
		p3fHLS[1] = new Point3f(0.1f, 0.8f, 0.2f);
		p3fHLS[2] = new Point3f(0.1f, 0.8f, -0.2f);
		p3fHLS[3] = new Point3f(0.1f, 1.0f, -0.2f);
		//head top 10
		Point3f[] p3fHT = new Point3f[4];
		p3fHT[0] = new Point3f(-0.1f, 1.0f, -0.2f);
		p3fHT[1] = new Point3f(-0.1f, 1.0f, 0.2f);
		p3fHT[2] = new Point3f(0.1f, 1.0f, 0.2f);
		p3fHT[3] = new Point3f(0.1f, 1.0f, -0.2f);
		//head bottom 11 were backwards
		Point3f[] p3fHBot = new Point3f[4];
		p3fHBot[0] = new Point3f(0.1f, 0.8f, -0.2f);
		p3fHBot[1] = new Point3f(0.1f, 0.8f, 0.2f);
		p3fHBot[2] = new Point3f(-0.1f, 0.8f, 0.2f);
		p3fHBot[3] = new Point3f(-0.1f, 0.8f, -0.2f);
		//right leg front  12
		Point3f[] p3fLFR = new Point3f[4];
		p3fLFR[0] = new Point3f(-0.2f, 0.2f, 0.05f);
		p3fLFR[1] = new Point3f(-0.2f, 0.1f, 0.05f);
		p3fLFR[2] = new Point3f(-0.1f, 0.1f, 0.05f);
  		p3fLFR[3] = new Point3f(-0.1f, 0.2f, 0.05f);
		//right leg back  13
		Point3f[] p3fLBR = new Point3f[4];
  		p3fLBR[0] = new Point3f(-0.1f, 0.2f, -0.05f);
		p3fLBR[1] = new Point3f(-0.1f, 0.1f, -0.05f);
		p3fLBR[2] = new Point3f(-0.2f, 0.1f, -0.05f);
		p3fLBR[3] = new Point3f(-0.2f, 0.2f, -0.05f);
		//right leg right side 14
		Point3f[] p3fRLRS = new Point3f[4];
  		p3fRLRS[0] = new Point3f(-0.2f, 0.2f, -0.05f);
		p3fRLRS[1] = new Point3f(-0.2f, 0.1f, -0.05f);
		p3fRLRS[2] = new Point3f(-0.2f, 0.1f, 0.05f);
		p3fRLRS[3] = new Point3f(-0.2f, 0.2f, 0.05f);
		//right leg left side 15
		Point3f[] p3fRLLS = new Point3f[4];
  		p3fRLLS[0] = new Point3f(-0.1f, 0.2f, 0.05f);
		p3fRLLS[1] = new Point3f(-0.1f, 0.1f, 0.05f);
		p3fRLLS[2] = new Point3f(-0.1f, 0.1f, -0.05f);
		p3fRLLS[3] = new Point3f(-0.1f, 0.2f, -0.05f);
		//left leg front 16
		Point3f[] p3fLLF = new Point3f[4];
  		p3fLLF[0] = new Point3f(0.1f, 0.2f, 0.05f);
		p3fLLF[1] = new Point3f(0.1f, 0.1f, 0.05f);
		p3fLLF[2] = new Point3f(0.2f, 0.1f, 0.05f);
		p3fLLF[3] = new Point3f(0.2f, 0.2f, 0.05f);
		//left leg back 17
		Point3f[] p3fLLB = new Point3f[4];
  		p3fLLB[0] = new Point3f(0.2f, 0.2f, -0.05f);
		p3fLLB[1] = new Point3f(0.2f, 0.1f, -0.05f);
		p3fLLB[2] = new Point3f(0.1f, 0.1f, -0.05f);
		p3fLLB[3] = new Point3f(0.1f, 0.2f, -0.05f);
		//left leg right side 18
		Point3f[] p3fLLRS = new Point3f[4];
		p3fLLRS[0] = new Point3f(0.1f, 0.2f, -0.05f);
		p3fLLRS[1] = new Point3f(0.1f, 0.1f, -0.05f);
		p3fLLRS[2] = new Point3f(0.1f, 0.1f, 0.05f);
  		p3fLLRS[3] = new Point3f(0.1f, 0.2f, 0.05f);
		//left leg left side 19
		Point3f[] p3fLLLS = new Point3f[4];
  		p3fLLLS[0] = new Point3f(0.2f, 0.2f, 0.05f);
		p3fLLLS[1] = new Point3f(0.2f, 0.1f, 0.05f);
		p3fLLLS[2] = new Point3f(0.2f, 0.1f, -0.05f);
		p3fLLLS[3] = new Point3f(0.2f, 0.2f, -0.05f);
		//right foot front 20
		Point3f[] p3fRFF = new Point3f[4];
  		p3fRFF[0] = new Point3f(-0.2f, 0.1f, 0.2f);
		p3fRFF[1] = new Point3f(-0.2f, 0.0f, 0.2f);
		p3fRFF[2] = new Point3f(-0.1f, 0.0f, 0.2f);
		p3fRFF[3] = new Point3f(-0.1f, 0.1f, 0.2f);
		//right foot back 21
		Point3f[] p3fRFB = new Point3f[4];
  		p3fRFB[0] = new Point3f(-0.1f, 0.1f, -0.05f);
		p3fRFB[1] = new Point3f(-0.1f, 0.0f, -0.05f);
		p3fRFB[2] = new Point3f(-0.2f, 0.0f, -0.05f);
		p3fRFB[3] = new Point3f(-0.2f, 0.1f, -0.05f);
		//right foot right side 22
		Point3f[] p3fRFRS = new Point3f[4];
		p3fRFRS[0] = new Point3f(-0.2f, 0.1f, -0.05f);
		p3fRFRS[1] = new Point3f(-0.2f, 0.0f, -0.05f);
		p3fRFRS[2] = new Point3f(-0.2f, 0.0f, 0.2f);
		p3fRFRS[3] = new Point3f(-0.2f, 0.1f, 0.2f);
		//right foot left side 23
		Point3f[] p3fRFLS = new Point3f[4];
		p3fRFLS[0] = new Point3f(-0.1f, 0.1f, 0.2f);
		p3fRFLS[1] = new Point3f(-0.1f, 0.0f, 0.2f);
		p3fRFLS[2] = new Point3f(-0.1f, 0.0f, -0.05f);
		p3fRFLS[3] = new Point3f(-0.1f, 0.1f, -0.05f);
		//right foot top 24
		Point3f[] p3fRFT = new Point3f[4];
		p3fRFT[0] = new Point3f(-0.1f, 0.1f, -0.05f);
		p3fRFT[1] = new Point3f(-0.2f, 0.1f, -0.05f);
		p3fRFT[2] = new Point3f(-0.2f, 0.1f, 0.2f);
		p3fRFT[3] = new Point3f(-0.1f, 0.1f, 0.2f);
		//right foot bottom 25
		Point3f[] p3fRFBot = new Point3f[4];
		p3fRFBot[0] = new Point3f(-0.2f, 0.0f, -0.05f);
		p3fRFBot[1] = new Point3f(-0.1f, 0.0f, -0.05f);
		p3fRFBot[2] = new Point3f(-0.1f, 0.0f, 0.2f);
		p3fRFBot[3] = new Point3f(-0.2f, 0.0f, 0.2f);
		//left foot front 26
		Point3f[] p3fLFF = new Point3f[4];
  		p3fLFF[3] = new Point3f(0.2f, 0.1f, 0.2f);
		p3fLFF[2] = new Point3f(0.2f, 0.0f, 0.2f);
		p3fLFF[1] = new Point3f(0.1f, 0.0f, 0.2f);
		p3fLFF[0] = new Point3f(0.1f, 0.1f, 0.2f);
		//left foot back 27
		Point3f[] p3fLFB = new Point3f[4];
  		p3fLFB[3] = new Point3f(0.1f, 0.1f, -0.05f);
		p3fLFB[2] = new Point3f(0.1f, 0.0f, -0.05f);
		p3fLFB[1] = new Point3f(0.2f, 0.0f, -0.05f);
		p3fLFB[0] = new Point3f(0.2f, 0.1f, -0.05f);
		//left foot right side 28
		Point3f[] p3fLFRS = new Point3f[4];
		p3fLFRS[3] = new Point3f(0.1f, 0.1f, 0.2f);
		p3fLFRS[2] = new Point3f(0.1f, 0.0f, 0.2f);
		p3fLFRS[1] = new Point3f(0.1f, 0.0f, -0.05f);
		p3fLFRS[0] = new Point3f(0.1f, 0.1f, -0.05f);
		//left foot left side 29
		Point3f[] p3fLFLS = new Point3f[4];
		p3fLFLS[3] = new Point3f(0.2f, 0.1f, -0.05f);
		p3fLFLS[2] = new Point3f(0.2f, 0.0f, -0.05f);
		p3fLFLS[1] = new Point3f(0.2f, 0.0f, 0.2f);
		p3fLFLS[0] = new Point3f(0.2f, 0.1f, 0.2f);
		//left foot top 30
		Point3f[] p3fLFT = new Point3f[4];
		p3fLFT[3] = new Point3f(0.1f, 0.1f, -0.05f);
		p3fLFT[2] = new Point3f(0.2f, 0.1f, -0.05f);
		p3fLFT[1] = new Point3f(0.2f, 0.1f, 0.2f);
		p3fLFT[0] = new Point3f(0.1f, 0.1f, 0.2f);
		//left foot bottom 31
		Point3f[] p3fLFBot = new Point3f[4];
		p3fLFBot[3] = new Point3f(0.2f, 0.0f, -0.05f);
		p3fLFBot[2] = new Point3f(0.1f, 0.0f, -0.05f);
		p3fLFBot[1] = new Point3f(0.1f, 0.0f, 0.2f);
		p3fLFBot[0] = new Point3f(0.2f, 0.0f, 0.2f);
		//array location 32 is not being used
		//Tail Right side  33
		Point3f[] p3fTRS = new Point3f[4];
		p3fTRS[0] = new Point3f(-0.1f, 0.65f, -0.45f);
		p3fTRS[1] = new Point3f(-0.1f, 0.6f, -0.5f);
		p3fTRS[2] = new Point3f(-0.1f, 0.2f, -0.1f);
		p3fTRS[3] = new Point3f(-0.1f, 0.25f, -0.05f);
		//Tail back 34
		Point3f[] p3fTailBack = new Point3f[4];
		p3fTailBack[0] = new Point3f(-0.1f, 0.6f, -0.5f);
		p3fTailBack[1] = new Point3f(0.1f, 0.6f, -0.5f);
		p3fTailBack[2] = new Point3f(0.1f, 0.2f, -0.1f);
		p3fTailBack[3] = new Point3f(-0.1f, 0.2f, -0.1f);
		//Tail Left side 35
		Point3f[] p3fTLS = new Point3f[4];
		p3fTLS[0] = new Point3f(0.1f, 0.65f, -0.45f);
		p3fTLS[1] = new Point3f(0.1f, 0.25f, -0.05f);
		p3fTLS[2] = new Point3f(0.1f, 0.2f, -0.1f);
		p3fTLS[3] = new Point3f(0.1f, 0.6f, -0.5f);
		//Tail Back(Upper Portion) 36
		Point3f[] p3fTailBackUp = new Point3f[4];
		p3fTailBackUp[0] = new Point3f(0.1f, 0.65f, -0.45f);
		p3fTailBackUp[1] = new Point3f(-0.1f, 0.65f, -0.45f);
		p3fTailBackUp[2] = new Point3f(-0.1f, 0.25f, -0.05f);
		p3fTailBackUp[3] = new Point3f(0.1f, 0.25f, -0.05f);
		//Tail Tip 37
		Point3f[] p3fTailTip = new Point3f[4];
		p3fTailTip[0] = new Point3f(-0.1f, 0.65f, -0.45f);
		p3fTailTip[1] = new Point3f(0.1f, 0.65f, -0.45f);
		p3fTailTip[2] = new Point3f(0.1f, 0.6f, -0.5f);
		p3fTailTip[3] = new Point3f(-0.1f, 0.6f, -0.5f);
		//right tooth front 38
		Point3f[] p3fRTF = new Point3f[4];
		p3fRTF[0] = new Point3f(-0.075f, 0.85f, 0.225f);
		p3fRTF[1] = new Point3f(-0.075f, 0.75f, 0.225f);
		p3fRTF[2] = new Point3f(-0.025f, 0.75f, 0.225f);
		p3fRTF[3] = new Point3f(-0.025f, 0.85f, 0.225f);
		//right tooth back 39
		Point3f[] p3fRTB = new Point3f[4];
		p3fRTB[0] = new Point3f(-0.025f, 0.85f, 0.2f);
		p3fRTB[1] = new Point3f(-0.025f, 0.75f, 0.2f);
		p3fRTB[2] = new Point3f(-0.075f, 0.75f, 0.2f);
		p3fRTB[3] = new Point3f(-0.075f, 0.85f, 0.2f);
		//right tooth right side 40
		Point3f[] p3fRTRS = new Point3f[4];
		p3fRTRS[0] = new Point3f(-0.075f, 0.85f, 0.2f);
		p3fRTRS[1] = new Point3f(-0.075f, 0.75f, 0.2f);
		p3fRTRS[2] = new Point3f(-0.075f, 0.75f, 0.225f);
		p3fRTRS[3] = new Point3f(-0.075f, 0.85f, 0.225f);
		//right tooth left side 41
		Point3f[] p3fRTLS = new Point3f[4];
		p3fRTLS[0] = new Point3f(-0.025f, 0.85f, 0.225f);
		p3fRTLS[1] = new Point3f(-0.025f, 0.75f, 0.225f);
		p3fRTLS[2] = new Point3f(-0.025f, 0.75f, 0.2f);
		p3fRTLS[3] = new Point3f(-0.025f, 0.85f, 0.2f);
		//right tooth top 42
		Point3f[] p3fRTT = new Point3f[4];
		p3fRTT[0] = new Point3f(-0.075f, 0.85f, 0.2f);
		p3fRTT[1] = new Point3f(-0.075f, 0.85f, 0.225f);
		p3fRTT[2] = new Point3f(-0.025f, 0.85f, 0.225f);
		p3fRTT[3] = new Point3f(-0.025f, 0.85f, 0.2f);
		//right tooth bottom 43
		Point3f[] p3fRTBot = new Point3f[4];
		p3fRTBot[3] = new Point3f(-0.075f, 0.75f, 0.2f);
		p3fRTBot[2] = new Point3f(-0.075f, 0.75f, 0.225f);
		p3fRTBot[1] = new Point3f(-0.025f, 0.75f, 0.225f);
		p3fRTBot[0] = new Point3f(-0.025f, 0.75f, 0.2f);
		//left tooth front 44
		Point3f[] p3fLTF = new Point3f[4];
		p3fLTF[0] = new Point3f(0.025f, 0.85f, 0.225f);
		p3fLTF[1] = new Point3f(0.025f, 0.75f, 0.225f);
		p3fLTF[2] = new Point3f(0.075f, 0.75f, 0.225f);
		p3fLTF[3] = new Point3f(0.075f, 0.85f, 0.225f);
		//left tooth back 45
		Point3f[] p3fLTB = new Point3f[4];
		p3fLTB[0] = new Point3f(0.075f, 0.85f, 0.2f);
		p3fLTB[1] = new Point3f(0.075f, 0.75f, 0.2f);
		p3fLTB[2] = new Point3f(0.025f, 0.75f, 0.2f);
		p3fLTB[3] = new Point3f(0.025f, 0.85f, 0.2f);
		//left tooth right side 46
		Point3f[] p3fLTRS = new Point3f[4];
		p3fLTRS[0] = new Point3f(0.075f, 0.85f, 0.2f);
		p3fLTRS[1] = new Point3f(0.075f, 0.75f, 0.2f);
		p3fLTRS[2] = new Point3f(0.075f, 0.75f, 0.225f);
		p3fLTRS[3] = new Point3f(0.075f, 0.85f, 0.225f);
		//left tooth left side 47
		Point3f[] p3fLTLS = new Point3f[4];
		p3fLTLS[0] = new Point3f(0.025f, 0.85f, 0.225f);
		p3fLTLS[1] = new Point3f(0.025f, 0.75f, 0.225f);
		p3fLTLS[2] = new Point3f(0.025f, 0.75f, 0.2f);
		p3fLTLS[3] = new Point3f(0.025f, 0.85f, 0.2f);
		//left tooth top 48
		Point3f[] p3fLTT = new Point3f[4];
		p3fLTT[3] = new Point3f(0.075f, 0.85f, 0.2f);
		p3fLTT[2] = new Point3f(0.075f, 0.85f, 0.225f);
		p3fLTT[1] = new Point3f(0.025f, 0.85f, 0.225f);
		p3fLTT[0] = new Point3f(0.025f, 0.85f, 0.2f);
		//left tooth bottom 49
		Point3f[] p3fLTBot = new Point3f[4];
		p3fLTBot[0] = new Point3f(0.075f, 0.75f, 0.2f);
		p3fLTBot[1] = new Point3f(0.075f, 0.75f, 0.225f);
		p3fLTBot[2] = new Point3f(0.025f, 0.75f, 0.225f);
		p3fLTBot[3] = new Point3f(0.025f, 0.75f, 0.2f);

	 	qa[0].setCoordinates(0, p3fFB);
		qa[1].setCoordinates(0, p3fBB);
		qa[2].setCoordinates(0, p3fBRS);
		qa[3].setCoordinates(0, p3fBLS);
		qa[4].setCoordinates(0, p3fBT);
		qa[5].setCoordinates(0, p3fBBot);
		qa[6].setCoordinates(0, p3fHF);
		qa[7].setCoordinates(0, p3fHB);
		qa[8].setCoordinates(0, p3fHRS);
		qa[9].setCoordinates(0, p3fHLS);
		qa[10].setCoordinates(0, p3fHT);
		qa[11].setCoordinates(0, p3fHBot);
		qar[6].setCoordinates(0, p3fLFR);
		qar[7].setCoordinates(0, p3fLBR);
		qar[8].setCoordinates(0, p3fRLRS);
		qar[9].setCoordinates(0, p3fRLLS);
		qal[6].setCoordinates(0, p3fLLF);
		qal[7].setCoordinates(0, p3fLLB);
		qal[8].setCoordinates(0, p3fLLRS);
		qal[9].setCoordinates(0, p3fLLLS);
		qar[0].setCoordinates(0, p3fRFF);
		qar[1].setCoordinates(0, p3fRFB);
		qar[2].setCoordinates(0, p3fRFRS);
		qar[3].setCoordinates(0, p3fRFLS);
		qar[4].setCoordinates(0, p3fRFT);
		qar[5].setCoordinates(0, p3fRFBot);
		qal[0].setCoordinates(0, p3fLFF);
		qal[1].setCoordinates(0, p3fLFB);
		qal[2].setCoordinates(0, p3fLFRS);
		qal[3].setCoordinates(0, p3fLFLS);
		qal[4].setCoordinates(0, p3fLFT);
		qal[5].setCoordinates(0, p3fLFBot);
		qa[12].setCoordinates(0, p3fTRS);
		qa[13].setCoordinates(0, p3fTailBack);
		qa[14].setCoordinates(0, p3fTLS);
		qa[15].setCoordinates(0, p3fTailBackUp);
		qa[16].setCoordinates(0, p3fTailTip);
		qa[17].setCoordinates(0, p3fRTF);
		qa[18].setCoordinates(0, p3fRTB);
		qa[19].setCoordinates(0, p3fRTRS);
		qa[20].setCoordinates(0, p3fRTLS);
		qa[21].setCoordinates(0, p3fRTT);
		qa[22].setCoordinates(0, p3fRTBot);
		qa[23].setCoordinates(0, p3fLTF);
		qa[24].setCoordinates(0, p3fLTB);
		qa[25].setCoordinates(0, p3fLTRS);
		qa[26].setCoordinates(0, p3fLTLS);
		qa[27].setCoordinates(0, p3fLTT);
		qa[28].setCoordinates(0, p3fLTBot);

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
		Vector3f[] nbd = new Vector3f[4];		// normals, backward-down
		for (int i = 0; i < 4; i++) {
			nbd[i] = new Vector3f(0.0f, -0.707f, -0.707f);
		}
		Vector3f[] nfu = new Vector3f[4];		// normals, forward-upward
		for (int i = 0; i < 4; i++) {
			nfu[i] = new Vector3f(0.0f, 0.707f, 0.707f);
		}
		Vector3f[] nbu = new Vector3f[4];		// normals, backward-upward
		for (int i = 0; i < 4; i++) {
			nbu[i] = new Vector3f(0.0f, 0.707f, -0.707f);
		}

		Material m = new Material(
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(0.0f, 0.0f, 0.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			new Color3f(1.0f, 1.0f, 1.0f),
			80.0f
		);

		TexCoord2f[] t0 = new TexCoord2f[4];
		t0[0] = new TexCoord2f(0.0625f, 0.25f);
		t0[1] = new TexCoord2f(0.0625f, 0.0625f);
		t0[2] = new TexCoord2f(0.25f, 0.0625f);
		t0[3] = new TexCoord2f(0.25f, 0.25f);
		TexCoord2f[] t1 = new TexCoord2f[4];
		t1[0] = new TexCoord2f(0.3125f, 0.25f);
		t1[1] = new TexCoord2f(0.3125f, 0.0625f);
		t1[2] = new TexCoord2f(0.5f, 0.0625f);
		t1[3] = new TexCoord2f(0.5f, 0.25f);
		TexCoord2f[] t2 = new TexCoord2f[4];
		t2[0] = new TexCoord2f(0.0f, 0.25f);
		t2[1] = new TexCoord2f(0.0f, 0.0625f);
		t2[2] = new TexCoord2f(0.0625f, 0.0625f);
		t2[3] = new TexCoord2f(0.0625f, 0.25f);
		TexCoord2f[] t3 = new TexCoord2f[4];
		t3[0] = new TexCoord2f(0.25f, 0.25f);
		t3[1] = new TexCoord2f(0.25f, 0.0625f);
		t3[2] = new TexCoord2f(0.3125f, 0.0625f);
		t3[3] = new TexCoord2f(0.3125f, 0.25f);
		TexCoord2f[] t4 = new TexCoord2f[4];
		t4[0] = new TexCoord2f(0.0625f, 0.3125f);
		t4[1] = new TexCoord2f(0.0625f, 0.25f);
		t4[2] = new TexCoord2f(0.25f, 0.25f);
		t4[3] = new TexCoord2f(0.25f, 0.3125f);
		TexCoord2f[] t5 = new TexCoord2f[4];
		t5[0] = new TexCoord2f(0.25f, 0.0f);
		t5[1] = new TexCoord2f(0.25f, 0.0625f);
		t5[2] = new TexCoord2f(0.0625f, 0.0625f);
		t5[3] = new TexCoord2f(0.0625f, 0.0f);
		TexCoord2f[] t6 = new TexCoord2f[4];
		t6[0] = new TexCoord2f(0.6875f, 0.1875f);
		t6[1] = new TexCoord2f(0.6875f, 0.125f);
		t6[2] = new TexCoord2f(0.75f, 0.125f);
		t6[3] = new TexCoord2f(0.75f, 0.1875f);
		TexCoord2f[] t7 = new TexCoord2f[4];
		t7[0] = new TexCoord2f(0.875f, 0.1875f);
		t7[1] = new TexCoord2f(0.875f, 0.125f);
		t7[2] = new TexCoord2f(0.9375f, 0.125f);
		t7[3] = new TexCoord2f(0.9375f, 0.1875f);
		TexCoord2f[] t8 = new TexCoord2f[4];
		t8[0] = new TexCoord2f(0.5625f, 0.1875f);
		t8[1] = new TexCoord2f(0.5625f, 0.125f);
		t8[2] = new TexCoord2f(0.6875f, 0.125f);
		t8[3] = new TexCoord2f(0.6875f, 0.1875f);
		TexCoord2f[] t9 = new TexCoord2f[4];
		t9[0] = new TexCoord2f(0.75f, 0.1875f);
		t9[1] = new TexCoord2f(0.75f, 0.125f);
		t9[2] = new TexCoord2f(0.875f, 0.125f);
		t9[3] = new TexCoord2f(0.875f, 0.1875f);
		TexCoord2f[] t10 = new TexCoord2f[4];
		t10[0] = new TexCoord2f(0.6875f, 0.3125f);
		t10[1] = new TexCoord2f(0.6875f, 0.1875f);
		t10[2] = new TexCoord2f(0.75f, 0.1875f);
		t10[3] = new TexCoord2f(0.75f, 0.3125f);
		TexCoord2f[] t11 = new TexCoord2f[4];
		t11[0] = new TexCoord2f(0.75f, 0.0f);
		t11[1] = new TexCoord2f(0.75f, 0.125f);
		t11[2] = new TexCoord2f(0.6875f, 0.125f);
		t11[3] = new TexCoord2f(0.6875f, 0.0f);
		TexCoord2f[] t12 = new TexCoord2f[4];
		t12[0] = new TexCoord2f(0.453125f, 0.484375f);
		t12[1] = new TexCoord2f(0.421875f, 0.484375f);
		t12[2] = new TexCoord2f(0.421875f, 0.453125f);
		t12[3] = new TexCoord2f(0.453125f, 0.453125f);
		TexCoord2f[] t13 = new TexCoord2f[4];
		t13[0] = new TexCoord2f(0.40625f, 0.375f);
		t13[1] = new TexCoord2f(0.375f, 0.375f);
		t13[2] = new TexCoord2f(0.375f, 0.34375f);
		t13[3] = new TexCoord2f(0.40625f, 0.34375f);
		TexCoord2f[] t14 = new TexCoord2f[4];
		t14[0] = new TexCoord2f(0.25f, 0.375f);
		t14[1] = new TexCoord2f(0.28125f, 0.375f);
		t14[2] = new TexCoord2f(0.28125f, 0.40625f);
		t14[3] = new TexCoord2f(0.25f, 0.40625f);
		TexCoord2f[] t15 = new TexCoord2f[4];
		t15[0] = new TexCoord2f(0.40625f, 0.40625f);
		t15[1] = new TexCoord2f(0.375f, 0.40625f);
		t15[2] = new TexCoord2f(0.375f, 0.375f);
		t15[3] = new TexCoord2f(0.40625f, 0.375f);
		TexCoord2f[] t16 = new TexCoord2f[4];
		t16[0] = new TexCoord2f(0.453125f, 0.484375f);
		t16[1] = new TexCoord2f(0.421875f, 0.484375f);
		t16[2] = new TexCoord2f(0.421875f, 0.453125f);
		t16[3] = new TexCoord2f(0.453125f, 0.453125f);
		TexCoord2f[] t17 = new TexCoord2f[4];
		t17[0] = new TexCoord2f(0.40625f, 0.375f);
		t17[1] = new TexCoord2f(0.375f, 0.375f);
		t17[2] = new TexCoord2f(0.375f, 0.34375f);
		t17[3] = new TexCoord2f(0.40625f, 0.34375f);
		TexCoord2f[] t18 = new TexCoord2f[4];
		t18[0] = new TexCoord2f(0.25f, 0.375f);
		t18[1] = new TexCoord2f(0.28125f, 0.375f);
		t18[2] = new TexCoord2f(0.28125f, 0.40625f);
		t18[3] = new TexCoord2f(0.25f, 0.40625f);
		TexCoord2f[] t19 = new TexCoord2f[4];
		t19[0] = new TexCoord2f(0.40625f, 0.40625f);
		t19[1] = new TexCoord2f(0.375f, 0.40625f);
		t19[2] = new TexCoord2f(0.375f, 0.375f);
		t19[3] = new TexCoord2f(0.40625f, 0.375f);
		TexCoord2f[] t20 = new TexCoord2f[4];
		t20[0] = new TexCoord2f(0.375f, 0.484375f);
		t20[1] = new TexCoord2f(0.34375f, 0.484375f);
		t20[2] = new TexCoord2f(0.34375f, 0.453125f);
		t20[3] = new TexCoord2f(0.375f, 0.453125f);
		TexCoord2f[] t21 = new TexCoord2f[4];
		t21[0] = new TexCoord2f(0.375f, 0.375f);
		t21[1] = new TexCoord2f(0.34375f, 0.375f);
		t21[2] = new TexCoord2f(0.34375f, 0.34375f);
		t21[3] = new TexCoord2f(0.375f, 0.34375f);
		TexCoord2f[] t22 = new TexCoord2f[4];
		t22[0] = new TexCoord2f(0.28125f, 0.375f);
		t22[1] = new TexCoord2f(0.3125f, 0.375f);
		t22[2] = new TexCoord2f(0.3125f, 0.453125f);
		t22[3] = new TexCoord2f(0.28125f, 0.453125f);
		TexCoord2f[] t23 = new TexCoord2f[4];
		t23[0] = new TexCoord2f(0.375f, 0.453125f);
		t23[1] = new TexCoord2f(0.34375f, 0.453125f);
		t23[2] = new TexCoord2f(0.34375f, 0.375f);
		t23[3] = new TexCoord2f(0.375f, 0.375f);
		TexCoord2f[] t24 = new TexCoord2f[4];
		t24[0] = new TexCoord2f(0.421875f, 0.453125f);
		t24[1] = new TexCoord2f(0.421875f, 0.484375f);
		t24[2] = new TexCoord2f(0.375f, 0.484375f);
		t24[3] = new TexCoord2f(0.375f, 0.453125f);
		TexCoord2f[] t25 = new TexCoord2f[4];
		t25[0] = new TexCoord2f(0.3125f, 0.375f);
		t25[1] = new TexCoord2f(0.34375f, 0.375f);
		t25[2] = new TexCoord2f(0.34375f, 0.453125f);
		t25[3] = new TexCoord2f(0.3125f, 0.453125f);
		TexCoord2f[] t26 = new TexCoord2f[4];
		t26[0] = new TexCoord2f(0.375f, 0.484375f);
		t26[1] = new TexCoord2f(0.34375f, 0.484375f);
		t26[2] = new TexCoord2f(0.34375f, 0.453125f);
		t26[3] = new TexCoord2f(0.375f, 0.453125f);
		TexCoord2f[] t27 = new TexCoord2f[4];
		t27[0] = new TexCoord2f(0.375f, 0.375f);
		t27[1] = new TexCoord2f(0.34375f, 0.375f);
		t27[2] = new TexCoord2f(0.34375f, 0.34375f);
		t27[3] = new TexCoord2f(0.375f, 0.34375f);
		TexCoord2f[] t28 = new TexCoord2f[4];
		t28[0] = new TexCoord2f(0.28125f, 0.375f);
		t28[1] = new TexCoord2f(0.3125f, 0.375f);
		t28[2] = new TexCoord2f(0.3125f, 0.453125f);
		t28[3] = new TexCoord2f(0.28125f, 0.453125f);
		TexCoord2f[] t29 = new TexCoord2f[4];
		t29[0] = new TexCoord2f(0.375f, 0.453125f);
		t29[1] = new TexCoord2f(0.34375f, 0.453125f);
		t29[2] = new TexCoord2f(0.34375f, 0.375f);
		t29[3] = new TexCoord2f(0.375f, 0.375f);
		TexCoord2f[] t30 = new TexCoord2f[4];
		t30[0] = new TexCoord2f(0.421875f, 0.453125f);
		t30[1] = new TexCoord2f(0.421875f, 0.484375f);
		t30[2] = new TexCoord2f(0.375f, 0.484375f);
		t30[3] = new TexCoord2f(0.375f, 0.453125f);
		TexCoord2f[] t31 = new TexCoord2f[4];
		t31[0] = new TexCoord2f(0.3125f, 0.375f);
		t31[1] = new TexCoord2f(0.34375f, 0.375f);
		t31[2] = new TexCoord2f(0.34375f, 0.453125f);
		t31[3] = new TexCoord2f(0.3125f, 0.453125f);
		//32 has been skipped
		TexCoord2f[] t33 = new TexCoord2f[4];
		t33[1] = new TexCoord2f(0.0625f, 0.5f);
		t33[2] = new TexCoord2f(0.0625f, 0.34375f);
		t33[3] = new TexCoord2f(0.078125f, 0.34375f);
		t33[0] = new TexCoord2f(0.078125f, 0.5f);
		TexCoord2f[] t34 = new TexCoord2f[4];
		t34[0] = new TexCoord2f(0.0625f, 0.5f);
		t34[1] = new TexCoord2f(0.0f, 0.5f);
		t34[2] = new TexCoord2f(0.0f, 0.34375f);
		t34[3] = new TexCoord2f(0.0625f, 0.34375f);
		TexCoord2f[] t35 = new TexCoord2f[4];
		t35[3] = new TexCoord2f(0.15625f, 0.5f);
		t35[0] = new TexCoord2f(0.140625f, 0.5f);
		t35[1] = new TexCoord2f(0.140625f, 0.34375f);
		t35[2] = new TexCoord2f(0.15625f, 0.34375f);
		TexCoord2f[] t36 = new TexCoord2f[4];
		t36[0] = new TexCoord2f(0.140625f, 0.5f);
		t36[1] = new TexCoord2f(0.078125f, 0.5f);
		t36[2] = new TexCoord2f(0.078125f, 0.34375f);
		t36[3] = new TexCoord2f(0.140625f, 0.34375f);
		TexCoord2f[] t37 = new TexCoord2f[4];
		t37[0] = new TexCoord2f(0.0625f, 0.515625f);
		t37[1] = new TexCoord2f(0.0f, 0.515625f);
		t37[2] = new TexCoord2f(0.0f, 0.5f);
		t37[3] = new TexCoord2f(0.0625f, 0.5f);

		qa[0].setNormals(0, npz);
		qa[1].setNormals(0, nmz);
		qa[2].setNormals(0, nmx);
		qa[3].setNormals(0, npx);
		qa[4].setNormals(0, npy);
		qa[5].setNormals(0, nmy);
		qa[6].setNormals(0, npz);
		qa[7].setNormals(0, nmz);
		qa[8].setNormals(0, nmx);
		qa[9].setNormals(0, npx);
		qa[10].setNormals(0, npy);
		qa[11].setNormals(0, nmy);
		qar[6].setNormals(0, npz);
		qar[7].setNormals(0, nmz);
		qar[8].setNormals(0, nmx);
		qar[9].setNormals(0, npx);
		qal[6].setNormals(0, npz);
		qal[7].setNormals(0, nmz);
		qal[8].setNormals(0, nmx);
		qal[9].setNormals(0, npx);
		qar[0].setNormals(0, npz);
		qar[1].setNormals(0, nmz);
		qar[2].setNormals(0, nmx);
		qar[3].setNormals(0, npx);
		qar[4].setNormals(0, npy);
		qar[5].setNormals(0, nmy);
		qal[0].setNormals(0, npz);
		qal[1].setNormals(0, nmz);
		qal[2].setNormals(0, nmx);
		qal[3].setNormals(0, npx);
		qal[4].setNormals(0, npy);
		qal[5].setNormals(0, nmy);
		qa[12].setNormals(0, nmx);
		qa[13].setNormals(0, nbd);
		qa[14].setNormals(0, npx);
		qa[15].setNormals(0, nfu);
		qa[16].setNormals(0, nbu);
		qa[17].setNormals(0, npz);
		qa[18].setNormals(0, nmz);
		qa[19].setNormals(0, nmx);
		qa[20].setNormals(0, npx);
		qa[21].setNormals(0, npy);
		qa[22].setNormals(0, nmy);
		qa[23].setNormals(0, npz);
		qa[24].setNormals(0, nmz);
		qa[25].setNormals(0, nmx);
		qa[26].setNormals(0, npx);
		qa[27].setNormals(0, npy);
		qa[28].setNormals(0, nmy);

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
		qa[10].setTextureCoordinates(0, 0, t10);
		qa[11].setTextureCoordinates(0, 0, t11);
		qar[6].setTextureCoordinates(0, 0, t12);
		qar[7].setTextureCoordinates(0, 0, t13);
		qar[8].setTextureCoordinates(0, 0, t14);
		qar[9].setTextureCoordinates(0, 0, t15);
		qal[6].setTextureCoordinates(0, 0, t16);
		qal[7].setTextureCoordinates(0, 0, t17);
		qal[8].setTextureCoordinates(0, 0, t18);
		qal[9].setTextureCoordinates(0, 0, t19);
		qar[0].setTextureCoordinates(0, 0, t20);
		qar[1].setTextureCoordinates(0, 0, t21);
		qar[2].setTextureCoordinates(0, 0, t22);
		qar[3].setTextureCoordinates(0, 0, t23);
		qar[4].setTextureCoordinates(0, 0, t24);
		qar[5].setTextureCoordinates(0, 0, t25);
		qal[0].setTextureCoordinates(0, 0, t26);
		qal[1].setTextureCoordinates(0, 0, t27);
		qal[2].setTextureCoordinates(0, 0, t28);
		qal[3].setTextureCoordinates(0, 0, t29);
		qal[4].setTextureCoordinates(0, 0, t30);
		qal[5].setTextureCoordinates(0, 0, t31);
		qa[12].setTextureCoordinates(0, 0, t33);
		qa[13].setTextureCoordinates(0, 0, t34);
		qa[14].setTextureCoordinates(0, 0, t35);
		qa[15].setTextureCoordinates(0, 0, t36);
		qa[16].setTextureCoordinates(0, 0, t37);

		Appearance a = new Appearance();
		a.setMaterial(m);
		Shape3D s3d = new Shape3D();
		s3d.setCapability(Shape3D.ALLOW_GEOMETRY_READ);
		for (int i = 0; i < qa.length; i++) {
			s3d.addGeometry(qa[i]);
		}
		TextureLoader tl = new TextureLoader("beaver.jpg", null);
		a.setTexture(tl.getTexture());
		TextureAttributes ta = new TextureAttributes();
		ta.setTextureMode(
			TextureAttributes.MODULATE
		);
		a.setTextureAttributes(ta);
		s3d.setAppearance(a);
		addChild(s3d);
		s3d = new Shape3D();
		s3d.setCapability(Shape3D.ALLOW_GEOMETRY_READ);
		for (int i = 0; i < qal.length; i++) {
			s3d.addGeometry(qal[i]);
		}
		s3d.setAppearance(a);
		tgl = new TransformGroup();
		tgl.addChild(s3d);
		tgl.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgl.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		addChild(tgl);
		s3d = new Shape3D();
		s3d.setCapability(Shape3D.ALLOW_GEOMETRY_READ);
		for (int i = 0; i < qar.length; i++) {
			s3d.addGeometry(qar[i]);
		}
		s3d.setAppearance(a);
		tgr = new TransformGroup();
		tgr.addChild(s3d);
		tgr.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		addChild(tgr);
		Transform3D t3d = new Transform3D();
		t3d.setRotation(new AxisAngle4f(0.0f, 0.0f, 1.0f, (float) Math.PI / 2.0f));
		PositionInterpolator pil = new PositionInterpolator(
			new Alpha(
				-1,
				Alpha.INCREASING_ENABLE | Alpha.DECREASING_ENABLE,
				0,
				0,
				500,
				0,
				0,
				500,
				0,
				0
			),
			tgl,
			t3d,
			0.0f,
			0.1f
		);
		pil.setSchedulingBounds(infiniteBounds);
		addChild(pil);
		PositionInterpolator pir = new PositionInterpolator(
			new Alpha(
				-1,
				Alpha.INCREASING_ENABLE | Alpha.DECREASING_ENABLE,
				0,
				500,
				500,
				0,
				0,
				500,
				0,
				0
			),
			tgr,
			t3d,
			0.0f,
			0.1f
		);
		pir.setSchedulingBounds(infiniteBounds);
		addChild(pir);
	}
}
