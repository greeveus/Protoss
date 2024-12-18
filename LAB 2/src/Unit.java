abstract class Unit extends GameObject {
    private int hp;

    public Unit(int id, String name, int x, int y, int hp) {
        super(id, name, x, y);
        this.hp = hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0; // Нельзя уйти в отрицательное значение
    }
}
