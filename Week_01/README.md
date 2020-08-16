# 算法训练营第一周总结

* 1.Deque API修改
* 2.Queue和PriorityQueue源码分析
* 3.五毒刷题法使用一周后的心得

### Deque Api修改
    //修改 linkedList 实现的 deque api
    //push 实际上相当于addFirst（linkFirst） 从头部插入 
    //pop  实际上相当于removeFirst 空集合时抛异常
    //poll 实际上相当于unLinkFirst 空集合时返回null
    // peek 空集合时返回null   getFirst空集合时抛出异常
    //将课程上的代码修改后如下：
        Deque<String> deque = new LinkedList<String>(); 
    	deque.addFirst(“a”); 
		deque.addFirst("b"); 
    	deque.addFirst("c"); 
    	System.out.println(deque);
        String str = deque.getFirst((); 
    	System.out.println(str); 
    	System.out.println(deque); 
		while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        } 
    	System.out.println(deque);

### Queue和PriorityQueue源码分析
	Queue作为队列的接口，常用的几个api有add、offer、remove、poll、element、remove，add添加空元素会抛异常，offer会返回false，remove空集合时会返回异常，poll空集合时返回null；
	PriorityQueue：
	入队元素需要实现Comparator接口，元素的大小比较方法可以由用户Comparator指定。
	在查看PriorityQueue的实现前需要先了解java实现优先队列所用的数据接口二叉堆。
		 首先是堆这种数据结构的特点：
		 (1)堆中某个节点的值总是不大于或不小于其父节点的值；
		 (2)堆总是一棵完全树。
		 常见的堆有二叉堆、斐波那契堆等。
		 PriorityQueue使用的便是二叉堆中的最小堆。最小堆，即父结点的键值总是小于或等于任何一个子节点的键值。
		  PriorityQueue使用的是基于数组实现的二叉堆，对于数组中任意位置的n上元素，其左孩子在[2n+1]位置上，右孩子[2(n+1)]位置，它的父亲则在[n-1/2]上，而根的位置则是[0]。
	PriorityQueue中构造方法、添加元素方法、和删除元素方法都需要维护二叉堆的相对顺序，进行heapify、上浮或者下移。
### 五毒刷题法使用一周后的心得
* 在了解五毒刷题法之前自己一直都是死磕的方式去刷题，一道题目总是需要看很久想很久之后才开始写，使用了五毒方法一周后，刷题速度明显快了不少，当然也有一些中等的题目因为有些解题方法确实比较难以理解，耗费了不少时间，比如环形链表2的数学解法、求柱状图中的最大矩形中使用的单调栈法，但是耐心看完理解后也会对自己有很大的提高，相比自己死磕去想解题思路，五毒法的优势是能有更快的速度去理解这道题目的优秀解法。
* 自己使用五毒刷题法现在的节奏大概是：
* 第一遍：
  除非是做过的已经掌握乐的题目，或者是很简单的马上能写出不错的解法的题目，否则不急着coding，想一下这道题目可能要考查的算法和数据结构大概是什么，然后打开题解，找到点赞数更多的、或者是思路描述清晰、代码风格简洁精炼的题解，然后详细阅读其中一种比较精简容易理解的解题方法，理解、默记，然后回头把刚才看到的代码大致写出来。
* 第二遍：
这时候对这道题目已经有基本的思路和理解了，这时候再看一下有没有其他优秀的题解方法，多找1-3种解题方法并一一默记、coding一遍，理解多种解题方法。
* 第三遍至第N遍
第一天刷过两遍后，第二天及第二周、面试前一定要各再刷一遍，但是不是说总次数就刷这五遍，而是平时有空闲时间的时候便需要把这些高频考题找出来再多提交几遍。可以写成脑图、或者截图记录下来在通勤时间多过几遍。这一周我其实这点做得不够好，课程的实战题目、作业题目虽然基本都刷了两遍以上，但是没有全部都做好归纳总结，最好是画脑图，或者是把题解收集起来截成图片，或者写进笔记，方便通勤或者其他零散的时间把这些解法快速多过几遍。

