# 第六周总结
第六周和第七周的课开始觉得很吃力了，之前的每周都是课堂加作业题全部过两遍甚至还有余力刷第三遍，到dp这周基本每道题要吃透都相比之前的更花时间，只能先把课程的题目先理解，作业的题先做一部分，感觉自己快要out了。。
大概整理下这周的思考

###dp与递归的区别
* 递归，借助函数调用自己实现，属于自顶向下的思路，不会记忆解，需要缓存记忆化去除重复的计算
* dp 利用迭代将结果存在数组里，从数组0位开始顺序往后计算.相比于 递归，不太好理解，边界情况比较难，dp状态公式推导如果不是看题解说实话很少有题目自己能推出来，可能还是需要多练习。
* 递归是穷举所有选择，根据选择更新状态；dp 是穷举所有状态，根据状态做选择。
* 带备忘录优化的递归，和 dp 是等价的。递归是归纳法，自顶向下；dp 是演绎法，自底向上（当然dp 也可以自顶向下）。

### dp题目大概思路：
 方法论：1）明确状态；2）穷举所有状态；3）根据选择更新状态，完成状态转移框架（即递归公式）。

