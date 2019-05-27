package test;

public class main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int i=0;
		for(i=2*i;i<10;i++) {
			System.out.println(i);*/
		Class dsh=main1.class;
//		Class.forName("");
		String ds="dsds";
		System.out.println(main1.class.getClassLoader());
		ClassLoader
		new  Thread();
	
	/*}*/

}
	/*
	 * 由于在建立堆的时候已经完成的基本的排序，只有每个节点点子节点之间的没有完成排序，
	 * 所以在抽取最大值，并用数组的最后的值 ，其实就是每个分支最小的或者倒数第二小的一个数
	 * ，然后由于建堆的过程中已经排好的大致的序列，此时只要按照最后一步---【从最顶端开始调整，这就是所谓的堆的记忆功能】
	 * 这个点就是最下面 的非子节点
	 * 也就是保证每个有子节点的节点是按照层序遍历的循序进行大小排序的！不要求改节点的子节点的大小顺序
	 */
	public static void swap (int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
		Class dsh=main1.class;
		System.out.println(dsh.getClassLoader());
	}
}