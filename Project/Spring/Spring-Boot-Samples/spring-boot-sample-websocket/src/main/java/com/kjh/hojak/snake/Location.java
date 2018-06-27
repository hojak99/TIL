package com.kjh.hojak.snake;

public class Location {

    public int x;
    public int y;
    public static final int GRID_SIZE = 10;
    public static final int PLAYFIELD_HEIGHT = 480;
    public static final int PLAYFIELD_WIDTH = 640;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location getAdjacentLocation(Direction direction) {
        switch (direction) {
            case NORTH:
                return new Location(this.x, this.y - Location.GRID_SIZE);
            case SOUTH :
                return new Location(this.x, this.y + Location.GRID_SIZE);
            case EAST :
                return new Location(this.x + Location.GRID_SIZE, this. y);
            case WEST :
                return new Location(this.x - Location.GRID_SIZE, this.y);
            case NONE :
                // fall through
            default:
                return this;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if(object == null || getClass() != object.getClass()) {
            return false;
        }

        Location location = (Location) object;

        if(this.x != location.x) {
            return false;
        }

        if(this.y != location.y) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = this.x;
        result = 31*result+this.y;
        return result;
    }
}
