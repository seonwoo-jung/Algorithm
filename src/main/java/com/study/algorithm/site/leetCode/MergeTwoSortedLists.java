package com.study.algorithm.site.leetCode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		System.out.println(
			mergeTwoLists(
				new ListNode(1, new ListNode(2, new ListNode(4))),
				new ListNode(1, new ListNode(3, new ListNode(4)))
			)
		);
	}

	private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// 더미 노드 생성 (결과 리스트의 시작점)
		ListNode dummy = new ListNode();
		// 현재 노드를 가리킬 포인터
		ListNode current = dummy;

		// 두 리스트를 순회하며 작은 값을 결과 리스트에 추가
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				current.next = list1;
				list1 = list1.next; // list1의 다음 노드로 이동
			} else {
				current.next = list2;
				list2 = list2.next; // list2의 다음 노드로 이동
			}
			current = current.next; // 현재 노드를 다음 노드로 이동
		}

		// 남아있는 노드를 결과 리스트에 추가
		if (list1 != null) {
			current.next = list1;
		} else if (list2 != null) {
			current.next = list2;
		}

		// 더미 노드의 다음 노드가 병합된 리스트의 시작점
		return dummy.next;
	}

	private static class ListNode {

		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
