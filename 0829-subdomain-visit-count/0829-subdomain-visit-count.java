class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : cpdomains) {
            String[] str = s.split(" ");
            String[] dom = str[1].split("\\.");

            int rep = Integer.parseInt(str[0]);
            if (dom.length == 3) {
                String d1 = dom[0].concat(".").concat(dom[1]).concat(".").concat(dom[2]);
                String d2 = dom[1].concat(".").concat(dom[2]);
                String d3 = dom[2];

                map.put(d1, map.getOrDefault(d1, 0) + rep);
                map.put(d2, map.getOrDefault(d2, 0) + rep);
                map.put(d3, map.getOrDefault(d3, 0) + rep);
            } else if (dom.length == 2) {
                String d2 = dom[0].concat(".").concat(dom[1]);
                String d3 = dom[1];

                map.put(d2, map.getOrDefault(d2, 0) + rep);
                map.put(d3, map.getOrDefault(d3, 0) + rep);
            } else {
                String d3 = dom[0];

                map.put(d3, map.getOrDefault(d3, 0) + rep);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        int n = list.size();

        for (int i = 0; i < n; i++) {
            String s = list.get(i);
            int rep = map.get(s);
            list.set(i, rep + " " + s);
        }

        return list;
    }
}