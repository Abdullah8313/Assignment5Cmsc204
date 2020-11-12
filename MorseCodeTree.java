/*
 * Name: Abdullah Nabeel
 * CMSC:204-Assignment 5
 */

import java.util.ArrayList;
import java.util.TreeMap;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>
{
	TreeNode<String> root;

	public MorseCodeTree()
	{
		root = null;
		buildTree();
	}//constructor

	@Override
	public TreeNode<String> getRoot()
	{
		return root;
	}//method

	@Override
	public void setRoot(TreeNode<String> newNode)
	{
		root = new TreeNode<String>(newNode);
	}//method

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result)
	{
		TreeNode<String> root = getRoot();
		if(root==null)
		{
			setRoot(new TreeNode<String>(result));
		}
		else
		{
			addNode(root, code, result);
		}
		return this;
	}//method

	public void traverse(TreeNode<String> node, ArrayList array)
	{
		if (node != null)
		{
	         array.add(node.data); // adds to end of list.
	         traverse (node.leftNode, array);
	         traverse (node.rightNode, array);
	    }//if
	}//method


	@Override
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		if(code.length() == 1)
		{
			if(code.equals("."))
			{
				root.leftNode = new TreeNode<String>(letter);
			}
			else
			{
				root.rightNode = new TreeNode<String>(letter);
			}
		}
		else
		{
			if(code.charAt(0)=='.')
			{
				addNode(root.leftNode, code.substring(1), letter);
			}
			else
				addNode(root.rightNode, code.substring(1), letter);
		}
	}//method

	@Override
	public String fetch(String code)
	{
		String letter = fetchNode(root, code);
		return letter;
	}//method

	@Override
	public String fetchNode(TreeNode<String> root, String code)
	{

		if(code.length() == 1)
		{
			if(code.equals("."))
			{
				return root.leftNode.data;
			}
			else
			{
				return root.rightNode.data ;
			}
		}
		else
		{
			if(code.charAt(0)=='.')
			{
				return fetchNode(root.leftNode, code.substring(1));
			}
			else
				return fetchNode(root.rightNode, code.substring(1));
		}
	}//method

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}//method

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}//method

	@Override
	public void buildTree()
	{
		//level 0
		setRoot(new TreeNode<String>(""));
		//level 1
		insert(".", "e");
		insert("-", "t");
		//level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		//level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		//level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}//method

	@Override
	public ArrayList<String> toArrayList()
	{
		ArrayList<String> array = new ArrayList<String>();
		LNRoutputTraversal(root, array);
		return array;
	}//method

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
	{
		if (root != null) {
			LNRoutputTraversal(root.getLeftNode(), list);
	        list.add(root.getData());
	        //System.out.println(list);
	        LNRoutputTraversal(root.getRightNode(), list);
	    }
	}//method

}//end class MorseCodeTree
