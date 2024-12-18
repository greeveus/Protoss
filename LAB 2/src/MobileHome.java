class MobileHome extends Building implements Moveable {

    public MobileHome(int id, String name, int x, int y, boolean built) {
        super(id, name, x, y, built);
    }

    @Override
    public void move(int x, int y) {
        System.out.println(getName() + " перемещается в координаты (" + x + ", " + y + ")");
    }
}
