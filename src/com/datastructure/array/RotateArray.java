package com.datastructure.array;

public class RotateArray {
	//time complexity of O(n) and space complexity of O(1)
	//jungle rotate
	void leftRotate(int arr[], int d, int n) {
		int i, j, k, temp;
		for(i = 0; i < gcd(d, n); i++) {
			temp = arr[i];
			j = i;
			while(true) {
				k = j + d;
				if(k >= n) {
					k = k - n;
				}
				if(k == i) {
					break;
				}
				arr[j]= arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}
	
	int gcd(int a, int b) {
    	if(b == 0) 
    		return a;
    	else
    		return gcd(b, a%b);
    }
	
	//reversal rotate
	void leftReversalRotate(int arr[], int d, int n) {
		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n-1);
	}
	
	void reverse(int arr[], int start, int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	// block swap rotate
	void rotateWithBlockSwap(int arr[], int d, int n)
	{
	  int i, j;
	  if(d == 0 || d == n)
	    return;
	  i = d;
	  j = n - d;
	  while (i != j)
	  {
	    if(i < j) /*A is shorter*/
	    {
	      swap(arr, d-i, d+j-i, i);
	      j -= i;
	    }
	    else /*B is shorter*/
	    {
	      swap(arr, d-i, d, j);
	      i -= j;
	    }
	    // printArray(arr, 7);
	  }
	  /*Finally, block swap A and B*/
	  swap(arr, d-i, d, i);
	}
	
	/*This function swaps d elements starting at index fi
	  with d elements starting at index si */
	void swap(int arr[], int fi, int si, int d)
	{
	   int i, temp;
	   for(i = 0; i<d; i++)   
	   {
	     temp = arr[fi + i];
	     arr[fi + i] = arr[si + i];
	     arr[si + i] = temp;
	   }     
	}     
	
	/* function to print an array */
    void printArray(int arr[], int size) 
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
    
    // Driver program to test above functions
    public static void main(String[] args) {
        RotateArray rotate = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        //rotate.leftRotate(arr, 2, 7);
        //rotate.leftReversalRotate(arr, 2, 7);
        rotate.rotateWithBlockSwap(arr, 2, 7);
        rotate.printArray(arr, 7);
    }
}
