
/**
 * @param {number[][]} students
 * @return {number}
 */
var maxStudentsOnBench = function (students) {
    const ID_RANGE = [1, 100];
    let maxStudentsOnBench = 0;
    const frequencyStudentsPerBench = new Array(ID_RANGE[1] + 1).fill(0);
    const bitStampForSeatedStudentsOnBench = Array.from(new Array(ID_RANGE[1] + 1), () => new Array(4).fill(0));

    for (let [studentID, benchID] of students) {

        const index = Math.floor(studentID / (1 + Math.floor(ID_RANGE[1] / 4)));
        const bitShifts = studentID % (1 + Math.floor(ID_RANGE[1] / 4));
        const bitStampStudent = 1 << bitShifts;

        if (!isSeated(bitStampForSeatedStudentsOnBench[benchID][index], bitStampStudent)) {
            ++frequencyStudentsPerBench[benchID];
            bitStampForSeatedStudentsOnBench[benchID][index] ^= bitStampStudent;
            maxStudentsOnBench = Math.max(maxStudentsOnBench, frequencyStudentsPerBench[benchID]);
        }
    }

    return maxStudentsOnBench;
};

/**
 * @param {number} bitStampForSeatedStudentsOnBench
 * @param {number} bitStampStudent
 * @return {boolean}
 */
function isSeated(bitStampForSeatedStudentsOnBench, bitStampStudent) {
    return (bitStampForSeatedStudentsOnBench & bitStampStudent) !== 0;
}
