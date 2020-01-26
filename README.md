# 剑指offer编程题练习
记录本人剑指offer编程题的解题思路



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

