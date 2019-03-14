public class Main {
    private static String[] mapRoman = {"I", "V", "X", "L", "C", "D", "M"};
    private static int[] mapInt = {1, 5, 10, 50, 100, 500, 1000};

    public static void main(String[] args) {
        System.out.println(romanToIntSub("IXC", 0, 1));
        System.out.println(romanToInt("IXC"));
    }

    private static int romanToIntSub(String input, int sum, int sign) {
        if (input.equals("")) return sum;
        int[] vn = findMax(input);
        if (vn[0] == -1) {
            System.err.println("Invalid input!");
            sum = -1;
            return -1;
        }
        if (vn[0] == 0)
           return sum + sign * vn[1];
        sum += sign * vn[1] * mapInt[vn[0]];
        String[] temp = (input + " ").split(mapRoman[vn[0]]);
        sum = romanToIntSub(temp[temp.length - 1].trim(), sum, sign);
        for (int i = 0; i < temp.length - 1; i++) {
           sum = romanToIntSub(temp[i].trim(), sum, sign * -1);
        }
        return sum;
    }

    private static int[] findMax(String input) {
        int[] result = {-1,0};
        int[] temp = new int[7];
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'I':
                    temp[0]++;
                    break;
                case 'V':
                    temp[1]++;
                    break;
                case 'X':
                    temp[2]++;
                    break;
                case 'L':
                    temp[3]++;
                    break;
                case 'C':
                    temp[4]++;
                    break;
                case 'D':
                    temp[5]++;
                    break;
                case 'M':
                    temp[6]++;
            }
        }
        for (int i = 6; i >= 0; i--) {
            if (temp[i] > 0) {
                result[0] = i;
                result[1] = temp[i];
                break;
            }
        }
        return result;
    }


    // below is other people's solution, which I think is wrong in certain cases.
    static int[] temp2 = new int[91];
    static{
        temp2['I'] = 1;
        temp2['V'] = 5;
        temp2['X'] = 10;
        temp2['L'] = 50;
        temp2['C'] = 100;
        temp2['D'] = 500;
        temp2['M'] = 1000;
    }
    public static int romanToInt(String s) {
        int res = 0, max = 0;
        for(int i = s.length()-1;i>=0;i--){
            int t = temp2[s.charAt(i)];
            if(t>=max){
                max = t;
                res += t;
            }else{
                res -= t;
            }
        }
        return res;
    }
}
