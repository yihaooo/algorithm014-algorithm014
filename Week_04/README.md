# 第四周总结

* 深度搜索，广度搜索
* 二分查找（难点，边界条件很容易出错）



### DFS BFS
	深度优先搜索递归模版

	def dfs(node):
		# already visted
		if node in visited:
			return
		visited.add(node)
		# process current node
		# ... logic here
		dfs(node.left)
		dfs(node.right)
	非递归模版(手动模拟栈)

	def DFS(self, tree):
		if tree.root is None:
			return []

		visited, stack = [], [tree.root]
		while stack:
			node = stack.pop()
			visited.add(node)

			process(node)
			nodes = generate_related_nodes(node)
			stack.push(nodes)
		# other processing work
	如果有大于两个子节点

	visited = set()
	def DFS(node, visited):
		if node in visited: # terminator
			#alredy visited
			return
		visited.add(node)
		#process current node here
		...
		for next_node in node.children():
			if next_node not in visited:
				DFS(next_node, visited)
	广度优先搜索模版(队列)

	def BFS(graph, start, end):
		queue = []
		queue.append([start])
		visted.add(start)

		while queue:
			node = queue.pop()
			visted.add(node)

			process(node)
			nodes = generate_related_nodes(node)
			queue.push(nodes)
		#other processing work
		...
		
#### ps.如果是对图的bfs记得记录已访问的节点

###  二分查找
各种变种题太多太繁杂，自己背着模版写题,看题解看着看着就乱了，特别是什么情况写 while (start<end) 什么情况写 while(start<=end)，这里看到一篇题解还不错：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/     还没完全理解透彻，先mark


