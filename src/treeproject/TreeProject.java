
package treeproject;

import java.util.Scanner;


public class TreeProject {
  
    public static void main(String[] args) {
       
         tree t = new tree();

            while(true){
                
                System.out.println("\n enter (0 => insert number , 1 => print , 2 => exit ) ");
                Scanner in = new Scanner(System.in);
                int num = in.nextInt();
                
                   if(num == 0){    
                        System.out.println("please enter integer number to insert number in tree.. ");
                        Scanner input = new Scanner(System.in);
                         int x = input.nextInt();    
                          tree.root = t.insert(x , tree.root);
      
                }else if(num == 1){
                   System.out.println("please enter type >> print ( preorder or postorder or inorder )");
                   Scanner input = new Scanner(System.in);
                     String typePrint = input.nextLine();
                     t.trev(typePrint, tree.root);
                   
                }else if(num == 2){
                       System.exit(0);
                   }
 
        }
        
    }
    
}

 class treeNode {
     treeNode left;
     treeNode right;
     int info ;
     public treeNode( int info, treeNode left, treeNode right  ){
         this.info=info;
         this.left=left;
         this.right=right;
     }

    public treeNode getLeft() {
        return left;
    }

    public void setLeft(treeNode left) {
        this.left = left;
    }

    public treeNode getRight() {
        return right;
    }

    public void setRight(treeNode right) {
        this.right = right;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
     
 }

class tree{
   public static treeNode root;
   
     //method
      public boolean empty(){
          return root==null; 
      }
    
    public treeNode insert(int info,treeNode t){
        treeNode p;
        if(t==null){
          p=new treeNode(info,null,null);
          return p;
        }else if(info < t.info){
            t.left=insert(info,t.left);
            return t;
        }else if(info > t.info){
            t.right=insert(info,t.right);
            return t;
        }else{
            System.out.println(info + " Already present ...");
            return null;
        }
    }
    
        public void visit(int x){
          System.out.print(x+" "+" ");
      }
    
     public void trev(String name,treeNode t){
       if(t!=null){
           if(name.equals("preorder")){
             visit(t.info);  
             trev("preorder",t.left);
             trev("preorder",t.right);
           }
           else  if(name.equals("postorder")){  
             trev("postorder",t.left);
             trev("postorder",t.right);
             visit(t.info);  
           } else if(name.equals("inorder")){
              trev("inorder",t.left);
              visit(t.info);  
              trev("inorder",t.right);
           }else{
               System.out.print("null");
           }
           
       }
    }
}
