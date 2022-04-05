package com.lipa

import org.bitcoindevkit.ElectrumConfig
import org.bitcoindevkit.EsploraConfig

class BlockchainConfigFactory {
    companion object {
        /**
         * electrum1 results in this error:
         * [ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (java-compile) on project batch-payouts: Compilation failure
         * [ERROR] /Users/severinbuhler/git/lipa/bdk-java-ulong-bug/src/main/java/com/lipa/QuarkusApp.java:[10,45] cannot find symbol
         * [ERROR]   symbol:   method electrum1(java.lang.String,<nulltype>,int,int,int)
         * [ERROR]   location: class com.lipa.BlockchainConfigFactory
         */
        @JvmStatic()
        fun electrum1(
            url: String,
            socks: String?,
            retry: ULong,
            timeout: ULong,
            stopGap: ULong
        ): ElectrumConfig {
            val config = ElectrumConfig(
                url,
                socks,
                retry.toUByte(),
                timeout.toUByte(),
                stopGap
            );
            return config
        }

        /**
         * Works as expected. Parameters are now Int and not any unsigned types.
         */
        @JvmStatic()
        fun electrum2(
            url: String,
            socks: String?,
            retry: Int,
            timeout: Int,
            stopGap: Int
        ): ElectrumConfig {
            val config = ElectrumConfig(
                url,
                socks,
                retry.toUByte(),
                timeout.toUByte(),
                stopGap.toULong()
            );
            return config
        }
    }


}