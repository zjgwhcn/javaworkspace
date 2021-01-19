补充版：2018-05-30
方法（函数）
1、格式
修饰符返回值类型 方法名(参数类型 形参1, 参数类型 形参2, ...){
       方法体;
       return 返回值;
}

注意：
A：方法不能嵌套定义，但可以嵌套调用，注意不要循环调用
B：方法只有被调用才能被执行
C：方法参数是值传递，不是地址传递(面试题)

方法的重载（Java中的重载机制）
Java中允许出现方法名相同而参数列表不相同，这种情况叫做方法的重载（与返回值类型无关）
参数列表不同：可以是参数的个数不同，也可以是参数的类型不同，不能是参数名不同

面向对象
一、面向对象
概念：面向对象是相对于面向过程而言的一种编程思想，基于面向过程
面向过程：关注实现过程
面向对象：关注结果，现实过程交给对象处理
特点：
1、更符合我们的思维习惯
2、让复杂的事情简单化
3、角色发生转变，由执行者转换为指挥者

二、类与对象的关系
类：对现实事物抽象出一组相关的属性和行为
类的组成：
       成员变量      （属性、外在描述）
       成员方法      （功能、行为）
       构造方法      （对数据初始化）

对象：类的具体表现形式
成员变量：写在类中方法外的变量，称为成员变量（全局变量）（不同于静态变量）
成员方法：写法类似于主方法(main方法)，不需要加static。有static的是类方法或者叫静态方法，可以用类名直接调用（所有逻辑判断必须在方法中）


创建一个类的具体对象：
关键字：new
格式：对象类型(类名) 对象名 = new 类名();
对象名：自己随便写，稍微有点意义，取名规范参照变量名规范
此处的对象名，才是以后真正使用的对象

使用类中变量和方法，目前来讲只能通过对象调用，格式：
成员变量：对象名.成员变量
成员方法：对象名.成员方法

三、成员变量和局部变量
成员变量和局部变量的区别：
1、定义位置的区别
       成员变量：类中，方法外
       局部变量：方法中，或者方法的形式参数中

2、初始化在的区别
       成员变量：有默认初始化值，如int类型默认为0，对象类型默认为null
       局部变量：没有默认初始化值，如需使用，必先初始化

3、存储位置的区别
       成员变量：存储在堆中，随着对象的创建而存在，随着对象的消失而消失（生命周期）
       局部变量：存储在栈中，随着方法的调用而存在，随着方法的调用完毕而消失


变量使用时：先找局部变量，有就使用没有就找成员变量，找不到成员变量去父类中找，找不到再往上找，直至找到object类中，都找不到就报错
使用过程遵循一个原则：就近原则
变量的作用域参照C语言的变量

四、匿名对象
没有名字的对象（一般不用，方法只调用一次的时候可以使用，好处是用完后对象就会消失，节省内存）
格式：
new类名().方法名();

五、构造方法
构造方法是类中一个特殊的方法，用来创建对象
格式：
修饰符  类名(){

}
特点：
1、方法名必须和类名相同
2、没有返回值类型
3、没有具体的返回值
作用：创建对象并对对象初始化
注意：
1、如果没有写构造方法，那么系统会默认给出一个无参构造方法
2、只要写了构造方法，那么系统不会再给出无参构造（无论是无参还是带参）
       没有无参构造会报错，因为必须要有一个空参构造器
       所以，永远手动给出无参构造

3、构造方法的重载（带参构造）
       构造方法可以接收不同的参数，用来初始化成员变量（并不推荐，推荐使用setter方法）

六、this关键字
谁调用，this就代表谁（代表本类对象的引用）
哪个对象调用方法，在该方法内部就有一个隐含的this，代表了这个对象本身

默认情况下，对象调用成员变量时系统会自动添加this（局部变量跟成员变量重名时，系统不能识别，所以需要手动添加this关键字）

常见应用：解决局部变量覆盖成员变量的问题

用法：
局部范围内有跟成员变量同名的局部变量，就需要加this，否则可以省略
this();调用当前类的无参构造方法

七、static关键字（静态）
作用：
当多个对象共享某个数据的时候，我们就可以把这个数据用static修饰（节省内存空间），这是一种设计思想
没有被static修饰的成员属于对象的特有描述

可以修饰成员变量和成员方法，不能修饰构造方法

特点：
1、随着类的加载而加载（.java文件编译成 .class文件后，.class文件会被加载到类加载器里，这时类就存在了）
2、优先于对象存在
3、可以直接被类名调用

注意：
1、静态方法中没有this关键字，因为静态是随着类的加载而加载，而this是对象创建后才存在，而类的加载在对象创建之前
2、静态方法只能访问静态成员变量和静态成员方法（非静态方法可以访问任何方法和成员变量）
3、静态内容可以通过对象调用，也可以用类名调用（推荐用类名调用）

作业：
编写一个标准的学生类(Student)
   Student:
       成员变量：name,age,sex
       构造方法：无参构造方法，带三个参数的构造方法
       成员方法：
              A:get/set方法
              B:把所有成员变量的值输出的方法(show)

面向对象的三大特性（封装、继承、多态）
一、封装
概念：隐藏对象的属性和实现细节，仅对外提供公共访问方式（让外界不能直接访问）
例子：银行取款机
常见的封装1：
将成员变量私有化，对外提供对应的getter/setter方法对其访问，提高对数据访问的安全性
代码举例：年龄不能为负数（在setAge()中做校验）
1、private访问权限修饰符：私有。被private修饰的内容，在其他类中不能被访问，只能在本类中访问
注：以后所有的成员变量，都要加上private

二、继承
作用：当多个类中存在相同的变量和方法的时候，重复写相同的代码，代码冗余度太高，Java提供了继承机制，将这些重复代码抽取到单独的一个类中，其他类只需要继承这个类即可，无需再写这些变量和方法

关键字：extends
这个单独的类称为：父类（基类、超类）
其他类：子类（派生类）
格式：
publicclass A extends B{

}

类A继承了类B（A是子类，B是父类）
好处：
1、提高代码的复用性
2、让类与类之间产生关系，是多态的前提
特点：只支持单继承，不支持多继承，支持多重继承（如果可以多继承，会出现调用不明确的问题）
注意：子类可以访问父类中所有非私有变量和方法
变量作用域的问题（同名的情况下）
遵循就近原则，先找局部变量，再找成员变量，再找父类
如果上面三种情况都是同名，要都输出：
this可代表成员变量，super可代表父类中的变量

super关键字：
super和this的用法很像，super代表父类内存空间的标识（可理解为就是父类对象，但不准确）

作用：
1、当子父类出现同名成员的时候，可通过super区分
2、当子类要调用父类构造方法的时候，可以用super();

方法的重写：
子类中的方法和父类中的非私有方法名相同，那么就是方法的重写，在子类中调用，默认会调用子类的方法(就近原则)

注意：
1、重写时，子类方法的访问权限必须大于父类的访问权限
2、静态方法只能被静态重写（必须同为静态）

final关键字：
如果父类方法不想被子类重写，用final关键字修饰

作用：
1、类不能被继承
2、方法不能被重写
3、变量不能被修改（称为“定义常量”，字面值常量：1，"abc"，'a'）

注意：定义常量一般都是大写（规范）


继承中的构造关系：
子类的构造方法的第一行，默认的都去调用了父类的无参构造方法（super()）

调用顺序：先父后子
作用：先初始化父类，好让子类使用父类中的成员变量和方法

注意：
无论子类的无参构造还是带参构造，都默认访问父类的无参构造

继承弊端：父类增加或修改了成员，子类也会跟着修改，增加了耦合性

附：何类，如果没有继承任何类，那么它默认继承了Object类，所以这个类中的super()指向Object类
    所有类就直接或者间接继承Object类（Object是所有类的超类），Object类中只有默认构造方法，所以，所有类都只调用父类的空参构造

