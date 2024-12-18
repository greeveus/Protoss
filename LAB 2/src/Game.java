public class Game {
    public static void main(String[] args) {
        Archer archer = new Archer(1, "Лучник", 0, 0, 100, 15); // Урон 15
        Fort fort = new Fort(2, "Крепость", 5, 5, true, 20);
        MobileHome mobileHome = new MobileHome(3, "Дом на колёсах", 2, 2, false);

        System.out.println("\n=== Состояние здоровья и урона ===");
        System.out.println(archer.getName() + " здоровье: " + archer.getHp());
        System.out.println(archer.getName() + " урон: " + archer.getDamage());

        System.out.println("\n=== Тест атаки ===");
        fort.attack(archer);
        archer.attack(archer); // Лучник атакует сам себя

        System.out.println("\n=== Тест перемещения ===");
        archer.move(3, 3);
        mobileHome.move(6, 6);

        System.out.println("\n=== Состояние здоровья и урона ===");
        System.out.println(archer.getName() + " здоровье: " + archer.getHp());
        System.out.println(archer.getName() + " урон: " + archer.getDamage());
    }
}
