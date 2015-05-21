import java.util.*;
import java.io.*;
import java.util.Vector;

/**
 * Created by ���� on 08.04.2015.
 */
public class A {
    FastScanner in;
    PrintWriter out;


    public static void main(String[] args) {
        new A().run();
    }

    int MaxM = 10050;
    int MAXN = 250;

    long inf = (long) 1e9 + 7;

    ArrayList<Integer> ans = new ArrayList<>(0);
    int[] x, y, z, color, p, we, st, mark, pr, dist, mark2, ino, que, ind;
    int tail, q_h, q_t, v, Min, indd;
    ArrayList<ArrayList<Integer>> g = new ArrayList<>();

    void initArrays() {
        x = new int[MaxM];
        y = new int[MaxM];
        z = new int[MaxM];
        color = new int[MAXN];
        p = new int[MAXN];
        we = new int[MAXN];
        st = new int[1005000];
        mark = new int[MaxM];
        pr = new int[MaxM];
        dist = new int[MaxM];
        mark2 = new int[MaxM];
        ino = new int[MaxM];
        que = new int[1005000];
        ind = new int[MaxM];
    }



    ArrayList<Integer> tmp = new ArrayList<>(), zz=new ArrayList<>();

    int get(int x) {
        if (p[x] == x) {
            return x;
        } else {
            p[x] = get(p[x]);
            return p[x];
        }
    }

    void un(int x, int y) {
        x = get(x);
        y = get(y);
        int t;

        if (x != y) {
            if (we[x] < we[y]) {
                t = x;
                x = y;
                y = t;
            }
            p[y] = x;
            if (we[x] == we[y])
                we[x]++;
        }
    }

    public void solve() throws IOException {
        initArrays();
        int n, m, i, flag = 0, j;
        g.ensureCapacity(MaxM);
        for (i=0;i<MaxM;i++) {
            g.add(new ArrayList<>(0));
        }
        for (i = 0; i < MAXN; i++) {
            p[i] = i;
            we[i] = 0;
            color[i] = 0;
        }

        n=in.nextInt();
        m=in.nextInt();

        for (i = 0; i < m; i++) {
            x[i]=in.nextInt();
            y[i]=in.nextInt();
            z[i]=in.nextInt();
            x[i]--;
            y[i]--;
            ind[i] = i;
        }
        q_h = 0;
        q_t = 0;
        for (i = 0; i < m; i++) {
            if ((get(x[i]) != get(y[i])) && (color[z[i]] == 0)) {
                un(x[i], y[i]);
                color[z[i]] = 1;
                ans.add(i);
            }
        }

        while (flag == 0) {
            q_h = 0;
            q_t = 0;
            tail = 0;
            for (i = 0; i < MaxM; i++) {
                mark[i] = 0;
            }
            for (i = 0; i < ans.size(); i++) {
                mark[ans.get(i)] = 1;
            }

            for (i = 0; i < m; i++) {
                dist[i] = (int) inf;
                pr[i] = -1;
                mark2[i] = 0;

                if (mark[i] == 0) {
                    st[tail] = i;
                    tail++;
                }
            }

            for (i = 0; i < ans.size(); i++) {
                for (j = 0; j < MAXN; j++) {
                    p[j] = j;
                    we[j] = 0;
                }

                for (j = 0; j < ans.size(); j++) {
                    if (ind[ans.get(i)] != ans.get(j)) {
                        un(x[ans.get(j)], y[ans.get(j)]);
                    }
                }
                for (j = 0; j < tail; j++) {
                    if (get(y[st[j]]) != get(x[st[j]])) {
                        g.get(ind[ans.get(i)]).add(ind[st[j]]);
                    }
                }

            }
            for (i = 0; i < MAXN; i++) {
                color[i] = 0;
            }
            for (i = 0; i < ans.size(); i++) {
                color[z[ans.get(i)]] = 1;
            }
            for (i = 0; i < ans.size(); i++) {
                color[z[ans.get(i)]] = 0;

                for (j = 0; j < tail; j++) {
                    if (color[z[st[j]]] == 0) {
                        g.get(ind[st[j]]).add(ind[ans.get(i)]);
                    }
                }
                color[z[ans.get(i)]] = 1;
            }
            for (i = 0; i < MAXN; i++) {
                p[i] = i;
                we[i] = 0;
            }
            for (i = 0; i < MaxM; i++) {
                ino[i] = 0;
            }
            for (i = 0; i < ans.size(); i++) {
                un(x[ans.get(i)], y[ans.get(i)]);
            }
            for (i = 0; i < tail; i++) {


                if (get(x[st[i]]) != get(y[st[i]])) {
                    dist[st[i]] = 0;
                    ino[st[i]] = 1;
                    que[q_t] = st[i];
                    q_t++;
                }
                if (color[z[st[i]]] == 0) {
                    ino[st[i]] = 2;
                }
            }
            while (q_h < q_t) {
                v = que[q_h];
                q_h++;
                mark2[v] = 1;
                for (i = 0; i < g.get(v).size(); i++) {

                    if (dist[v] + 1 < dist[g.get(v).get(i)]) {
                        pr[g.get(v).get(i)] = v;
                        dist[g.get(v).get(i)] = dist[v] + 1;
                    }

                    if (mark2[g.get(v).get(i)] == 0) {
                        que[q_t] = g.get(v).get(i);
                        q_t++;
                    }
                }


            }
            tmp.clear();
            indd = -1;
            Min = -1;

            for (i = 0; i < m; i++) {
                mark[i] = 0;
                if ((ino[i] == 2) && (((Min == -1) && (dist[i] != inf)) || (dist[i] < Min))) {
                    indd = i;
                    Min = dist[i];
                }
            }

            while (indd != -1) {
                tmp.add(indd);
                indd = pr[indd];
            }
            if (tmp.size() == 0) {
                flag = 1;
            } else {
                for (i = 0; i < tmp.size(); i++) {
                    mark[tmp.get(i)] = 1;
                }
                for (i = 0; i < ans.size(); i++) {
                    if (mark[ans.get(i)] == 0) {
                        zz.add(ans.get(i));
                    } else {
                        mark[ans.get(i)] = 0;
                    }
                }
                for (i = 0; i < tmp.size(); i++) {
                    if (mark[tmp.get(i)] != 1) {
                        zz.add(tmp.get(i));
                    }
                }
                ans = zz;
                zz.clear();
            }
        }
        out.println(ans.size());
        for (i = 0; i < ans.size(); i++) {
            out.print((ans.get(i) + 1) + " ");
        }
    }


    public void run() {
        try {
            in = new FastScanner(new File("rainbow.in"));
            out = new PrintWriter("rainbow.out");

            solve();

            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}