三、多态
定义：对象在不同时刻表现出的不同状态

为什么要有多态
一个引用变量倒底会指向哪个类的实例对象，该引用变量发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。多态就是为了不修改程序代码，就可以改变程序运行时所绑定的具体对象和方法，让程序可以选择多个运行状态。

主要针对应用类型，编译状态和运行状态不同，才能成为多态

注：用到多态的地方，一般不会用具体类的多态，都是用抽象类或者接口的多态。

前提条件：
1、要有继承或实现关系
2、要有方法的重写
3、要有父类引用指向子类对象（向上转型）
多态中成员特点：方法有重写，而变量没有
1、成员变量
       编译看左边，运行看左边
2、成员方法
       编译看左边，运行看右边
编译的时候，看左边的引用中有没有相应的属性和方法，没有就报错，运行的时候，再看是变量还是方法，选择到相应的位置查看有没有相应的属性和方法，没有就报错

多态弊端：父类引用不能使用子类特有成员

向上转型和向下转型
向上转型：子转父（多态的默认情况）
向下转型：父转子（父可以直接调用子类特有成员，少创建一个对象，节省内存空间）
注意：向下转型可能会造成类型转换异常的问题（因为子类间不能互转）

抽象类
抽象方法：没有方法体，且被关键字abstract修饰的方法，称为抽象方法。

抽象类：里面含有抽象方法，且被abstract修饰的类
注：有抽象方法的类一定是抽象类或者接口，但抽象类中不一定有抽象方法（可以没有抽象方法或有成员方法，直接把类用abstract修饰）

作用：强制子类必须完成某些功能

格式：
修饰符 abstract 类名{
       修饰符 abstract 返回值类型 方法名(参数列表);
}

特点：
1、抽象类不能直接实例化（不能直接创建对象）
2、抽象类必须被继承且实现父类中的所有抽象方法(去掉abstract，写上方法体)，才能实例化（只能通过具体子类实例化）
   如果不实现抽象方法，只能用抽象类去继承（还是一个抽象类，还是不能实例化）

抽象类中成员的特点:
1、成员变量：可以有成员变量，也可以有定义常量（final修饰的常量）
2、构造方法：有构造方法，但是此处的构造方法只用来初始化抽象类中的数据，不能用来创建对象
3、成员方法：可以有抽象方法，也可以有非抽象方法

接口

为什么要有接口：
1、接口是对外暴露的规则，你要使用我的规则，就必须遵循我的规则（霸王条款）
2、接口是程序的功能扩展
3、接口的出现，降低了耦合性（优质编程：高内聚低耦合）
4、接口可以用来多实现



定义：一个抽象类中，只有抽象方法，且这个类用interface修饰，叫做接口（比抽象更抽象的形式）

定义接口格式：
       interface 类名{
              抽象方法1();// publicabstract 返回值类型 方法名(参数列表);
              抽象方法2();
              …………
       }

使用方式：必须有一个具体的类来实现这个接口(实现关键字：implements)（类与类是继承extends，类与接口是实现implements）

定义实现格式：
       class 类名 implements 接口名{
              实现抽象方法;// public 返回值类型方法名(参数列表){ 方法体}
       }

接口的特点：
1、接口不能被实例化
2、接口中的方法，要么被子类实现，要么子类也是抽象类

接口成员特点：
1、成员变量：接口中只有常量（默认修饰符：public static final，推荐手动给出修饰符）
2、成员方法：接口中的所有方法都是抽象且公共的（默认修饰符public abstract，推荐手动给出修饰符），所以重写接口中的抽象方法必须是公共的
3、构造方法：接口中没有构造方法（接口中的数据是static修饰的，随着类的加载而加载，所以不需要构造方法初始化）

类、接口关系总结

类与类：继承关系，只能单继承，可以多重继承
类与接口：实现关系，可以单实现也可以多实现（用,隔开），可以在继承的同时实现
接口与接口：继承关系，可以单继承，也可以多继承（用,隔开）（注意这一点，Java中其实是有多继承的，在接口中体现，类里面没有）



包：其实就是文件夹，用于区分相同名字的类


修饰符
public:都可以访问
private:只有本类可以访问
默认:同一个包下可以访问
protected:不同包下有继承关系的可以访问


Object

1、toString()
       a、重写toString()，打印对象时不再是地址值，显得有意义
       b、toString()方法：把对象类型转变为String类型

2、==号
比较基本数据类型，比较的是值
比较引用类型，比较的是地址值

3、equals
比较引用类型，比较的是地址值（没有意义，推荐重写该方法）

注：以后比较基本数据类型用==，比较引用类型用equals


Scanner

创建一个输入对象
Scannersc = new Scanner(System.in);

获取int类型的数据
intnum = sc.nextInt();

获取String类型的数据
Stringstr = sc.nextLine();



重点：常用的API

String类

创建字符串
1、Strings1 = "abc";
2、Strings2 = new String();
        s2 = "abc";
3、Strings3 = new String("abc");

字符串的拼接用 + 表示

注意：
1、字符串一旦被初始化就不可以被改变，因为字符串是保存在常量池中的，所以此处是值不会被改变，但是引用可以改变（面试题）
2、Strings1 = "abc";和 String s3 = newString("abc"); 有什么区别？
   第一个只有一个对象，第二个有两个对象，但是他们的值是同一个，都是常量池里面的 abc
3、Strings1 = "abc";和 String s2 = "abc";是同一个值，指向了常量池里面的同一个数据

String中的方法
1、字符串的判断功能（返回true/false）
   boolean equals(Object obj)：判断字符串的内容是否相同,区分大小写。
   boolean equalsIgnoreCase(String str):判断字符串的内容是否相同,不区分大小写。
   boolean contains(String str):判断字符串对象是否包含给定的字符串。
   boolean startsWith(String str):判断字符串对象是否以给定的字符串开始。
   boolean endsWith(String str):判断字符串对象是否以给定的字符串结束。
   boolean isEmpty():判断字符串对象是否为空。数据是否为空。

2、字符串的获取功能（返回的是一个新的字符串）
   int length():获取字符串的长度
   char charAt(int index):返回字符串中给定索引处的字符
   int indexOf(int ch):返回指定字符在此字符串中第一次出现的索引
   int indexOf(String str):返回指定字符串在此字符串中第一次出现的索引
   int indexOf(int ch,int fromIndex):返回在此字符串中第一次出现指定字符的索引，从指定的索引开始搜索。
   int indexOf(String str,int fromIndex):返回在此字符串中第一次出现指定字符串的索引，从指定的索引开始搜索。
   String substring(int start):截取字符串。返回从指定位置开始截取后的字符串。
   String substring(int start,int end)截取字符串。返回从指定位置开始到指定位置结束截取后的字符串。（包左不包右）

3、字符串的转换功能
   char[] toCharArray()：把字符串转换成字符数组。
   staticString valueOf(int i)：把int（基本类型）转换成字符串。
   String toLowerCase()：把字符串变成小写
   String toUpperCase():把字符串变成大写
   String concat(String str):拼接字符串。（跟 + 功能一样）

4、字符串的替换
   String replace(char oldChar,char newChar)：用新的字符去替换指定的旧字符
   String replace(String oldString,StringnewString)：用新的字符串去替换指定的旧字符串

5、切割功能
   String[] split(String regex)

6、去除字符串两端空格
   String trim()

7、按字典顺序比较两个字符串，第一个字符相等比较第二个，一直往下比较
   int compareTo(String str)


作业：
1、键盘录入一个字符串，统计里面小写字符、大写字符、数字的个数
2、键盘录入一个字符串，用上面讲过的方法，让首字母大写，后面的全小写



字符串缓冲区类、可变字符串类(StringBuffer/StringBuilder)

