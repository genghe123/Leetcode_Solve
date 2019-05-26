###文档结构
```
RoadGrid
│  README.md
│  pom.xml
│
└───src
    │──main
    │  └───java
    │     │  Maze.java
    │     │  MazeUsingHash.java
    │
    └──test
        └───java
          │  MazeUsingHashTest.java
```
### 运行环境
* JDK1.8 Maven
### 运行向导
* 导入pom.xml, 测试文件在src/test目录下,可单独运行测试用例，也可通过surefire插件启动
* > mvn test 或 surefire:test -f pom.xml 指令
### 输入方式说明
* MazeUsingHash.java 中实现了两个构造函数
    1. String字符串输入
    2. InputStream流输入，适用于输入较长，或文件输入
### 输出方式说明
* MazeUsingHash.java 中实现了抽象父类中的abstract函数： render(), 返回String
### 测试用例说明
* 测试用例包括了边界测试，非法输入测试，压力测试
