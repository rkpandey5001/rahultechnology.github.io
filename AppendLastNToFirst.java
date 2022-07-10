package LinkedList;

import java.util.Scanner;

public class AppendLastNToFirst 
{
	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n)
	{
		LinkedListNode<Integer> newHead=null,temp=head,newTail=head,currentHead=null,temp2=null;
		int length=0;
		if(head==null)
		{
			return head;
		}
		while(temp!=null)
		{
			length=length+1;
			temp=temp.next;
		}
		int i=1;
		while(i<length-n)
		{
			newTail=newTail.next;
			i++;
		}
		newHead=newTail.next;
		newTail.next=null;
		currentHead=head;
		temp2=newHead;
		while(temp2!=null)
		{
			if(temp2.next==null)
			{
				temp2.next=currentHead;
				break;
			}
			temp2=temp2.next;
		}
		return newHead;
	}
	public static LinkedListNode<Integer> takeInput()
	{
		Scanner scan=new Scanner(System.in);
		int data =scan.nextInt();
		LinkedListNode<Integer> head=null,temp=null;
		while(data!=-1)
		{
			LinkedListNode<Integer> newNode=new LinkedListNode(data);
			if(head==null)
			{
				head=newNode;
				temp=newNode;
			}
			else
			{
				temp.next=newNode;
				temp=newNode;
			}
			data=scan.nextInt();
		}
		return head;
		
	}
	
	public static void print(LinkedListNode<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
	}
   
    public static LinkedListNode<Integer> insertNode(LinkedListNode<Integer> head,int data,int pos)
    {
    	LinkedListNode<Integer> newNode=new LinkedListNode<Integer>(data);
    	if(pos==0)
    	{
    		newNode.next=head;
    		return newNode;
    	}
    	int i=0;
    	LinkedListNode<Integer> temp=head;
    	while(i<pos-1)
    	{
    		temp=temp.next;
    		i++;
    	}
    	newNode.next=temp.next;
    	temp.next=newNode;
    	return head;
    }
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		LinkedListNode<Integer> head=takeInput();
		System.out.println("Before inserted element");
		print(head);
	    System.out.println();
	    System.out.println("Enter number of nodes move from last to front");
	    int n=scan.nextInt();
	    LinkedListNode<Integer> head1=appendLastNToFirst(head, n);
		print(head1);

	}

}
