public class SplayTree 
{ 
      
    // An AVL tree node  
    static class node  
    {  
      
        int key;  
        node left, right;  
    };  
      
    /* Helper function that allocates  
    a new node with the given key and  
        null left and right pointers. */
    static node newNode(int key)  
    {  
        node Node = new node(); 
        Node.key = key;  
        Node.left = Node.right = null;  
        return (Node);  
    }  
      
    // A utility function to right  
    // rotate subtree rooted with y  
    // See the diagram given above.  
    static node rightRotate(node x)  
    {  
        node y = x.left;  
        x.left = y.right;  
        y.right = x;  
        return y;  
    }  
      
    // A utility function to left  
    // rotate subtree rooted with x  
    // See the diagram given above.  
    static node leftRotate(node x)  
    {  
        node y = x.right;  
        x.right = y.left;  
        y.left = x;  
        return y;  
    }  
      
    // This function brings the key at 
    // root if key is present in tree.  
    // If key is not present, then it 
    // brings the last accessed item at  
    // root. This function modifies the 
    // tree and returns the new root  
    static node splay(node root, int key)  
    {  
        // Base cases: root is null or 
        // key is present at root  
        if (root == null || root.key == key)  
            return root;  
      
        // Key lies in left subtree  
        if (root.key > key)  
        {  
            // Key is not in tree, we are done  
            if (root.left == null) return root;  
      
            // Zig-Zig (Left Left)  
            if (root.left.key > key)  
            {  
                // First recursively bring the 
                // key as root of left-left  
                root.left.left = splay(root.left.left, key);  
      
                // Do first rotation for root,  
                // second rotation is done after else  
                root = rightRotate(root);  
            }  
            else if (root.left.key < key) // Zig-Zag (Left Right)  
            {  
                // First recursively bring 
                // the key as root of left-right  
                root.left.right = splay(root.left.right, key);  
      
                // Do first rotation for root.left  
                if (root.left.right != null)  
                    root.left = leftRotate(root.left);  
            }  
      
            // Do second rotation for root  
            return (root.left == null) ?  
                                  root : rightRotate(root);  
        }  
        else // Key lies in right subtree  
        {  
            // Key is not in tree, we are done  
            if (root.right == null) return root;  
      
            // Zag-Zig (Right Left)  
            if (root.right.key > key)  
            {  
                // Bring the key as root of right-left  
                root.right.left = splay(root.right.left, key);  
      
                // Do first rotation for root.right  
                if (root.right.left != null)  
                    root.right = rightRotate(root.right);  
            }  
            else if (root.right.key < key)// Zag-Zag (Right Right)  
            {  
                // Bring the key as root of  
                // right-right and do first rotation  
                root.right.right = splay(root.right.right, key);  
                root = leftRotate(root);  
            }  
      
            // Do second rotation for root  
            return (root.right == null) ?  
                                   root : leftRotate(root);  
        }  
    }  
      
    // The search function for Splay tree.  
    // Note that this function returns the  
    // new root of Splay Tree. If key is  
    // present in tree then, it is moved to root.  
    static node search(node root, int key)  
    {  
        return splay(root, key);  
    }  
      
    // A utility function to print  
    // preorder traversal of the tree.  
    // The function also prints height of every node  
    static void preOrder(node root, int space)  
    {  
        if (root != null)  
        {   
            space = space + 2;
            preOrder(root.left,space);  
            
            for(int i=0; i < space; i++) System.out.print(" ");
                    
            System.out.println(root.key + " "); 
            preOrder(root.right,space);  
        }  
    }  
     
    static node insert(node root, int key) {
        root = insertRec(root,key);
        root = search(root,key);
        
        return root;
    }
    
    /* A recursive function to insert a new key in BST */
    static node insertRec(node root, int key) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            return newNode(key);
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
    
    
    // Driver code 
    public static void main(String[] args)  
    {  
        node root = newNode(100);  
        root.left = newNode(50);  
        root.right = newNode(200);  
        root.left.left = newNode(40);  
        root.left.left.left = newNode(30);  
        root.left.left.left.left = newNode(20);  
      
        root = search(root, 20);  
        System.out.print("Preorder traversal of the" +   
                         " modified Splay tree is \n");  
        preOrder(root, 0);  
        
        root = insert(root, 250);
        System.out.println("------------------");
        preOrder(root,0);
        
    }  
}  
  
// G4G