package dataStructure.collection.queue;

/**
 * @author liyu
 * @date 2020/1/20 15:34
 * @description
 */
public class Text {
    public static void main(String[] args) throws Exception {

        //����ʹ������ʵ�ֶ���
        testArrayQueue();

    }

    private static void testArrayQueue() throws Exception {
        int i;
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        i = arrayQueue.deQueue();
        System.out.println("i = " + i);
        i = arrayQueue.deQueue();
        System.out.println("i = " + i);
        i = arrayQueue.deQueue();
        System.out.println("i = " + i);
        arrayQueue.printQueueArray();
        System.out.println("arrayQueue.isEmpty() = " + arrayQueue.isEmpty());
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        arrayQueue.enQueue(4);
        arrayQueue.enQueue(5);
        System.out.println("arrayQueue.isFull() = " + arrayQueue.isFull());
        arrayQueue.printQueueArray();
    }
}
