import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class main {
    public  void withStream(){
        IntStream.of(1,2,4,6,7,8).parallel().filter(el-> el>2).forEach(el-> System.out.println(el));
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
    public void futures(){
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<String> task1=service.submit(()->{
            Thread.sleep(2500);
            return "hello world from task1";
        });
        Future<String> task2=service.submit(()->{
            Thread.sleep(5500);
            return "hello world from task2";

        });
        try{
            if(!task1.isCancelled()){
                System.out.println("task 1 completed  : "+task1.get());
            }
            if(!task2.isCancelled()){
                System.out.println("task2 completed :"+task2.get());
            }


        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    public static void main(String[] args) {
        main m =new main();
        m.futures();
    }
}