与String的区别：String一旦被赋值，值不能发生改变。而StringBuffer/StringBuilder，值还可以改变。（StringBuffer/StringBuilder采用的是缓冲区机制，一开始，首先开辟一些空间，然后，随着数据的最多，然后，还可以继续开辟空间。这些操作针对的是同一个对象）

StringBuffer/StringBuilder:方法类似，StringBuffer：线程安全，效率低；StringBuilder：线程不安全，效率高，推荐使用StringBuilder

1、构造方法：
   StringBuffer()
   StringBuffer(String str)
注：
String和StringBuffer的转换：通过构造方法可以实现。
  
2、成员方法：
   public int length()：字符个数。实际长度。

3、添加功能
   public StringBuffer append(int i):在末尾追加元素（可添加任意类型）
   public StringBuffer insert(int index,int i):在指定位置添加元素

4、删除功能：
   StringBuffer deleteCharAt(int index):删除指定位置字符
   StringBuffer delete(int start, int end):删除指定开始位置和结束位置间的字符

5、字符串反转
   StringBuffer reverse()



Arrays:针对数组操作的操作类（全是静态）
       public static String toString(int[] a):把整型数组转变成字符串。
       public static void sort(int[] a)：对数组进行排序
       public static int binarySearch(int[]a,int key):对数组进行二分查找。


基本类型对应的包装类型

基本类型      包装类
  byte         Byte
  short        Short
  int            Integer
  long         Long
  float         Float
  double    Double
  char          Character
  boolean  Boolean


Integer:把int类型包装成对象类型
       public static String toBinaryString(inti):转二进制
       public static String toOctalString(inti):转八进制
       public static String toHexString(int i):转十六进制

构造方法：
       Integer(int value):把int类型转化为Integer类型
       Integer(String s) :把String类型转化为Integer类型
注意：这里字符串必须是由数字字符组成的字符串


int和String类型互转：
   int -- String
       String.valueOf(int i)
       Integer.toString(int i)

   String -- int
       Integer.parseInt(String s)

JDK5以后Integer新特性
   自动装箱：也就是把基本类型直接赋值给引用类型
   自动拆箱：也就是把引用类型直接拆成基本类型

例：
   Integer i = 10;// 自动装箱，相当于 new Integer(10);
   i += 20;// 自动拆箱，相当于 i = newInteger(i.intValue()+20);


Date

构造方法：Date(): 获取当前时间，格式不符合我们平常使用习惯
成员方法：public long getTime(): 获取当前时间的毫秒值（从1970年之后）

DateFormat:对日期进行格式化
       public final String format(Date date):将一个Date 格式化为日期/时间字符串
       public Date parse(String source):从给定字符串的开始解析文本，生成一个日期

DateFormat是一个抽象类，一般使用的是子类SimpleDateFormat

SimpleDateFormat
       public SimpleDateFormat(String pattern):用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat
             String pattern = "yyyy-MM-dd HH:mm:ss";// 常见模式

例1：Date转String

//创建当前时间
Datedate = new Date();
//创建格式化日期类，并设定好日期格式
SimpleDateFormatsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//将日期转化为字符串
Stringstr = sdf.format(date);


例2：String转Date

//获取字符串时间
Stringstr = "2017-03-29 05:45:30";
//创建格式化日期类，并设定好日期格式
SimpleDateFormatsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//将字符串转化为日期
Datedate = sdf.parse(str);

注意：第一步字符串的时间格式要和第二部设定的日期格式相同


Calendar类:仅想获取年、月、日、时、分、秒的时候可以用这个类
       public static Calendar getInstance():使用默认时区和语言环境获得一个日历。返回的 Calendar 基于当前时间，使用了默认时区和默认语言环境(可用于创建Calendar对象)

       public static final int YEAR:获取日历年字段，静态且是常量（Calendar.YEAR）
       public static final int MONTH:获取日历月字段（0-11，所以结果推荐+1）
       public static final int HOUR:获取日历小时字段（12小时制）
       public static final int HOUR_OF_DAY:获取日历小时字段（24小时制）


例：
//创建Calendar对象（此处推荐用多态的方式）
Calendarc = Calendar.getInstance();
//获取日历中的年字段
intyear = c.get(Calendar.YEAR);






集合

集合是存储对象最常用的方式（因为Java是面向对象的语言）
存储对象可以使用数组，但是数组长度固定，对要变化的数据存储不了，所以有了集合用于存储对象

特点：
1、长度可变
2、只能存储对象
3、可以存储不同类型的对象

集合体系结构
Collection接口
   子接口：
       |--List:元素有序（存储顺序与取出顺序一致，可用下标取），可重复
              实现类：
              |--ArrayList : 底层数据结构是数组，查询快，增删慢；线程不安全，效率高
              |--LinkedList : 底层数据结构是链表，查询慢，增删快；线程不安全，效率高
              |--Vector : 底层数据结构是数组，查询快，增删慢；线程安全，效率低（几乎不用）

       |--Set: 元素无序且唯一
              实现类：
              |--HashSet :底层是一个HashMap（哈希表），hashCode保证了唯一性，线程不安全，效率高
              |--TreeSet :底层是一个TreeMap（二叉树），二叉树保证了唯一性，Comparator接口进行排序，线程不安全，效率高



Collection接口中的功能
  1、添加功能
            booleanadd(Object obj):向集合末尾添加一个元素，返回值添加成功返回true，有些集合添加重复元素会失败
            booleanaddAll(Collection c)：向集合中添加一个集合中的所有元素
  2、删除功能
            voidclear()：删除集合中的所有元素（慎用）
            booleanremove(Object obj)：从集合中删除指定的元素
            booleanremoveAll(Collection c):从集合中删除一个指定的集合元素（只要有一个元素被删除就返回true）
  3、判断功能
            booleanisEmpty()：判断集合是否为空
            booleancontains(Object obj)：判断集合中是否存在指定的元素
            booleancontainsAll(Collection c)：判断集合中是否存在指定的一个集合中的元素（只有所有元素都包含才返回true）

  4、长度功能
            intsize():获取集合中的元素个数
  5、交集功能
            booleanretainAll(Collection c):判断两个集合中是否有相同的元素（交集，A对B做交集，A集合保存的是交集元素，B集合不发生改变，返回值表示的是A集合是否发生过改变，只要A改变就返回true）
  6、把集合转换成数组
            Object[]toArray():把集合变成数组

  7、遍历功能
            Iteratoriterator():就是用来获取集合中每一个元素（跟for循环功能一样）

注：iterator() 返回的是一个 Iterator 对象，所以我们要用的其实是 Iterator 对象下面的一些方法
       1、boolean hasNext() : 如果迭代器中还有元素就返回true
       2、Object next() : 返回迭代器中的元素，并把指针指向下一个元素


List接口中的特有功能

   1、添加功能
            voIDAdd(int index, Object obj):在指定位置添加元素
   2、删除功能
            Objectremove(int index):根据指定索引删除元素，返回删除的元素
   3、修改功能
            Objectset(int index, Object obj):把指定索引位置的元素修改为指定的值，返回修改前的值
   4、获取功能
            intindexOf(Object o):返回指定元素在集合中第一次出现的索引
            Objectget(int index):获取指定位置的元素（结合size()，可作为List的遍历方式）
            ListIteratorlistIterator()：列表迭代器，遍历List中的所有元素
              注1：ListIterator 作用跟 Iterator 类似，但是有一些特有功能：
                     A、voidadd() : 可用于一边遍历一边增加元素，增加到刚遍历到的元素的后面（Iterator 遍历没这个功能，如果强行增加会报并发修改异常 : ConcurrentModificationException）
                     B、逆向遍历（但是必须先正向遍历过一次）
                            booleanhasPrevious() : 对应 hasNext()
                            Object previous() : 对应next()
              
   5、截取功能
            ListsubList(int fromIndex, int toIndex)：截取集合


