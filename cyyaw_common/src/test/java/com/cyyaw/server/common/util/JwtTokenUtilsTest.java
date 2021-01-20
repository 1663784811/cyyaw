package com.cyyaw.server.common.util;


import com.cyyaw.common.util.JwtTokenUtils;
import org.junit.Test;

public class JwtTokenUtilsTest {





    @Test
    public void test001(){


        String token = JwtTokenUtils.createToken("WHY", "abc", "admin");


        System.out.println(token);

        boolean b = JwtTokenUtils.verifierToken(token );

        System.out.println(b);
    }












}
