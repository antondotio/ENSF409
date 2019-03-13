
class Node <TYPE>
{
	Integer keyM;
	TYPE itemM;
	Node nextM;
	
	public Node()
	{
		keyM = null;
		itemM=  null; 
		nextM  = null;
	
	}
	public Node(TYPE itemA, Integer keyA, Node  nextA)
	
	{
		itemM = itemA ;
		keyM = keyA;
		nextM = nextA;
	}
}
