package base.multithread.delayqueue;

import lombok.Getter;
import lombok.Setter;
import lombok.var;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liyu
 * @date 2019/12/25 8:43
 * @description
 */
public class OrderDelay implements Delayed {

    private static final int expireTime = 15000;

    @Getter
    @Setter
    private int orderId;
    @Getter
    @Setter
    private Date orderTime;

    /**
     * ��Ϣ�Ƿ��ڣ��Ƿ���Ա���ȡ�������жϵ����ݡ������ظ�����˵����Ϣ�ѵ��ڣ���ʱ��Ϣ�Ϳ��Ա���ȡ������
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return orderTime.getTime() + expireTime - new Date().getTime();
    }

    /**
     * ��DelayQueue�����������ݻ�ִ�����������������Ӧ�������ĸ�λ�õ��ж����ݡ�
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        return this.orderTime.getTime() - ((OrderDelay) o).orderTime.getTime() > 0 ? 1 : -1;
    }
}
