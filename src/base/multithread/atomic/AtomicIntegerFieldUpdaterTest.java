package base.multithread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author liyu
 * @date 2019/11/25 17:07
 * @description ����������޸�����ԭ����
 * AtomicIntegerFieldUpdater:ԭ�Ӹ��������ֶεĸ�����
 * AtomicLongFieldUpdater��ԭ�Ӹ��³������ֶεĸ�����
 * AtomicStampedReference ��ԭ�Ӹ��´��а汾�ŵ��������͡����ཫ����ֵ�����ù��������������ڽ��ԭ�ӵĸ������ݺ����ݵİ汾�ţ����Խ��ʹ�� CAS ����ԭ�Ӹ���ʱ���ܳ��ֵ� ABA ����
 * Ҫ��ԭ�ӵظ��¶����������Ҫ��������һ������Ϊ����������޸�����ԭ���඼�ǳ����࣬����ÿ��ʹ�ö�����ʹ�þ�̬���� newUpdater()����һ����������������Ҫ������Ҫ���µ�������ԡ��ڶ��������µĶ������Ա���ʹ�� public volatile ���η���
 */


public class AtomicIntegerFieldUpdaterTest {
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

        User user = new User("Java", 22);
        System.out.println(a.getAndIncrement(user));// 22
        System.out.println(a.get(user));// 23
    }

}

class User {
    private String name;
    public volatile int age;

    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}