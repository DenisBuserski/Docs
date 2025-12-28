class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);
        int total = 0;

        for (int index = 0; index < s.length(); index++) {
            int current = map.get(s.charAt(index));
            int nextIndex = index + 1;

            if (nextIndex < s.length() && current < map.get(s.charAt(nextIndex))) {
                total -= current;
            } else {
                total += current;
            }
        }

        return total;
        
    }
}
