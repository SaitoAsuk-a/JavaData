package dataStructure.collection.listnode;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liyu
 * @date 2020/1/15 10:06
 * @description ѭ����������
 */
@Getter
@Setter
public class CLNode {
    private int data;
    private CLNode next;

    public CLNode(int data) {
        this.data = data;
    }
}
