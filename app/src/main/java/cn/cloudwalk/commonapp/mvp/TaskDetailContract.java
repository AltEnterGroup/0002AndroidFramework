/**
 * Project Name:CommonApp
 * File Name:TaskDetailContract
 * Package Name:cn.cloudwalk.commonapp.articleDetail
 * Date:2017/1/17 001712:48
 * Copyright @ 2010-2017 Cloudwalk Information Technology Co.Ltd All Rights Reserved.
 */
package cn.cloudwalk.commonapp.mvp;

import cn.cloudwalk.base.BasePresenter;
import cn.cloudwalk.base.BaseView;

/**
 * ClassName:TaskDetailContract <br/>
 * Description: TODO Description. <br/>
 * Date:     2017年01月17日 12:48 <br/>
 * @author 284891377
 * @version
 * @since JDK 1.7	 
 */
public interface TaskDetailContract {


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
    interface View extends BaseView<Presenter> {
    void showTitle(String title);


}

interface Presenter extends BasePresenter {
    void deleteTask();

}
}
