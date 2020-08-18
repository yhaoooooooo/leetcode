package leetcode.editor.cn;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 403 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public String multiply(String num1, String num2) {
        int upNum = 0;

        byte[] num1Bytes = num1.getBytes();
        byte[] num2Bytes = num2.getBytes();

        String result = "0";

        for (int p1 = 0, num1Position = num1Bytes.length - 1; num1Position >= 0; num1Position--, p1++) {
            int num1N = num1Bytes[num1Position] - 48;
            for (int p2 = 0, num2Position = num2Bytes.length - 1; num2Position >= 0; num2Position--, p2++) {
                int num2N = num2Bytes[num2Position] - 48;

                int r = num1N * num2N;
                result = plus(result, r, p2);
            }
        }

        return null;
    }

    private String plus(String result, int r,int p2) {
        String zeros = "";
        for (int i = 0; i < p2; i++) {
            zeros = zeros + "0";
        }
        String tmp = r+""+zeros;
        return "0";
    }

    private String plus(String r, String tmp) {

        byte[] num1Bytes = r.getBytes();
        byte[] num2Bytes = tmp.getBytes();

        String result = "0";

        int i = num1Bytes.length - 1;
        int j = num2Bytes.length - 1;

        int up = 0;
        while (i >= 0 && j >= 0) {
            int tmp1 = num1Bytes[i] - 48;
            int tmp2 = num2Bytes[j] - 48;

            int sum = tmp1 + tmp2;
            if (sum >= 10) {
                result = "1" + "";
            }

        }

        return "0";
    }
    public static void main(String[] args) {
        System.out.println("12".getBytes()[0]);
        System.out.println("10".getBytes()[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
