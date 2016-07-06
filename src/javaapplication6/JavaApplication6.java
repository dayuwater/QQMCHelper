/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author tanwang
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    
    private static int TOTAL_WATERMELON=21; //4*7
    private static int TOTAL_MONGO=42; // 4*14
    private static int TOTAL_STRAWBERRY=63; //4*21
    private static int TOTAL_ICE=105; //4*35
    private static int TOTAL_SUGAR=105;  //4*35
    
    public int watermelon=TOTAL_WATERMELON;
    public int mongo=TOTAL_MONGO;
    public int strawberry=TOTAL_STRAWBERRY;
    public int ice=TOTAL_ICE;
    public int sugar=TOTAL_SUGAR;
    public int score=0;
           
    
    
    private  void fillBucket(){
          watermelon=TOTAL_WATERMELON;
      mongo=TOTAL_MONGO;
      strawberry=TOTAL_STRAWBERRY;
      ice=TOTAL_ICE;
      sugar=TOTAL_SUGAR;
      score=0;
        
        
    }
    
    private boolean make3() {
        if (strawberry >= 7 && watermelon >= 3 && mongo >= 5 && ice >= 6 && sugar >= 5) {
            strawberry -= 7;
            watermelon -= 3;
            mongo -= 5;
            ice -= 6;
            sugar -= 5;
            score += 9;
            return true;

        } else {
            return false;
        }

    }
    
    private boolean make1(){
        if (strawberry >= 0 && watermelon >= 2 && mongo >= 0 && ice >= 4 && sugar >= 2) {
            strawberry -= 0;
            watermelon -= 2;
            mongo -= 0;
            ice -= 4;
            sugar -= 2;
            score += 2;
            return true;

        } else {
            return false;
        }

        
    }
    
    private boolean make2(){
        if (strawberry >= 0 && watermelon >= 0 && mongo >= 6 && ice >= 5 && sugar >= 4) {
            strawberry -= 0;
            watermelon -= 0;
            mongo -= 6;
            ice -= 5;
            sugar -= 4;
            score += 5;
            return true;

        } else {
            return false;
        }

        
    }
    
    private int[] fetch(){
        return new int[]{strawberry,watermelon,mongo,ice,sugar,score};
        
    }
    
    private void restore(int[] i){
        strawberry=i[0];
        watermelon=i[1];
        mongo=i[2];
        ice=i[3];
        sugar=i[4];
        score=i[5];
        
    }
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        JavaApplication6 pro=new JavaApplication6();
        pro.fillBucket();
        
        ArrayList<int[]> counts=new ArrayList<int[]>();
    
        // check max 3
        int cc3=0;
        int[] data=pro.fetch();
        
        while(pro.make3()){
            cc3++;
        }
        pro.restore(data);
        
        // tweak 3
        
        
        for (int j = 0; j < cc3+1; j++) {
            int c1=0;
            int c2=0;
            int c3=0;
            pro.fillBucket();
           

            for (int i = 0; i < j; i++) {
                pro.make3();
                c3++;
            }
            
            // check max 2
            int[] data2=pro.fetch();
            int cc2=0;
            while (pro.make2()) {
                cc2++;

            }
            // tweak 2
            
            for (int k = 0; k < cc2+1; k++) {
                pro.restore(data2);
                c1=0;
                c2=0;
                
                for (int l = 0; l < k; l++) {

                    pro.make2();
                    c2++;
                }

                while (pro.make1()) {
                    c1++;

                }
                int[] count = new int[4];
                count[0] = c1;
                count[1] = c2;
                count[2] = c3;
                count[3] = pro.score;
                counts.add(count);

                
            }
            
           
            
            
            
            
        }
        
        counts.sort(new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                int[] ia=(int[]) a;
                int[] ib=(int[]) b;
                if(ia[3]>ib[3]){
                    return -1;
                }
                else{
                    return 1;
                }
                
           }
        });
        System.out.printf("Best solution: 1=%d, 2=%d, 3=%d, score=%d",counts.get(0)[0],counts.get(0)[1],counts.get(0)[2],counts.get(0)[3]);
        
        
        
    }
    
}
