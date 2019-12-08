package base.designpatterns.behavioralpattern.iterator;

/**
 * @author liyu
 * @date 2019/12/8 15:15
 * @description ����ʵ���� Container �ӿڵ�ʵ���ࡣ������ʵ���� Iterator �ӿڵ��ڲ��� NameIterator��
 */
public class NameRepository implements Container {
    public String names[] = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
