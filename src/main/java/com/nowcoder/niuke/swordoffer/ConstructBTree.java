package com.nowcoder.niuke.swordoffer;

import java.util.Arrays;

/**
 * Created by hztaoran on 2016/8/8.
 */
public class ConstructBTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (null == pre || null == in || pre.length <= 0 || in.length <= 0) {
            return null;
        }

        if (pre.length != in.length) {
            throw new IllegalArgumentException("length is not equal");
        }

        TreeNode root = new TreeNode(0);
        boolean flag = false;
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                flag = true;
                root.val = in[i];
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1)
                        , Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length)
                        , Arrays.copyOfRange(in, i + 1, in.length));
            }
        }

        if (!flag) {
            throw new IllegalArgumentException("no root node match");
        }

        return root;
    }
}
