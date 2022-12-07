package ElasticERL;

//main file
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ElasticERL {

	public void intSetEINThreshold(int size) {
		if (size <= 100)
			System.out.println("small data, use");
		else if (size >= 100 && size < 500000)
			System.out.println("flexible");
		else if (size <= 500000)
			System.out.println("large data");

	}

	public static void generate() {
		Random rnd = new Random();
		int n = 10000000 + rnd.nextInt(90000000);
		System.out.println(n);

	}

	public void allKeys(ElasticERL a) {
		// returns all keys in a sorted sequence

	}

	public static String nextKey(ListNode a) {
		a = a.getNext();
		return a.getElement().toString();

	}

	public static String prevkey(ListNode a) {
		a = a.getPrev();
		return a.getElement().toString();
	}

	public static int rangeKey(NodeList list, int key1, int key2) {
		ListNode p = (ListNode) list.first();
		boolean flag = false;
		int counter = 0;
		while (p.getNext() != null) {
			if (key1 == (int) p.getElement()) {
				flag = true;
				if (counter > 1) {
					System.out.println("Same key is found again");
				} else {
					System.out.println("1st key is found");
				}
			}

			if (flag == true) {
				counter++;
			}

			if (counter != 1 && key2 == (int) p.getElement()) {
				System.out.println("2nd key is found");
				flag = false;
				break;
			}
			p = p.getNext();
		}
		return counter - 2;
	}

	public static int remove(NodeList list, int key) {
		ListNode p = (ListNode) list.first();
		int removedVal;
		while (p.getNext() != null) {
			if (key == (int) p.getElement()) {
				System.out.println("Key found");
				removedVal = (int) p.getElement();
				list.remove(p);
				return removedVal;
			}
			p = p.getNext();
		}
		System.out.println("Key not found");
		return -1;
	}

	public static String getValues(NodeList list, int key) {
		ListNode p = (ListNode) list.first();
		String v;
		while (p.getNext() != null) {
			if (key == (int) p.getElement()) {
				System.out.println("Key found");
				v = (String) p.getValue();
				return v;
			}
			p = p.getNext();
		}
		return "The key " + key + " was not found";
	}

	ListNode sortedMerge(ListNode a, ListNode b) {
		ListNode result = null;
		/* Base cases */
		if (a == null)
			return b;
		if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (Integer.parseInt(a.getElement().toString()) <= Integer.parseInt(b.getElement().toString())) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}

	ListNode mergeSort(Position P) {
		ListNode h = (ListNode) P;
		// Base case : if head is null
		if (h == null || h.next == null) {
			return h;
		}

		// get the middle of the list
		ListNode middle = getMiddle(h);
		ListNode nextofmiddle = middle.next;

		// set the next of middle ListNode to null
		middle.next = null;

		// Apply mergeSort on left list
		ListNode left = mergeSort(h);

		// Apply mergeSort on right list
		ListNode right = mergeSort(nextofmiddle);

		// Merge the left and right lists
		ListNode sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

// Utility function to get the middle of the linked list
	public static ListNode getMiddle(ListNode head) {
		if (head == null)
			return head;

		ListNode slow = head, fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

// Utility function to print the linked list
	void printList(ListNode headref) {
		while (headref != null) {
			System.out.print(headref.getElement().toString() + " ");
			headref = headref.next;
		}
	}

	public static Position add(NodeList list, int key, String v) {
		list.addLast(key);
		ListNode p = (ListNode) list.tail.getPrev();
		p.setValue(v);
		return p;
	}

	public static void main(String[] args) {
		// generate();
		// TODO Auto-generated method stub
		NodeList<Integer> list = new NodeList<Integer>();
//		int [] sortArray=new int[500000];
//		
//		
		try {
			int i = 0;
			File myObj = new File("EHITS_test_file1.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				int newData = Integer.parseInt(data);
				list.addLast(newData);
				// sortArray[i]=newData;
				i++;

			}

			myReader.close();
			// Temp.setNext(list);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
//		 
//		 
//		 int[] array= new int[list.size()];//intializing array with size
		ListNode<Integer> p = (ListNode<Integer>) list.first();
		ListNode<Integer> f = (ListNode<Integer>) list.last();
		ListNode t = (ListNode) list.last();

		

		// remove() demo
		add(list, 123, "Testing");
		System.out.println(list.tail.getPrev().getElement().toString());
		System.out.println(list.tail.getPrev().getValue());
		int value = remove(list, 123);
		System.out.println("key " + value + " was removed");
		
		// getValues() demo
		String strVal = getValues(list, 33240013);
		System.out.println("The value of the key is: " + strVal);
		add(list, 1234, "Value of node with key 1234");
		String strVal2 = getValues(list, 1234);
		System.out.println("The value of the key is: " + strVal2);
		
		// rangekey() demo
		System.out.println(p.getElement().toString());
		add(list, 123, "This is the value of node with key 123");
		long ans = rangeKey(list, 33240013, 123);
		System.out.println("The number of elements betwen the two keys is: " + ans);

	}
}
