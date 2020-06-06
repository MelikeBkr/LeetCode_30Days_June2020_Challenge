class Solution {
    public int[][] reconstructQueue(int[][] people)
    {
        //sort as descendant order for first column, 
        //ascendent order for second column (if first columns are equal)
        Arrays.sort(people, new Comparator<>()
        {
            public int compare(int[] a, int[] b) {
                //if the next value and the current value are not equal
                if (a[0] != b[0])
                {
                    //get the greater
                    return b[0] - a[0];
                }
                else
                {
                    //if they are equal then select the smaller one for the second column
                    return a[1] - b[1];
                }
            }
        });

        List<int[]> temp = new ArrayList<>();
        //copy sorted elements to the temp array based on the index
        //which can be obtained from value in second column 
        for (int i = 0; i < people.length; i++) 
        {
            temp.add(people[i][1], people[i]);
        }
        //copy all values into 2D Array 
        //to fulfil the return type condition
        int[][] result = new int[people.length][2];
        for (int i = 0; i < temp.size(); i++) 
        {
            result[i][0] = temp.get(i)[0];
            result[i][1] = temp.get(i)[1];
        }
        return result;
    }
}