class Solution {

    class Pair {
        String ft;
        int sec;

        Pair(String ft, int sec) {
            this.ft = ft;
            this.sec = sec;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> set = new HashSet<>();

        // Add all words to set
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }

        set.remove(beginWord);

        while (!q.isEmpty()) {

            String word = q.peek().ft;
            int step = q.peek().sec;
            q.remove();

            // If we reached endWord
            if (word.equals(endWord)) {
                return step;
            }

            // Change each character
            for (int i = 0; i < word.length(); i++) {

                char[] replacedCharArray = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    replacedCharArray[i] = ch;

                    String replacedWord = new String(replacedCharArray);

                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, step + 1));
                    }
                }
            }
        }

        return 0;
    }
}