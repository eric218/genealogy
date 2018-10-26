package com.dct.swocean.util.filehelper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.dct.swocean.util.ResponseEnum;
import com.dct.swocean.util.StringUtils;
import com.dct.swocean.util.SysException;

/**
 * 文件处理工具类
 * 
 * @author panda
 *
 */
public class FileUpload
{
    private final static String maxFileSize = "10Mb";

    /**
     * 文件上传/断点续传
     * 
     * @param file
     *            文件对象
     * @param filepath
     *            存储路径
     * @return
     */
    public static FileResponse upload(MultipartFile file, String filepath)
    {
        long fileSize = file.getSize();
        if (file == null || fileSize == 0)
        {
            throw new SysException(ResponseEnum.FILE_IS_NULL);
        }
        long maxSize = Long.parseLong(StringUtils.getNumber(maxFileSize));
        maxSize = maxSize * 1024 * 1024;
        if (fileSize > maxSize)
        {
            throw new SysException(ResponseEnum.FILE_SIZE_FULL);
        }
        FileResponse fileResponse = new FileResponse();
        fileResponse.setFilepath(filepath);
        fileResponse.setFilename(file.getOriginalFilename());
        File targetFile = new File(filepath + file.getOriginalFilename());
        // 判断文件父目录是否存在
        if (!targetFile.getParentFile().exists())
        {
            targetFile.getParentFile().mkdirs();
        }
        // 开始位置
        long startByte = 0;
        // 结束位置
        long endByte = fileSize - 1;
        // 判断文件是否存在
        if (targetFile.exists())
        {
            // 获取已存在文件大小
            long haveSize = getFileSize(filepath + file.getOriginalFilename());
            if (fileSize == haveSize)
            {
                fileResponse.setRange(null);
                return fileResponse;
            }
            else
            {
                startByte = haveSize;
            }
        }
        // 需上传长度
        long fileLength = endByte - startByte + 1;
        RandomAccessFile randomAccessFile = null;
        try
        {
            randomAccessFile = new RandomAccessFile(targetFile, "rw");
            randomAccessFile.seek(startByte);
            byte[] b = file.getBytes();
            // 【注意】RandomAccessFile.write()参数：字节数组，起始位置，传入长度
            randomAccessFile.write(b, (int) startByte, (int) fileLength);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            close(randomAccessFile);
        }
        fileResponse.setRange(startByte + "-" + endByte);
        return fileResponse;
    }

    /**
     * 批量文件上传
     * 
     * @param files
     *            文件对象集
     * @param filepath
     *            存储路径
     * @return
     */
    public List<FileResponse> batchUpload(List<MultipartFile> files, String filepath)
    {
        List<FileResponse> list = new ArrayList<FileResponse>();
        FileResponse fileResponse;
        for (MultipartFile file : files)
        {
            fileResponse = new FileResponse();
            fileResponse = upload(file, filepath);
            list.add(fileResponse);
        }
        return list;
    }

    /**
     * 获取文件大小(byte)
     * 
     * @param filepath
     *            文件路径
     * @return
     */
    public static long getFileSize(String filepath)
    {
        File file = new File(filepath);
        if (file.exists() && file.isFile())
        {
            return file.length();
        }
        else
        {
            return 0;
        }
    }

    /**
     * 文件拷贝
     * 
     * @param source
     *            资源文件
     * @param target
     *            目标文件
     * @throws IOException
     */
    public void copyFile(File source, File target)
    {
        FileInputStream input = null;
        FileOutputStream output = null;
        try
        {
            input = new FileInputStream(source);
            output = new FileOutputStream(target);
            byte[] b = new byte[1024];
            int n = 0;
            while ((n = input.read(b)) != -1)
            {
                output.write(b, 0, n);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            close(input, output);
        }

    }

    /**
     * 压缩文件
     * 
     * @param filePath
     *            待压缩的文件路径
     * @return 压缩后的文件
     */
    public static File zip(String filePath)
    {
        File target = null;
        File source = new File(filePath);
        if (source.exists())
        {
            // 压缩文件名
            String zipName = source.getName() + ".zip";
            target = new File(source.getParent(), zipName);
            if (target.exists())
            {
                target.delete(); // 删除旧的文件
            }
            FileOutputStream fos = null;
            ZipOutputStream zos = null;
            try
            {
                fos = new FileOutputStream(target);
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                // 添加对应的文件Entry
                addEntry("/", source, zos);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            finally
            {
                close(zos, fos);
            }
        }
        return target;
    }

    /**
     * 扫描添加文件Entry
     * 
     * @param base
     *            基路径
     * @param source
     *            源文件
     * @param zos
     *            zip文件输出流
     * @throws IOException
     */
    private static void addEntry(String base, File source, ZipOutputStream zos)
    {
        // 按目录分级，形如：/aaa/bbb.txt
        String entry = base + source.getName();
        if (source.isDirectory())
        {
            for (File file : source.listFiles())
            {
                // 递归列出目录下的所有文件，添加文件Entry
                addEntry(entry + "/", file, zos);
            }
        }
        else
        {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try
            {
                byte[] buffer = new byte[1024 * 10];
                fis = new FileInputStream(source);
                bis = new BufferedInputStream(fis, buffer.length);
                int read = 0;
                zos.putNextEntry(new ZipEntry(entry));
                while ((read = bis.read(buffer, 0, buffer.length)) != -1)
                {
                    zos.write(buffer, 0, read);
                }
                zos.closeEntry();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            finally
            {
                close(bis, fis);
            }
        }
    }

    /**
     * 解压文件
     * 
     * @param filePath
     *            压缩文件路径
     */
    public static void unzip(String filePath)
    {
        File source = new File(filePath);
        if (source.exists())
        {
            ZipInputStream zis = null;
            BufferedOutputStream bos = null;
            try
            {
                zis = new ZipInputStream(new FileInputStream(source));
                ZipEntry entry = null;
                while ((entry = zis.getNextEntry()) != null && !entry.isDirectory())
                {
                    File target = new File(source.getParent(), entry.getName());
                    if (!target.getParentFile().exists())
                    {
                        // 创建文件父目录
                        target.getParentFile().mkdirs();
                    }
                    // 写入文件
                    bos = new BufferedOutputStream(new FileOutputStream(target));
                    int read = 0;
                    byte[] buffer = new byte[1024 * 10];
                    while ((read = zis.read(buffer, 0, buffer.length)) != -1)
                    {
                        bos.write(buffer, 0, read);
                    }
                    bos.flush();
                }
                zis.closeEntry();
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
            finally
            {
                close(zis, bos);
            }
        }
    }

    /**
     * 关闭一个或多个流对象
     * 
     * @param closeables
     *            可关闭的流对象列表
     */
    public static void close(Closeable... closeables)
    {
        try
        {
            if (closeables != null)
            {
                for (Closeable closeable : closeables)
                {
                    if (closeable != null)
                    {
                        closeable.close();
                    }
                }
            }
        }
        catch (IOException e)
        {
        }
    }
}
