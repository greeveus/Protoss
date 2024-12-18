abstract class Building extends GameObject {
    private boolean built;

    public Building(int id, String name, int x, int y, boolean built) {
        super(id, name, x, y);
        this.built = built;
    }

    public boolean isBuilt() {
        return built;
    }
}
