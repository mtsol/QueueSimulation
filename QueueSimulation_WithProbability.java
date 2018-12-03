/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuesimulation;

/**
 *
 * @author mba
 */
public class QueueSimulation_WithProbability {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int qlength = 0, n = 15; 
        double lambda = 5, mean = 7, given_K = 1;
        
        double inter_arrival_time = (-1/lambda*Math.log(Math.random())),
                cust_arrival_time = inter_arrival_time,
                cust_service_strt_time = cust_arrival_time,
                srvr_service_time = (-1/mean*Math.log(Math.random())),
                cust_exit_time = srvr_service_time+cust_service_strt_time,
                time_of_K = 0;
        
        for(int i = 1; i <= n; i++)
        {
            /*System.out.println(i+"  "+inter_arrival_time+" "+cust_arrival_time+"   "+qlength+"  "+cust_service_strt_time
                    +"   "+srvr_service_time+"  "+cust_exit_time);*/
            System.out.printf("%s \t %.3f \t %.3f \t %s \t %.3f \t %.3f \t %.3f \n", i, inter_arrival_time, cust_arrival_time, 
                    qlength, cust_service_strt_time, srvr_service_time, cust_exit_time);
            inter_arrival_time =(-1/lambda*Math.log(Math.random())); 
            cust_arrival_time = inter_arrival_time+cust_arrival_time;
            if(cust_exit_time>cust_arrival_time)
            {
                cust_service_strt_time = cust_exit_time;
                qlength++;
            }
            else{
                cust_service_strt_time = cust_arrival_time;
                qlength=0;
            }
            if((qlength) == given_K)
            {
                time_of_K = cust_exit_time - cust_arrival_time+time_of_K;
                
            }
            
            
            
            srvr_service_time = (-1/mean*Math.log(Math.random()));
            cust_exit_time = cust_service_strt_time + srvr_service_time;
            
            
        }
        
        System.out.println("P("+given_K+") = "+Math.exp(lambda/mean)*(1-(lambda/mean)));
        System.out.println("L = "+lambda/(mean-lambda));
        System.out.println("W = "+1/(mean-lambda));
        
        
        
        System.out.println("Calculated P("+given_K+") = "+time_of_K/cust_exit_time);
        
        
    }
    
}
