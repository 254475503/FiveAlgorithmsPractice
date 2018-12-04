package com.sohu.yifanshi.dynamicAlgorithms.package0_1question;

import java.util.ArrayList;
import java.util.List;

public class DiguiTest {
    public  static final int Bagweight = 150;
    public static void main(String[] args) {
        ArrayList<Items> itemsArrayList = new ArrayList<Items>();
        String[] names = new String[]{"A","B","C","D","E","F","G"};
        int[] weights = new int[]{10,40,30,50,35,40,30};
        int[] values = new int[]{35,30,6,50,40,10,25};
        for(int i = 0 ;i<weights.length;i++)
        {
            itemsArrayList.add(new Items(names[i],weights[i],values[i]));
        }
        long currenTime = System.currentTimeMillis();
        int result = maxValue(itemsArrayList,Bagweight);
        long endTime = System.currentTimeMillis();
        System.out.println("result is :"+result);
    }

    public static int maxValue(ArrayList<Items> items,int bagweight)
    {
        if(items.size()==0||bagweight==0)
            return 0;
        else
        {
            ArrayList<Items> tempArray = items;
            Items item = tempArray.remove(0);
            int leftval = item.getValue()+maxValue(tempArray,bagweight-item.getWeight());
            int rightval = maxValue(tempArray,bagweight);
            if(leftval>rightval)
                return leftval;
            else
                return rightval;
        }
    }

}
