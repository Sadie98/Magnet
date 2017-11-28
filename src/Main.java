import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	static double B, Bx, By, x0, y0, R0, I;

	static Scanner in = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String args[])
	{
		I = 10;
		R0 = 5;
		x0 = 23;
		y0 = 12;
		int x = 100, y =100 ;
		double dl = 10;
		B = Math.sqrt(x*x + y*y);
		for (int i = 0; i < 1000; i++)
		{
			out.println(String.valueOf(x) + ' ' + String.valueOf(y));
			Bfield(x, y);
			double dx = dl * Bx/B;
			double dy = dl * By/B;
			x += dx;
			y += dy;
			
		}
		out.flush();
	}
	
	
	
	static void Bfield (double x, double y)
	{
		int n = 100;
		double r, alfa = 0, delta, s1 = 0, s2 = 0;
		delta = 2 * Math.PI / n;
		for (int j = 1; j < n; j++)
		{
			r = Math.sqrt(Math.pow((x - x0),2) + Math.pow((y - y0),2) + Math.pow(R0,2) - 2 * (y - y0) * R0 * Math.cos(alfa));
			s1 += delta / (2 * Math.pow(r,  3));
			s2 += Math.cos(alfa) * delta / (2 * Math.pow(r,  3));
			alfa += delta;
			r = Math.sqrt(Math.pow((x - x0),2) + Math.pow((y - y0),2) + Math.pow(R0,2) - 2 * (y - y0) * R0 * Math.cos(alfa));
			s1 += delta / (2 * Math.pow(r,  3));
			s2 += Math.cos(alfa) * delta / (2 * Math.pow(r,  3));			
		}
		Bx = I * Math.pow(R0,  2) * s1 - I * (y - y0) * R0 * s2;
		By = I * (x - x0) * R0 * s2;
		B = Math.sqrt(Bx*Bx + By*By);
		//out.println(String.valueOf(Bx) + ' ' + String.valueOf(By) + ' ' + String.valueOf(B));
		
	}
}
