package 总结API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class map的一些方法使用 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new map的一些方法使用().testHashMapCompute();
	}

    /**
     *  forEach(BiConsumer<? super K, ? super V> action)
     *  循环key,value
     */
    @Test
    public static void testHashMapForEach(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");
        map.put("d","ddd");

        map.forEach((k,v)->{
            System.out.println(k+"  "+v);
        });
        /**
         * a  aaa
         * b  bbb
         * c  ccc
         * d  ddd
         */

    }

    /**
     *  V getOrDefault(Object key, V defaultValue)
     *  如果根据key得到value为null并且不包含这个key，则返回默认设置的值
     */
    @Test
    public static void testHashMapGetOrDefault(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","aaa");
        map.put("b",null);
        map.put("c","ccc");
        map.put("d","ddd");

        String orDefault1 = map.getOrDefault("a", "eeee");
        String orDefault2 = map.getOrDefault("b", "eeee");
        String orDefault3 = map.getOrDefault("m", "eeee");
        System.out.println(orDefault1+"  "+orDefault2+"   "+orDefault3);
        /**
         * aaa  null   eeee
         */

    }


    /**
     * compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
     *         Objects.requireNonNull(remappingFunction);
     *         V oldValue = get(key);
     *         V newValue = remappingFunction.apply(key, oldValue);
     *
     *   只要新value不为null就会插入新key或者覆盖原来value,如果新value为null,就会把这个键值对直接删除
     */
    @Test
    public void testHashMapCompute(){
        List<Student> studentList = Arrays.asList(
                new Student("apple",null,10),
                //new Student("orange","女",30),
                //  new Student("pink",null,60),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("orange",null,150)
        );
        Map<String,String> map = new HashMap<String, String>();
        map.put("pink",null);//原来为空，测试现在不为空
        map.put("orange","女");//原来不为空，测试现在为空
        map.put("apple",null);//原来为空，测试现在为空
        System.out.println(map);
        studentList.stream().forEachOrdered(student->map.compute(student.getName(),(k,v)->{
            return student.getSex();}));
        System.out.println(map);
        // {pink=男, black=男}
    }

    /**
     * computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
     *         Objects.requireNonNull(mappingFunction);
     *         返回值就是Function里面的V，所以computeIfAbsent方法执行后还可以继续做一系列的操作,
     *         但是value已经放到集合中了，所以只有引用类型才可以继续操作，String不行
     *
     * 只要是原来的value为null,就会插入或者更新，如果不为null，不变
     * 如果新的value为null,则不做操作,原来的数据不会删除
     *
     */
    @Test
    public void testHashMapComputeIfAbsent(){
        List<Student> studentList = Arrays.asList(
                new Student("apple",null,10),
                //new Student("orange","女",30),
                //  new Student("pink",null,60),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("orange",null,150)
        );
        Map<String,String> map = new HashMap<String, String>();
        map.put("pink",null);//原来为空，测试现在不为空
        map.put("orange","女");//原来不为空，测试现在不为空
        studentList.stream().forEachOrdered(student->map.computeIfAbsent(student.getName(),k->k).toUpperCase());
        //  studentList.stream().forEachOrdered(student->map.computeIfAbsent(student.getName(),k->null));
        System.out.println(map);
        // {{orange=女, apple=apple, pink=pink, black=black}   toUpperCase没有达到效果
    }

    @Test
    public void testHashMapComputeIfAbsent2(){
        List<Student> studentList = Arrays.asList(
                new Student("apple",null,10),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("black","女",80)
        );
        Map<String,List<Student>> map = new HashMap<>();
        studentList.stream().forEachOrdered(
                student->map.computeIfAbsent(student.getName(),k->new ArrayList<Student>()).add(student)
        );
        System.out.println(map);
        // {
        // apple=[Student{name='apple', sex='null', money=10.0}],
        // pink=[Student{name='pink', sex='男', money=60.0}],
        // black=[Student{name='black', sex='男', money=60.0}, Student{name='black', sex='女', money=80.0}]
        // }   add达到效果了
    }


    /**
     * computeIfPresent(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction)
     *
     * 不会插入新key-value，
     * 根据key获取value,
     * 如果oldValue不为null, newValue为null则删除，newValue不为null则更新，
     * 如果oldValue为null，当不存在这个键值对处理，不做任何操作
     */
    @Test
    public void testHashMapComputeIfPresent(){
        List<Student> studentList = Arrays.asList(
                new Student("apple","女",10),
                new Student("pink","男",60),
                new Student("black","男",60),
                new Student("red","女",60),
                new Student("orange",null,150)
        );
        Map<String,String> map = new HashMap<String, String>();
        map.put("pink",null);//原来为空，测试现在不为空
        map.put("orange","女");//原来不为空，测试现在为空
        map.put("apple","男");//原来不为空，测试现在不为空
        studentList.stream().forEachOrdered(student->map.computeIfPresent(student.getName(),(k,v)->{
            return student.getSex();}));
        System.out.println(map);
        // {apple=女, pink=null}
    }

    /**
     *  V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
     *  根据key获取value为null,则用新value，
     *  若不为null, oldvalue与newValue会执行这个函数remappingFunction，赋值给当前key
     */
    @Test
    public void testHashMapMerge(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","aaa");
        map.put("b",null);

        map.merge("a","hahaha",String::concat);
        map.merge("b","hahaha",String::concat);
        System.out.println(map);
        //{a=aaahahaha, b=hahaha}
    }


    /**
     * default V putIfAbsent(K key, V value)
     *
     * 如果获取的value为null,则用赋予新的value（插入或者更新）
     */
    @Test
    public void testHashMapPutIfAbsent(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","aaa");
        map.put("b",null);

        map.putIfAbsent("a","ddd");
        map.putIfAbsent("b","ddd");
        map.putIfAbsent("c","ddd");
        System.out.println(map);
        //{a=aaa, b=ddd, c=ddd}
    }
    class Student{
    	
    	private String name;
    	private String sex;
    	private int age;
    	
		public Student(String name,String sex,int age) {
			super();
			this.age = age;
			this.name = name;
			this.sex = sex;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
    }
}
