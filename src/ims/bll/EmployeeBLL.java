/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.bll;

/**
 *
 * @author Admin
 */
public class EmployeeBLL {
    public static char[] syb={'~','!','@','#','$','%','^','&','*'};
   public static char[] num={'1','2','3','4','5','6','7','8','9'}; 
    public static Boolean checkSb(String s)
    {
        boolean b=false;
        char a[]= s.toCharArray();
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<syb.length;j++)
            {
                if(a[i]==syb[j])
                    b=true;
            }
        }
        return b;
    } 
    public static Boolean checkNum(String s)
    {
       boolean b=false;
        char a[]= s.toCharArray();
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<syb.length;j++)
            {
                if(a[i]==num[j])
                    b=true;
            }
        }
        return b; 
    }
}
