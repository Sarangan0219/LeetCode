//package PriorotyQueue;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.PriorityQueue;
//
///*   difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and worker[j] is the ability of
//jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
//
// Every worker can be assigned at most one job, but one job can be completed multiple times. For example, if three
// workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job,
// their profit is $0.
//*/
//public class MostProfitAssigningWork {
//
//    public class Job {
//        int d;
//        int p;
//
//        public Job(int diff, int profit) {
//            this.d = diff;
//            this.p = profit;
//        }
//    }
//
//    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
//
//
//        // Sort the class Work in ascending order of difficulty.
//        // If difficulty is the same, sort according to descending order of profit.
//        PriorityQueue <Job> pq = new PriorityQueue<>((a, b) -> (a.diff == b.diff ? b.profit - a.profit : a.diff - b.diff));
//        PriorityQueue<Job> pq = new PriorityQueue<>((a,b) -> (a.d == b.d ? b.p - a.p : a.d - b.d));
//        int n = difficulty.length;
//
//        for (int h =0 ; h < n; h++) {
//            pq.add(new Job(difficulty[h], profit[h]));
//        }
//        Arrays.sort(worker);
//        int maxProfit = 0;
//        int  i = 0;
//        int max  = 0;
//
//
//        while(!pq.isEmpty() && i < worker.length) {
//            Job job = pq.peek();
//            if (worker[i] >= job.diff) {
//                // Now we know this Job can be done by worker[i]. But to verify whether it yields maximum profit or not
//                // We need to compare it with previous maximum profit.
//                max = Math.max(max, job.profit);
//                // Need to compare the next Job.
//                pq.poll();
//            } else {
//                i++;
//                maxProfit += max;
//            }
//        }
//
//        // Assign the maximum profit work with maximum difficulty to the remaining workers
//        while(i < worker.length){
//            maxProfit += max;
//            i++;
//        }
//        return maxProfit;
//    }
//
//
//
//}
