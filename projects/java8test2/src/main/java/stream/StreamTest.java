package stream;

import lombok.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void list_stream_print(){
        List<String> list = new ArrayList<>();
        list.add("1");
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        stream.forEach(System.out::println);
        parallelStream.forEach(System.out::println);

    }
    public static void array_stream_print(){
        Integer[] nums = new Integer[]{1,2,3,4,5};
        Stream<Integer> stream = Arrays.stream(nums);

        stream.forEach(System.out::println);

    }

    public static void init_stream() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        stream.forEach(System.out::println); // 1 2 3 4 5 6

        System.out.println("------------------------------");
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::println); // 0 2 4 6 8 10

        System.out.println("------------------------------");
        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::println);
    }

    public static void reader_stream(){

        BufferedReader reader =new BufferedReader(new InputStreamReader(StreamTest.class.getResourceAsStream("stream_file.txt")));
        Stream<String> lineStream = reader.lines();
        lineStream.forEach(System.out::println);
    }

    public static void pattern_stream(){

        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
        stringStream.forEach(System.out::println);
    }

    public static void limit_skip_distinct(){
        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);

        Stream<Integer> newStream = stream.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
                .distinct() //6 7 9 8 10 12 14
                .skip(2) //9 8 10 12 14
                .limit(2); //9 8
        newStream.forEach(System.out::println);

    }

    public  static void map_flatmap(){
        List<String> list = Arrays.asList("a,b,c", "1,2,3");

        //将每个元素转成一个新的且不带逗号的元素
        Stream<String> s1 = list.stream().map(s -> s.replaceAll(",", ""));
        s1.forEach(System.out::println); // abc  123

        Stream<String> s3 = list.stream().flatMap(s -> {
            //将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        s3.forEach(System.out::println); // a b c 1 2 3

        list.stream().flatMap(s -> {
            final String s2 = s.replaceAll(",", "");
            return Stream.of(s2);

        }).forEach(System.out::println);

    }

    public void sort(){
        List<String> list = Arrays.asList("aa", "ff", "dd");
        //String 类自身已实现Compareable接口
        list.stream().sorted().forEach(System.out::println);// aa dd ff

        Student s1 = new Student("aa", 10);
        Student s2 = new Student("bb", 20);
        Student s3 = new Student("aa", 30);
        Student s4 = new Student("dd", 40);
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        //自定义排序：先按姓名升序，姓名相同则按年龄升序
        studentList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getName().equals(o2.getName())) {
                        return o1.getAge() - o2.getAge();
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        ).forEach(System.out::println);

    }

    public void peek(){
        Student s1 = new Student("aa", 10);
        Student s2 = new Student("bb", 20);
        List<Student> studentList = Arrays.asList(s1, s2);

        studentList.stream()
                .peek(o -> o.setAge(100))
                .forEach(System.out::println);
    }

    public void end(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        boolean allMatch = list.stream().allMatch(e -> e > 10); //false
        boolean noneMatch = list.stream().noneMatch(e -> e > 10); //true
        boolean anyMatch = list.stream().anyMatch(e -> e > 4);  //true

        Integer findFirst = list.stream().findFirst().get(); //1
        Integer findAny = list.stream().findAny().get(); //1

        long count = list.stream().count(); //5
        Integer max = list.stream().max(Integer::compareTo).get(); //5
        Integer min = list.stream().min(Integer::compareTo).get(); //1

    }

    public void reduce(){
        //经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

        Integer v = list.stream().reduce((x1, x2) -> x1 + x2).get();
        System.out.println(v);   // 300

        Integer v1 = list.stream().reduce(10, (x1, x2) -> x1 + x2);
        System.out.println(v1);  //310

        Integer v2 = list.stream().reduce(0,
                (x1, x2) -> {
                    System.out.println("stream accumulator: x1:" + x1 + "  x2:" + x2);
                    return x1 - x2;
                },
                (x1, x2) -> {
                    System.out.println("stream combiner: x1:" + x1 + "  x2:" + x2);
                    return x1 * x2;
                });
        System.out.println(v2); // -300

        Integer v3 = list.parallelStream().reduce(0,
                (x1, x2) -> {
                    System.out.println("parallelStream accumulator: x1:" + x1 + "  x2:" + x2);
                    return x1 - x2;
                },
                (x1, x2) -> {
                    System.out.println("parallelStream combiner: x1:" + x1 + "  x2:" + x2);
                    return x1 * x2;
                });
        System.out.println(v3); //197474048

    }

    public void collectors(){
        Student s1 = new Student("aa", 10,1);
        Student s2 = new Student("bb", 20,2);
        Student s3 = new Student("cc", 10,3);
        List<Student> list = Arrays.asList(s1, s2, s3);

//装成list
        List<Integer> ageList = list.stream().map(Student::getAge).collect(Collectors.toList()); // [10, 20, 10]

//转成set
        Set<Integer> ageSet = list.stream().map(Student::getAge).collect(Collectors.toSet()); // [20, 10]

//转成map,注:key不能相同，否则报错
        Map<String, Integer> studentMap = list.stream().collect(Collectors.toMap(Student::getName, Student::getAge)); // {cc=10, bb=20, aa=10}

//字符串分隔符连接
        String joinName = list.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")")); // (aa,bb,cc)

//聚合操作
//1.学生总数
        Long count = list.stream().collect(Collectors.counting()); // 3
//2.最大年龄 (最小的minBy同理)
        Integer maxAge = list.stream().map(Student::getAge).collect(Collectors.maxBy(Integer::compare)).get(); // 20
//3.所有人的年龄
        Integer sumAge = list.stream().collect(Collectors.summingInt(Student::getAge)); // 40
//4.平均年龄
        Double averageAge = list.stream().collect(Collectors.averagingDouble(Student::getAge)); // 13.333333333333334
// 带上以上所有方法
        DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(Student::getAge));
        System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());

//分组
        Map<Integer, List<Student>> ageMap = list.stream().collect(Collectors.groupingBy(Student::getAge));
//多重分组,先根据类型分再根据年龄分
//        Map<Integer, Map<Integer, List<Student>>> typeAgeMap = list.stream().collect(Collectors.groupingBy(Student::getType, Collectors.groupingBy(Student::getAge)));

//分区
//分成两部分，一部分大于10岁，一部分小于等于10岁
        Map<Boolean, List<Student>> partMap = list.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 10));

//规约
        Integer allAge = list.stream().map(Student::getAge).collect(Collectors.reducing(Integer::sum)).get(); //40

        Student s4 = new Student("cc", 100,4);
        List<Student> dupList = Arrays.asList(s1, s2, s3,s4);
        final LinkedHashMap<String, Integer> collectResult = dupList.stream()
                .collect(
                        Collectors.toMap(name->name.getName(), type -> type.getType(), (x, y) -> x+y, LinkedHashMap::new));
        collectResult.keySet().forEach(key->System.out.println(key+":"+collectResult.get(key)));
    }
    public static void main(String[] args) {
       new StreamTest().collectors();
    }

    @Data
    private class Student {
        private String name;
        private Integer age;
        private Integer type;

        public Student(String name, int age) {
            this.age=age;
            this.name=name;
        }
        public Student(String name, int age,int type) {
            this.age=age;
            this.name=name;
            this.type=type;
        }
    }
}
