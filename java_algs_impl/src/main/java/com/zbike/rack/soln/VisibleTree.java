package com.zbike.rack.soln;

public class VisibleTree {

}

/*
import random

# Definition for a  binary tree node.
# For simplification, we use binary tree to demo the algorithm.
# But any kind of trees, it should work well.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
    
    def __str__(self, ind = 0):
        res = "\t"*ind + str(self.val) + "\n"
        if self.left == None:   res += "\t"*(ind+1) + "None" + "\n"
        else:                   res += self.left.__str__(ind+1)
        if self.right == None:   res += "\t"*(ind+1) + "None" + "\n"
        else:                   res += self.right.__str__(ind+1)
        return res
    
    @staticmethod
    def generateRandomBinaryTree(depth = 0):
        ''' Randomly generate a binary tree, for test.
            Set depth limit to prevent "maximum recursion depth exceeded"
        '''
        guess = random.randint(0,3)
        if guess == 0 or depth == 20:
            return None
        else:
            root = TreeNode(random.randint(1,100))
            root.left = TreeNode.generateRandomBinaryTree(depth+1)
            root.right = TreeNode.generateRandomBinaryTree(depth+1)
            return root

    @staticmethod
    def CountVisibleNodeRec(root, maxSoFar = None):
        ''' Recursive method to count the visible nodes
        '''
        if root == None:        # Empty tree
            return 0
        
        assert isinstance(root, TreeNode)
        
        if maxSoFar == None:    maxSoFar = root.val

        if maxSoFar <= root.val:
            # This is a visible node
            return TreeNode.CountVisibleNodeRec(root.left, root.val) + \
                   TreeNode.CountVisibleNodeRec(root.right, root.val) + \
                   1
        else:
            # Current node is not visible
            return TreeNode.CountVisibleNodeRec(root.left, maxSoFar) + \
                   TreeNode.CountVisibleNodeRec(root.right, maxSoFar)

    @staticmethod
    def CountVisibleNodeIte(root):
        ''' Iterative method to count the visible nodes
        '''
        if root == None:       # Empty tree
            return 0
        
        # Each element in stack is a list as: [node, maxSoFar]
        stack = [[root, root.val]]
        count = 0
        
        while len(stack) != 0:
            current = stack.pop()
            if current[0].val >= current[1]:
                # This is a visible node.
                count += 1
            
            maxSoFar = max(current[0].val, current[1])
            if current[0].left != None:
                stack.append([current[0].left, maxSoFar])
            if current[0].right != None:
                stack.append([current[0].right, maxSoFar])

        return count

def main():
    # Make the test case
    root = TreeNode.generateRandomBinaryTree()
    
    print "The count of visible nodes is (with recursive method):", \
           TreeNode.CountVisibleNodeRec(root)
    print "The count of visible nodes is (with iterative method):", \
           TreeNode.CountVisibleNodeIte(root)

    
if __name__ == "__main__":
    main()  */