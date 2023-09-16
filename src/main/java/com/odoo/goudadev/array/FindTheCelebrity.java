package com.odoo.goudadev.array;

import java.util.Map;
import java.util.Set;

/**
 * Created by gouthamvidyapradhan on 25/11/2017.
 *
 * <p>Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may
 * exist one celebrity. The definition of a celebrity is that all the other n - 1 people know
 * him/her but he/she does not know any of them.
 *
 * <p>Now you want to find out who the celebrity is or verify that there is not one. The only thing
 * you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of
 * whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as
 * few questions as possible (in the asymptotic sense).
 *
 * <p>You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement
 * a function int findCelebrity(n), your function should minimize the number of calls to knows.
 *
 * <p>Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's
 * label if there is a celebrity in the party. If there is no celebrity, return -1.
 */
public class FindTheCelebrity {

    private static Map<Integer, Set<Integer>> map = Map.of(
        0, Set.of(1, 2, 3, 4, 5, 6),
        1, Set.of(0, 2, 3),
        2, Set.of(1, 3, 4),
        4, Set.of(2, 3, 5),
        5, Set.of(3, 4, 6),
        6, Set.of(0, 3, 5)
    );

    public int findCelebrity(int n) {
        int candidate = -1, i = 0, next = 1;
        while (i < n) {
            if (next >= n) break;
            if (knows(i, next) && !knows(next, i)) {
                i = next;
                next = i + 1;
            } else if ((!knows(i, next) && !knows(next, i)) || (knows(i, next) && knows(next, i))) {
                i = next + 1;
                next = i + 1;
            } else {
                next++;
            }
            candidate = i;
        }
        if (candidate == -1 || candidate >= n) return -1;
        for (int j = 0; j < candidate; j++) {
            if (!knows(j, candidate) || knows(candidate, j)) {
                candidate = -1;
                break;
            }
        }
        return candidate;
    }

    private boolean knows(int a, int b) {
        return map.get(a).contains(b);
    }
}
