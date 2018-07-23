# 本项目是我的 Demo 代码
工具列表：
* 对数器,路径：src/com/bleedyao/demo/testAlgorithm/result/Checker.java

# 对数器，用户验证算法结果
优点：
* 随机生成数组，长度随机，数据随机
* 对比功能，判断测试数组和正确数组结果是否一致
* 使用简单，只需要你实现自己的算法，就很容易得到结果

使用方式如下所示：
```java
new Checker(testArray -> {
    // 你的算法逻辑
}).run();
```

个性化设置：
```java
new Checker(testArray -> {
    // 你的算法逻辑
}).setCorrectAlgorithm(correctArray -> {
    // 正确算法逻辑
}).setSize(2000) // 设置数组最大长度（随机数组长度是随机的），不设置为 100
    .setDataRange(300) // 设置数组元素范围，范围在 [-range, range)(例如 [-300, 300) 之间)，不设置为 [-100,100]
    .setRunCount(2000) // 设置运行次数，不设置为 100
    .run();
```

运行结果：
```java
staaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaart
第 99 测试
原始数组：[-1, -73, -50, 96, -80]
测试数组：[-1, -73, -50, 96, -80]
正确数组：[-80, -73, -50, -1, 96]
测试结果：false
ennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnd

staaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaart
第 100 测试
原始数组：[16, -77, -25, -96, -5, 23, 71, -31, 17, 55, -86, -100]
测试数组：[16, -77, -25, -96, -5, 23, 71, -31, 17, 55, -86, -100]
正确数组：[-100, -96, -86, -77, -31, -25, -5, 16, 17, 23, 55, 71]
测试结果：false
ennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnd
```
