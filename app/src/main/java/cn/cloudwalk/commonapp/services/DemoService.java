/**
 * Project Name:CommonApp
 * File Name:DemoService2
 * Package Name:cn.cloudwalk.commonapp.services
 * Date:2017/2/14 001411:38
 * Copyright @ 2010-2017 Cloudwalk Information Technology Co.Ltd All Rights Reserved.
 */
package cn.cloudwalk.commonapp.services;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * ClassName:DemoService2 <br/>
 * Description: TODO Description. <br/>
 * Date:     2017年02月14日 11:38 <br/>
 * @author 284891377
 * @version
 * @since JDK 1.7	 
 */
class DemoService {
//    //TODO  示例变量注释 livetemplate filtem
//    /**
//     * :{TODO}(用一句话描述这个变量表示什么).
//     * create by:284891377
//     * @since JDK 1.7
//     */
//    public String filed="XXXXX";
//    //TODO  示例方法注释 livetemplate mettem
//    /**
//     * method:(一句话描述方法作用). <br/>
//     * 适用条件:(可选).<br/>
//     * 执行流程:(可选).<br/>
//     * 使用方法:(可选).<br/>
//     * 使用方法:(可选).<br/>
//     * @param param xxx
//     * @return retu xxxx
//     *
//     * @author:284891377   Date: 2017/1/16 0016 16:16
//     *
//     * @since JDK 1.7
//     */
//    public void method(String param){
//
//    }

//TODO ------------handler防止内存泄漏

    DemoService mReference;

    public static class MyHandler extends Handler {
        //声明一个弱引用对象
        WeakReference<DemoService> mReference;

        MyHandler(DemoService activity) {
            //在构造器中传入Activity,创建弱引用对象
            mReference = new WeakReference<DemoService>(activity);
        }

        public void handleMessage(Message msg) {
            //在使用activity之前先判空处理
            if (mReference != null && mReference.get() != null) {
                //mReference.get().text.setText("hello word");
            }
        }
    }

    //TODO ------------handler防止内存泄漏
//TODO ------------静态的内部类防止内存泄漏
    TestResource mTestResource;

    private void initData() {
        if (mTestResource == null) {
            mTestResource = new TestResource();
        }
    }

    public void onClick(View v) {
        initData();
    }

    //非静态内部类默认会持有外部类的引用
//修改成就太之后正常被回收,是因为静态的内部类不会对Activity有引用
    private static class TestResource {
    }

    //TODO ------------静态的内部类防止内存泄漏
//TODO   ------内部线程防止内存泄漏
    private static class MyThread implements Runnable {
        public void run() {
            SystemClock.sleep(20000);
        }
    }
}
