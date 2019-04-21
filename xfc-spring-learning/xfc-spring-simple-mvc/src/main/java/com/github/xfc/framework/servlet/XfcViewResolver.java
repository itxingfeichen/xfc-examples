package com.github.xfc.framework.servlet;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : chenxingfei
 * @date: 2019-04-20  22:56
 * @description:
 */
public class XfcViewResolver {

    private String viewName;

    private File file;

    public XfcViewResolver(String viewName, File file) {
        this.viewName = viewName;
        this.file = file;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String parse(XfcModelAndView mv) {

        StringBuffer buffer = new StringBuffer();
        RandomAccessFile read = null;
        try {
            read = new RandomAccessFile(this.file, "r");
            String line;
            while ((line = read.readLine()) != null) {
                Matcher matcher = getMatcher(line);
                while (matcher.find()) {
                    for (int i = 1; i <= matcher.groupCount(); i++) {
                        String paramName = matcher.group(i);
                        // 去除匹配符号中的占位符
                        Object paramValue = mv.getModel().get(paramName);

                        if (paramValue != null) {

                            // 开始替换
                            line = line.replaceAll("@\\{" + paramName + "\\}", paramValue.toString());
                        }
                    }
                }
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

    public Matcher getMatcher(String str) {
        Pattern pattern = Pattern.compile("@\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);

        return pattern.matcher(str);
    }

}
