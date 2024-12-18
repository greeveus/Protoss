class Fort extends Building implements Attacker {
    private int damage;

    public Fort(int id, String name, int x, int y, boolean built, int damage) {
        super(id, name, x, y, built);
        this.damage = damage;
    }

    @Override
    public void attack(Unit unit) {
        if (isBuilt()) {
            System.out.println(getName() + " стреляет из пушек по " + unit.getName() + " и наносит урон: " + damage);
            unit.receiveDamage(20); // Условный урон 20
        } else {
            System.out.println(getName() + " ещё не построена и не может атаковать.");
        }
    }
}
