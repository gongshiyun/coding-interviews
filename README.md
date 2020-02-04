# 剑指offer编程题练习

[TOC]

## 前言

本文记录本人剑指offer编程题的解题思路，题目从牛客网获取，地址https://www.nowcoder.com/ta/coding-interviews?page=1



## 1.二维数组中的查找

在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
该题在一个横竖都是递增有序的长度相等的二维数组中找到一个数。可以直接遍历所有得出答案，但那就太low太暴力了。

**解题思路：**

我们可以参考二分查找的思想，从中间值开始查找目标数。那么二维数组的中间值在哪里？已知二维数组是从左到右，从上到下都是递增的，所以我们可以从左下角或右上角开始查找。以从左下角的数n开始查找为例，左边的数大，上面的数小。n与目标数比较时，如果目标数大于n，则右移；如果目标数小于n，则上移；如果相等返回true。移动后，继续同样的逻辑，直到下标达到临界值。

**JAVA代码：**

```java
public boolean Find(int target, int[][] array) {
    int rowCount = array.length;
    int colCount = array[0].length;

    for (int i = rowCount - 1, j = 0; i >= 0 && j < colCount;) {
        if (array[i][j] == target) {
            return true;
        }
        if (array[i][j] < target) {
            j++;
            continue;
        }
        if (array[i][j] > target) {
            i--;
        }
    }
    return false;
}
```



## 2.替换空格

请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

**解题思路：**

这题没有什么好说的，遍历字符串，如果是空字符，将其替换为20%即可，要注意下标的变化，替换为20%后下标要+3再开始下一次的判断。

**JAVA代码：**

```java
public String replaceString(StringBuffer str) {
    if (str == null) {
        throw new NullPointerException();
    }
  
    int i = 0;
    while (i < str.length()) {
        if (str.charAt(i) == ' ') {
            str.replace(i, i + 1, "%20");
            i += 3;
        } else {
            i++;
        }
    }
    return str.toString();
}
```



## 3.从尾到头打印链表

输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

**解题思路：**

一看题目，会想到可以直接从尾部遍历链表吗？题目给出的链表当然是不可以的，只能从头遍历了。由于结果要逆序放在一个数组里，遍历的时候是顺序的，可以使用stack栈这个数据结构来存储遍历出来的数，最后再放入到数组中去。

**JAVA代码：**

```java
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        
        ArrayList<Integer> result = new ArrayList<>(stack.size());
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
```



## 4.重建二叉树

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

**解题思路：**

说实话，看了题目我也有点懵，啥是前序遍历和中序遍历？好像还有个叫后序遍历吧，都已经忘了，那就重新捡起来吧！

![img](README.assets/20180507105447745.png)

**前序遍历：**

对于当前节点，先输出该节点，然后输出他的左孩子，最后输出他的右孩子。对应顺序为ABC

**中序遍历：**

对于当前结点，先输出它的左孩子，然后输出该结点，最后输出它的右孩子。对应顺序为BAC

**后序遍历：**

对于当前结点，先输出它的左孩子，然后输出它的右孩子，最后输出该结点。对应顺序为BCA

了解到这三种遍历方法后，可以知道，前序遍历的第一个数，一定是根结点，中序遍历从开始到根结点数的范围，是二叉树根节点的左子树。

如题目所述的前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，根节点是1，从中序遍历序列知道，{4，7，2}是左子树的中序遍历序列，{5，3，8，6}是右子树的中序遍历序列。再从前序遍历序列中知道，{2，4，7}是左子树的前序遍历序列，{3，5，6，8}是右子树的前序遍历序列

对于左子树：2是根节点，{4，7}是左子树的中序遍历序列，{4，7}是左子树的前序遍历序列。通过前序遍历序列得知4是左子树根结点，由中序遍历序列{4，7}可知，7是右子树的前序遍历序列。

按照这套逻辑，最后得出树如下：

![image-20200129145735077](README.assets/image-20200129145735077.png)

总结一下，递归重建二叉树的逻辑：

