# 第三周总结
* 1.递归、回溯、动态规划、贪心的归纳
* 2.第三周学习进度


## 1.递归、回溯、分治、贪心的归纳
对递归已经比较熟悉了，这周通过几道题目对回溯也更理解了些，但是对分治、贪心还是掌握得不是很好，概念还比较模糊，在此通过题解区和blog的帖子，自己归纳总结区分一下。
###递归 Recursion

通过函数体来进行的循环，一种编程技巧。倒着思考，看到问题的尽头。思路简单但效率低（建立函数的副本，消耗大量时间和内存）。递归是分治和动态规划的基础，而贪心是动态规划中的一种特殊情况（局部最优也是全局最优）。

终止条件（最简子问题的答案） + 自身调用（解决子问题），不要试图去搞清楚函数内部如何实现的，就先认为它可以实现这个功能。



	比如，遍历一颗树
	def traverse(root):
		if root is None:
			return
		for child in root.children:
			traverse(child)

	计算n阶乘，递归实现。


	def Factorial(n):
		if n <= 1:   # 终止条件
			return 1
		return n*Factorial(n-1)

#### 递归的代码模板：
	def recursion(level, param1, param2, ...):
    # recursion terminator
    if level > MAX_LEVEL:
        print_result
        return
     
    # process logic in current level
    process_data(level, data, ...)
     
    # drill down
    recursion(level + 1, p1, ...)
 
    # reverse the current level status if needed
    reverse_state(level)


有些情况下递归处理问题是高效的，比如归并排序。但有些情况下，非常低效。比如斐波那契数列，显然递推是简单快速的，但如果非要递归但话也可以，低效。

Fibonacci数列，函数调用自身，注意递归的停止条件。分为调用和回溯两个阶段。

但是过程中存在大量重复计算，递归效率并不高。（因为存在重复的子问题，可以用判重或记录结果）

*  比较经典的递归题目有汉诺塔问题、爬楼梯问题（斐波那契）

###回溯 backtrack
回溯算法可以抽象理解为一个N叉树的遍历，比如斐波那契数列可以理解成一个二叉树，而零钱兑换的例子就是一个N叉树。
	# 二叉树遍历
	def traverse(root):
    if root is None:
        return
    # 前序代码在这
    traverse(root.left)
    # 中序代码在这
    traverse(root.right)
    # 后序代码在这
 
	# N叉树遍历
	def traverse(root):
    if root is None:
        return
    for child in root.childen:
        # 前序代码在这
        traverse(child)
        # 后序代码在这

####回溯的代码模板：
	def backtrack(choiceList, track, answer):
    """choiceList, 当前可以进行的选择列表
        track, 决策路径，即已经作出的一系列选择
        answer, 储存符合条件的决策路径
    """
    if track is OK:
        answer.add(track)
    else:
        for choice in choiceList:
            # choose: 选择一个choice 加入track
            backtrack(choices, track, answer)
            # unchoose: 从track中撤销上面的选择

知道的比较经典的回溯题目有这周课上刚看的组合、全排列和全排列2、n皇后、子集

###分治 Divde & Conquer
将问题分成几个小模块，逐一解决。典型的递归结构。分治可以高效率解决的，是没有中间结果（没有所谓的重复计算）的问题。　（适合的解决方法：动态规划、子问题记忆）
典型的分治思想，归并排序。将数组分解最小之后，把n个记录看成是n个有序的子序列，每个子序列长度为1。然后两两归并，得到ceil(n/2)个长度为2或者1的有序子序列，再两两归并...，如此重复直到得到长度为n的有序序列为止。

用递归实现的话就很简洁，直接左右两边递归的归并排序，再merge左右两边就行了。
	def merge_sort(alist):
    if len(alist) <= 1:
        return alist
    # 二分分解
    num = len(alist)//2
    left = merge_sort(alist[:num])
    right = merge_sort(alist[num:])
    # 合并
    return merge(left,right)

剩下的细节无非就是写一下如何合并两个有序数组，双指针同时向后扫，小的就放进结果指针后移，大的就指针不动。
	def merge(left, right):
    '''合并操作，将两个有序数组left[]和right[]合并成一个大的有序数组'''
    #left与right的下标指针
    l, r = 0, 0
    result = []
    while l<len(left) and r<len(right):
        if left[l] < right[r]:
            result.append(left[l])
            l += 1
        else:
            result.append(right[r])
            r += 1
  
    if l < len(left):
        result += left[l:]
    elif r < len(right):
        result += right[r:]
    return result


####分治的代码模板：
	def divide_conquer(problem, param1, param2, ...):
    # recursion terminator
    if problem is None:
        print_result
        return
     
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
     
    # conquer subproblems
    subresult1 = divide_conquer(subproblems[0], p1, ...)
    subresult2 = divide_conquer(subproblems[1], p1, ...)
    ...
     
    # process and generate the final result
    result = process_result(subresult1, subresult2, ...)

###贪心 Greedy
对问题求解的时候，总是做出在当前看来最优的选择。但处处做贪心，总体未必是最优的。

适用贪心的场景：问题能够分解成子问题来解决，子问题的最优解能够递推到最终问题的最优解。这种子问题最优解称为最优子结构。

贪心和动态规划的区别在于，它对每个子问题的解决方案都做出选择，不能回退。而动态规划会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。贪心可以看作是动态规划的一个特例。

个人感觉贪心的应用范围较小，知道的比较经典的贪心问题有买卖股票的最佳时机和Interval Scheduling（区间调度问题）

##2.第三周自己的学习进度
第二周课程+作业+每日一题的题目还有几道没能做到三刷，第三周因为感冒的缘故加上加班，分治和贪心的课程题还赶在第三周结束前刷完，到第四周的周三才刷完，感觉现在的题目难度慢慢加大，题量越来越多，前面的题目感觉还没完全记住随时会忘的状态，后续又来了很多题目，现在一周的量可能比之前自己一个月看的量都多，有点压力山大，但是希望自己能坚持，有点信心，刷下去总会有收获。