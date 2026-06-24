class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {  // ← return type int
        int m = r - l + 1;
        int size = 2 * m;

        long[][] T = new long[size][size];

        for (int v = 0; v < m; v++) {
            for (int d = 0; d < 2; d++) {
                int src = v * 2 + d;
                if (d == 1) {
                    for (int w = 0; w < v; w++) {
                        int dst = w * 2 + 0;
                        T[dst][src] = (T[dst][src] + 1) % MOD;
                    }
                } else {
                    for (int w = v + 1; w < m; w++) {
                        int dst = w * 2 + 1;
                        T[dst][src] = (T[dst][src] + 1) % MOD;
                    }
                }
            }
        }

        long[] init = new long[size];
        for (int v1 = 0; v1 < m; v1++) {
            for (int v2 = 0; v2 < m; v2++) {
                if (v2 > v1) {
                    init[v2 * 2 + 1] = (init[v2 * 2 + 1] + 1) % MOD;
                } else if (v2 < v1) {
                    init[v2 * 2 + 0] = (init[v2 * 2 + 0] + 1) % MOD;
                }
            }
        }

        long[][] Tp = matPow(T, n - 2);
        long[] result = matVecMul(Tp, init);

        long ans = 0;
        for (long x : result) ans = (ans + x) % MOD;
        return (int) ans;  // ← cast to int
    }

    private long[][] matMul(long[][] A, long[][] B) {
        int sz = A.length;
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++) {
            for (int k = 0; k < sz; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < sz; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[][] matPow(long[][] M, int p) {
        int sz = M.length;
        long[][] result = new long[sz][sz];
        for (int i = 0; i < sz; i++) result[i][i] = 1;

        while (p > 0) {
            if ((p & 1) == 1) result = matMul(result, M);
            M = matMul(M, M);
            p >>= 1;
        }
        return result;
    }

    private long[] matVecMul(long[][] M, long[] v) {
        int sz = v.length;
        long[] out = new long[sz];
        for (int i = 0; i < sz; i++) {
            for (int k = 0; k < sz; k++) {
                out[i] = (out[i] + M[i][k] * v[k]) % MOD;
            }
        }
        return out;
    }
}