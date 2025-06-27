#!/bin/bash
# 进入上级目录（相对于脚本所在位置）
cd "$(dirname "\$0")/../" || exit 1

# 执行 Java 程序（注意：Linux 使用冒号:作为类路径分隔符）
java -cp "assembly-demo-1.0-SNAPSHOT.jar:lib/*" com.hafiz.Runner
