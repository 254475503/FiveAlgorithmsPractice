package com.sohu.yifanshi.tree.connect;

import com.sohu.yifanshi.standarddatastructure.Node;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Solution {
    /**
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root==null||root.left==null)
            return root;
        Queue<Node> queue  = new LinkedBlockingQueue<>();
        int temp = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            int i = temp;
            temp = 0;
            while(i!=0){
                Node node = queue.poll();
                if(i!=1){
                    node.next = queue.peek();
                }
                if(node.left!=null){
                    queue.add(node.left);
                    queue.add(node.right);
                    temp+=2;
                }
                i--;
            }
        }
        return root;
    }


    /**
     * 给定一个二叉树
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。zhiyo
     *
     * 只用常数级别的额外空间
     */
    public Node connect2(Node root){
        Node nextLevelFirst,prev = null,currentNode;
        nextLevelFirst = root;
        while (nextLevelFirst!=null){
            currentNode = nextLevelFirst;
            nextLevelFirst = null;
            while (currentNode!=null){
                if(currentNode.left!=null){
                    if(nextLevelFirst==null){
                        nextLevelFirst = currentNode.left;
                    }
                    if (prev != null) {
                        prev.next = currentNode.left;
                    }
                    prev = currentNode.left;
                }
                if(currentNode.right!=null){
                    if(nextLevelFirst==null){
                        nextLevelFirst = currentNode.right;
                    }
                    if (prev != null) {
                        prev.next = currentNode.right;
                    }
                    prev = currentNode.right;
                }

                currentNode = currentNode.next;
            }
            prev = null;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.connect2(new Node());
    }
}
