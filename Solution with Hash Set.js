
/**
 * @param {number[][]} students
 * @return {number}
 */
var maxStudentsOnBench = function (students) {
    const ID_RANGE = [1, 100];
    const frequencyStudentsPerBench = new Array(ID_RANGE[1] + 1).fill(0);
    const seatedStudentsOnBench = new Array(ID_RANGE[1] + 1);
    for (let i = 0; i < seatedStudentsOnBench.length; ++i) {
        seatedStudentsOnBench[i] = new Set();
    }

    let maxStudentsOnBench = 0;
    for (let [studentID, benchID] of students) {

        if (!seatedStudentsOnBench[benchID].has(studentID)) {
            ++frequencyStudentsPerBench[benchID];
            seatedStudentsOnBench[benchID].add(studentID);
            maxStudentsOnBench = Math.max(maxStudentsOnBench, frequencyStudentsPerBench[benchID]);
        }
    }

    return maxStudentsOnBench;
};
