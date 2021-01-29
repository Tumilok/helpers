package com.epam.prejap.ess.helpers.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * <p>Presents the work of some helper methods of {@link Collections} class</p>
 *
 * <ul>
 *     <li>{@link Collections#reverse(List)} reverses the order of the elements in the specified list.</li>
 *     <li>{@link Collections#sort(List)} sorts the specified list into ascending order, according to the natural
 *     ordering of its elements. All elements in the list must implement the {@link Comparable} interface.</li>
 *     <li>{@link Collections#shuffle(List)} randomly permutes the specified list using a <b>default</b> source of randomness.
 *     All permutations occur with approximately equal likelihood.</li>
 *     <li>{@link Collections#shuffle(List, Random)} Randomly permute the specified list using the <b>specified</b>
 *     source of randomness. All permutations occur with equal likelihood assuming that the source of randomness is fair.</li>
 *     <li>{@link Collections#swap(List, int, int)} swaps the elements at the specified positions in the specified list.</li>
 * </ul>
 *
 * @author Uladzislau Tumilovich
 * @version 1.0
 */
class CollectionsHelpers {

    /**
     * Reverse list using {@link Collections#reverse(List)}
     *
     * @param list initial list to reverse
     */
    static void collectionsReversingDemo(ArrayList<Integer> list) {
        System.out.println("REVERSE DEMO");
        Collections.reverse(list);
        System.out.println("List after reversing: " + list + "\n");
    }

    /**
     * Sort list using {@link Collections#sort(List)}
     *
     * @param list initial list to reverse
     */
    static void collectionsSortDemo(ArrayList<Integer> list) {
        System.out.println("SORT DEMO");
        Collections.sort(list);
        System.out.println("List after sorting: " + list + "\n");
    }

    /**
     * Shuffle list using {@link Collections#shuffle(List)}
     *
     * @param list initial list to reverse
     */
    static void collectionsShuffleDemo(ArrayList<Integer> list) {
        System.out.println("SHUFFLE DEMO");
        Collections.shuffle(list);
        System.out.println("List after shuffle: " + list + "\n");
    }

    /**
     * Shuffle list using {@link Collections#shuffle(List, Random)}
     * and provided source of randomness
     *
     * @param list initial list to reverse
     */
    static void collectionsShuffleWithRandomDemo(ArrayList<Integer> list) {
        System.out.println("SHUFFLE WITH RANDOM DEMO");
        Collections.shuffle(list, new Random());
        System.out.println("List after shuffle: " + list + "\n");
    }

    /**
     * Swap first and last elements of list using {@link Collections#swap(List, int, int)}
     *
     * @param list initial list to reverse
     */
    static void collectionsSwapDemo(ArrayList<Integer> list) {
        System.out.println("SWAP DEMO");
        Collections.swap(list, 0, 4);
        System.out.println("List after swapping [0] <=> [4]: " + list + "\n");
    }

    public static void main(String[] args) {
        List<ArrayList<Integer>> testData = List.of(
                new ArrayList<>(List.of(1, 2, 3, 4, 5)),
                new ArrayList<>(List.of(5, 4, 3, 2, 1)),
                new ArrayList<>(List.of(5, 2, 1, 4, 3)),
                new ArrayList<>(List.of(3, 1, 5, 4, 2)),
                new ArrayList<>(List.of(1, 5, 2, 4, 3))
        );

        for (List<Integer> list : testData) {
            System.out.println("Testing list: " + list);

            collectionsReversingDemo((ArrayList<Integer>) list);
            collectionsSortDemo((ArrayList<Integer>) list);
            collectionsShuffleDemo((ArrayList<Integer>) list);
            collectionsShuffleWithRandomDemo((ArrayList<Integer>) list);
            collectionsSwapDemo((ArrayList<Integer>) list);
        }
    }
}
