import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class app
{

private static void copyFileUsingFileStreams(File source, File dest) throws IOException {    
    InputStream input = null;    
    OutputStream output = null;    
    try {
           input = new FileInputStream(source);
           output = new FileOutputStream(dest);        
           byte[] buf = new byte[1024];        
           int bytesRead;        
           while ((bytesRead = input.read(buf)) != -1) {
               output.write(buf, 0, bytesRead);
           }
    } finally {
        input.close();
        output.close();
    }
}

public static void isDirectory(File file) {
		if(file.exists()){
			if (file.isFile()) {
				System.out.println(file.getAbsolutePath());
				try{
			copyFileUsingFileStreams(new File(file.getAbsolutePath()), new File("C:\\Users\\23684\\Pictures\\YS8\\" + new File(file.getAbsolutePath()).getName()));
		}catch(Exception e)
		{System.out.println(e);}
			}else{
				File[] list = file.listFiles();
				if (list.length == 0) {
					System.out.println(file.getAbsolutePath() + " is null");
				} else {
					for (int i = 0; i < list.length; i++) {
						isDirectory(list[i]);
					}
				}
			}
		}else{
		}
	}
public static void main(String args[]) 
{
	String path = null, path2 = null;
	File desktop = new File(System.getProperty("user.home")+System.getProperty("file.separator")+"XX");
	JFileChooser fileChooser = new JFileChooser(desktop.toString());
	fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	System.out.println("请选择您的PSV中要提取图片的文件夹...");
	int returnVal = fileChooser.showOpenDialog(fileChooser);
	if(returnVal == JFileChooser.APPROVE_OPTION){ 
	path = fileChooser.getSelectedFile().getAbsolutePath();
	} 
	System.out.println("请选择您的目标文件夹...");
	int returnVal2 = fileChooser.showOpenDialog(fileChooser);
	if(returnVal2 == JFileChooser.APPROVE_OPTION){ 
	path2 = fileChooser.getSelectedFile().getAbsolutePath();
	} 
    isDirectory(new File("G:\\picture\\SCREENSHOT"));
}

}