1.通过前序遍历序列的第一位开始遍历，是树的根节点

2.在中序遍历序列中，找到该根结点数，左右两边的序列就是左子树和右子树的中序遍历序列，得出左子树节点数量A和右子树的节点数量B

3.回到前序遍历序列，找到左子树的前序遍历序列和右子树的前序遍历序列，从第一位开始，后面的A位就是左子树的前序遍历序列，再后面的B位就是右子树的前序遍历序列

4.对于左子树和右子树，各自重新从第一步开始重建二叉树

**JAVA代码：**

```java
public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
    return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
}


/**
 * 递归重建二叉树
 *
 * @param pre     前序遍历序列
 * @param in      中序遍历序列
 * @param preLow  前序遍历序列低位下标
 * @param preHigh 前序遍历序列高位下标
 * @param inLow   后序遍历序列低位下标
 * @param inHigh  后序遍历序列高位下标
 * @return
 */
public TreeNode reConstructBinaryTree(int[] pre, int[] in, int preLow, int preHigh, int inLow, int inHigh) {
    if (preHigh < preLow || inHigh < inLow) {
        return null;
    }

    // 前序遍历的第一个数是根结点
    int rootVal = pre[preLow];
    TreeNode root = new TreeNode(rootVal);
    for (int i = inLow; i <= inHigh; i++) {
        if (in[i] == rootVal) {
            // 计算左子树的节点数量
            int leftTreeNodeNum = i - inLow;
            // 左子树前序遍历序列和右子树前序遍历序列的分割点下标
            int preMid = preLow + leftTreeNodeNum;
            root.left = reConstructBinaryTree(pre, in, preLow + 1, preMid, inLow, i);
            root.right = reConstructBinaryTree(pre, in, preMid + 1, preHigh, i + 1, inHigh);
        }
    }
    return root;
}
```



## 5.用两个栈实现队列

用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

**解题思路：**

队列的特点是先进先出，push是从尾部加入，pop是从头部出来。而栈是后进先出，与队列不一样。如果使用两个栈来实现队列的话，首先是push方法，直接使用栈的push就可以，主要是pop方法，需要将栈底部的元素拿出来，才能满足队列的要求，所以这里只能使用另一个栈来接收栈pop出来的元素，最后在最顶部的就是队列的头部元素。

**JAVA代码：**

```java
public class Solution {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
```



## 6.旋转数组的最小数字

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

**解题思路：**

直接遍历数组，相邻的两个数，如果下一位比上一位小，那么下一位就是最小元素。

```java
public static int minNumberInRotateArray(int [] array) {
    for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
            return array[i + 1];
        }
    }
    return array[0];
}
```

还有二分查找法，这里略过。



## 7.斐波那契数列

大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。

n<=39

**解题思路：**

先了解啥是斐波那契数列：

