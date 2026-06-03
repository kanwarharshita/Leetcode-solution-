import java.util.*;

class Solution {

    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        int ans1 = solve(
                landStartTime,
                landDuration,
                waterStartTime,
                waterDuration);

        int ans2 = solve(
                waterStartTime,
                waterDuration,
                landStartTime,
                landDuration);

        return Math.min(ans1, ans2);
    }

    private int solve(
            int[] start1,
            int[] dur1,
            int[] start2,
            int[] dur2) {

        int m = start2.length;

        int[][] rides = new int[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = start2[i];
            rides[i][1] = dur2[i];
        }

        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        int[] starts = new int[m];
        int[] prefixMinDur = new int[m];
        int[] suffixMinFinish = new int[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDur[0] = rides[0][1];

        for (int i = 1; i < m; i++) {
            prefixMinDur[i] =
                    Math.min(prefixMinDur[i - 1], rides[i][1]);
        }

        suffixMinFinish[m - 1] =
                rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {

            suffixMinFinish[i] =
                    Math.min(
                            suffixMinFinish[i + 1],
                            rides[i][0] + rides[i][1]
                    );
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {

            int finish1 = start1[i] + dur1[i];

            int idx = upperBound(starts, finish1);

            if (idx >= 0) {
                ans = Math.min(
                        ans,
                        finish1 + prefixMinDur[idx]
                );
            }

            if (idx + 1 < m) {
                ans = Math.min(
                        ans,
                        suffixMinFinish[idx + 1]
                );
            }
        }

        return ans;
    }

    private int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}