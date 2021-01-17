package com.cyyaw.common.util;

import java.math.BigDecimal;

public class BigDecimalUtilsWHY {

    private BigDecimalUtilsWHY(){}

    public static BigDecimal random(BigDecimal min, BigDecimal max){
        float minF = min.floatValue();
        float maxF = max.floatValue();
        BigDecimal db = new BigDecimal(Math.random() * (maxF - minF) + minF);
        return db.setScale(2,BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal random(){
        long l = System.currentTimeMillis();
        return random(BigDecimal.ZERO,new BigDecimal(l+""));
    }


}
