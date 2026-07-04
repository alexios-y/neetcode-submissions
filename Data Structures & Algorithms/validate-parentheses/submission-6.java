class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        char[] ch=s.toCharArray();
        for(char c : ch){
            if(c=='('||c=='{'||c=='[')
                st.push(c);
            else{
                if(!st.isEmpty()){
                char top=st.peek();
                if(top=='(' && c==')' || top=='{' && c=='}' || top=='[' && c==']'){
                    st.pop();
                }else
                    return false;

                } else return false;
            }
        }

        return st.isEmpty();
    }
}
