package javaIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//二进制流
public class testIO {

public static void main(String[] args) {
// 1、指明目标和源
	File o = new File("temp/Hello.class");
	File t = new File("tmp/Hello.class");
	// 2、构建流对象
	DataInputStream dis = null;
	DataOutputStream dos = null;
	try {
		dis = new DataInputStream(new FileInputStream(o));
		dos = new DataOutputStream(new FileOutputStream(t));
		int i;
	// 3、读写流
		while ((i = dis.read()) != -1) {
			dos.write(i);
	}
		dos.flush();
		System.out.println("操作成功!");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
	// 4、关闭流
	try {
		if (dos != null) {
			dos.close();
	}
		if (dis != null) {
			dis.close();
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	}
	}
	
