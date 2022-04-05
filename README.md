# BDK Java ULong bug

### Kotlin Wrappers
- [BlockchainConfigFactory](src/main/kotlin/com.lipa/BlockchainConfigFactory.kt) contains wrappers.
- [QuarkusApp](src/main/java/com/lipa/QuarkusApp.java) contains the calling java code.

`electrum1` is almost built like the regular wrapper in BDK. It uses ULong instead of UByte though as UByte is a Kotlin datatype.

```kotlin
// BDK provided Kotlin Wrapper
data class ElectrumConfig (
    var url: String, 
    var socks5: String?, 
    var retry: UByte, 
    var timeout: UByte?, 
    var stopGap: ULong 
) 
```

`electrum1` is valid code while linting in the IDE but fails to compile:

```text
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (java-compile) on project batch-payouts: Compilation failure
[ERROR] /Users/severinbuhler/git/lipa/bdk-java-ulong-bug/src/main/java/com/lipa/QuarkusApp.java:[10,45] cannot find symbol
[ERROR]   symbol:   method electrum1(java.lang.String,<nulltype>,int,int,int)
[ERROR]   location: class com.lipa.BlockchainConfigFactory
```

It fails to find a method for the type `method electrum1(java.lang.String,<nulltype>,int,int,int)`.
There is a ULong <> int mismatch.


`electrum2` fixes that by using `Int` directly in Kotlin.

[QuarkusApp]