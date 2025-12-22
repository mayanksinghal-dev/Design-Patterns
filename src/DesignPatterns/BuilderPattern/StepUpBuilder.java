package DesignPatterns.BuilderPattern;

/**
 * Builder which restricts the object to be built is particular order. You can only build object by providing value at each step
 */

class HouseBuilder {
    private final int land;
    private final int base;
    private final int walls;
    private final int rooms;
    private final int roof;

    private HouseBuilder(Builder builder) {
        this.land = builder.land;
        this.base = builder.base;
        this.walls = builder.walls;
        this.rooms = builder.rooms;
        this.roof = builder.roof;
    }

    public static Land builder() {
        return new Builder();
    }
    interface Land{
        Base setLand(int land);
    }
    interface Base{
        Optional setBase(int base);
    }
    interface Optional{
        Builder setWalls(int walls);
        Builder setRooms(int rooms);
        Builder setRoof(int roof);
    }
    public static class Builder implements Land, Base, Optional{
        private int land;
        private int base;
        private int walls;
        private int rooms;
        private int roof;

        public Base setLand(int land) {
            this.land = land;
            return this;
        }

        public Optional setBase(int base) {
            this.base = base;
            return this;
        }

        public Builder setWalls(int walls) {
            this.walls = walls;
            return this;
        }

        public Builder setRooms(int rooms) {
            this.rooms = rooms;
            return this;
        }

        public Builder setRoof(int roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder build() {
            if (roof > 0) {
                throw new IllegalStateException("Age cannot be negative");
            }
            return new HouseBuilder(this);
        }

    }
}

public class StepUpBuilder {
    HouseBuilder houseBuilder = HouseBuilder.builder().setLand(1).setBase(1).setWalls(1).setRooms(4).setRoof(1).build();
}
