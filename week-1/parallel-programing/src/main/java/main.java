import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {
    public  void withStream(){
        IntStream.of(1,2,4,6,7,8).parallel().filter(el-> el>10).forEach(el-> System.out.println(el));
        Stream.of("abc","pqr","lmn");
    }
    public void withoutStream(){
        ArrayList<Integer> nums= new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(4);
        nums.add(6);
        for (int num: nums){
            System.out.println(num*num);
        }
    }

    public static void main(String[] args) {
        main m =new main();
        m.withoutStream();
    }
}
