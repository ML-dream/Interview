package 其他测试.一些测试.test;

import java.util.Scanner;
/*
 * HashMap
 */
public class Main{
public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num1=0;
        while(sc.hasNext()){
            num1=sc.nextInt();
            int c=0;
            int d=0;
            while(num1>=3){
                c=(int)num1/3;
                d+=c;
                int f=num1%3;
                num1=(int) (f+c);
                
            }
            if(num1==2) {
            	d++;
            }
            for(int i=0;i<10;i++) {
            			System.out.println(i);
            }
            System.out.println(d);
        }
}
}