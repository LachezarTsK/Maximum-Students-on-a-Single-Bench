
import kotlin.math.max

class Solution {

    private companion object {
        val ID_RANGE = intArrayOf(1, 100)
    }

    fun maxStudentsOnBench(students: Array<IntArray>): Int {

        var maxStudentsOnBench = 0
        val frequencyStudentsPerBench = IntArray(ID_RANGE[1] + 1)
        val bitStampForSeatedStudentsOnBench = Array(ID_RANGE[1] + 1) { LongArray(2) }

        for ((studentID, benchID) in students) {

            val index = studentID / (1 + ID_RANGE[1] / 2)
            val bitShifts = studentID % (1 + ID_RANGE[1] / 2)
            val bitStampStudent: Long = 1L shl bitShifts

            if (!isSeated(bitStampForSeatedStudentsOnBench[benchID][index], bitStampStudent)) {
                ++frequencyStudentsPerBench[benchID];
                bitStampForSeatedStudentsOnBench[benchID][index] =
                    bitStampForSeatedStudentsOnBench[benchID][index] xor bitStampStudent
                maxStudentsOnBench = max(maxStudentsOnBench, frequencyStudentsPerBench[benchID])
            }
        }

        return maxStudentsOnBench
    }

    private fun isSeated(bitStampForSeatedStudentsOnBench: Long, bitStampStudent: Long): Boolean {
        return (bitStampForSeatedStudentsOnBench and bitStampStudent) != 0L
    }
}
