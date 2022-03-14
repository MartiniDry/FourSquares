# FourSquares

**Algorithmic testbed for the Lagrange four-squares problem**

![Version](https://img.shields.io/badge/Version-1.0-blue)
![Language](https://img.shields.io/badge/Language-JavaSE_1.8-green)

------

The above code proposes different algorithms to find all solutions to the Lagrange's four-squares problem:

&nbsp; &nbsp; &nbsp; &nbsp; **∀ n ∈ ℕ, ∃ (a, b, c, d) ∈ ℕ | a²+b²+c²+d² = n**

The following algorithms have been implemented in Java:

1) **Naive algorithm**<br/>→ we swipe `a`, `b`, `c` and `d` to find all solutions.

2) **Degree-4 checking (modulo)**: checking parameter `d` using the modulo<br/>→ we only swipe over `a`, `b` and `c` and check that **`d` ∈ ℕ** using the instruction: `d % 1 == 0`.

3) **Simple upper-bounding**: setting an upper-bound to `a`, `b` and `c`<br/>→ `a` is majorated using the problem formula and we set `b < a` and `c < b` to avoid symmetrical solutions. When we find a solution, it implies that `a > b > c > d`.

4) **Lower-bounding**: setting a lower bound to `a`, `b` and `c`<br/>→ those bound are easily deducted from the problem formula: `a²+b²+c²+d² = n` and the below optimization. It implies that `4a² > n`, `3b² > n-a²` and `2c² > n-a²-b²`.

5) **Degree-4 checking (cast)**: checking parameter `d` using Java type casting<br/>→ we check that **`d` ∈ ℕ** using the instruction: `d == (int) d`.

6) **Enhanced upper-bounding**: combining the optimization 3 with another upper-bound<br/>→ the second bounding can be deduced from the problem formula.

A simple table sums up some important features for those algorithms:
| Algorithm | Time complexity | Memory complexity | Redundant solutions |
|:---|:---:|:---:|:---:|
| 1 - naive | O(n⁴) | O(1) | NO |
| 2 - C4(mod) | O(n³) | O(1) | NO |
| 3 - C4(mod) + UB | O(n³) | O(1) | NO |
| 4 - C4(mod) + UB + LB | O(n³) | O(1) | `YES` |
| 5 - C4(cast) + UB + LB | O(n³) | O(1) | `YES` |
| 6 - C4(cast) + EUB + LB | O(n³) | O(1) | `YES` |

---

Here is a benchmark I made in my laptop:

    PC  - ASUS R510C
    CPU - Intel Core i5-3337U (x64)
    OS - Windows 10 v.21H1 build 19043.1586
    2 physical cores
    
![Benchmark from 100 to 200.000](res/benchmark_1e2_2e6.png)
