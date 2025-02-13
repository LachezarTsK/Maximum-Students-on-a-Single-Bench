
package main

var ID_RANGE = [2]int{1, 100}

func maxStudentsOnBench(students [][]int) int {

    maxStudentsOnBench := 0
    frequencyStudentsPerBench := make([]int, ID_RANGE[1]+1)
    bitStampForSeatedStudentsOnBench := make([][]int64, ID_RANGE[1] + 1)
    for i := range bitStampForSeatedStudentsOnBench {
        bitStampForSeatedStudentsOnBench[i] = make([]int64, 2)
    }

    for _, current := range students {

        studentID := current[0]
        benchID := current[1]

        index := studentID / (1 + ID_RANGE[1]/2)
        bitShifts := studentID % (1 + ID_RANGE[1]/2)
        bitStampStudent := int64(1) << bitShifts

        if !isSeated(bitStampForSeatedStudentsOnBench[benchID][index], bitStampStudent) {
            frequencyStudentsPerBench[benchID]++
            bitStampForSeatedStudentsOnBench[benchID][index] ^= bitStampStudent
            maxStudentsOnBench = max(maxStudentsOnBench, frequencyStudentsPerBench[benchID])
        }
    }

    return maxStudentsOnBench
}

func isSeated(bitStampForSeatedStudentsOnBench int64, bitStampStudent int64) bool {
    return (bitStampForSeatedStudentsOnBench & bitStampStudent) != 0
}
