import java.util.*;
public class DuplicatesAndUniqueElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter elements separated by commas: ");
        String input = sc.nextLine();

        String[] elements = input.split(",");
        int[] nums = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            nums[i] = Integer.parseInt(elements[i].trim());
        }

        List<Integer> duplicates = new ArrayList<>();
        List<Integer> uniques = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (frequencyMap.get(num) > 1 && !duplicates.contains(num)) {
                duplicates.add(num);
            }
            if (frequencyMap.get(num) == 1 && !uniques.contains(num)) {
                uniques.add(num);
            }
        }

        System.out.println("List-1 - Elements with duplicates: " + duplicates);
        System.out.println("List-2 - Elements without duplicates: " + uniques);
    }
}
