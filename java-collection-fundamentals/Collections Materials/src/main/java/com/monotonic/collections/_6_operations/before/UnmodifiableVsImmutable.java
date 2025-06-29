package com.monotonic.collections._6_operations.before;

import java.util.*;

public class UnmodifiableVsImmutable
{
    public static void main(String[] args)
    {
        Map<String, Integer> mutableCountryToPopulation = new HashMap<>();
        mutableCountryToPopulation.put("UK", 67);
        mutableCountryToPopulation.put("USA", 328);

        System.out.println("mutableCountryToPopulation =" + mutableCountryToPopulation);

        Map<String, Integer> unmodifiableCountryToPop = Collections.unmodifiableMap(mutableCountryToPopulation);

        Map<String, Integer> copiedCountryToPop = Map.copyOf(mutableCountryToPopulation);


        System.out.println("copiedCountryToPop = " + copiedCountryToPop);
        System.out.println("unmodifiableCountryToPop = " + unmodifiableCountryToPop);

        mutableCountryToPopulation.put("Germany", 83);
        System.out.println("copiedCountryToPop = " + copiedCountryToPop);

        System.out.println("unmodifiableCountryToPop = " + unmodifiableCountryToPop);

        Map<String, Integer> countryToPopulation = Map.of("UK", 67, "USA", 328);
        countryToPopulation.put("Germany", 83);
        System.out.println("countryToPopulation = " + countryToPopulation);


        

    }
}
