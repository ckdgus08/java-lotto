package lotto.domain;

import java.util.Arrays;

public enum Reward {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int sameCount;
    private int money;

    Reward(int sameCount, int money) {
        this.sameCount = sameCount;
        this.money = money;
    }

    public static int getMoneyFromSameCount(int sameCount) {
        return getRewardFromSameCount(sameCount).money;
    }

    private static Reward getRewardFromSameCount(int sameCount) {
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.isSameCount(sameCount))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 숫자의 상금이 등록되어 있지 않습니다."));
    }

    private boolean isSameCount(int sameCount) {
        return this.sameCount == sameCount;
    }
}
