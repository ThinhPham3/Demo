package com.mothaiba.mot.hai;

import com.sun.source.tree.Tree;

import java.util.*;

public class leetcode {
    public static void main(String[] args) {
        Boolean a = Palindrome (121);
        Boolean b = Duplicate(new int[]{1,1,3,4,5});
        String c = new String("dasdSDS");
        c.toLowerCase();
        int d = Max(new int[]{111,2,33,4,7,8,9});
        //System.out.println(d);
        List<HashMap<String, Object>> arrs = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, Object> arrs_child = new HashMap<>();
            arrs_child.put("id",i);
            arrs_child.put("comb", i+1);
            arrs_child.put("price",i + 1000);
            arrs_child.put("comb_name", "comb_name"+ Integer.toString(i));
            arrs.add(arrs_child);
        }

        AddProductNameAndSum(arrs);
        //System.out.println(arrs);
        String str = "/../asd/";
        String arrOfStr = simplifyPath(str);
        //System.out.println(arrOfStr);
        String [] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        for (int i = 0; i < reorderLogFiles(logs).length; i++) {
            System.out.println(reorderLogFiles(logs)[i]);
        }
    }
    public static boolean Palindrome (int x){
        if (x == 0) // true
            return true;
        if (x < 0 || x % 10 == 0) // 10
            return false;
        int reverse = 0;
        while (x > reverse){
            int pop = x % 10;
            x /= 10;
            reverse = (reverse * 10) + pop;
        }
        if (x == reverse || x == reverse / 10) // case so le
            return true;
        else
            return false;
    }
    public static boolean Duplicate (int[] num){
        HashSet<Integer> rs = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            if(rs.contains(num[i])){
                return true;
            }
            rs.add(num[i]);
        }
        return false;
    }
    public static int Max (int[] arrs){
        int max = arrs[0];
        for (int i = 1; i < arrs.length; i++) {
            if(Math.max(max, arrs[i]) == arrs[i]){
                max = arrs[i];
            }
        }
        return max;
    }
    public static void AddProductNameAndSum (List<HashMap<String, Object>> arrs){
        for (int i = 0; i < arrs.size(); i++) {
            Integer comb = (Integer) arrs.get(i).get("comb");
            if(comb > arrs.size() - 1)
                continue;
            String comb_name = (String) arrs.get(comb).get("comb_name");
            Integer price = (Integer) arrs.get(comb).get("price");
            Integer sum = (Integer) arrs.get(i).get("price") + price;
            arrs.get(i).put("comb_name", comb_name);
            arrs.get(i).put("price", sum);
        }
    }
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>(); // create a stack to keep track of directories
        String[] directories = path.split("/"); // split the path by slash '/'
        for (String dir : directories) { // iterate over the directories
            if (dir.equals(".") || dir.isEmpty()) { // ignore the current directory '.' and empty directories
                continue;
            } else if (dir.equals("..") && !stack.isEmpty()) {// go one level up for double period '..'
                stack.pop();
            } else { // for any other directory, push it to the stack
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack);
    }


    public static String[] reorderLogFiles(String[] logs) {
        if(logs.length == 0) return logs;
        List<String> letterLogs = new ArrayList<>(), digitLogs = new ArrayList<>();
        separateLettersDigits(logs, letterLogs, digitLogs);
        sortLetterLogs(letterLogs);
        return generateOutput(letterLogs, digitLogs);
    }

    public static void separateLettersDigits(String[] input, List<String> letterLogs, List<String> digitLogs) {
        for(String log : input) {
            if(Character.isDigit(log.charAt(log.length()-1))){
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }
    }

    public static void sortLetterLogs(List<String> letterLogs) {
        //sắp xếp các phần tử của List theo cài đặt đối tượng Comparator.
        // Comparator - sắp xếp các phan tu cua Object pass vao do lap trinh vien quy dinh
        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1.substring(o1.indexOf(" ") + 1);
                String s2 = o2.substring(o2.indexOf(" ") + 1);
                //1 la >, -1 la <, 0 la same
                return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
            }
        });
    }

    public static String[] generateOutput(List<String> letterLogs, List<String> digitLogs) {
        String[] output = new String[letterLogs.size() + digitLogs.size()];
        for(int i = 0; i < letterLogs.size(); i++) {
            output[i] = letterLogs.get(i);
        }
        for(int i = letterLogs.size(); i < output.length; i++) {
            output[i] = digitLogs.get(i-letterLogs.size());
        }
        return output;
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root,targetSum, res, new ArrayList<>());
        return res;
    }
    public static void dfs (TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> list){
        targetSum -= root.val;
        list.add(root.val);
        //base case
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(list));
        }else {
            if (root.left !=null){
                dfs(root.left, targetSum, res, list);
            }
            if (root.right !=null){
                dfs(root.right, targetSum, res, list);
            }
        }
        list.remove(list.size()-1);
    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
    }
}