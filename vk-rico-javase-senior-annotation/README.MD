
# Java注解
## 参考资料
[全面解析Java注解](http://blog.csdn.net/northleaf/article/details/50528805)<br/>
[深入理解Java注解](http://www.cnblogs.com/peida/archive/2013/04/24/3036689.html)
## 分类
### 按运行机制分类
#### 源码注解
这类注解只存在于源码之中，编译后的Class文件里不存在
#### 编译时注解
这类注解存在于源码与Class文件中
#### 这类注解存在于源码与Class文件中
在运行阶段还起作用的注解，比较典型的是Spring中的@Autowired<br/>
`特别注意：只有第3种注解才会在反射的时候获取到`<br/>

java.lang.annotation.RetentionPolicy枚举类中定义了这三种机制的注解<br/>
@Retention元注解用于描述注解的生命周期（即：被描述的注解在什么范围内有效）<br/>
### 按来源分类

