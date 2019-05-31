package 数据结构和算法.JianZhiOffer;

public class taijie {
    public int JumpFloor(int target) {
        if(target <= 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int one = 1;
        int two = 2;
        int result = 0;
        for(int i = 3; i <=target; i++){
            result = one+ two;
            one = two;
            two = result;
        }
        return result;
    }
}