//package com.github.xfc.maven.plugin;
//
//import org.apache.maven.plugin.AbstractMojo;
//import org.apache.maven.plugin.MojoExecutionException;
//import org.apache.maven.plugin.MojoFailureException;
//import org.apache.maven.plugins.annotations.LifecyclePhase;
//import org.apache.maven.plugins.annotations.Mojo;
//import org.apache.maven.plugins.annotations.Parameter;
//import org.codehaus.plexus.util.StringUtils;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.time.Instant;
//import java.util.stream.Stream;
//
///**
// * @author : chenxingfei
// * @date: 2019-08-14  07:26
// * @description: 静态资源处理插件
// * https://blog.csdn.net/qq_35192681/article/details/86315924
// */
//@Mojo(name = "srp", defaultPhase = LifecyclePhase.PACKAGE)
//public class StaticResourcesProcessor extends AbstractMojo {
//
//    /**
//     * 可以对指定后缀的文件处理
//     */
//    @Parameter(name = "suffixs")
//    private String[] suffixs;
//
//    /**
//     * 可以对文件追加指定版本
//     */
//    @Parameter(name = "version")
//    private String version;
//
//    private static String[] tagNames = {"link|href", "script|src"};
//
//
//    @Override
//    public void execute() throws MojoExecutionException, MojoFailureException {
//        String property = System.getProperty("user.dir");
//        File file = new File(property);
//        processFile(file);
//    }
//
//    /**
//     * 处理文件
//     *
//     * @param file
//     */
//    private void processFile(File file) {
//        if (file.isFile()) {
//            try {
//                processDocument(file);
//                return;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (file.isDirectory()) {
//            File[] files = file.listFiles();
//            for (File file1 : files) {
//                processFile(file1);
//            }
//        }
//    }
//
//    /**
//     * 处理文档
//     *
//     * @param file
//     * @throws IOException
//     */
//    private void processDocument(File file) throws IOException {
//        // 获取到当前文件内容
//        Document document = Jsoup.parse(file, "UTF-8");
//        Stream.of(tagNames).forEach(tagName -> {
//            String[] tagAndAttr = tagName.split("\\|");
//            // 根据tag名称获取
//            Elements elements = document.getElementsByTag(tagAndAttr[0]);
//            if (elements != null && elements.size() > 0) {
//
//                for (Element element : elements) {
//                    // 原始地址
//                    String originAddress = element.attr(tagAndAttr[1]);
//                    String newAddress = originAddress;
//                    // 判断是否已经加了参数
//                    if (originAddress.contains("?")) {
//                        newAddress = originAddress.substring(0, originAddress.indexOf("?"));
//                    }
//                    if (StringUtils.isNotBlank(version)) {
//                        newAddress = newAddress + "?v=" + version;
//                    } else {
//                        newAddress += "?v=" + Instant.now().toEpochMilli();
//                    }
//                    element.attr(tagAndAttr[1], newAddress);
//                }
//            }
//
//
//        });
//        FileOutputStream fos = new FileOutputStream(file, false);
//        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
//        osw.write(document.html());
//        osw.close();
//
//    }
//}
