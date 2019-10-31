package dataStructure.set;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] agrs){
//        treeSetBaseDemo();

//        naturalSort();

        customSort();
    }

    public static void treeSetBaseDemo() {
        TreeSet<String> treeSet = new TreeSet<String>();
        System.out.println("TreeSet��ʼ��������С��"+treeSet.size());

        //Ԫ����ӣ�
        treeSet.add("my");
        treeSet.add("name");
        treeSet.add("jiaboyan");
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("3");
        System.out.println("TreeSet������С��" + treeSet.size());
        System.out.println("TreeSetԪ��˳��Ϊ��" + treeSet.toString());

        //����forѭ��������
        for(String str:treeSet){
            System.out.println("����Ԫ�أ�"+str);
        }

        //����������������
        Iterator<String> iteratorAesc = treeSet.iterator();
        while(iteratorAesc.hasNext()){
            String str = iteratorAesc.next();
            System.out.println("����Ԫ������"+str);
        }

        //����������������
        Iterator<String> iteratorDesc = treeSet.descendingIterator();
        while(iteratorDesc.hasNext()){
            String str = iteratorDesc.next();
            System.out.println("����Ԫ�ؽ���"+str);
        }

        //Ԫ�ػ�ȡ:ʵ��NavigableSet�ӿ�
        String firstEle = treeSet.first();//��ȡTreeSetͷ�ڵ㣺
        System.out.println("TreeSetͷ�ڵ�Ϊ��" + firstEle);

        // ��ȡָ��Ԫ��֮ǰ������Ԫ�ؼ��ϣ�(������ָ��Ԫ��)
        SortedSet<String> headSet = treeSet.headSet("jiaboyan");
        System.out.println("jiaboyan�ڵ�֮ǰ��Ԫ��Ϊ��"+headSet.toString());

        //��ȡ����Ԫ��֮��ļ��ϣ�������ͷ��������β��
        SortedSet subSet = treeSet.subSet("1","world");
        System.out.println("1--world֮��ڵ�Ԫ��Ϊ��"+subSet.toString());

        //�����жϣ�
        boolean isEmpty = treeSet.isEmpty();
        System.out.println("TreeSet�Ƿ�Ϊ�գ�"+isEmpty);
        boolean isContain = treeSet.contains("who");
        System.out.println("TreeSet�Ƿ����whoԪ�أ�"+isContain);

        //Ԫ��ɾ����
        boolean jiaboyanRemove = treeSet.remove("jiaboyan");
        System.out.println("jiaboyanԪ���Ƿ�ɾ��"+jiaboyanRemove);

        //�����в����ڵ�Ԫ�أ�ɾ������false
        boolean whoRemove = treeSet.remove("who");
        System.out.println("whoԪ���Ƿ�ɾ��"+whoRemove);

        //ɾ�������ص�һ��Ԫ�أ����set���ϲ�����Ԫ�أ��򷵻�null
        String pollFirst = treeSet.pollFirst();
        System.out.println("ɾ���ĵ�һ��Ԫ�أ�"+pollFirst);

        //ɾ�����������һ��Ԫ�أ����set���ϲ�����Ԫ�أ��򷵻�null
        String pollLast = treeSet.pollLast();
        System.out.println("ɾ�������һ��Ԫ�أ�"+pollLast);


        treeSet.clear();//��ռ���:
    }

    //��Ȼ����˳������
    public static void naturalSort(){
        TreeSet<String> treeSetString = new TreeSet<String>();
        treeSetString.add("a");
        treeSetString.add("z");
        treeSetString.add("d");
        treeSetString.add("b");
        System.out.println("��ĸ˳��" + treeSetString.toString());

        TreeSet<Integer> treeSetInteger = new TreeSet<Integer>();
        treeSetInteger.add(1);
        treeSetInteger.add(24);
        treeSetInteger.add(23);
        treeSetInteger.add(6);
        System.out.println("����˳��" + treeSetInteger.toString());
    }

    //�Զ�������˳������
    public static void customSort(){
        TreeSet<App> treeSet = new TreeSet<App>();

        //�������
        App app1 = new App("hello",10);
        App app2 = new App("world",20);
        App app3 = new App("my",15);
        App app4 = new App("name",25);

        //��ӵ����ϣ�
        treeSet.add(app1);
        treeSet.add(app2);
        treeSet.add(app3);
        treeSet.add(app4);
        System.out.println("TreeSet����˳��Ϊ��"+treeSet);
    }
}
