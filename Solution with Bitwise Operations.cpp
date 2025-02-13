
#include <array>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

    static constexpr array<int, 2> ID_RANGE = { 1, 100 };

public:
    int maxStudentsOnBench(const vector<vector<int>>& students) const {

        int maxStudentsOnBench = 0;
        array<int, ID_RANGE[1] + 1> frequencyStudentsPerBench{};
        array<array<long long, 2>, ID_RANGE[1] + 1>  bitStampForSeatedStudentsOnBench{};

        for (const auto& current : students) {
            int studentID = current[0];
            int benchID = current[1];

            int index = studentID / (1 + ID_RANGE[1] / 2);
            int bitShifts = studentID % (1 + ID_RANGE[1] / 2);
            long long bitStampStudent = 1LL << bitShifts;

            if (!isSeated(bitStampForSeatedStudentsOnBench[benchID][index], bitStampStudent)) {
                ++frequencyStudentsPerBench[benchID];
                bitStampForSeatedStudentsOnBench[benchID][index] ^= bitStampStudent;
                maxStudentsOnBench = max(maxStudentsOnBench, frequencyStudentsPerBench[benchID]);
            }
        }

        return maxStudentsOnBench;
    }

private:
    bool isSeated(long long bitStampForSeatedStudentsOnBench, long long bitStampStudent) const {
        return (bitStampForSeatedStudentsOnBench & bitStampStudent) != 0;
    }
};
