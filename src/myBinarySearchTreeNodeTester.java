import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class myBinarySearchTreeNodeTester {
    //first test case with 2 numbers in the array
    @Test
    public void binarySearch1() {
        int[] A = {1, 2};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(A);
        test.print();
        assertEquals(2, test.size());
        assertEquals(2, test.height());
        assertEquals(1, test.depth(2));

        assertEquals(A[0], test.myValue);
        assertEquals(A[1], test.right.myValue);

    }

    //test case with 3 numbers in the array
    @Test
    public void binarySearch2() {
        int[] A = {3, 6, 9};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(A);
        test.print();
        assertEquals(3, test.size());
        assertEquals(3, test.height());
        assertEquals(2, test.depth(9));

        assertEquals(A[0], test.myValue);
        assertEquals(A[1], test.right.myValue);
        assertEquals(A[2], test.right.right.myValue);
    }

    //same test case as the second test case but this time with negative numbers
    //FAILS
    @Test
    public void binarySearch3() {
        int[] A = {-3, -6, -9};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(A);
        test.print();
        assertEquals(3, test.size());
        assertEquals(3, test.height());
        assertEquals(2, test.depth(-9));

        assertEquals(A[0], test.myValue);
        assertEquals(A[1], test.right.myValue);
        assertEquals(A[2], test.right.right.myValue);
    }
    //same test like the second one but this time with multiples
    //testing the recursive print when a value is already in the tree
    //*FAILS
    @Test
    public void binarySearch4() {
        int[] A = {1, 1, 1};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(A);
        test.print();
        assertEquals(3, test.size());
        assertEquals(3, test.height());
        assertEquals(2, test.depth(1));

        assertEquals(A[0], test.myValue);
        assertEquals(A[1], test.right.myValue);
        assertEquals(A[2], test.right.right.myValue);
    }
    //test case with only one value in the tree which in this case would be the root
    //test passes
    @Test
    public void binarySearch5(){
        int [] A = {1};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(A);
        test.print();
        assertEquals(1, test.size());
        assertEquals(1, test.height());
        assertEquals(0, test.depth(1));

        assertEquals(A[0], test.myValue);

    }
}