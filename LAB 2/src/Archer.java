class Archer extends Unit implements Attacker, Moveable {
    private int damage;

    public Archer(int id, String name, int x, int y, int hp, int damage) {
        super(id, name, x, y, hp);
        this.damage = damage;
    }

    @Override
    public void attack(Unit unit) {
        if (this.isAlive()) {
            System.out.println(getName() + " атакует " + unit.getName() + " и наносит урон: " + damage);
            unit.receiveDamage(damage);
        }
    }

    @Override
    public void move(int x, int y) {
        System.out.println(getName() + " перемещается в (" + x + ", " + y + ")");
    }

    public int getDamage() {
        return damage;
    }
}
