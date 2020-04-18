class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    myValue = inValue;
    //assigns no value to left
    left = null;
    //assigns no value to right
    right = null;
  }
  
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.
    int i = 0;
    myValue = (A[0]);
    for(i = 1; i < A.length; i++){
      this.insert(A[i]);
    }
  }
  
  public void insert(int inValue) {
    // This method takes a new integer as input and decides 
    // if it should be place: 
    //    * as the left child,
    //    * as the right child, 
    //    * in the left subtree,
    //    * or in the right subtree.
    // If the value already exists in the tree, no action is taken. 
    if (inValue < myValue) {
      if (left == null) {
        left = new myBinarySearchTreeNode(inValue);
      } else {
        left.insert(inValue);
      }

    //other option to where the in value is greater than my value
    } else if (inValue > myValue) {
      if (right == null) {
        right = new myBinarySearchTreeNode(inValue);
      } else {
        right.insert(inValue);
      }
    } else {
      //when a value in the tree already exists
      System.out.println("Value in place of tree");
    }
  }


  
  public int height() {
    // This method recursively calculates the height of the entire (sub)tree.
    // This method will take O(n) time
    int leftHeight = 0;
    int rightHeight = 0;
    int treeHeight = 0;
    if (left != null) {
      leftHeight += left.height();
    }
    if (right != null) {
      rightHeight += right.height();
    }
    //left height is the total height if it has more nodes than right side
    if (leftHeight > rightHeight) {
      treeHeight = leftHeight;
    //if right side has more nodes than left side, total height is the number in the right
    } else if (rightHeight > leftHeight) {
      treeHeight = rightHeight;
    }
  //return the total height
    return treeHeight + 1;
  }
  
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
     // Additionally, remember that the depth is the number of nodes on the path from a node to the root 
     // (i.e. the number of the recursie calls).
    if(search < myValue) {
      if (left == null) {
        return -1;
      }
      return left.depth(search) + 1;
      //this makes it go left
    }
    if (search > myValue){
      if(right == null) {
        return -1;
      }
      return right.depth(search) + 1;
      //this makes it go right
    }
    if(search == myValue){
      return 0;
    }
    return -1;
  }

  public int size(){
    // This method recursively calculates the number of nodes in the (sub)tree.
    int sizeSum = 0;
    if(left != null){
      sizeSum += left.size();
    }
    if(right != null){
      sizeSum += right.size();
    }
    return sizeSum + 1;
  }


  // Utility function included so you can debug your solution. 
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
  
} 
