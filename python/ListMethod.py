class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


    def getList(myList):
        head = ListNode(myList[0])
        cur = head
        for num in myList[1:]:
            cur.next = ListNode(num)
            cur = cur.next
        return head

    def printNode(head):
        while head is not None:
            print(head.val)
            head = head.next