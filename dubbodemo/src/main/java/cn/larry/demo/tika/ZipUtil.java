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
public class ZipUtil {

    public static void main(String[] args) {
        deCompress("D:\\home\\data\\data.zip", "D:\\home\\jsondata");
    }

    public static void compress(String sourceDir, String destFile) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(destFile))) {
            File file = new File(sourceDir);
            if (!file.exists()) {
                throw new RuntimeException("source file not exists");
            }
            if (file.isFile()) {
                writeToZipos(file, zos);
            }
            if (file.isDirectory()) {
                Files.walkFileTree(Paths.get("D:\\home\\data"), new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                            throws IOException {
                        writeToZipos(file.toFile(), zos);
                        return FileVisitResult.CONTINUE;
                    }
                });
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToZipos(File file, ZipOutputStream zos) throws IOException {
        int size = 1024 * 8;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file), size)) {
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);
            byte[] bufs = new byte[size];
            int read;
            while ((read = bis.read(bufs, 0, size)) != -1) {
                zos.write(bufs, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void deCompress(String zipFile, String outDir) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFile));
             BufferedInputStream bin = new BufferedInputStream(zin)) {
            ZipEntry entry;
            try {
                while ((entry = zin.getNextEntry()) != null && !entry.isDirectory()) {
                    File fout = new File(outDir, entry.getName());
                    if (!fout.exists())
                        (new File(fout.getParent())).mkdirs();

                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fout));
                    int size = 1024 * 8;
                    byte[] bytes = new byte[size];
                    int read;
                    while ((read = bin.read(bytes, 0, size)) != -1) {
                        bos.write(bytes, 0, read);
                    }
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
