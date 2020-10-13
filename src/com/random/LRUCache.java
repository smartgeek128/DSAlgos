package com.random;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Node head;
	Node tail;
	Map<Integer, Node> map = null;
	int capacity = 0;

	public LRUCache(int capacity) {
		this.map = new HashMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;

		Node t = map.get(key);

		// move to tail
		removeNode(t);
		offerNode(t);
		return t.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node t = map.get(key);
			t.value = value;

			// move to tail
			removeNode(t);
			offerNode(t);
		} else {
			if (map.size() >= capacity) {
				// delete head
				map.remove(head.key);
				removeNode(head);
			}

			// add to tail
			Node node = new Node(key, value);
			offerNode(node);
			map.put(key, node);
		}
	}

	private void offerNode(Node node) {
		if (tail != null)
			tail.next = node;

		node.next = null;
		node.prev = tail;
		tail = node;

		if (head == null)
			head = tail;
	}

	private void removeNode(Node node) {
		if (node.prev != null)
			node.prev.next = node.next;
		else
			head = node.next;

		if (node.next != null)
			node.next.prev = node.prev;
		else
			tail = node.prev;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.put(1, 1001);
		cache.put(2, 1002);
		cache.put(3, 1003);
		cache.put(4, 1004);
		cache.put(5, 1005);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}
}

class Node {
	int key;
	int value;
	Node next;
	Node prev;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}