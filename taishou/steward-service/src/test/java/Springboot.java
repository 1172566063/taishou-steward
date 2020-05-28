
import com.alibaba.fastjson.JSON;
import com.zkl.taishou.common.VO.CalculateStepOneVO;
import com.zkl.taishou.common.entity.calculate.CalculateRecord;
import com.zkl.taishou.common.utils.CommonUtils;
import com.zkl.taishou.common.utils.EntityTransform;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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
    public static void main(String[] args) {
        CalculateStepOneVO calculateStepOne=new CalculateStepOneVO();
        //calculateStepOne.setUserId(new Long(1));
        calculateStepOne.setArea(new Long(20));
        calculateStepOne.setBedNum(new Long(30));
        calculateStepOne.setClientNum(new Long(40));
        calculateStepOne.setRoomNum(new Long(50));
        calculateStepOne.setStaffNum(new Long(60));
//        EntityTransform<CalculateStepOneVO, CalculateRecord> voToEntity=new EntityTransform<>(calculateStepOne,new CalculateRecord());
//        EntityTransform<CalculateStepOneVO, CalculateRecord> voToEntity2=new EntityTransform(calculateStepOne,new CalculateRecord());
//        CalculateRecord calculateRecord = voToEntity.toEntity();
//        CalculateRecord calculateRecord2 = voToEntity2.toEntity();
        CalculateRecord calculateRecord = EntityTransform.Build(calculateStepOne, new CalculateRecord()).toEntity();
        System.out.println(JSON.toJSONString(calculateRecord));
        //System.out.println(JSON.toJSONString(calculateRecord2));
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
