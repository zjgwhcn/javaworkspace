package Object.java04.zjg;

class Example0401 {
	int x=1;  //实例变量x，属于实例，每个实例都有自己的x值
	static int y=2;  //类变量y，属于类，所有的实例都共享一个y值

	public static void main(String args[]){
		System.out.println("y="+Example0401.y); //访问并输出类变量y
		Example0401.y*= 2;
		Example0401 ol=new Example0401(); //创建实例ol
		ol.x *=10;
	}
}
