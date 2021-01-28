package com.epam.prejap.ess.helpers.collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CollectionsHelpersTest {

    @Test(dataProvider = "getLists") // given
    public void shallReverseList(List<Integer> list) {
        // when
        List<Integer> copyList = new ArrayList<>(list);
        Collections.reverse(list);

        // then
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), copyList.get(copyList.size() - 1 - i));
        }
    }

    @Test(dataProvider = "getLists") // given
    public void shallSortList(List<Integer> list) {
        // when
        List<Integer> copyList = new ArrayList<>(list);
        Collections.sort(list);

        // then
        for (int i = 0; i < list.size(); i++) {
            assertTrue(copyList.contains(list.get(i)));

            if (i + 1 >= list.size()) break;

            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test(dataProvider = "getLists") // given
    public void shallShuffleList(List<Integer> list) {
        // when
        List<Integer> copyList = new ArrayList<>(list);
        Collections.shuffle(list);

        // then
        for (Integer i : list) {
            assertTrue(copyList.contains(i));
        }
    }

    @Test(dataProvider = "getListsWithRandom") // given
    public void shallShuffleListUsingProvidedSourceOfRandomness(List<Integer> list, Random random) {
        // when
        List<Integer> copyList = new ArrayList<>(list);
        Collections.shuffle(list, random);

        // then
        for (Integer i : list) {
            assertTrue(copyList.contains(i));
        }
    }

    @Test(dataProvider = "getLists") // given
    public void shallSwapFirstWithLastElements(List<Integer> list) {
        // when
        List<Integer> copyList = new ArrayList<>(list);
        Collections.swap(list, 0, list.size() - 1);

        // then
        assertEquals(copyList.get(copyList.size() - 1), list.get(0));
        assertEquals(copyList.get(0), list.get(list.size() - 1));

        for (Integer i : list) {
            assertTrue(copyList.contains(i));
        }
    }

    @DataProvider
    public Object[][] getLists() {
        return new Object[][] {
                { new ArrayList<>(List.of(1, 2, 3, 4, 5)) },
                { new ArrayList<>(List.of(2, 5, 2, 6, 3)) },
                { new ArrayList<>(List.of(5, 2, 5, 7, 3)) }
        };
    }

    @DataProvider
    public Object[][] getListsWithRandom() {
        return new Object[][] {
                { new ArrayList<>(List.of(1, 2, 3, 4, 5)), new Random() },
                { new ArrayList<>(List.of(2, 5, 2, 6, 3)), new Random(3) },
                { new ArrayList<>(List.of(5, 2, 5, 7, 3)), new Random(5) }
        };
    }
}
