package com.example;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        // 监控目录
        String rootDir = args.length > 0 ? args[0] : System.getProperty("user.home");
        LOGGER.info("监听文件目录变化，正在遍历目录：" + rootDir);
        // 轮询间隔 5 秒
        long interval = TimeUnit.SECONDS.toMillis(1);
        // 创建过滤器
//        IOFileFilter directories = FileFilterUtils.and(
//                FileFilterUtils.directoryFileFilter(),
//                HiddenFileFilter.VISIBLE
//        );
//        IOFileFilter files = FileFilterUtils.and(
//                FileFilterUtils.fileFileFilter(),
//                FileFilterUtils.suffixFileFilter(".txt")
//        );
//        IOFileFilter filter = FileFilterUtils.or(directories, files);
        // 使用过滤器
//        FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir), filter);
        //不使用过滤器
        FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir));
        observer.addListener(new FileListener());
        //创建文件变化监听器
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        // 开始监控
        monitor.start();
    }
}
