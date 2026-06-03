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

        long[] rides = new long[m];

        for (int i = 0; i < m; i++) {
            rides[i] = (((long) start2[i]) << 32)
                    | (dur2[i] & 0xffffffffL);
        }

        Arrays.sort(rides);

        int[] starts = new int[m];
        int[] prefMinDur = new int[m];
        int[] suffMinFinish = new int[m];

        starts[0] = (int) (rides[0] >> 32);
        prefMinDur[0] = (int) rides[0];

        for (int i = 1; i < m; i++) {

            starts[i] = (int) (rides[i] >> 32);

            int dur = (int) rides[i];

            prefMinDur[i] =
                    Math.min(prefMinDur[i - 1], dur);
        }

        int lastStart = (int) (rides[m - 1] >> 32);
        int lastDur = (int) rides[m - 1];

        suffMinFinish[m - 1] =
                lastStart + lastDur;

        for (int i = m - 2; i >= 0; i--) {

            int start = (int) (rides[i] >> 32);
            int dur = (int) rides[i];

            int finish = start + dur;

            suffMinFinish[i] =
                    Math.min(
                            suffMinFinish[i + 1],
                            finish
                    );
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {

            int finish1 = start1[i] + dur1[i];

            int idx = upperBound(starts, finish1);

            if (idx >= 0) {

                int candidate =
                        finish1 + prefMinDur[idx];

                if (candidate < ans) {
                    ans = candidate;
                }
            }

            if (idx + 1 < m) {

                int candidate =
                        suffMinFinish[idx + 1];

                if (candidate < ans) {
                    ans = candidate;
                }
            }
        }

        return ans;
    }

    private int upperBound(
            int[] arr,
            int target) {

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {

            int mid = (l + r) >>> 1;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }
}