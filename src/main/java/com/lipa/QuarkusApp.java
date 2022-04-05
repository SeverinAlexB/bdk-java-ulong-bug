package com.lipa;

import io.quarkus.runtime.QuarkusApplication;
import kotlin.UByte;


public class QuarkusApp implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
        /*
         * electrum1 results in this error:
         * [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (java-compile) on project batch-payouts: Compilation failure
         * [ERROR] /Users/severinbuhler/git/lipa/bdk-java-ulong-bug/src/main/java/com/lipa/QuarkusApp.java:[10,45] cannot find symbol
         * [ERROR]   symbol:   method electrum1(java.lang.String,<nulltype>,int,int,int)
         * [ERROR]   location: class com.lipa.BlockchainConfigFactory
         */
        var config = BlockchainConfigFactory.electrum1(
                "ssl://electrum.blockstream.info:60002",
                null,
                5,
                5,
                100
        );

        /*
         * Works as expected.
         */
//        var config = BlockchainConfigFactory.electrum2(
//                "ssl://electrum.blockstream.info:60002",
//                null,
//                5,
//                5,
//                100
//        );


        System.out.println("Config " + config.toString());
        return 0;
    }
}