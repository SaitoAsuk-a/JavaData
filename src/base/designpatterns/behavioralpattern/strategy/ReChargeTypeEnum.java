package base.designpatterns.behavioralpattern.strategy;

import lombok.*;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/12/9 10:43
 * @description ����ö����
 */

@AllArgsConstructor
@Getter
public enum ReChargeTypeEnum {
    E_BANK(1, "����"),

    BUSI_ACCOUNTS(2, "�̻��˺�"),

    MOBILE(3, "�ֻ���ֵ"),

    CARD_RECHARGE(4, "��ֵ��");
    private int value;
    private String description;

    public static ReChargeTypeEnum from(int value) {
        return Arrays.stream(values())
                .filter(element -> element.getValue() == (value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no type for this value"));
    }

}
