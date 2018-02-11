package com.datastructure.array;

public class DrawCircle {

	//draw space
	public static String getSpace(int i) {
		String s = "";
		for(int j = 0; j < i; j++) {
			s += " ";
		}
		return s;
	}
	
	//find the position to draw asterisks
	public static int getX(int r, int y) {
		int h = y - r;
		double l = Math.sqrt((r*r) - (h*h));
		return (int) Math.round(r-l);
	}
	
	//paint the circle
	public static void paint(int r) {
		//suppose the center of the circle has position (r,r)
		int x = 0;  //start of x coordinate
		int y = r * 2; //start of y coordinate
		int c = 0; //number of spaces in between
		int z = 2; //decremental steps
		
		for(int i = r * 2; i >= 0; i = i-z) {
			//get the x coordinate of "*"
			x = getX(r, y);
			//draw the left corresponding "*" to y 
			System.out.print(getSpace(x)+"*");
			//get the space between two asterisks
			c = (r-x) * 2;
			//draw the right corresponding "*" to y 
			System.out.println(getSpace(c)+"*");
			//decrement y 
			y -= z;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//paint(10);
		 // 定义半径  
        int r = 10;  
        // 定义y为圆的纵坐标,其中y=y+2是让设置纵坐标的步长，可以调整椭圆的“胖瘦”  
        for (int y = 0; y <= 2 * r; y = y + 2) {  
            long x = Math.round(r - Math.sqrt(2 * r * y - y * y));  
            for (int i = 0; i <= 2 * r; i++) {  
                // i==x是指某一个纵坐标对应的一个横坐标，i==2*r-x 是指该纵坐标对应的第二个横坐标  
                if (i == x || i == 2 * r - x) {  
                    System.out.print("*");  
                } else {  
                    System.out.print(" ");  
                }  
            }  
            System.out.print("\n");  
        }  
	}

}