ArrayList类中的特有功能：
   1、查询功能
              public boolean contains(Objectobj) : 查询是否包含指定的元素，包含返回true
   2、删除功能
              protected void removeRange(intfromIndex,int toIndex) : 移除列表中索引在 fromIndex（包括）和 toIndex（不包括）之间的所有元素


LinkedList类中的特有功能
   1、添加功能
             voidaddFirst(Object obj) : 增加新元素到最前面
            voidaddLast(Object obj) : 增加新元素到最后面（跟add(Object obj)一样）
   2、获取功能
            ObjectgetFirst() : 获取第一个元素（跟get()一样）
            ObjectgetLast() : 获取最后一个元素
   3、删除功能
             ObjectremoveFirst() : 删除第一个元素，返回被删除的值
             ObjectremoveLast() : 删除最后一个元素，返回被删除的值


Vector类中的特有功能
   1、添加功能
             publicvoid addElement(Object obj)（相当于add(Object obj)）
   2、获取功能
            publicObject elementAt(int index)（相当于get(int index)）

            publicEnumeration elements()     （类似于Iterator）
                           booleanhasMoreElements()（类似于hasNext()）
                          ObjectnextElement()     （类似于next()）



Set接口中的功能跟Collection中的功能一致


HashSet类
保存字符串每次遍历顺序不固定
保存自定义对象的时候，需要重写hashCode()和equals()保证对象的唯一性


TreeSet类
TreeSet在内存中的存储，可以对元素进行排序，排序方式：
1、自然排序（a-z）（无参构造，默认排序方式）
2、根据创建set 时提供的 Comparator 进行排序，具体取决于使用的构造方法
保存自定义对象的时候会报错（ClassCastException），自定义的类不能转成Comparable类。
需要调用TreeSet(Comparator comparator) 构造方法创建TreeSet
调用此构造方法前需要创建一个类实现Comparator接口，重写compare()方法，自定义排序方式，然后把这个类的对象传给TreeSet(Comparator comparator) 构造方法


例：
调用TreeSet(Comparator comparator) 构造方法创建TreeSet保存自定义的Girl对象
TreeSet<Girl>set = new TreeSet<Girl>(new MyComparator());

新建一个类实现Comparator接口
publicclass MyComparator implements Comparator<Girl> {

       @Override
       public int compare(Girl g1, Girl g2) {
              
              int num = g1.getAge() -g2.getAge();
              int num2 = (num ==0)?(g1.getName().compareTo(g2.getName())):num;
              
              return num2;
       }

}



Collections
是针对集合类的一个帮助类。提供了一系列静态方法实现对各种集合的二分查找、排序、取最大最小值等操作。相当于对Array进行类似操作的类——Arrays
publicstatic void reverse(List<?> list) : 对集合元素反转，只对List有效
publicstatic void shuffle(List<?> list) : 对集合元素重新随机排序，只对List有效


面试题：Collection和Collections的区别？
Collection是集合的顶层接口
Collections是对集合操作的工具类






泛型
定义：任意类型，是一种把明确数据类型的工作放在创建对象或调用方法时进行的特殊类型
格式：<T>、<E>、<>
作用：解决警告和类型转换问题


增强for循环
格式：
for(数组或集合类型 变量名 : 数组或集合){
       直接使用变量名即可;
}




补充：

链表：把一些结点通过链子连接起来的数据结构
结点：由数值域和指针(地址)域组成（域：空间，存放数值和指针的空间）
      结点里面一半存着数值(数值本身也有地址)，另一半存着下一个数值对应的地址


哈希表：
哈希表是一个键值对形式的，键是对象的内存地址，值是哈希值
HashSet存储自定义对象，存储的是对象通过哈希算法算出来的值


二叉树：有两个叉子的树，左结点和右结点
存储：
按照存储顺序，把第一个存储的数据作为根结点，后面存储的数据都与这个根节点比较，大的往右子结点边放，小的往左子节点边放，相同的替换（保证了唯一），如果左右满了，则根据大小往下发展左右结点
取：
从根节点开始，按左中右顺序获取（获取完后是排好序的）
左中右：根结点的左子节点，左子节点的左子节点...一直到没有左子节点的数据作为获取的第一个数据
       获取的第一个数据的父结点作为获取的第二个数据
       获取的第一个数据的右子节点作为获取的第三个数据
       依次往上获取....
       获取到根结点的时候，根结点的右子节点，再获取右子节点的左子节点，一直到没有左子节点的时候，作为获取的数据，然后规则同上



Map<K,V>

Map是一个键值对(双列)形式的集合，键唯一，值可重复
Collection是单列形式的集合

Map接口的实现类
       |--HashMap
       |--TreeMap

Map接口的功能：
1、增加功能
            Vput(K key,V value):当key在集合中不存在时，添加元素；当key在集合中存在时候，替换元素。返回值V，返回的是添加元素之前key所对应的value

2、删除功能
            voidclear():清除所有键值对数据
            Vremove(Object key):根据指定的键删除键值对，返回值V，返回的是被删除的值

3、判断功能
            booleancontainsKey(Object key):判断指定的键是否在集合中存在
            booleancontainsValue(Object vlaue):判断指定的值是否在集合中存在
            booleanisEmpty():判断集合是否为空

5、长度功能
             int size()

4、获取功能
            Objectget(Object key):根据键获取值
            Set<K>keySet():所有键的集合
            Collection<V>values():所有值的集合

            Set<Map.Entry<K,V>>entrySet():键值对对象的集合（用于遍历map集合）
                     K getKey();
                     V getValue();
例：
       Set<Map.Entry<String,String>> set = map.entrySet();
              for(Map.Entry<String,String> me : set){
                     String key = me.getKey();
                     String value =me.getValue();
                     System.out.println(key+"--->"+value);
              }

注：
HashMap和TreeMap中的方法和Map中的类似，所以学完Map中的方法就可以直接使用它的实现类，无需再学新的方法


Hashtable和HashMap的区别
Hashtable：JDK1.0出现，安全，效率低，不允许出现null键和null值
HashMap：JDK1.2出现，效率高，不安全，允许出现null键和null值


作业：
Map集合的嵌套(两层Map嵌套)
              /*
               * LN  岭南  {ln,岭南}
               *
               * 岭南：
               *          DX  电信学院
               *          YS  艺术学院
               *          WY  外语学院
               *
               * {LN={DX=电信学院,YS=艺术学院,WY=外语学院}}
               *
               * */

可变参数
格式：
修饰符返回值 方法名(参数类型... 参数名){

}
可变参数其实是一个数组
注：
一个方法中有可变参数，那么这个可变参数只能在参数列表的最后一位

例：
       public static int sum(int... arr) {
              int sum = 0;
              for (int i = 0; i < arr.length;i++) {
                     sum += arr;
              }
              return sum;
       }





Throwable: 异常

Throwable是异常的超类，有两个子类：
       |--Error : 错误(严重，必须修改代码来解决)
       |--Exception : 异常(不严重，如果是编译期间异常，直接throws(一般方法调用的时候用throws)或者try...catch...；如果是运行期间异常(RuntimeException)，修改代码)

Throwable类下的方法：
实际开发中常用的就一个：public void printStackTrace() : 把异常信息显示到控制台

处理异常格式：

try{
  可能出异常的代码
}catch(异常类名 变量名){
  出异常后的处理方案
}finally{
  无论出不出异常都要被执行的代码  // 释放资源(IO/数据库)
}

注意：1、在异常处理中，一旦try里面出异常了，就直接跳到catch里面执行，异常后面的代码不再执行
      2、finally里面的代码绝对会被执行

一段代码中可能有多个异常的情况：
1、一个个try...catch...
2、所有的代码写一个try...多个catch...catch...
注：针对2这种情况，JDK1.7新特性：
try{

}catch(异常1 | 异常2 | 异常3 变量名e){
       e.printStackTrace();// 自动匹配异常并把错误信息显示到控制台
}

