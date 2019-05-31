package 其他知识点.其他;



import java.util.ArrayList;
 
import java.util.Scanner;
 
public class test是 {
 
    public static void main(String[] args) {
 
        // TODO Auto-generated method stub
 
        Scanner in = new Scanner(System.in);
 
        int n = in.nextInt();
 
        ArrayList<String> arr = new ArrayList<>();
 
        while(in.hasNext()){
 
            arr.add(in.nextLine());
 
        }
 
        /*String[] str = new String[arr.size()];
 
        for(int m = 0; m < arr.size(); m++){
 
            str[m++] =arr.get(m);
 
        }*/
 
        int max = 0;
 
        for(int m = 0; m < arr.size(); m++){
 
            String []str = arr.get(m).split(",");
 
            max = max > str.length ? max : str.length;
 
        }
 
        int ll = 0;
 
        String result = "0";
 
        while(ll < max){
 
            for(int i = 0; i < arr.size(); i++){
 
                String []str = arr.get(i).split(",");
 
                for(int j = 0; j < n; j++){
 
                    if(ll + j < str.length)
 
                        result += str[ll + j] + ",";
 
                }
 
                if(i == arr.size() - 1){
 
                    ll = ll + n;
 
                }
 
            }
 
        }
 
        //System.out.println(result);
 
        String []str = result.split(",");
 
        for(int i = 1; i < str.length - 1; i++){
 
            System.out.print(str[i] + ",");
 
        }
 
        System.out.print(str[str.length - 1]);
 
         
 
    }
 
}