package movingAvg;

import java.io.BufferedReader;  
import java.io.FileInputStream;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.Reader;  
import java.util.ArrayList;  
import java.util.List;  

public class MovingAverageSolution {
    private List<String> inputs = new ArrayList<String>();  
    private int winSize = 0;  
      
    public MovingAverageSolution(){  
    }  
      
    public static void main(String[] args) throws Exception {  
        BufferedReader br = null;  
        MovingAverageSolution solution = new MovingAverageSolution();  
        try {  
            InputStream inputStream = new FileInputStream("input1.txt");  
            Reader reader = new InputStreamReader(inputStream);  
            br = new BufferedReader(reader);  
              
//          br = new BufferedReader(new InputStreamReader(System.in));  
              
            solution.winSize = Integer.parseInt(br.readLine());  
            String input = br.readLine();  
            while(input != null){  
                solution.inputs.add(input);  
                solution.process(solution.inputs);  
                input = br.readLine();  
            }  
              
        } finally {  
            if (br != null)  
                br.close();  
        }  
    }  
      
    public void process(List<String> inputs) {  
//      System.out.println(inputs.size());  
        if(winSize<=0 || inputs.size() < winSize){  
            return;  
        }  
          
        double sum = 0;  
        for(int i=inputs.size()-1; i>=inputs.size()-winSize; i--){  
            sum += Double.parseDouble(inputs.get(i));  
        }  
        double average = sum*1.0 / winSize;  
        System.out.println(String.format("%.3f", average));  
    }  

}