注：1、try里面的代码越少约好，因为JVM需要分配资源去管理异常，try里面代码越多越占资源
    2、当明确知道异常类型的时候，异常类名就写具体的异常，如果不知道异常类型，写父异常Exception，推荐写明确的异常，因为Exception下面有很多子异常，JVM需要一个个去匹配，效率低
    3、多个catch...catch...之间，如果异常是平级关系，那么catch的异常与顺序无关，如果存在父子关系，父异常要放在后面，如果放前面，后面的子异常会报错，因为异常会多态赋值给父异常，后面的子异常存在没有意义，就会报错


面试题：
1、final、finally、finalize(Object里的一个方法:垃圾回收器)的区别
2、如果在catch中有return，finally里面的代码是否会被执行，如果执行，在return前还是后
       会在return前执行，因为return后面的代码都不生效


补充：

异常处理基本原则：

1、如果你不能处理异常，不要捕获该异常

2、如果要捕获，应在离异常源近的地方捕获它

3、不要吞没你捕获的异常（就是捕获的异常，但是什么也不做）

4、除非你要重新抛出异常，否则把它log起来

5、当一个异常被重新包装，然后重新抛出的时候，不要打印statck trace

6、用自定义的异常类，不要每次需要抛出异常的时候都抛出java.lang.Exception。方法的调用者可以通过throws知道有哪些异常需要处理--所以它是自我描述的

7、如果你编写业务逻辑，对于终端用户无法修复的错误，系统应该抛出非检查的异常（unchecked exception）；如果你编写一个第三方的包给其他的开发人员用，对于不可修复的错误要用需要检查的异常（checked exception）

8、绝对不要因为写throws语句会让你用起来不舒服，而不声明需要检查的异常

9、应用级别的错误或不可修复的系统异常用非检查的异常（unchecked exception）抛出（注意是错误，意味着不可修复，比如配置文件错误）

10、根据异常的粒度组织你的方法



File类

对文件或文件夹进行操作的类（电脑上能看到的东西，要么是文件要么是文件夹）
所以，File既能表示某个具体的文件，又能表示目录路径（文件夹）,取决于构造方法里面传入的参数

构造方法：
publicFile(String pathname) // pathname：可以传文件也可以传文件夹，但都得以路径的形式
创建一个file对象，指向所传入的文件，仅作指向操作，没有其他作用

绝对路径：以盘符开始的路径（D:\\）
相对路径：不以盘符开始的路径，但要明确相对于谁的路径（一般相对于项目的根目录）

publicFile(String parent,String child) : 根据传入的父目录和子目录创建file对象

publicFile(File parent,String child) : 根据传入的父file对象和子路径创建一个新的file对象


成员方法：
  1、创建功能：
       创建文件：public booleancreateNewFile()
       如果指定的文件不存在就创建一个新文件，返回true，如果指定的文件存在，就不创建，返回false
      
       创建文件夹：
       public boolean mkdir():创建指定的文件夹，不存在就创建，返回true，存在就不创建，返回false
       public boolean mkdirs():创建多级目录，父目录和子目录都会创建

  2、删除功能
       public boolean delete():既可以删除文件，又可以删除目录，取决于你创建的file对象

       注意：如果删除的目录下还有文件或文件夹，那么删除会返回false，必须先把子目录删掉才能删父目录
            delete方法删除的文件，不会到回收站中，会被直接删除，相当于 Shift + Delete

  3、判断功能
       public boolean exists():文件或目录是否存在
       public boolean isAbsolute():是否是绝对路径
       public boolean isFile():是否是文件
       public boolean isDirectory():是否是目录
       public boolean isHidden()是否隐藏
       public boolean canRead():是否可读
       public boolean canWrite():是否可写

  4、获取功能
       public String getAbsolutePath():获取file对象的绝对路径
       public String getPath():获取相对路径
       public String getName():获取文件名
       public long length():获取文件内容的字节数
       public long lastModified():获取最后一次修改时间的毫秒值

       public static File[] listRoots():获取所有的盘符根目录
       public String[] list():获取指定目录下所有文件和文件夹的名字
       public File[] listFiles():获取指定目录下所有文件和文件夹的对象

       public String[] list(FilenameFilterfilter):获取符合某种条件的文件和文件夹名字
              FilenameFilter:文件名过滤器接口
                     用匿名内部类，实现 accept(File dir,String name) 方法
                     dir: file对象所指向的目录  ，name: 获取到的此目录下的文件名

       例：获取D盘下所有.txt文件
              在accept方法中，通过File(String parent,String child)构造方法拼接file对象
              判断file是否是文件，再判断是否是.txt文件，都满足的条件再返回

   5、重命名
       public boolean renameTo(File dest)
例:
       File f = new File("a.txt");
       f.renameTo(new File("aa.txt"));



递归

定义：方法定义的时候在调用本身

注意：
  1、一定要有一个出口，否则会造成死循环
  2、构造方法不能递归调用


例1：求n!

publicstatic int jc(int n){
       if(n == 1){
              // 出口
              return 1;
       }else{
              // 规律
              return n * jc(n - 1);
       }
}

例2：求某个文件夹及其子文件夹下所有 ".txt" 文件
      
       public static void showFiles(File file){
              
              File[] files = file.listFiles();

              for (File f : files) {
                     if (f.isDirectory()) {
                            showFiles(f);
                     }else {
                            if (f.getName().endsWith(".txt")){
                                   System.out.println(f.getAbsolutePath());
                            }
                     }
              }
       }





IO流

定义：Input/Output 输入输出流
作用：处理特殊的文件在不同设备上的读取和写入（一般用来处理文件在服务器上的上传下载）

IO流分类
  按流向分
       字节流：万能的，绝对不会错，如果分不清什么文件，用字节流
              |--字节输入流：读取数据  InputStream --> FileInputStream
              |--字节输出流：写入数据  OutputStream --> FileOutputStream

       字符流：处理长文本，效率更高（记事本打开能看得懂的文件，用字符流）
              |--字符输入流：读取数据   Reader --> InputStreamWriter  --> FileReader
              |--字符输出流：写入数据   Writer --> OutputStreamWriter --> FileWriter

注意：FileWriter/FileReader 都没有无参构造，因为必须指定读写位置


字符流

一、FileWriter

构造方法
1、publicFileWriter(File file)
2、publicFileWriter(String fileName) : 指定文件路径，如果文件不存在，就自动创建；如果文件存在，就覆盖
3、publicFileWriter(String fileName,boolean append) : 允许每次写文件都往原内容后面追加，而不是覆盖（默认为覆盖）

成员方法
1、publicvoid write(String str) : Writer类中的方法，写入一个字符串
2、publicvoid flush() : OutputStreamWriter类中的方法，刷新该流的缓冲（Write()并没有直接把数据写入文件，而是保存到了缓冲区里面）
3、publicvoid close() : OutputStreamWriter类中的方法，关闭流，关闭之前推荐先刷新流（它本身也会刷新），在关闭该流之后，不能再调用 write() 或 flush() ，不能关闭以前关闭过的流，每个IO流操作，必须要执行close()

面试题：
为什么IO流里面必须要执行close() ？
1、让流对象变成垃圾，好让垃圾回收器回收
2、通知系统释放和文件相关的资源（构造方法中会自动创建文件，创建一个文件，系统就会分配资源去管理文件）

为什么字符流里面要先flush()再close()，是不是要每操作一次就刷新一次 ？
因为字符流的write()方法并不是把数据直接写到文件里，而是写到了缓冲区，如果文件过大（比如上传下载大文件），会很吃内存，所以因该要在一个合适的时间调用flush()，而不能最后调close()的时候刷新，但也不要刷新频率过高，可以设置为(100M左右刷一次)

