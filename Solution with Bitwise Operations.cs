
using System;

public class Solution
{
    private static readonly int[] ID_RANGE = { 1, 100 };

    public int MaxStudentsOnBench(int[][] students)
    {
        int maxStudentsOnBench = 0;
        int[] frequencyStudentsPerBench = new int[ID_RANGE[1] + 1];
        long[,] bitStampForSeatedStudentsOnBench = new long[ID_RANGE[1] + 1, 2];

        foreach (int[] current in students)
        {
            int studentID = current[0];
            int benchID = current[1];

            int index = studentID / (1 + ID_RANGE[1] / 2);
            int bitShifts = studentID % (1 + ID_RANGE[1] / 2);
            long bitStampStudent = 1L << bitShifts;

            if (!IsSeated(bitStampForSeatedStudentsOnBench[benchID, index], bitStampStudent))
            {
                ++frequencyStudentsPerBench[benchID];
                bitStampForSeatedStudentsOnBench[benchID, index] ^= bitStampStudent;
                maxStudentsOnBench = Math.Max(maxStudentsOnBench, frequencyStudentsPerBench[benchID]);
            }
        }

        return maxStudentsOnBench;
    }

    private bool IsSeated(long bitStampForSeatedStudentsOnBench, long bitStampStudent)
    {
        return (bitStampForSeatedStudentsOnBench & bitStampStudent) != 0;
    }
}
