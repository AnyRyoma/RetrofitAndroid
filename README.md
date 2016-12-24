# RetrofitAndroid
学习Retrofit2 框架小案例


Retrofit是什么
Retrofit官网的介绍： A type-safe HTTP client for Android and Java
是一个基于OkHttp的RESTFUL Api请求工具

Retrofit的原理
Retrofit就是充当了一个适配器（Adapter）的角色
将一个Java接口翻译成一个Http请求，然后用OkHttp去发送这个请求

最关键的就是:Java的动态代理


Retrofit巧妙地用注解来描述一个HTTP请求，将一个HTTP请求抽象成一个Java接口，
然后用了Java动态代理的方式，动态的将这个接口的注解“翻译”成一个HTTP请求，最后再执行这个HTTP请求
