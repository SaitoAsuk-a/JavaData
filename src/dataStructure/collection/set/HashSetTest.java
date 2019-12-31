package dataStructure.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.lang.System.out;

public class HashSetTest {
    public static void main(String[] agrs){
//        baseOprateDemo();

        hashCodeAndEquals();

    }

    public static void baseOprateDemo() {
        //����HashSet���ϣ�
        Set<String> hashSet = new HashSet<String>();
        out.println("HashSet��ʼ������С��"+hashSet.size());

        //Ԫ����ӣ�
        hashSet.add("my");
        hashSet.add("name");
        hashSet.add("is");
        hashSet.add("jiaboyan");
        hashSet.add(",");
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("!");
        out.println("HashSet������С��"+hashSet.size());

        //������������
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            out.println(str);
        }
        //��ǿforѭ��
        for(String str:hashSet){
            if("jiaboyan".equals(str)){
                out.println("���������Ҫ��Ԫ��:"+str);
            }
            out.println(str);
        }

        //Ԫ��ɾ����
        hashSet.remove("jiaboyan");
        out.println("HashSetԪ�ش�С��" + hashSet.size());
        hashSet.clear();
        out.println("HashSetԪ�ش�С��" + hashSet.size());

        //�����жϣ�
        boolean isEmpty = hashSet.isEmpty();
        out.println("HashSet�Ƿ�Ϊ�գ�" + isEmpty);
        boolean isContains = hashSet.contains("hello");
        out.println("HashSet�Ƿ����hello��" + isContains);
    }

    public static void hashCodeAndEquals(){
        //��һ�� Set���ϣ�
        Set<String> set1 = new HashSet<String>();
        String str1 = new String("jiaboyan");
        String str2 = new String("jiaboyan");
        set1.add(str1);
        set1.add(str2);
        out.println("���ȣ�"+set1.size()+",����Ϊ��"+set1);

        //�ڶ��� Set���ϣ�
        Set<App> set2 = new HashSet<App>();
        App app1 = new App();
        app1.setName("jiaboyan");

        App app2 = new App();
        app2.setName("jiaboyan");

        set2.add(app1);
        set2.add(app2);
        out.println("���ȣ�"+set2.size()+",����Ϊ��"+set2);

        //������ Set���ϣ�
        Set<App> set3 = new HashSet<App>();
        App app3 = new App();
        app3.setName("jiaboyan");
        set3.add(app3);
        set3.add(app3);
        out.println("���ȣ�"+set3.size()+",����Ϊ��"+set3);
    }
}
