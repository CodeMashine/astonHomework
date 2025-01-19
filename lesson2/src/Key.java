public class Key {
    public String name;

    public Key(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.charAt(0);
    }

    public boolean equals(Key other) {
        if (this.name.equals(other.name)) return true;
        if (other != this) return false;
        return true;
    }
}
