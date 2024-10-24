public class AgeComparator {
    public static void main(String[] args) {
        int vasyaAge = 29; //29 vasyaAge
        int katyaAge = 14; //14 katyaAge
        int mishaAge = 36; //36 mishaAge

        int min = -1; // минимальный возраст
        int middle = -1; // средний возраст
        int max = -1; // максимальный возраст

        if (vasyaAge <= katyaAge && vasyaAge <= mishaAge) {
            min = vasyaAge;
        } else if (katyaAge <= vasyaAge && katyaAge <= mishaAge) {
            min = katyaAge;
        } else if (mishaAge <= vasyaAge && mishaAge <= katyaAge) {
            min = mishaAge;
        }
        System.out.println(min);

        if (vasyaAge >= katyaAge && vasyaAge <= mishaAge) {
            middle = vasyaAge;
        } else if (vasyaAge >= mishaAge && vasyaAge <= katyaAge) {
            middle = vasyaAge;
        } else if (katyaAge >= vasyaAge && katyaAge <= mishaAge) {
            middle = katyaAge;
        } else if (katyaAge >= mishaAge && katyaAge <= vasyaAge) {
            middle = katyaAge;
        } else if (mishaAge >= vasyaAge && mishaAge <= katyaAge) {
            middle = mishaAge;
        } else if (mishaAge >= katyaAge && mishaAge <= vasyaAge) {
            middle = mishaAge;
        }
        System.out.println(middle);

        if (vasyaAge >= katyaAge && vasyaAge >= mishaAge) {
            max = vasyaAge;
        } else if (katyaAge >= vasyaAge && katyaAge >= mishaAge) {
            max = katyaAge;
        } else if (mishaAge >= vasyaAge && mishaAge >= katyaAge) {
            max = mishaAge;
        }
        System.out.println(max);
    }
}

