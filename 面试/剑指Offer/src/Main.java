import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        ArrayList<ArrayList<String>> arrayList1 = new ArrayList<ArrayList<String>>();
	       /* System.out.println(sc.nextInt());
	        System.out.println(sc.nextLine());*/
//	        System.out.println(sc.nextLine());
/*	        System.out.println(sc.hasNextLine());
	        System.out.println(sc.nextLine());
	        System.out.println(sc.hasNextLine());
	        System.out.println(sc.nextLine());
	        System.out.println(sc.hasNextLine());
	        System.out.println(sc.nextLine());
	        System.out.println(sc.hasNextLine());
	        System.out.println(sc.nextLine());
	        System.out.println(sc.hasNextLine());
	        System.out.println(sc.nextLine());
	        System.out.println(sc.hasNextLine());
	        System.out.println(sc.nextLine());*/
	    /*    while(true) {
	        	if(sc.nextLine().equals("")) break;
	        	System.out.println(sc.nextLine());
	        }*/
	        
	        while(sc.hasNext()){
	        	ArrayList<String> a= new ArrayList<String>();
	        	String mmm=sc.nextLine();
	        	System.out.println();
	        	String[] arr =mmm.split("\\,");
	        	for(String string:arr){
	        		a.add(string);
	        	}
	        	arrayList1.add(a);
	      }
//	        test(n,arrayList1);
	    }
	    
	    static void test(int n,ArrayList<ArrayList<String>> list){
	    	for(int i=0;i<list.size();i++){
	    				if(list.get(i).size()<=n){
	    					for(int m=0;m<list.get(i).size();m++){
		    					System.out.println(list.remove(m)+",");
		    				}
	    				}else{
	    					for(int m=0;m<n;m++){
	    					System.out.println(list.remove(m)+",");
	    				}
	    	}
	    }
	    test(n,list);
	    }	
	

}