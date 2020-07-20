package com.sohu.yifanshi.test.binaryadd;

public class BinaryAdd67 {
    public static void main(String[] args) {
        BinaryAdd67 binaryAdd67 = new BinaryAdd67();
        System.out.println(binaryAdd67.addBinary("1010","1011"));
    }
    public String addBinary(String a, String b) {
        Double x = new Double(0),y = new Double(0);
        for(int i = 0 ; i < a.length() ; i++)
        {
            if(a.charAt(a.length()-1-i)=='1')
            {
                x+=Math.pow(2,i);
            }
        }
        for(int i = 0 ; i < b.length() ; i++)
        {
            if(b.charAt(b.length()-1-i)=='1')
            {
                y+=Math.pow(2,i);
            }
        }
        x+=y;
        return tentobinary(x);
    }

    public String tentobinary(Double x)
    {
        StringBuilder result = new StringBuilder();
        while (x>1){
            if(x%2==1)
                result.append("1");
            else
                result.append("0");
        }
        if(x==1)
            result.append("1");
        else
            result.append("0");
        return result.reverse().toString();

    }

}
