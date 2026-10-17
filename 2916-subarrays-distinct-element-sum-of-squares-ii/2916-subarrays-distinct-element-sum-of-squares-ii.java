class Solution {
    static final int MOD = 1_000_000_007;

    int[] tree, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];

        int[] last = new int[100001];
        long current = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int p = last[x];

            long old = update(1, 0, n - 1, p, i);

            current = (current + 2 * old + i - p + 1) % MOD;
            ans = (ans + current) % MOD;

            last[x] = i + 1;
        }

        return (int) ans;
    }

    long update(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) {
            return 0;
        }

        if (ql <= l && r <= qr) {
            long old = tree[node];
            tree[node] = (int) ((tree[node] + (long) (r - l + 1)) % MOD);
            lazy[node]++;
            return old;
        }

        push(node, l, r);

        int mid = (l + r) / 2;

        long res = update(node * 2, l, mid, ql, qr)
                 + update(node * 2 + 1, mid + 1, r, ql, qr);

        tree[node] = (int) ((tree[node * 2] + (long) tree[node * 2 + 1]) % MOD);

        return res % MOD;
    }

    void push(int node, int l, int r) {
        if (lazy[node] == 0 || l == r) {
            return;
        }

        int mid = (l + r) / 2;
        int v = lazy[node];

        apply(node * 2, mid - l + 1, v);
        apply(node * 2 + 1, r - mid, v);

        lazy[node] = 0;
    }

    void apply(int node, int len, int v) {
        tree[node] = (int) ((tree[node] + (long) len * v) % MOD);
        lazy[node] += v;
    }
}