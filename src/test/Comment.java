package test;

public class Comment {
    int id;
    String name;

    @Override
    public boolean equals(Object obj) {

        if (obj == this)
            return true;

        if (obj instanceof Comment) {
            if (((Comment) obj).id == this.id) {
                if (this.name == null) {
                    return ((Comment) obj).name == null;
                }
                if (this.name.equals(((Comment) obj).name))
                    return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
