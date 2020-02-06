// 1. Show In-order
// 2. Write post-order, pre-order
// 
// 3. Review find min
// 4. write iterative findMin
// 5. Write recursive findmax
// 6. Review insert and page 117

// Java program to demonstrate insert operation in binary search tree
/* Class containing left and right child of current node and key value*/

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
    public int getKey() {return key;}
    public void setKey(int k) {key=k;}
}

public class BinarySearchTree {
 
    // Root of BST
    Node root;
 
    // Constructor
    BinarySearchTree() { 
        root = null; 
    }
 
    // This method mainly calls insertRec()
    void insert(int key) {
       root = insertRec(root, key);
    }
     
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    // This method mainly calls InorderRec()
    void inorder()  {
       inorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    
    // This method mainly calls InorderRec()
    void preorder()  {
       preorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void preorderRec(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    
    // This method mainly calls InorderRec()
    void postorder()  {
       postorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.key);
        }
    }
 
    void remove(int key) {
        removeNode(key, root).getKey();
        System.out.println("removed: "+key);
    }
    
    Node removeNode(int key, Node root) {
        if(root == null) {return null;}
        
        int k = root.getKey();
        
        if (k > key) {
            root.left = removeNode(key, root.left);
        }
        else if (k < key) {
            root.right = removeNode(key, root.right);
        }
        else if (root.left != null && root.right != null) {
            root.key = findMin(root.right).getKey();
            root.right = removeNode(root.key,root.right);
        }
        else {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }
    
    void findMin() {
        System.out.println("findMin: "+findMin(root).getKey());
    }
    
    Node findMin(Node root) {
        if (root.left != null) 
            return findMin(root.left);
        return root;
    }
    
    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        // print inorder traversal of the BST
        tree.inorder();
        System.out.println("\n\n");
        tree.preorder();
        System.out.println("\n\n");
        tree.postorder();
        System.out.println("\n\n");
        tree.findMin();
        tree.remove(30);
        
        tree.inorder();
    }
}