注：想让写入的数据换行，加"\r\n" // 为了识别不同的系统和环境，两个都写上


二、FileReader

构造方法
1、publicFileReader(File file)
2、publicFileReader(String fileName) : 指向需要读取的文件 // 文件必须存在

成员方法
1、publicint read() : 读取一个字符，返回一个ASCII码表中字符对应的int类型的数，当字符不存在时，返回 -1
2、publicint read(char[] chs) : 一次读一个数组，数组自定义，长度一般为1024的整数倍，当读不到数据时，返回 -1
3、publicvoid close() : 无论读写，都需要关流

注：读没有刷新方法（flush()），写有


例1：拷贝文件
       // 创建输入流
       FileReader fr = newFileReader("a.txt");
       // 创建输出流
       FileWriter fw = newFileWriter("b.txt");
       // 读取文件
       int ch = 0;
       while ((ch=fr.read()) != -1) {
              // 读取的同时写文件
              fw.write(ch);
              // 刷新,数据太少，可以不刷新
              fw.flush();
       }
       // 关闭流操作，输入输出都得关闭
       fw.close();
       fr.close();

例2：
       // 创建输入流
       FileReader fr = new FileReader("b.txt");
       // 读取，每次读一个数组
       // 创建一个数组
       char[] chs = new char[4];
       int len = 0;// 实际有效长度
       while ((len = fr.read(chs)) != -1) {
              System.out.print(newString(chs,0,len));
       }
       // 关流
       fr.close();



字节流（OutputStream/InputStream）

FileOutputStream: 字节输出流，写

构造方法
publicFileOutputStream(String name)
publicFileOutputStream(File file)

成员方法
publicvoid close():关闭流，字节流一般不用刷新方法
publicvoid write(int b): 写一个字符
publicvoid write(byte[] b) : 写一个字符数组 // byte[] bys = "abcdefg".getBytes();


FileInputStream: 字节输入流，读

构造方法
publicFileInputStream(String name)
publicFileInputStream(File file)

成员方法
publicint read()
publicint read(byte[] b)
publicvoid close()

例：用字节流复制图片



缓冲流


流数据的读写，每次读一个字符(字节)效率很低，也可以每次读一个数组（一般数组长度为1024的倍数），效率高。但是每次写起来麻烦，因此Java提供了一套高效的流：缓冲流(带缓冲区的流)（只是读写效率高了，代码写起来跟以前还是差不多）

BufferedWriter: 字符缓冲流写数据

构造方法:
publicBufferedWriter(Writer out) : 创建一个使用默认大小输出缓冲区的缓冲字符输出流

例:
BufferedWriterbw = new BufferedWriter(new FileWriter("a.txt"));

注:
为什么传递的是Writer
       因为BufferedWriter这种流，被称为缓冲流，它只提供数据的缓冲功能
       真正的读写还得靠别人。所以，我们这里将使用FileWriter作为参数传递
       缓冲区只提供缓冲功能，没有真正的读写。

基本流: 能直接进行读写的流对象
高级流: 站在基本流的基础上，提供一些特殊的功能(处理流)


成员方法:
publicvoid write(String str)

publicvoid newLine(): 根据系统写入一个行分隔符
例:
       bw.newLine(); // 换行

publicvoid flush()
publicvoid close()


BufferedReader: 字符缓冲流读数据

构造方法:
publicBufferedReader(Reader in)

例：
BufferedReaderbr = new BufferedReader(new FileReader("c.txt"));

成员方法:
publicint read()
publicint read(char[] cbuf,int off,int len)

publicString readLine(): 根据系统读取一个文本行。通过下列字符之一即可认为某行已终止：换行 ('\n')、回车 ('\r') 或回车后直接跟着换行
例:
       String line = null;
       while((line=br.readLine())!=null){
              System.out.println(line);
       }

publicvoid close()


BufferedOutputStream: 字节缓冲流写数据
BufferedInputStream  : 字节缓冲流读数据

用法跟字符缓冲流一样，没有新方法


打印流（只有写数据）

PrintStream: 打印字节流
能够方便地打印各种数据值表示形式，并且能自动写数据、换行、刷新

构造方法:
publicPrintStream(OutputStream out,boolean autoFlush)

成员方法: 查看API

PrintWriter: 打印字符流
如果启用了自动刷新，则只有在调用 println、printf 或format 的其中一个方法时才可能完成此操作

构造方法:
publicPrintWriter(OutputStream out,boolean autoFlush)

成员方法:
publicvoid println(): 通过写入行分隔符字符串终止当前行
publicvoid println(String x): 打印 String，然后终止该行

例:
       PrintWriter pw = new PrintWriter(new FileWriter("a.txt"),true);
       pw.println("hello"); //写数据，换行，刷新
       pw.println("world");


转换流

通过构造方法实现字节流与字符流互转

OutputStreamWriter: 字符流转字节流
构造方法:
publicOutputStreamWriter(OutputStream out)

InputStreamReader  : 字节流转字符流
构造方法:
publicInputStreamReader(InputStream in)



序列化流

有些类需要进行网络传输（比如JavaBean），就必须实现序列化接口(implementsSerializable)，并给它添加一个ID，以解决黄色警告现的问题:(鼠标点点)
privatestatic final long serialVersionUID = 333558257579870816L;




多线程(Thread)

定义：指应用程序有多条执行路径

作用：提高效率

什么时候使用：当要操作的代码的内容比较多(耗时)，循环次数较多的情况下使用（一般用在上传下载）


Thread类的常用方法

构造方法:
publicThread(Runnable target)

成员方法:
publicfinal String getName(): 获取当前线程的名称，默认从Thread0开始
publicfinal void setName(String name): 修改线程名称
publicstatic Thread currentThread(): 获取当前线程对象

publicfinal int getPriority(): 获取线程的优先级（默认为5，范围1--10，数值越大，优先级越高）
publicfinal void setPriority(int newPriority): 设置线程的优先级
MAX_PRIORITY= 10
MIN_PRIORITY= 1
NORM_PRIORITY= 5
注：优先级可以在一定程度上让线程获取较多的执行机会，但仅在一定程度上而已

publicfinal void join(): 启动某个线程后，加入线程（加入后，这个线程会一直被执行，其他线程等待，直到这个线程执行完毕其他线程才能执行）

publicfinal void setDaemon(boolean on): 将该线程标记为守护线程(该方法必须在启动线程前调用)，设置为守护线程后，该线程就依赖于其他线程的存在
publicfinal boolean isDaemon():该线程是否为守护线程

publicstatic void yield(): 暂停当前线程，执行其他线程（在一定程度上平均分配执行机会，但并不绝对，想要绝对公平，推荐使用等待唤醒机制）
publicstatic void sleep(long millis): 让线程睡millis毫秒（暂停）


会用到的Object中的方法（等待唤醒机制，用锁对象去调用）
publicfinal void wait(): 让当前线程等待
publicfinal void notify(): 唤醒线程

注：wait()和sleep(long millis)的异同
1、都是让线程等待
2、sleep(longmillis)是Thread类的静态方法，需要传递参数。不释放锁对象
3、wait()是Object类的方法，可以不用传递参数（也可以传一个0）。释放锁对象


使用方式1: 继承Thread类
         1、定义一个类继承Thread类
         2、子类要重写Thread类的run()方法
         3、让线程启动并执行

    注意：启动线程并执行，不是直接调用run()，而是调用start()。这个方法做了两件事情:
         1、启动线程
         2、自动调用run()方法

补充：开启多个线程需要创建多个线程对象，分别调用start()

例：
publicclass MyThread extends Thread{
       @Override
       public void run() {
              for (int i = 0; i < 100; i++) {
                     System.out.println(getName()+"---"+i);
              }
       }
}

