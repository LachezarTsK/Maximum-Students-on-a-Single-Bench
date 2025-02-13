
public class Solution {

    private static final int[] ID_RANGE = {1, 100};

    public int maxStudentsOnBench(int[][] students) {

        int maxStudentsOnBench = 0;
        int[] frequencyStudentsPerBench = new int[ID_RANGE[1] + 1];
        long[][] bitStampForSeatedStudentsOnBench = new long[ID_RANGE[1] + 1][2];

        for (int[] current : students) {
            int studentID = current[0];
            int benchID = current[1];

            int index = studentID / (1 + ID_RANGE[1] / 2);
            int bitShifts = studentID % (1 + ID_RANGE[1] / 2);
            long bitStampStudent = 1L << bitShifts;

            if (!isSeated(bitStampForSeatedStudentsOnBench[benchID][index], bitStampStudent)) {
                ++frequencyStudentsPerBench[benchID];
                bitStampForSeatedStudentsOnBench[benchID][index] ^= bitStampStudent;
                maxStudentsOnBench = Math.max(maxStudentsOnBench, frequencyStudentsPerBench[benchID]);
            }
        }

        return maxStudentsOnBench;
    }

    private boolean isSeated(long bitStampForSeatedStudentsOnBench, long bitStampStudent) {
        return (bitStampForSeatedStudentsOnBench & bitStampStudent) != 0;
    }
}
