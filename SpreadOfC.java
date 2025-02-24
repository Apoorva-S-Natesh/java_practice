public class SpreadOfC 
{
	public static void main(String[] args) 
	{
        String [] sequence = {"TCCCCGCATAGCTGAACAT", "TGACGCGCGATAGTTTCCA", "TTAACGTAACGAGTGTCGG", "TTAGGTAACGAGCGTTAGT", "TTACGTAAGCGTTAGTCGG", "TACGGACGTTAGTATTCGG"};
		for (int i = 0; i < sequence.length; i++)
		{
        	int c_score = calculateSpread(sequence[i], 'C');
			int g_score = calculateSpread(sequence[i], 'G');
			int spreadCG = calculateSpreadForMultiple(sequence[i], 'C', 'G');
			int spreadAT = calculateSpreadForMultiple(sequence[i], 'A', 'T');
			double totalSumiG =  calculateOverallSum_iG(sequence[i]);
			double totalSumwG =  calculateOverallSum_wG(sequence[i]);

			System.out.println("Sequence: " + sequence[i]);
       		System.out.println("Spread Score C : " + c_score);
			System.out.println("Spread Score G : " + g_score);
			System.out.println("Spread Score for 'C' and 'G' combined: " + spreadCG);
			System.out.println("Spread Score for 'A' and 'T' combined: " + spreadAT);
			System.out.printf("Total bond score iG: %.3f\n", totalSumiG);
			System.out.printf("Total bond score wG: %.3f\n", totalSumwG);
		}
	}

	public static int calculateSpread(String sequence, char target) 
	{
       		 int score = 0;
        		int prevIndex = -1; // To store the previous occurrence of 'C'
        
       		 for (int i = 0; i < sequence.length(); i++) 
		{
            			if (sequence.charAt(i) == target) {
                			if (prevIndex != -1) {
                    			score += (i - prevIndex);
                			}
                		prevIndex = i; // Update the last found index of 'C'
            		}
        		}
       		 return score;
   	 }

	public static int calculateSpreadForMultiple(String sequence, char target1, char target2) 
	{
        		int score = 0;
        		int prevIndex = -1;

        		for (int i = 0; i < sequence.length(); i++) 
				{
            			char current = sequence.charAt(i);
            			if (current == target1 || current == target2) 
			{
               				 if (prevIndex != -1) 
				{
                    					score += (i - prevIndex);
                				}
                				prevIndex = i;
            			}
        		}
        		return score;
    	}

	public static double calculateOverallSum_iG(String sequence) {
        char[] nucleotides = {'A', 'T', 'C', 'G'};
        double[] bondValues = {0.90, 0.88, 0.94, 0.59}; 

        double sum = 0.0f;

        // Compute sum based on bond values
        for (char nucleotide : sequence.toCharArray()) {
            for (int i = 0; i < nucleotides.length; i++) {
                if (nucleotide == nucleotides[i]) {
                    sum += bondValues[i];
                    break; // Exit loop once found
                }
            }
        }
        return sum;
    }

	public static double calculateOverallSum_wG(String sequence) 
	{
       		char[] nucleotides = {'A', 'T', 'C', 'G'};
        	double [] bondValues = {0.90, 0.88, 0.94, 0.43}; 
       		double sum = 0.0;
       		for (char nucleotide : sequence.toCharArray()) 
		{
            			for (int i = 0; i < nucleotides.length; i++) 
			{
              	 			 if (nucleotide == nucleotides[i])
				 {
                  					  sum += bondValues[i];
                   					 break; // Exit loop once found
                				}
           			 }
       		 }
        		return sum;
    	}
}

