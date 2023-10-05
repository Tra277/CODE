package binarysearchexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinarySearchExample {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4};
        int search = 4;

        //tạo một list mới để copy lại cái list tìm được ở dưới
        ArrayList<Integer> indices = findAllIndices(arr, search);
        if (indices.isEmpty()) {
            System.out.println(search + " not found in array.");
        } else {
            Collections.sort(indices);
            System.out.println("Indices of " + search + " in array: " + indices);
        }

    }

    //Tạo một ArrayList để lưu tất cả các index
    public static ArrayList<Integer> findAllIndices(int[] arr, int search) {
        ArrayList<Integer> indices = new ArrayList<>();
        //Tìm một index bất kì thỏa mãn theo binary search
        //bài này mình cần viết thuật toán ra chứ không được sử dụng hàm có sẵn
        int index = Arrays.binarySearch(arr, search);

        //Nếu tìm thấy (>=0) ( do không tìm thấy thì trả về -1) thì add cái index này vào array list 
        if (index >= 0) {
            indices.add(index);

            //param left để lưu vị trí thằng bên trái index được tìm thấy và bắt đầu quét phía bên trái, cứ thằng nào bằng thì cho vào list
            int left = index - 1;
            while (left >= 0 && arr[left] == search) {
                indices.add(left);
                left--;
            }

            //param right để lưu vị trí thằng bên trái index được tìm thấy và bắt đầu quét phía bên phải, cứ thằng nào bằng thì cho vào list
            int right = index + 1;
            while (right < arr.length && arr[right] == search) {
                indices.add(right);
                right++;
            }
        }
        //trả về list chứa tất cả index
        return indices;
    }
}
