/*
 * Name: Abdullah Nabeel
 * CMSC:204-Assignment 5
 */

public class TreeNode<T>
{
	T data;
	TreeNode<T> rightNode;
	TreeNode<T> leftNode;

	public TreeNode(T dataNode)
	{
		this.data = dataNode;
		this.rightNode = null;
		this.leftNode = null;
	}

	public TreeNode(TreeNode<T> node)
	{
		this.data = node.data;
		this.rightNode = node.rightNode;
		this.leftNode = node.leftNode;
	}

	public T getData()
	{
		return this.data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public TreeNode<T> getRightNode()
	{
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode)
	{
		this.rightNode = rightNode;
	}

	public TreeNode<T> getLeftNode()
	{
		return leftNode;
	}

	public void setLeftNode(TreeNode<T> leftNode)
	{
		this.leftNode = leftNode;
	}




}//end class