publicclass ThreadTest {
       public static void main(String[] args) {
              MyThread mt1 = new MyThread();
              MyThread mt2 = new MyThread();
              
              mt1.setName("Cang");
              mt2.setName("XiaoZe");
              
              mt1.start();
              mt2.start();
              
       }
}


使用方式2: 实现Runnable接口
       1、创建一个类实现Runnable接口
       2、重写run()方法
       3、创建这个类的实例
       4、把类的实例作为Thread的构造参数传递，创建Thread对象

注：推荐用方式2，原因：
       方式2避免了方式1单继承的局限性
       方式2只创建了一次资源对象，更好的实现了操作和数据的分离

例：
publicclass MyThread2 implements Runnable {
       @Override
       public void run() {
              for (int i = 0; i < 100; i++) {
                     System.out.println(Thread.currentThread().getName()+"---"+i);
              }
       }
}

publicclass ThreadTest {
       public static void main(String[] args) {
              MyThread2 mt = new MyThread2();
              Thread t1 = new Thread(mt);
              Thread t2 = new Thread(mt);
              
              t1.setName("Cang");
              t2.setName("XiaoZe");
              
              t1.start();
              t2.start();
       }
}


例：售票
publicclass TicketThread implements Runnable{
       private int tickets = 50;
       @Override
       public void run() {
              while(true){
                     if (tickets > 0) {
                            try {
                                   Thread.sleep(100);
                            } catch(InterruptedException e) {
                                   e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName()+"正在出售第:"+(tickets--)+" 张票");
                     }
              }
       }
}

publicclass TicketsTest {

       public static void main(String[] args) {
              
              TicketThread tt = newTicketThread();
              
              Thread t1 = new Thread(tt);
              Thread t2 = new Thread(tt);
              Thread t3 = new Thread(tt);
              Thread t4 = new Thread(tt);
              
              t1.setName("窗口1");
              t2.setName("窗口2");
              t3.setName("窗口3");
              t4.setName("窗口4");
              
              t1.start();
              t2.start();
              t3.start();
              t4.start();
       }
}

注：由于线程的随机性和延迟性，导致线程访问共享数据时出现了线程安全的问题

哪些代码会出现线程安全问题？
1、有共享数据
2、该共享数据被多条语句操作
3、上面的代码都在多线程程序中

该怎么解决线程安全的问题？
找到可能出问题的代码，给它加个锁，只有当前线程把被锁住的代码执行完毕，别的线程才能执行这段代码。（一次只让一个线程访问）

加锁: synchronized
1、代码锁（同步代码块）（推荐使用）
格式:
synchronized(锁对象){

有线程安全问题，需要被锁的代码;

}

锁对象: 锁可以是任意锁（任意对象），但多个对象调用该段代码时，必须使用同一把锁
       锁对象可以用Object对象，也可以是其他自定义的对象，推荐直接使用 this 关键字，表示当前类的对象（synchronized(this)）
       如果是被 static 修饰的静态方法，里面没有 this 关键字，此处锁对象用当前类的字节码文件对象: "类名.class"（synchronized(TicketThread.class)）

2、方法锁(同步方法)
把锁加到方法上，直接在方法上加 synchronized 关键字

注意：要防止出现死锁
死锁：线程A在等线程B释放锁的同时线程B在等线程A释放锁


对上面代码的改进:

publicclass TicketThread implements Runnable{
       private int tickets = 50;
       @Override
       public void run() {
              while(true){
                     synchronized (this) {
                            if (tickets > 0){
                                   try {
                                          Thread.sleep(100);
                                   } catch(InterruptedException e) {
                                          e.printStackTrace();
                                   }
                                   System.out.println(Thread.currentThread().getName()+"正在出售第:"+(tickets--)+" 张票");
                            }
                     }
              }
       }
}


等待唤醒机制:
Object中的方法（等待唤醒机制，用锁对象去调用）
publicfinal void wait(): 让当前线程等待
publicfinal void notify(): 唤醒线程


例：让窗口12轮流出票

publicclass TicketThread implements Runnable{
       private int tickets = 50;
       @Override
       public void run() {
              while(true){
                     synchronized (this) {
                            if (tickets > 0){
                                   try {
                                          Thread.sleep(100);
                                   } catch(InterruptedException e) {
                                          e.printStackTrace();
                                   }
                                   this.notify();// 一个线程过来，唤醒下一个线程
                                   System.out.println(Thread.currentThread().getName()+"正在出售第:"+(tickets--)+" 张票");
                                   try {
                                          this.wait();//执行完毕后，当前线程等待，等待下一个线程将它唤醒
                                   } catch(InterruptedException e) {
                                          e.printStackTrace();
                                   }
                            }
                     }
              }
       }
}




网络编程(Socket)

网络中不同计算机上程序间的数据交换（多台计算机在网络上通信）

网络参考模型
1、OSI 七层参考模型: 应用层、表示层、回话层、传输层、网络层、数据链路层、物理层
2、TCP/IP四层参考模型: 应用层、传输层、网际层、主机至网络层

网络通信三要素
1、IP地址（InetAddress）: 网络中每一台计算机的唯一标识（不易记，可用主机名代替）

2、端口: 用于标识不同进程的逻辑地址

3、传输协议 :通讯规则(TCP/UDP)


IP地址

由4段点分十进制组成，每段十进制范围是 0-255

IP地址的分类：
       A类       1.0.0.1---127.255.255.254    (1)10.X.X.X是私有地址(私有地址就是在互联网上不使用，而被用在局域网络中的地址)                                                               (2)127.X.X.X是保留地址，用做循环测试用的。
       B类 128.0.0.1---191.255.255.254 172.16.0.0---172.31.255.255是私有地址。169.254.X.X是保留地址。
       C类       192.0.0.1---223.255.255.254 192.168.X.X是私有地址
       D类       224.0.0.1---239.255.255.254      
       E类 240.0.0.1---247.255.255.254

我们常用的是C类，DE类为保留地址


IP地址的组成：
       IP地址 = 网络号码+主机地址 (网络号码固定，主机地址可在0-255之间变化)

       A类IP地址 :第一段号码为网络号码，剩下的三段号码为本地计算机的号码（一共可以配 256*256*256 =16777216 台主机）

       B类IP地址 :前二段号码为网络号码，剩下的二段号码为本地计算机的号码（256*256 = 65536）

       C类IP地址 :前三段号码为网络号码，剩下的一段号码为本地计算机的号码（ 256 ）

补充：常用CMD命令
1、ipconfig: 查看本机IP
2、ping+IP地址 : 查看网络是否有问题

例：
       ping 127.0.0.1  : 本机回环地址，查看本机网络是否有问题（丢包）
       ping www.baidu.com : 查看是否能与百度通信(是否能连上百度)


端口：
物理端口 : 网卡口
逻辑端口 : 应用程序端口（我们指的就是逻辑端口）
1、每个网络程序都会至少有一个逻辑端口
2、用于标识进程的逻辑地址，不同进程的标识不一样
3、有效端口：0~65535，其中0~1024系统使用或保留端口


协议：
定义的通信规则

TCP协议
1、需要建立连接，形成传输数据的通道（建立连接通道）
2、数据大小不受限制
3、通过三次握手完成连接
4、协议可靠，但是传输速度慢

UDP协议
1、将数据源和目的地封装成数据报包
2、数据包的大小有限制，不超过64k
3、不需要建立连接
4、不可靠协议，但是传输速度快


Socket
Socket用于描述主机的IP地址和应用程序的端口号，每个应用程序所打开的服务里面都有一个Socket（Socket里面包含了当前主机IP，当前应用的端口号）
Socket是网络编程提供的一种机制，通信两端都有Socket，所以，网络通信其实就是Socket间的通信，数据在Socket间通过IO流传输


UDP要用到的类

InetAddress类

没有构造方法，那么有两种情况
1、所有方法都是静态的
2、有一个静态方法能返回 InetAddress 对象

