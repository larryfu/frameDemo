package cn.larry.demo.tika;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by fugz on 2016/8/1.
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {

//        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("D:\\home\\data\\data.zip"))) {
//            Files.walkFileTree(Paths.get("D:\\home\\data"), new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
//                        throws IOException {
//                    writeToZipos(file.toFile(), zipOutputStream);
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        }

       decompress();
    //    fileToZip("D:\\home\\data\\jsondata", "D:\\home\\data", "compressedData");
    }

    private static void decompress(){
        long startTime=System.currentTimeMillis();
        try {
            ZipInputStream Zin=new ZipInputStream(new FileInputStream(
                    "D:\\home\\data\\data.zip"));//输入源zip路径
            BufferedInputStream Bin=new BufferedInputStream(Zin);
            String Parent="D:\\home\\jsondata"; //输出路径（文件夹目录）
            File Fout=null;
            ZipEntry entry;
            try {
                while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){
                    Fout=new File(Parent,entry.getName());
                    if(!Fout.exists()){
                        (new File(Fout.getParent())).mkdirs();
                    }
                    FileOutputStream out=new FileOutputStream(Fout);
                    BufferedOutputStream Bout=new BufferedOutputStream(out);
                    int b;
                    while((b=Bin.read())!=-1){
                        Bout.write(b);
                    }
                    Bout.close();
                    out.close();
                    System.out.println(Fout+"解压成功");
                }
                Bin.close();
                Zin.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("耗费时间： "+(endTime-startTime)+" ms");
    }

    private static void writeToZipos(File file, ZipOutputStream zos) throws IOException {
        int size = 1024 * 8;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file), size)) {
            ZipEntry zipEntry = new ZipEntry("dir/"+file.getName());
            zos.putNextEntry(zipEntry);
            byte[] bufs = new byte[size];
            int read = 0;
            while ((read = bis.read(bufs, 0, size)) != -1) {
                zos.write(bufs, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     *
     * @param sourceFilePath :待压缩的文件路径
     * @param zipFilePath    :压缩后存放路径
     * @param fileName       :压缩后文件的名称
     * @return
     */
    public static boolean fileToZip(String sourceFilePath, String zipFilePath, String fileName) {
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if (sourceFile.exists() == false) {
            System.out.println("待压缩的文件目录：" + sourceFilePath + "不存在.");
        } else {
            try {
                File zipFile = new File(zipFilePath + "/" + fileName + ".zip");
                if (zipFile.exists()) {
                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName + ".zip" + "打包文件.");
                } else {
                    File[] sourceFiles = sourceFile.listFiles();
                    if (null == sourceFiles || sourceFiles.length < 1) {
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                    } else {
                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        byte[] bufs = new byte[1024 * 10];
                        for (int i = 0; i < sourceFiles.length; i++) {
                            //创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            //读取待压缩的文件并写进压缩包里
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024 * 10);
                            int read = 0;
                            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                                zos.write(bufs, 0, read);
                            }
                        }
                        flag = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                //关闭流
                try {
                    if (null != bis) bis.close();
                    if (null != zos) zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

//        public static void main(String[] args){
//            String sourceFilePath = "D:\\TestFile";
//            String zipFilePath = "D:\\tmp";
//            String fileName = "12700153file";
//            boolean flag = FileToZip.fileToZip(sourceFilePath, zipFilePath, fileName);
//            if(flag){
//                System.out.println("文件打包成功!");
//            }else{
//                System.out.println("文件打包失败!");
//            }
//        }

}