斐波那契数列（Fibonacci sequence），又称[黄金分割](https://baike.baidu.com/item/黄金分割/115896)数列、因[数学家](https://baike.baidu.com/item/数学家/1210991)列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“[兔子数列](https://baike.baidu.com/item/兔子数列/6849441)”，指的是这样一个数列：1、1、2、3、5、8、13、21、34、……在数学上，斐波那契数列以如下被以[递推](https://baike.baidu.com/item/递推/1740695)的方法定义：*F*(1)=1，*F*(2)=1, *F*(n)=*F*(n - 1)+*F*(n - 2)（*n* ≥ 3，*n* ∈ N*）在现代物理、准[晶体结构](https://baike.baidu.com/item/晶体结构/10401467)、化学等领域，斐波纳契数列都有直接的应用，为此，美国数学会从 1963 年起出版了以《斐波纳契数列季刊》为名的一份数学杂志，用于专门刊载这方面的研究成果。——参考自百度百科

在这道题目中，n从0开始，区分0，1，和n>1的情况，当n>1时，*F*(n)=*F*(n - 1)+*F*(n - 2)

**JAVA代码：**

```java
public int Fibonacci(int n) {
    if (n == 0) {
        return 0;
    }
    if (n == 1) {
        return 1;
    }
    return Fibonacci(n - 1) + Fibonacci(n - 2);
}
```



## 8. 跳台阶

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

**解题思路：**

先列出来各种情况：

1级：1种 1

2级：2种 11 2

3级：3种 111 12 21

4级：5种 1111 112 211 121 22

5级：8种 11111 1112 122 212 2111 221 1211 1121

发现一个规律，大于2级台阶，f(n) = f(n-1)+f(n-2)，是一个斐波那契数列

可以这样思考：一次只能跳一级或者两级，那么只需考虑前一级台阶再跳一级，或者前两级台阶再跳两级的种数的和。实现参考斐波那契数列的计算。

**JAVA代码：**

```java
public int JumpFloor(int target) {
    if (target <= 0) {
        throw new IllegalArgumentException();
    }
    if (target == 1) {
        return 1;
    }
    if (target == 2) {
        return 2;
    }
    return JumpFloor(target - 1) + JumpFloor(target - 2);
}
```



## 9.变态跳台阶

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

**解题思路：**

参考第八题跳台阶，一次只能跳一级或者两级，第n级 *F*(n)=*F*(n - 1)+*F*(n - 2)。这题变成不限制一次跳多少级，那么第n级的跳法应该是前面所有级的跳法之和+1，1是直接跳n级，公式如下：

*F*(n)=*F*(n - 1)+*F*(n - 2) + ... + F(1) + 1,  n >=3

那么*F*(n) = 2*F*(n - 1) = 2^(n-1),  n >=3

列举：

1级，1种

2级，2种

3级，111，12，21，3 4种

4级，1111，112，121，211，22，31，13，4 8种

5级。。。

符合该公式

**JAVA代码：**

```java
public int JumpFloorII(int target) {
    if (target <= 0) {
      throw new IllegalArgumentException();
    }
    if (target == 1) {
      return 1;
    }
    if (target == 2) {
      return 2;
    }
    return 2 * JumpFloorII(target - 1);
}
```

还有更牛逼的方法：

```java
public int JumpFloorII(int target) {
    if (target <= 0) {
        throw new IllegalArgumentException();
    }
    return 1 << (target - 1);
}
```



## 10.矩形覆盖

我们可以用2\*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2\*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

**解题思路：**

n=1, 1

n=2, 2

n=3, 3

n=4, 5

n=5, 8

是一个斐波那契数列

**JAVA代码：**

```java
public int RectCover(int target) {
    if (target < 1) {
        return 0;
    }
    if (target == 1) {
        return 1;
    }
    if (target == 2) {
        return 2;
    }
    return RectCover(target - 1) + RectCover(target - 2);
}
```



## 11.二进制中1的个数

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

### 什么是补码

计算机中的有符号数有三种表示方法，即[原码](https://baike.baidu.com/item/原码/1097586)、[反码](https://baike.baidu.com/item/反码/769985)和补码。三种表示方法均有符号位和数值位两部分，符号位都是用0表示“正”，用1表示“负”，而数值位，三种表示方法各不相同。在[计算机](https://baike.baidu.com/item/计算机/140338)系统中，数值一律用补码来表示和存储。原因在于，使用补码，可以将符号位和数值域统一处理；同时，加法和减法也可以统一处理。

原码求补码：

- 正整数的补码是其二进制表示，与[原码](https://baike.baidu.com/item/原码)相同

- 求负整数的补码，将其原码除符号位外的所有位取反（0变1，1变0，符号位为1不变）后加1

- 数0的补码表示是**唯一**的

  [+0]补=[+0]反=[+0]原=00000000

  [ -0]补=11111111+1=00000000



补码求原码：

已知一个数的补码，求原码的操作其实就是对该补码再求补码 [3] ：

⑴如果补码的符号位为“0”，表示是一个[正数](https://baike.baidu.com/item/正数/1294288)，其原码就是补码。

⑵如果补码的符号位为“1”，表示是一个[负数](https://baike.baidu.com/item/负数/1294977)，那么求给定的这个补码的补码就是要求的原码。

例：已知一个补码为11111001，则原码是10000111（-7）。

因为符号位为“1”，表示是一个负数，所以该位不变，仍为“1”。

其余七位1111001取反后为0000110；再加1，所以是10000111。



**常识1：在计算机系统中，数值一律用补码来表示和存储。**

**常识2：正数的原码、反码、补码都是其本身。**

也就是说，根本就不需要考虑数的符号问题。



**解题思路：**

将整数与1做与操作后，如果等于1说明最低位为1，然后对整数进行无符号右移，继续上述操作，直到整数为0结束。

**JAVA代码：**

```java
public int NumberOf1(int n) {
    int count = 0;
    while (n != 0) {
        if ((n & 1) == 1) {
            count++;
        }
        n >>>= 1;
    }
    return count;
}
```



## 12.数值的整数次方

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

保证base和exponent不同时为0

**解题思路：**

直接用Math.power方法就解决了。当然这样就太简单了，还是不要调API比较好。这题可以从减少乘的次数的思想出发，使用递归处理

JAVA代码：

```java
public double Power(double base, int exponent) {
    if (base == 0 && exponent == 0) {
    		throw new RuntimeException();
    }
    if (base == 0) {
    		return 0;
    }
    if (exponent == 0) {
    		return 1;
    }
    if (exponent == 1) {
    		return base;
    }
    if (exponent == -1) {
    		return 1 / base;
    }
    return Power(base, exponent / 2) * Power(base, exponent / 2)
    		* Power(base, exponent % 2);
}
```



## 13.调整数组顺序使奇数位于偶数前面

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

**解题思路：**

复制一个相同数组，遍历数组，将奇数统一放在前面，偶数放在后面即可

**JAVA代码：**

```java
public static void reOrderArray(int [] array) {
        int[] result = new int[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        int index = 0;
        for (int i : result) {
            if ((i & 1) == 1) {
                array[index++] = i;
            }
        }
        for (int i : result) {
            if ((i & 1) == 0) {
                array[index++] = i;
            }
        }
}
```



## 14.链表中倒数第k个结点

输入一个链表，输出该链表中倒数第k个结点。

**解题思路：**

使用两个指针遍历链表，第二个指针在第一个指针遍历了k-1个结点后开始遍历，当第一个指针到达尾部时，第二个指针所在位置就是倒数第k个结点。

**JAVA代码：**

```java
public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        int i = 0;
        for (; p1 != null; i++) {
            if (i >= k) {
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return i < k ? null : p2;
}
```



## 15.反转链表

输入一个链表，反转链表后，输出新链表的表头。

**解题思路：**

遍历链表，将链表前后结点的下一位改为前一位

**JAVA代码：**

```java
public ListNode ReverseList(ListNode head) {
    if (head == null) {
        return null;
    }

    ListNode p = head;
    ListNode temp;
    ListNode before = null;
    while (true) {
        temp = p.next;
        p.next = before;
        before = p;
        if (temp == null) {
            break;
        }
        p = temp;
    }
    return p;
}
```



## 16. 合并两个排序的链表

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

**解题思路：**

新建一个链表，然后遍历两个链表的结点，比较哪个链表的结点小就放入新链表中。

**JAVA代码：**

```java
public ListNode Merge(ListNode list1,ListNode list2) {
    ListNode head = new ListNode(0);
    ListNode p = head;
    // 比较两个链表的结点大小
    while (list1 != null && list2 != null) {
        if (list1.val > list2.val) {
            p.next = new ListNode(list2.val);
            list2 = list2.next;
        } else {
            p.next = new ListNode(list1.val);
            list1 = list1.next;
        }
        p = p.next;
    }
    // 遍历完其中一个链表后，直接将没遍历完的链表的结点顺序放入新链表中
    while (list1 != null) {
        p.next = new ListNode(list1.val);
        p = p.next;
        list1 = list1.next;
    }
    while (list2 != null) {
        p.next = new ListNode(list2.val);
        p = p.next;
        list2 = list2.next;
    }
    return head.next;
}
```



