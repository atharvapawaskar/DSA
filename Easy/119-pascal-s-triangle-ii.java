/**
 * LeetCode #119: Pascal's Triangle II
 * Difficulty: Easy
 * Language: Java
 * Date: 2026-10-10T03:59:16.678Z
 */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long current =1;
        result.add(1);

        for(int col =1;col<=rowIndex;col++){
            current = current * (rowIndex - col +1)/col;
            result.add((int) current);
        }
    return result;
    }
}