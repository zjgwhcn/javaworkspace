package Object.java04.zjg;

class Example0401 {
	int x=1;  //ʵ������x������ʵ����ÿ��ʵ�������Լ���xֵ
	static int y=2;  //�����y�������࣬���е�ʵ��������һ��yֵ

	public static void main(String args[]){
		System.out.println("y="+Example0401.y); //���ʲ���������y
		Example0401.y*= 2;
		Example0401 ol=new Example0401(); //����ʵ��ol
		ol.x *=10;


		System.out.println("ol.x="+ol.x);
		System.out.println("ol.y="+ol.y);
		
		Example0401 o2=new Example0401(); //����ʵ��o2
		System.out.println("o2.x="+o2.x);
		System.out.println("o2.y="+o2.y);

	}
}
