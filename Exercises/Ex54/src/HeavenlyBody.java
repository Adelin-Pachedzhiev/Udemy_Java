/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes type) {
        this.key = new Key(name, type);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double   getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        if(this.satellites.contains(satellite)){
            return false;
        }
        this.satellites.add(satellite);
        return true;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        return this.getKey().equals(((HeavenlyBody) obj).getKey());
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return key.getName() + ": " + key.getBodyType() + ", " + this.getOrbitalPeriod();
    }

    public static Key makeKey(String name, BodyTypes type){
        return new Key(name, type);
    }

    public enum BodyTypes {
        DWARF_PLANET,
        MOON,
        PLANET
    }

    public static final class Key {
        private  String name;
        private  BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null){
                return false;
            }
            if(this == obj){
                return true;
            }
            if(obj instanceof Key){
                return this.getName().equals(((Key) obj).getName()) && (this.getBodyType().equals(((Key) obj).getBodyType()));
            }
            return false;
        }

        @Override
        public int hashCode() {
            return getName().hashCode() + getBodyType().hashCode() + 43;
        }

        @Override
        public String toString() {
            return this.getName() + ": " + this.getBodyType();
        }
    }
}