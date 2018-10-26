package com.dct.swocean.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 图片添加水印工具类 Created by huangxueshan on 2018/4/18.
 */
public class ImageRemarkUtil
{

    // 水印透明度
    private static float alpha = 0.5f;
    // 水印横向位置
    private static int positionWidth = 1;
    // 水印纵向位置
    private static int positionHeight = 1;
    // 水印文字字体
    private static Font font = new Font("宋体", Font.BOLD, 14);
    // 水印文字颜色
    private static Color color = Color.red;

    /**
     * 对水印位置、样式进行设置
     * 
     * @param alpha
     *            水印透明度
     * @param positionWidth
     *            水印横向位置
     * @param positionHeight
     *            水印纵向位置
     * @param font
     *            水印文字字体
     * @param color
     *            水印文字颜色
     */
    public static void setImageMarkOptions(float alpha, int positionWidth, int positionHeight, Font newfont,
            Color color)
    {
        if (alpha != 0.0f)
        {
            ImageRemarkUtil.alpha = alpha;
        }
        if (positionWidth != 0)
        {
            ImageRemarkUtil.positionWidth = positionWidth;
        }
        if (positionHeight != 0)
        {
            ImageRemarkUtil.positionHeight = positionHeight;
        }
        if (newfont != null)
        {
            font = new Font(newfont.getFamily() != null ? newfont.getFamily() : "宋体", newfont.getStyle(),
                    newfont.getSize() != 0 ? newfont.getSize() : 14);

        }
        if (color != null)
        {
            ImageRemarkUtil.color = color;
        }

    }

    /**
     * 添加水印图片
     * 
     * @param iconPath
     *            水印图片路径
     * @param srcImgPath
     *            原图片路径
     * @param targerPath
     *            目标图片路径
     * @param degree
     *            水印旋转角度
     */
    public static void markImageByIcon(String iconPath, String srcImgPath, String targerPath, Integer degree,
            boolean byMark)
    {
        OutputStream os = null;
        try
        {
            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);
            // 获取画笔对象
            Graphics2D g = getGraphics2D(srcImg, buffImg);
            // 设置水印旋转
            setDegree(degree, byMark, buffImg, g);

            // 水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);

            // 得到Image对象。
            Image img = imgIcon.getImage();

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

            // 水印图片的位置
            g.drawImage(img, positionWidth, positionHeight, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            // 释放资源
            g.dispose();

            // 生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeOutputStream(os);
        }
    }

    /**
     * 添加左上角或右上角水印图片
     * 
     * @param iconPath
     * @param srcImgPath
     * @param targerPath
     * @param isLeft
     */
    public static void markImageInCornerByIcon(String iconPath, String srcImgPath, String targerPath, boolean isRight)
    {
        OutputStream os = null;
        try
        {
            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);
            // 获取画笔对象
            Graphics2D g = getGraphics2D(srcImg, buffImg);

            // 水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);

            // 得到Image对象。
            Image img = imgIcon.getImage();

            // 设置水印旋转
            int posWidth = 1;
            int posHeight = (int) (imgIcon.getIconWidth() / 1.4);
            int degree = -45;

            if (isRight)
            {
                posWidth = (int) (buffImg.getWidth() - imgIcon.getIconWidth() / 1.4);
                posHeight = 1;
                degree = 45;
            }

            g.rotate(Math.toRadians(degree), posWidth, posHeight);

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

            // 水印图片的位置
            g.drawImage(img, posWidth, posHeight, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            // 释放资源
            g.dispose();

            // 生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeOutputStream(os);
        }
    }

