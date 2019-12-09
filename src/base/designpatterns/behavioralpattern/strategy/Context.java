package base.designpatterns.behavioralpattern.strategy;

/**
 * @author liyu
 * @date 2019/12/9 10:37
 * @description ������ɫ
 */
public class Context {
    private Strategy strategy;
    public Double calRecharge(Double charge, Integer type) {
        // ����һ������ȥ���ɶ�Ӧ�Ĳ���
        strategy = StrategyFactory.getInstance().creator(ReChargeTypeEnum.from(type));
        if (strategy == null) {
            throw new RuntimeException("�������ɴ���");
        }
        return strategy.calRecharge(charge);
    }
}
