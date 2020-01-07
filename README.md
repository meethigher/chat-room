# Java控制台式聊天室

## 原理

![原理](https://meethigher.top/blog/2020/01/07/chat-room/服务端与客户端交互过程图.png)

原理上面那个图，描述的很详细了，不多赘述。

## 实现

* Server端
  * SingleServer类：实现服务端的主类
  * ServerRunnable类：runnable接口的实现类，用来接收和发送消息
* Client端
  * SingleClient类：实现客户端的主类
  * CTSRunnable类：接口实现类，用来实现客户端向服务端发送消息
  * STCRunnable类：接口实现类，用来实现客户端接收服务端向客户端返回的数据

## 运行结果

* 聊天功能

  ![聊天功能](https://meethigher.top/blog/2020/01/07/chat-room/%E5%AE%A2%E6%88%B7%E7%AB%AF%E4%B9%8B%E9%97%B4%E9%80%9A%E8%AE%AF.png)

* 用户退出提示

![用户退出提示](https://meethigher.top/blog/2020/01/07/chat-room/%E7%94%A8%E6%88%B7%E9%80%80%E5%87%BA%E9%80%9A%E7%9F%A5.png)

## 具体过程

[记录实现socket聊天室的过程](https://meethigher.top/blog/2020/01/07/chat-room/)