    /**
     * 添加重复水印图片，旋转角度以水印左下角为中心
     * 
     * @param iconPath
     *            水印图片路径
     * @param srcImgPath
     *            原图片路径
     * @param targerPath
     *            目标图片路径
     * @param degree
     *            旋转角度
     * @param widthRep
     *            水平重复间隔
     * @param heightRep
     *            垂直重复间隔
     */
    public static void markImageCoverByIcon(String iconPath, String srcImgPath, String targerPath, Integer degree,
            Integer widthRep, Integer heightRep)
    {
        OutputStream os = null;
        try
        {

            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);
            // 获取画笔对象
            Graphics2D g = getGraphics2D(srcImg, buffImg);
            // 设置水印旋转
            if (null != degree)
            {
                g.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            }

            // 水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);

            // 得到Image对象。
            Image img = imgIcon.getImage();

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

            // 水印范围大小
            int size = (buffImg.getWidth() + buffImg.getHeight());

            // 水印图片的位置
            for (int i = -size / 2 + widthRep + imgIcon.getIconWidth(); i < size; i += widthRep
                    + imgIcon.getIconWidth())
            {
                for (int j = -size / 2 + heightRep + imgIcon.getIconHeight(); j < size; j += heightRep
                        + imgIcon.getIconHeight())
                {
                    g.drawImage(img, i - imgIcon.getIconWidth(), j - imgIcon.getIconHeight(), null);
                }
            }

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            // 释放资源
            g.dispose();

            // 生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeOutputStream(os);
        }
    }

    /**
     * 添加水平重复水印图片,一行
     * 
     * @param iconPath
     * @param srcImgPath
     * @param targerPath
     * @param widthRep
     * @param isTop
     */
    public static void markImageLevelByIcon(String iconPath, String srcImgPath, String targerPath, Integer widthRep,
            boolean isTop)
    {
        OutputStream os = null;
        try
        {

            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);
            // 获取画笔对象
            Graphics2D g = getGraphics2D(srcImg, buffImg);

            // 水印图片的路径 水印图片一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);

            // 得到Image对象。
            Image img = imgIcon.getImage();

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

            int posHeight = positionHeight;
            if (!isTop)
            {
                posHeight = buffImg.getHeight() - positionHeight - imgIcon.getIconHeight();
            }

            // 水印图片的位置
            for (int i = 0; i < buffImg.getWidth() + imgIcon.getIconWidth(); i += widthRep + imgIcon.getIconWidth())
            {
                g.drawImage(img, i, posHeight, null);
            }

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            // 释放资源
            g.dispose();

            // 生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeOutputStream(os);
        }
    }

    /**
     * 给图片添加水印文字、可设置水印文字的旋转角度
     * 
     * @param logoText
     *            水印文字
     * @param srcImgPath
     *            源图片路径
     * @param targerPath
     *            目标图片路径
     * @param degree
     *            旋转角度
     * @param byMark
     *            是否以水印坐标为中心设置水印旋转
     */
    public static void markImageByText(String logoText, String srcImgPath, String targerPath, Integer degree,
            boolean byMark)
    {
        InputStream is = null;
        OutputStream os = null;
        try
        {
            // 源图片
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g = getGraphics2D(srcImg, buffImg);
            setDegree(degree, byMark, buffImg, g);
            setFontStyle(g);

            g.drawString(logoText, positionWidth, positionHeight);
            // 释放资源
            g.dispose();
            // 生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeInputStream(is);
            closeOutputStream(os);
        }
    }

    /**
     * 添加左上角或右上角水印文字
     * 
     * @param iconPath
     * @param srcImgPath
     * @param targerPath
     * @param isLeft
     */
    public static void markImageInCornerByText(String logoText, String srcImgPath, String targerPath, boolean isRight)
    {
        InputStream is = null;
        OutputStream os = null;
        try
        {
            // 源图片
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g = getGraphics2D(srcImg, buffImg);
            FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
            double degree = -45;
            double posWidth = fm.getHeight() / 1.4;
            double posHeight = (fm.getHeight() + fm.stringWidth(logoText)) / 1.4;
            if (isRight)
            {
                posHeight = fm.getHeight() / 1.4;
                posWidth = buffImg.getWidth() - (fm.getHeight() + fm.stringWidth(logoText)) / 1.4;
                degree = 45;
            }
            g.rotate(Math.toRadians(degree), posWidth, posHeight);
            setFontStyle(g);
            // 第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
            g.drawString(logoText, (int) posWidth, (int) posHeight);
            // 释放资源
            g.dispose();
            // 生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeInputStream(is);
            closeOutputStream(os);
        }
    }

    /**
     * 给图片添加重复水印文字，旋转角度以水印左下角为中心
     * 
     * @param logoText
     *            水印文字
     * @param srcImgPath
     *            源图片路径
     * @param targerPath
     *            目标图片路径
     * @param degree
     *            旋转角度
     * @param widthRep
     *            水平重复间隔
     * @param heightRep
     *            垂直重复间隔
     */
    public static void markImageCoverByText(String logoText, String srcImgPath, String targerPath, Integer degree,
            Integer widthRep, Integer heightRep)
    {
        InputStream is = null;
        OutputStream os = null;
        try
        {
            // 源图片
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g = getGraphics2D(srcImg, buffImg);
            // 设置水印旋转
            if (null != degree)
            {
                g.rotate(Math.toRadians(degree), 1, 1);
            }
            setFontStyle(g);

            // 第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
            // 水印范围大小
            int size = (buffImg.getWidth() + buffImg.getHeight());

            FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);

            for (int i = -size / 2 + widthRep + fm.stringWidth(logoText); i < size; i += widthRep
                    + fm.stringWidth(logoText))
            {
                for (int j = -size / 2 + heightRep + fm.getHeight(); j < size; j += heightRep + fm.getHeight())
                {
                    g.drawString(logoText, i - fm.stringWidth(logoText), j - fm.getHeight());
                }
            }

            // 释放资源
            g.dispose();
            // 生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeInputStream(is);
            closeOutputStream(os);
        }
    }

    /**
     * 添加水平重复水印文字，一行
     * 
     * @param logoText
     * @param srcImgPath
     * @param targerPath
     * @param widthRep
     */
    public static void markImageLevelByText(String logoText, String srcImgPath, String targerPath, Integer widthRep,
            boolean isTop)
    {
        InputStream is = null;
        OutputStream os = null;
        try
        {
            // 源图片
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g = getGraphics2D(srcImg, buffImg);

            setFontStyle(g);

            FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
            // 第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
            // 水印范围大小
            int posHeight = positionHeight + fm.getHeight();
            if (!isTop)
            {
                posHeight = buffImg.getHeight() - positionHeight;
            }

            for (int i = 0; i < buffImg.getWidth() + fm.stringWidth(logoText); i += widthRep + fm.stringWidth(logoText))
            {
                g.drawString(logoText, i, posHeight);
            }

            // 释放资源
            g.dispose();
            // 生成图片
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeInputStream(is);
            closeOutputStream(os);
        }
    }

    /**
     * 获取画笔对象并处理
     * 
     * @param srcImg
     * @param buffImg
     * @return
     */
    private static Graphics2D getGraphics2D(Image srcImg, BufferedImage buffImg)
    {
        Graphics2D g = buffImg.createGraphics();

        // 设置对线段的锯齿状边缘处理
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                null);
        return g;
    }

    /**
     * 判断和设置水印旋转中心是以图片为主还是水印为主
     * 
     * @param degree
     * @param byMark
     * @param buffImg
     * @param g
     */
    private static void setDegree(Integer degree, boolean byMark, BufferedImage buffImg, Graphics2D g)
    {
        if (null != degree)
        {
            double widthDegree = (double) buffImg.getWidth() / 2;
            double heightDegree = (double) buffImg.getHeight() / 2;
            if (byMark)
            {
                widthDegree = positionWidth;
                heightDegree = positionHeight;
            }
            g.rotate(Math.toRadians(degree), widthDegree, heightDegree);
        }
    }

    /**
     * 设置文字水印颜色、字体、透明度
     * 
     * @param g
     */
    private static void setFontStyle(Graphics2D g)
    {
        // 设置水印文字颜色
        g.setColor(color);
        // 设置水印文字Font
        g.setFont(font);
        // 设置水印文字透明度
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
    }

    /**
     * 关闭资源
     * 
     * @param is
     */
    private static void closeInputStream(InputStream is)
    {
        try
        {
            if (null != is)
                is.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     * 
     * @param os
     */
    private static void closeOutputStream(OutputStream os)
    {
        try
        {
            if (null != os)
                os.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
