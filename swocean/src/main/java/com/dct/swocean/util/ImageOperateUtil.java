package com.dct.swocean.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Description: 图像压缩、裁剪、调整大小
 * @author: Created by dongxinyou on 2018/4/18.
 * @version 1.0.0
 * @updated by huangxueshan 修改了图像调整大小的操作
 */
@SuppressWarnings("restriction")
public class ImageOperateUtil {
	
	//指定静态图片文件名
	private static String fileNameNew = "";

	public static void main(String[] args) {
		//实例化一个ImageOperateUtil对象
		ImageOperateUtil util = new ImageOperateUtil();
		String fileName = "D:/temp/woman.jpg";
		try {
			fileNameNew = "cut.jpg";
			//读入文件
			File file = new File(fileName);
			//构造Image对象
			BufferedImage img = ImageIO.read(file);
	        BufferedImage image = util.cropImage(img, 200, 300, 100, 150);
			System.out.println(image);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Description: 图像压缩
	 * @author: Created by dongxinyou on 2018/4/18.
	 * @version 1.0.0
	 * @param fileName 文件路径
	 * @param size 最小宽/高
	 * @param isWidth 是否是等宽压缩
	 * @return  image 调整后的图像对象
	 * @throws IOException 当文件读入失败，或者文件调整大小失败时抛出
	 */
	public BufferedImage ImgCompress(String fileName,int size,boolean isWidth) throws IOException {  
        File file = new File(fileName);//读入文件
        BufferedImage img = ImageIO.read(file);//构造Image对象
        int width = img.getWidth(null);//得到源图宽
    	int height = img.getHeight(null);//得到源图长
    	BufferedImage image = null;
    	//以宽度为基准，等比例放缩图片 
        if(isWidth){
        	int h = (int) (height * size / width);
        	image = resize(img,size,h);
        }
        //以高度为基准，等比例缩放图片
        else{        	
        	int w = (int) (width * size / height);
        	image = resize(img,w,size);
        }
        return image;
    }
	
	/**
	 * Description: 调整图片大小:强制压缩/放大图片到固定的大小
	 * @author: Created by dongxinyou on 2018/4/18.
	 * @version 1.0.0
	 * @param img	图像对象
	 * @param width	int 新宽度
	 * @param high	int 新高度
	 * @return  image 调整后的图像对象
	 * @throws IOException 当输出文件流失败，或者文件编码失败时抛出
	 */
    public BufferedImage resize(Image img, int width, int high) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(width, high,BufferedImage.TYPE_INT_RGB );
        image.getGraphics().drawImage(img, 0, 0, width, high, null);//绘制缩小后的图
        
        File destFile = new File("D:\\temp\\"+fileNameNew);
        FileOutputStream out = new FileOutputStream(destFile);//输出到文件流
        
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);// 可以正常实现bmp、png、gif转jpg
        encoder.encode(image);//JPEG编码
        out.close();
        
        return image;
    }
    
    
	/**
	 * Description: 图片裁剪操作:
	 * @author: Created by dongxinyou on 2018/4/18.
	 * @version 1.0.0
     * @param bufferedImage 图像源
	 * @param startX	int 裁剪开始x坐标
	 * @param startY	int 裁剪开始y坐标
	 * @param width	int 裁剪结束x坐标
	 * @param height	int 裁剪结束y坐标 
	 * @return  result 调整后的图像对象
	 * @throws IOException
	 */    
    public BufferedImage cropImage(BufferedImage bufferedImage, int startX, int startY, int width, int height) throws Exception {

        if (startX == -1) {
            startX = 0;
        }
        if (startY == -1) {
            startY = 0;
        }
        BufferedImage result = new BufferedImage(width, height,4);  //根据传入的宽度和高度实例化一个图片内存对象
        //根据新的宽度和高度设定新的RGB值
        for (int x = startX; x < (startX+width); ++x) {
            for (int y = startY; y < (startY+height); ++y) {
                int rgb = bufferedImage.getRGB(x, y);
                result.setRGB(x - startX, y - startY, rgb);
            }
        }
        
        File destFile = new File("D:\\temp\\"+fileNameNew);
        FileOutputStream out = new FileOutputStream(destFile);//输出到文件流        
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);// 可以正常实现bmp、png、gif转jpg
        encoder.encode(result);//JPEG编码
        out.close();
        
        return result;
    }
}
