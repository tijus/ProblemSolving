package algorithm;


interface DoublyLinkedListContract {
    void add(int value);

    void addFirst(int value);

    boolean remove(int value);

    boolean removeLast();

    boolean removeFirst();

    int size();
}

class Execution {

    private static DoublyLinkedList head = new DoublyLinkedList(-1);
    private static DoublyLinkedList tail = new DoublyLinkedList(-1);
    private static int size = 0;

    private static class DoublyLinkedList implements DoublyLinkedListContract {

        int value;
        DoublyLinkedList next = null;
        DoublyLinkedList prev = null;

        DoublyLinkedList(int value) {
            this.value = value;
        }

        @Override
        public void add(int value) {
            DoublyLinkedList newNode = new DoublyLinkedList(value);
            DoublyLinkedList currHead = size == 0 ? head : tail.prev;
            head.next = newNode;
            newNode.prev = head;
            tail.prev = newNode;
            newNode.next = tail;

            size += 1;
        }

        @Override
        public boolean remove(int value) {
            if (size == 0)
                return false;
            DoublyLinkedList ptr = head.next;
            while (ptr != null) {
                if (ptr.value == value) {
                    remove(ptr);
                    size -= 1;
                    return true;
                }
                ptr = ptr.next;
            }

            return false;
        }

        @Override
        public void addFirst(int value) {
            DoublyLinkedList newNode = new DoublyLinkedList(value);
            newNode.next = head.next;
            head.next.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
            size += 1;
        }

        @Override
        public boolean removeLast() {
            if (size == 0)
                return false;

            remove(tail.prev);
            return true;
        }

        @Override
        public boolean removeFirst() {
            if (size == 0)
                return false;
            remove(head.next);
            return false;
        }

        private void remove(DoublyLinkedList doublyLinkedList) {
            DoublyLinkedList currPrev = doublyLinkedList.prev;
            DoublyLinkedList currNext = doublyLinkedList.next;

            currPrev.next = doublyLinkedList.next;
            currNext.prev = doublyLinkedList.prev;
        }

        @Override
        public int size() {
            return size;
        }
    }
}


