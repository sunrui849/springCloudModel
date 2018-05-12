import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2018/5/2.
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {9,1,12,7,8,3,4,22,65,5};
        sort(arr,0,9);
        System.out.println(arr);
        for (int a:arr
             ) {
            System.out.println(a);
        }

    }


    public static void sort(int[] arr,int left,int right){

        //1,找到递归算法的出口
        if( left > right) {
            return;
        }
        //2, 存
        int i = left;
        int j = right;
        //3,key
        int key = arr[ left ];
        //4，完成一趟排序
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && arr[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && arr[i] <= key) {
                i++;
            }
            if(i<j){
                int p = arr[i];
                arr[i] = arr[j];
                arr[j] = p;
            }

        }

        // 4.4，调整key的位置
        int p = arr[i];
        arr[i] = arr[left];
        arr[left] = p;
        //5, 对key左边的数快排
        sort(arr, left, i-1 );
        //6, 对key右边的数快排
        sort(arr, i+1,right);
    }
}
