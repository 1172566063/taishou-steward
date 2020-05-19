
import com.alibaba.fastjson.JSON;
import com.zkl.taishou.common.VO.CalculateStepOneVO;
import com.zkl.taishou.common.utils.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/11-11:23
 * @Version:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Springboot {


    @Test
    public static void main3(String[] args) {
        /*Double obj=2.54;
        double eps = 1e-10;  // 精度范围
        System.out.println( obj-obj%1+1);*/
        Map<String,Double> map= new Hashtable<>();
        map.put("asdfs",3.56);
        map.put("bsdfs",7.15);
        map.put("csdfs",2.00);
        map.forEach((K,V)->{
            if(!CommonUtils.isIntegerForDouble(V)){
                V=V-V%1+1;
                map.put(K,V);
            }

        });

        System.out.println(JSON.toJSONString(map));
    }


    @Test
    public static void main2(String[] args) {
        CalculateStepOneVO calculateStepOne=new CalculateStepOneVO();
        calculateStepOne.setUserId(new Long(1));
        calculateStepOne.setArea(new Long(20));
        calculateStepOne.setBedNum(new Long(30));
        calculateStepOne.setClientNum(new Long(40));
        calculateStepOne.setRoomNum(new Long(50));
        calculateStepOne.setStaffNum(new Long(60));
        Integer yearAnnualTurnover=35000;
        Map map = new ConcurrentHashMap();
        Class calculateStepOneClass = calculateStepOne.getClass();
        Field[] declaredFields = calculateStepOneClass.getDeclaredFields();
        try {
            for(Field field:declaredFields){
                String name = field.getName();
                if(name.equals("serialVersionUid")||name.equals("userId")){
                    continue;
                }
                Field declaredField = calculateStepOneClass.getDeclaredField(name);
                declaredField.setAccessible(true);
                Object aDouble = declaredField.get(calculateStepOne);

                map.put(field.getName()+"Contribution",yearAnnualTurnover/Long.valueOf(String.valueOf(aDouble)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(map));
    }


    @Test
    public static void test(String[] args)throws InterruptedException,ExecutionException{
            ExecutorService exec= Executors.newCachedThreadPool();
            ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
            ArrayList<Future<String>> resultss = new ArrayList<Future<String>>();
            resultss.add(exec.submit(new test2("a","b")));
            System.out.println("a");
            results.add(exec.submit(new test1(1,2)));

        System.out.println("b");
        for (Future<String> fs : resultss) {
            if (fs.isDone()) {
                System.out.println(fs.get());
            } else {
                System.out.println("Future result is not yet complete");
            }
        }
        for (Future<Integer> fs : results) {
            if (fs.isDone()) {
                System.out.println(fs.get());
            } else {
                System.out.println("Future result is not yet complete");
            }
        }
        exec.shutdown();

    }




    static class test1 implements Callable<Integer>{

    private  Integer a,b;
    public test1(Integer c,Integer d){
        this.a=c;
        this.b=d;
    }

        @Override
        public Integer call() throws Exception {
            return a+b;
        }
    }

    static class test2 implements Callable<String>{

    private String c,d;

    public test2(String a,String b){
        this.c=a;
        this.d=b;
        }
        @Override
        public String call() throws Exception {
            return c+d;
        }
    }




}
