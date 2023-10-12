package Trees;
//TC =>O(N) where N is the no of node
public class InorderTraversal {
     ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null)return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
     }
}
