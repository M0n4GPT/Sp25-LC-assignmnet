class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = singleSpaces(s);
        reverse(sb,0,sb.length()-1);
        reverseWord(sb);
        return sb.toString();
    }

    public StringBuilder singleSpaces(String s){
        int left=0,right=s.length()-1;
        while(left<=right && s.charAt(left)==' '){
            left++;
        }
        while(left<=right&&s.charAt(right)==' '){
            right--;
        }
        StringBuilder sb= new StringBuilder();
        while(left<=right){
            char c = s.charAt(left);
            if(c!=' '){
                sb.append(c);
            }
            else if (sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right){
        while(left<right){
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    public void reverseWord(StringBuilder sb){
        int n=sb.length();
        int start=0,end=0;

        while(start<n){
            while(end<n&&sb.charAt(end)!=' '){
                end++;
            }
            reverse(sb,start,end-1);
            start = end+1;
            end++;
        }
    }
}
