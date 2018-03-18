
public class CArea {
static double radius;
static double length;
	static double getArea(double rad){
		double Area;
		Area=Math.PI*rad*rad;
		return Area;
	}
	
	static double getSurfaceArea(double rad, double height){
		double Area=((2*Math.PI*rad*rad)+2*(rad*Math.PI*height));
		return Area;
	}
}
