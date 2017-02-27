# AndroidReview

### Handler机制的原理
UI主线程初始化第一个Handler时会通过ThreadLocal创建一个Looper对象，使用ThreadLocal的目的是为了保证每一个线程只创建一个Looper.之后其他的handler初始化的时候直接获取第一个Handler创建的looper.Looper循环Handler发送到消息队列Message Queue里的消息，并取出消息分发到指定的handler进行处理
其中handler发送消息到队列通过sendMessage方法，而handler分发处理的消息通过handleMessage进行接收子线程传过来的消息，在主线程中做相应处理
![](https://github.com/littleBearJrue/MarkDownPhotos/blob/master/handler.png?raw=true)

### 关于NDK的理解
1. 下载NDK工具
2. 使用NDK工具实现对JNI接口的设计
3. 用C/C++实现对本地代码的实现工作
4. 使用jni接口将代码文件转化为动态链接库.so文件
5. 将动态链接库.so文件复制到java项目中