成员方法:
publicstatic InetAddress getByName(String host) : 通过主机名获取IP地址对象（主机名可以是机器名（如 "java.sun.com"），也可以是其 IP 地址的文本表示形式）

publicString getHostAddress() : 返回 IP 地址字符串
publicString getHostName() : 获取此 IP 地址的主机名



DatagramSocket类 : 此类表示用来发送和接收数据报包(UDP)的Socket

构造方法:
publicDatagramSocket() : 创建UDP的Socket对象（一般用于创建发送端Socket对象）
publicDatagramSocket(int port) : 创建UDP的Socket对象并将其绑定到本地主机上的指定端口（一般用于创建接收端Socket对象，此处的端口需要和发送端包装的数据报包中的端口一致）

成员方法:
publicvoid send(DatagramPacket p) : 发送已经被 DatagramPacket 打包好的数据报包（发送的是DatagramPacket的对象）
publicvoid receive(DatagramPacket p) : 接收数据包，接收之前需要先创建 DatagramPacket 对象，用于作接收数据的容器

publicvoid close() : 关闭此Socket（因为底层调用了IO，所以要关闭）



DatagramPacket类 : 此类表示数据报包（用来打包数据报包，使用构造方法就能打包）

构造方法:
publicDatagramPacket(byte[] buf,int length,InetAddress address,int port) : 构造方法打包数据报包（发送端）

buf- 包数据（是一个byte[]）
length- 包长度
address- 目的地址（InetAddress 类的 getByName(String host)）
port- 目的端口号（自定义）

DatagramPacket(byte[]buf, int length) : 用来接收长度为 length 的数据包（数组）（接收端）

成员方法:
publicbyte[] getData() : 获取数据报包里的数据
publicint getLength() : 获取要发送或者接收到的数据的长度
publicInetAddress getAddress() : 获取数据报包中的IP地址


例：局域网聊天室

接收端
publicclass Receive {

       public static void main(String[] args)throws IOException {
              
              // 创建Socket对象
              DatagramSocket ds = newDatagramSocket(10086);
              while (true) {
                     // 接收数据
                     byte[] b = new byte[1024];
                     DatagramPacket dp = newDatagramPacket(b, b.length);
                     ds.receive(dp);
                     
                     // 解析数据并显示
                     String ip =dp.getAddress().getHostAddress();
                     byte[] b2 = dp.getData();
                     String s = new String(b2,0, dp.getLength());
                     Date d = new Date();
                     SimpleDateFormat sdf = newSimpleDateFormat("HH:mm:ss");
                     System.out.println(sdf.format(d));
                     System.out.println(ip+" Say: "+s);
              }
              
       }

}

发送端
publicclass Send {

       public static void main(String[] args)throws IOException {
              
              // 创建Socket对象
              DatagramSocket ds = newDatagramSocket();
              
              Scanner sc = newScanner(System.in);
              while (true) {
                     // 包装数据
                     String line =sc.nextLine();
                     if(line.equals("886")) {
                            break;
                     }
                     byte[] b = line.getBytes();
                     DatagramPacket dp = newDatagramPacket(b, b.length, InetAddress.getByName("10.61.1.131"),10086);
                     // 发送
                     ds.send(dp);
              }
              
              // 释放资源
              ds.close();
              
       }

}



TCP要用到的类

Socket类

构造方法:
publicSocket(String host,int port) : 创建一个Socket并将其连接到指定主机上的指定端口号，一般用在客户端（发送端）

成员方法:
publicInputStream getInputStream(): 获取此Socket的输入流
publicOutputStream getOutputStream() : 获取此Socket的输出流

publicvoid close(): 关闭Socket


ServerSocket类

构造方法:
publicServerSocket(int port) : 创建绑定到特定端口的服务器Socket ，一般用在服务器端（接收端）

成员方法:
publicSocket accept() : 监听并接受到此Socket的连接，此方法在连接传入之前一直阻塞，注意: 返回的是Socket对象，可以用Socket类里面的方法
publicInetAddress getInetAddress() : 获取主机地址，返回值是 InetAddress 对象，可调用 getHostAddress() 获取IP地址
publicvoid close()


例：TCP网络聊天室

服务器端
publicclass Service {
       public static void main(String[] args)throws IOException {
              // 创建Socket对象
              ServerSocket ss = newServerSocket(10086);
              // 监听
              Socket s = ss.accept();
              // 获取Socket里面的输入流
              InputStream is =s.getInputStream();
              while(true){
                     byte[] b = new byte[1024];
                     int len = 0;
                     while((len = is.read(b)) !=-1){
                            String ip =s.getInetAddress().getHostAddress();
                            String mess = newString(b,0,len);
                            System.out.println(ip+" 说了: "+mess);
                     }
                     /*// 关闭资源
                     ss.close();*/
              }
       }
}


客户端
publicclass Client {
       public static void main(String[] args)throws IOException {
              // 创建Socket对象
              Socket s = newSocket("192.168.1.101",10086);
              // 获取输出流，写数据
              OutputStream os =s.getOutputStream();
              Scanner sc = newScanner(System.in);
              while(true){
                     String line =sc.nextLine();
                     if(line.equals("over~")){
                            break;
                     }
                     os.write(line.getBytes());
              }
              // 释放资源
              s.close();
       }
}



数据库编程(JDBC)

常用数据库：MySQL、Oracle、SqlServer、Sybase...

数据库厂商推出数据库的同时还配备了数据库驱动

Java通过操作数据库驱动操作数据库

但是这样效率很低，需要了解每一个驱动，而且换一个数据库就得重新写代码，为了解决这个问题，SUN推出了JDBC技术

JDBC: Java Database Connectivity,是SUN推出的操作数据库的规范

JDBC和数据库驱动：规范和实现的关系

我们数据库编程需要知道JDBC提供的接口、类、方法，还要有对应的数据库驱动

JDBC在JDK中，包名一般为：java.sql.* ；javax.sql.*

驱动：去数据库厂商的网站下载



JDBC开发步骤

0、搭建开发环境：把数据库驱动的jar包加入到构建路径中。

1、注册驱动
2、获取与数据库的链接
3、创建代表SQL语句的对象
4、执行SQL语句
5、如果是查询语句：返回结果集
6、释放资源


增加
publicclass TestSql {

    public static void main(String[] args)throws Exception{
        // 1、注册驱动
        // DriverManager.registerDriver(newDriver());
       Class.forName("com.mysql.jdbc.Driver");
        // 2、获取与数据库的链接
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
        // 3、创建代表SQL语句的对象
        Statement sta = con.createStatement();
        // 4、执行SQL语句
        sta.execute("INSERT INTOstudent(name,age,sex,class) VALUES ('小刚',21,'男','2班')");
        // 5、释放资源
        sta.close();
        con.close();
    }
}

删除
//4、执行SQL语句
sta.execute("DELETEFROM student WHERE id=3");

修改
//4、执行SQL语句
sta.execute("UPDATEstudent SET name='哈哈' WHERE id=3");


查询
publicclass TestSql {

    public static void main(String[] args)throws Exception{

       // 1、注册驱动
       Class.forName("com.mysql.jdbc.Driver");
       // 2、获取与数据库的链接
        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
       // 3、创建代表SQL语句的对象
        Statement sta = con.createStatement();
       // 4、执行SQL语句
        String sql = "select * fromstudent";
        ResultSet rs = sta.executeQuery(sql);
       // 5、如果是查询语句：返回结果集。
        while(rs.next()){
           System.out.println(rs.getObject(1));
           System.out.println(rs.getObject(2));
           System.out.println(rs.getObject(3));
           System.out.println(rs.getObject(4));
           System.out.println(rs.getObject(5));
        }

       // 6、释放资源
        rs.close();
        sta.close();
        con.close();
    }
}
