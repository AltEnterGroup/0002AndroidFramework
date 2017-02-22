/**
 * Project Name:CommonApp
 * File Name:TaskDetailFragment
 * Package Name:cn.cloudwalk.commonapp.articleDetail
 * Date:2017/1/17 001712:53
 * Copyright @ 2010-2017 Cloudwalk Information Technology Co.Ltd All Rights Reserved.
 */
package cn.cloudwalk.commonapp.module.taskDetail;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import cn.cloudwalk.commonapp.mvp.TaskDetailContract;

/**
 * ClassName:TaskDetailFragment <br/>
 * Description: TODO Description. <br/>
 * Date:     2017年01月17日 12:53 <br/>
 * @author 284891377
 * @version
 * @since JDK 1.7	 
 */
public class TaskDetailFragment extends Fragment implements TaskDetailContract.View{
    private TaskDetailContract.Presenter mPresenter;
    @Override
    public void showTitle(String title) {

    }


    @Override
    public void setPresenter(@NonNull TaskDetailContract.Presenter presenter) {
        //mPresenter = checkNotNull(presenter);
    }


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
//TODO 使用规范-----------------------------Handler使用
//    private StaticHandler mHandler = new StaticHandler(this);
//
//    public static class StaticHandler extends Handler {
//        private final WeakReference<Activity> mActivity;
//
//
//        public StaticHandler(Activity activity) {
//            mActivity = new WeakReference<Activity>(activity);
//        }
//
//
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//        }
//    }
}
