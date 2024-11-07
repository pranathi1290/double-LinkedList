import java.util.Scanner;

class Node{
	int data;
	Node next;
	Node prev;
	public Node(int data)
	{
		this.data=data;
	}
}

public class LinkedList {
	Node start;
public void create(int data) {
		Node l=start;
		Node newNode=new Node(data);
		if(start==null) {
			start=newNode;
		}
		else {
			while(l.next != null) {
				l=l.next;
			}
			
			l.next=newNode;
			newNode.prev=l;
		}
	}
public void printElements() {
	Node l=start;
	if(start==null) {
		System.out.println("no data");
	}
	else {
		while(l!=null) {
			System.out.print(l.data+"<->");
			l=l.next;
		}
		System.out.println();
	}
	
}
public void insertAtbegin(int data)
{
    Node l=start;
    Node newNode=new Node(data);
    if(start==null){
        System.out.println("list is empty");
    }
    newNode.next=start;
    start.prev=newNode;
    start=newNode;
    
}
public void insertAtend(int data){
    Node l=start;
    Node newNode=new Node(data);
    if(start==null){
        System.out.println("list is empty");
        }
        while(l.next!=null){
            l=l.next;
        }
        l.next=newNode;
        newNode.prev=l;
        l=l.next;
}
public void insertAtmiddle(int data,int pos){
    Node l=start;
    Node newNode=new Node(data);
    if(start==null){
        System.out.println("list is empty");
    }
    for(int i=1;i<pos-1;i++){
        l=l.next;
        
    }
    newNode.next=l.next;
    l.next.prev=newNode;
    l.next=newNode;
    newNode.prev=l;
    
}
public void deleteAtBegin(){
    Node l=start;
    if(start==null){
        System.out.println("list is empty");
    }
      Node d=start;
	System.out.println("data deleting "+d.data);
	start=start.next;
	start.prev=d;
	d.next=null;
	

}
public void deleteAtend(){
    	Node l=start;
	if (start==null) {
		System.out.println("list is empty");
	}
	else {
		while(l.next.next!=null) {
			l=l.next;
		}
		Node d=l.next;
		System.out.println("deleted element "+d.data);
		l.next=null;
		d.prev=null;
	}
}
public void deleteAtmiddle(){
    Node l=start;
	int position;
	System.out.println("enter position");
	Scanner sc=new Scanner(System.in);
	position=sc.nextInt();
	if(start==null) {
		System.out.println("Empty list");
	}
	else {
		for(int i=1;i<position-1;i++) {
			l=l.next;
		}
		Node d=l.next;
		System.out.println("deleted element "+d.data);
		l.next=d.next;
		l.next.prev = l;
		l.next.next.prev = l.next;
		d.next=null;

}

}
public void count(){
     Node l=start;
	 int count=0;
	if(start==null) {
		System.out.println("list is empty");
	}
	else {
		while(l!=null) {
			l=l.next;
			count++;
			
		}
		System.out.println("count "+count);
	}

}
public void search(int ele){
    Node l=start;
    int f=0;
    if(start==null){
        System.out.println("list is empty");
    }
    else {
		while(l.next!=null) {
			if(l.data==ele) {
				f=1;
				break;
			}
			l=l.next;
		}
		if(f==1) {
			System.out.println("element found");
		}
		else {
			System.out.println("element not found");
		}
	}

        
    }
    
public void sort() {
	Node pass,l;
	int temp;
	System.out.println("double linked list is sorted");
	for(pass=start;pass.next!=null;pass=pass.next) {
		for(l=start;l.next!=null;l=l.next) {
			if(l.data>l.next.data) {

				temp=l.data;
				l.data=l.next.data;
				l.next.data=temp;
			}
		}
	}
}
public void reverse() {
	Node ll=null;
	Node l=start;
	Node t=null;
	while(l!=null) {
		t=l.next;
		
		l.next=ll;
		ll=l;
		l=t;
	}
System.out.println("double linked list is reversed");
	start=ll;
	
}


public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.create(10);
		list.create(20);
		list.create(40);
		list.create(20);
		list.create(30);
		list.printElements();
		list.insertAtbegin(100);
		list.printElements();
		list.insertAtend(60);
		list.printElements();
		list.insertAtmiddle(70,3);
		list.printElements();
		list.deleteAtBegin();
		list.printElements();
		list.deleteAtend();
		list.printElements();
		list.deleteAtmiddle();
		list.printElements();
		list.count();
		list.search(70);
		list.printElements();
		list.sort();
		list.printElements();
        list.reverse();
		list.printElements();
		}
}
