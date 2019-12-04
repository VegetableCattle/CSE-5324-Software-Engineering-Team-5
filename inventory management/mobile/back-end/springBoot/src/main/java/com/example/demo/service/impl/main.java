package com.example.demo.service.impl;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int [] pre={1,2,4,7,3,5,6,8};
        int [] in={4,7,2,1,5,3,8,6};
        TreeNode root= reConstructBinaryTree(pre,in);
        System.out.println(Arrays.binarySearch(in,6));
    }
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root;
        TreeNode node=new TreeNode(0);
        int k=1;
        node.val=pre[0];
        root=node;
        while(Arrays.binarySearch(in,pre[k])<Arrays.binarySearch(in,pre[0])){
            TreeNode left=new TreeNode(pre[k]);
            if(Arrays.binarySearch(in,pre[k])<Arrays.binarySearch(in,pre[k-1])){
                left.val=pre[k];
                node.left=left;
                node=left;
            }
            else{
                left.val=pre[k];
                node.right=left;
                node=left;
            }
            k++;
        }
        node=root;
        while(k<pre.length){
            TreeNode left=new TreeNode(pre[k]);
            if(Arrays.binarySearch(in,pre[k])<Arrays.binarySearch(in,pre[k-1])){
                left.val=pre[k];
                node.left=left;
                node=left;
            }
            else{
                left.val=pre[k];
                node.right=left;
                node=left;
            }
            k++;
        }
        return root;
    }
}
