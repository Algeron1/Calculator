

class Result {
    static int getResult(String formula, int a, int b){
        int result=0;
       if(formula.contains("+")){
           result=a+b;
       }
       else if(formula.contains("-")){
           result=a-b;
       }
       else if(formula.contains("*")){
           result=a*b;
       }
       else if(formula.contains("/")){
           result=a/b;
       }
       return result;
    }
}
