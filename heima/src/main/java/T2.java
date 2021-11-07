import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.14
 */
public class T2 {

//    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    public static void main(String[] args) {

//
//        System.out.println(Integer.toBinaryString(Integer.SIZE));
//        System.out.println(Integer.toBinaryString(COUNT_BITS));
//        System.out.println(Integer.toBinaryString(1 << COUNT_BITS));
//        System.out.println(Integer.toBinaryString(CAPACITY));
//        System.out.println(Integer.toBinaryString(RUNNING));
//        System.out.println(Integer.toBinaryString(SHUTDOWN));
//        System.out.println(Integer.toBinaryString(STOP));
//        System.out.println(Integer.toBinaryString(TIDYING));
//        System.out.println(Integer.toBinaryString(TERMINATED));

        System.out.println(                "if (redis.call('hexists', KEYS[1], ARGV[2]) == 1) then " +
                "redis.call('pexpire', KEYS[1], ARGV[1]); " +
                "return 1; " +
                "end; " +
                "return 0;");
    }

}
