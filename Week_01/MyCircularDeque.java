package com.kihao.demo;

//641 设计循环双端队列
    class Node{
        int val;
        Node next,pre;
        public Node(int val){
            this.val =val;
            this.next =null;
            this.pre = null;
        }
    }

    class MyCircularDeque {

        int capacity = 0;
        Node head,tail;
        int count = 0;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            this.capacity = k;
            head = null;
            tail = null;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(count == capacity){
                return false;
            }
            Node nowNode = new Node(value);
            if(this.count == 0){
                this.head = this.tail = nowNode;
            }else{
                this.head.pre = nowNode;
                nowNode.next = this.head;
                this.head = nowNode;
            }
            count++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(count == capacity){
                return false;
            }
            Node nowNode = new Node(value);
            if(count==0){
                this.head = this.tail = nowNode;
            }else{
                this.tail.next = nowNode;
                nowNode.pre = this.tail;
                this.tail = nowNode;
            }
            count++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(count == 0){
                return false;
            }else if(count == 1){
                this.tail = this.head = null;
            }else{
                Node newHead = this.head.next;
                this.head.next =null;
                newHead.pre = null;
                this.head = newHead;
            }
            count--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(count == 0){
                return false;
            }else if(count == 1){
                this.tail = this.head =null;
            }else{
                Node newTail = this.tail.pre;
                this.tail.pre = null;
                newTail.next = null;
                this.tail = newTail;
            }
            count--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(count==0){
                return -1;
            }
            return this.head.val;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(count==0){
                return -1;
            }
            return this.tail.val;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return count==0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return count == capacity;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

