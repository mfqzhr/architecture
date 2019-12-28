package com.architecture.projectsix.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 穆繁强
 * @date 2019/12/28
 */
public class LogUtil {
    public static void writeLogToLocal(String path, String log) throws IOException {
        String fileName = path + "/logout.txt";
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logFmt = "\r\n" + localDateTime + " " + log;
        File file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        }
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(raf.length());
        raf.write(logFmt.getBytes());
        raf.close();


    }

}
