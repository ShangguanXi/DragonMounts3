package net.dragonmounts.util;

public class Segment implements Cloneable {
    // scale multiplier
    public float scaleX;
    public float scaleY;
    public float scaleZ;
    // rotation points
    public float x;
    public float y;
    public float z;
    public float pitch;
    public float yaw;
    public float roll;

    @Override
    public Segment clone() {
        try {
            return (Segment) super.clone();
        } catch (CloneNotSupportedException e) {
            Segment segment = new Segment();
            segment.scaleX = this.scaleX;
            segment.scaleY = this.scaleY;
            segment.scaleZ = this.scaleZ;
            segment.x = this.x;
            segment.y = this.y;
            segment.z = this.z;
            segment.pitch = this.pitch;
            segment.yaw = this.yaw;
            segment.roll = this.roll;
            return segment;
        }
    }
}
