class Solution {
    public int myAtoi(String s) {
        Automaton auto = new Automaton();
        int length = s.length();
        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            if(c==' ')  auto.state = auto.table.get(auto.state)[0];
            else if(c=='+'||c=='-') auto.state = auto.table.get(auto.state)[1];
            else if(Character.isDigit(c)) auto.state = auto.table.get(auto.state)[2];
            else auto.state = auto.table.get(auto.state)[3];
            if("number".equals(auto.state)) {
                auto.ans = auto.ans*10 +(c -'0');
                auto.ans = auto.sign == 1 ? Math.min(auto.ans, (long) Integer.MAX_VALUE) : Math.min(auto.ans, -(long)Integer.MIN_VALUE);
            }
            else if ("signed".equals(auto.state))  auto.sign = c == '+' ? 1 : -1;
        }
        return (int) (auto.sign*auto.ans);
        
    }
}

class Automaton{
    public int sign=1;
    public long ans = 0;
    public String state = "none";
    public Map<String, String[]> table = new HashMap<String, String[]>();

    public Automaton() {
        table.put("none", new String[]{"none", "signed", "number", "end"});
        table.put("signed", new String[]{"end", "end", "number", "end"});
        table.put("number", new String[]{"end", "end", "number", "end"});
        table.put("end", new String[]{"end", "end", "end", "end"});
    }

}

