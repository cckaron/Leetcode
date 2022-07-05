package src;

import java.util.*;

public class CityTrip {
    public static City[] cities;
    public static int maxDepth;
    public static void main(String[] args){
        int[] T = new int[]{0, 0, 0, 1, 6, 1, 0, 0};
        City initCity = transformArrToMap(T);

        dfs(initCity, 0, false);
        System.out.println(maxDepth);
    }

    public static class City {
        int name;
        boolean isVisited;
        Stack<City> connectedCity;

        public City(int name, boolean isVisited, Stack<City> connectedCity) {
            this.name = name;
            this.isVisited = isVisited;
            this.connectedCity = connectedCity;
        }
    }

    public static City transformArrToMap(int[] arr){
        cities = new City[arr.length];

        for (int i=0; i<arr.length; i++){ // cities = [City{0, {}}, City{1, {}} , City{2, {}} ...}
            cities[i] = new City(i, false, new Stack<>());
        }

        //arr = [0,9,0,2,6,8,0,8,3,0]
        for (int i=1; i<arr.length; i++){ // arr[1] = 9
            cities[ arr[i] ].connectedCity.push(cities[i]);
        }

        return cities[0];
    }

    public static int dfs(City city, int depth, boolean isSold){
        if (isSold && city.name % 2 == 1) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        if (city.connectedCity.isEmpty()){
            maxDepth = Math.max(maxDepth, depth+1);
            return depth+1;
        }

        // 檢查票
        if (city.name % 2 == 1) isSold = true;

        while (! city.connectedCity.empty()){
            dfs(city.connectedCity.pop(), depth+1, isSold);
        }
        return 0;
    }
}
