//coding:
public List<Integer> flatten(List<Object> list) {
  List<Integer> res = new ArrayList<>();
  //if there is maximum two levels, then we don't even need recursion, but if we can't determine how many levels of the given list,
  //then
  Deque<Iterator> deque = new ArrayDeque<Iterator>();
  deque.add(list.iterator());

  while (!deque.isEmpty()) {
    Iterator it = deque.pop();

    while(it.hasNext()) {
      Object obj = it.next();
      if (obj instanceOf Iterable) { //if it is a list
        deque.push(it);
        it = ((Iterable) obj).iterator();

      } else if (obj instanceOf Integer) {
        res.add((Integer) obj);
      }
    }
  }
  return res;

}


//given s string, add * in between different chars, use recursion
private final static String res = "";
public static String addStar(String str) {

  if (str == null || str.size() == 0) {
    return "";
  } else if (str.size() < 2) {
    return "" + str.get(0);
  }

  return addStar(str, 0);

}

private static String addStar(String str, int index) {
  res = res + str.charAt(index);

  if (index == str.length() - 1) {
    return;
  }
  if (str.charAt(index) != str.char(index + 1)) {
    res = res + "*";
  }

  return addStar(str, idnex + 1);
}

//first unique character in a string
//we have to iterate this string as least once
//so we can iterate this string and find out the last index of each char, if there exist, then update it's index
//hashmap is suitable.
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        HashMap<Character, Boolean> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), false);
            } else {
                map.put(s.charAt(i), true);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))) { //if it is true, means this is the only one in whole string
                return i;
            }
        }
        return -1;
    }
}

//merge two sorted array into another sorted:
public int[] merge(int[] l1, int[] l2) {
  int m = l1.length;
  int n = l2.length;
  int[] res = new int[m+n];

  int i = 0;
  int j = 0;
  int k = 0;
  while (i < m || j < n) {
    if (i == m && j == n) {
      return res;
    } else if (i == m) {
      while (j < n) {
        res[k++] = l2[j++];
      }
    } else if (j == n) {
      while (i < m) {
        res[k++] = l2[i++];
      }
    }
    if (l1[i] == l2[j]) {
      res[k++] = l1[i];
      res[k++] = l2[j];
      i++;
      j++;
    } else if (l1[i] > l2[j]) {
      res[k++] = l2[j++];
    } else {
      res[k++] = l1[i++];
    }
  }
  return res;
}

public String aggre(String str) {
  if (str.length() == 0) return "";

  String res = "";
  int i = 0;
  while (i < str.length()) {
    int count = 1;
    String s = str.substring(i, i + 1);
    while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
      i++;
      count++;
    }
    res += s + String.valueOf(count);
  }
  return res;
}

//write a code to move all the negative numbers before all positive numbers in an Array.
The order of the numbers in a array must be same.
eg. input is [5,2,7,-4,3,-8,-10] output: [-4,-8,-10,5,2,7,3];
static void rearrange(int arr[], int n)
	{
		int j = 0, temp;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				if (i != j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
	}

  coding. given two strings consist of numbers, plus those two strings and get the new strings.
  eg: "123445", " 234455", output: "357900"  , string is enough big, so do not use string.valueof.
  public class Solution {
      public String addStrings(String num1, String num2) {
          StringBuilder sb = new StringBuilder();
          int carry = 0;
          for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
              int x = i < 0 ? 0 : num1.charAt(i) - '0';
              int y = j < 0 ? 0 : num2.charAt(j) - '0';
              sb.append((x + y + carry) % 10);
              carry = (x + y + carry) / 10;
          }
          return sb.reverse().toString();
      }
  }

  private static void bubbleSort(int[] nums){
          for (int i = 0; i < nums.length-1; i++) { //i控制每次的边界条件，i层数为length-1
              for (int j = nums.length-1; j > i; j--) { //j与j-1构成了指针,j每次都从nums.length-1开始，比如有五个元素的数组，每次都是先[4]和[3]比较
                  if (nums[j] < nums[j-1]){ //if value in j is smaller than value in j-1, then we swap them
                      int temp = nums[j];
                      nums[j] = nums[j-1];
                      nums[j-1] = temp; //从后往前遍历，每次j的结束条件是到达I边界，因为每一次都是最前面的被排好
                  }
              }
          }
      }
  static int removeDuplicates(int arr[], int n)
	{
		if (n==0 || n==1)
			return n;
		int[] temp = new int[n];
		int j = 0;
		for (int i=0; i<n-1; i++)
			if (arr[i] != arr[i+1])
				temp[j++] = arr[i];
		temp[j++] = arr[n-1];

		// Modify original array
		for (int i=0; i<j; i++)
			arr[i] = temp[i];

		return j;
	}


 //一上来进行自我介绍，然后写一道easy的题。如下：给定一组字符串 e.g. ["a", "abc", "a", "b"]，找出出现次数最大的字符串list，
 //结果为["a"]，因为频率为2，其他字符串出现1次。
