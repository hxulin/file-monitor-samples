package com.example;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class FileListener extends FileAlterationListenerAdaptor {

    private static final Logger LOGGER = Logger.getLogger(FileListener.class);

    /**
     * 新建文件
     */
    public void onFileCreate(File file) {
        LOGGER.info("新建文件：" + file.getAbsolutePath());
    }

    /**
     * 修改文件
     */
    public void onFileChange(File file) {
        LOGGER.info("修改文件：" + file.getAbsolutePath());
    }

    /**
     * 删除文件
     */
    public void onFileDelete(File file) {
        LOGGER.info("删除文件：" + file.getAbsolutePath());
    }

    /**
     * 新建目录
     */
    public void onDirectoryCreate(File directory) {
        LOGGER.info("新建目录：" + directory.getAbsolutePath());
    }

    /**
     * 修改目录
     */
    public void onDirectoryChange(File directory) {
        LOGGER.info("修改目录：" + directory.getAbsolutePath());
    }

    /**
     * 删除目录
     */
    public void onDirectoryDelete(File directory) {
        LOGGER.info("删除目录：" + directory.getAbsolutePath());
    }

    public void onStart(FileAlterationObserver observer) {
        LOGGER.info("监听服务准备就绪，正在监听文件目录变化...");
    }

    public void onStop(FileAlterationObserver observer) {

    }
}
