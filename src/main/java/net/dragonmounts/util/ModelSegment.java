package net.dragonmounts.util;


public abstract class ModelSegment<T extends ScaledModelPart> extends Segment {
    // misc meta data
    public boolean visible;

    public ModelSegment<T> save(T model) {
        this.scaleX = model.scaleX;
        this.scaleY = model.scaleY;
        this.scaleZ = model.scaleZ;
        this.x = model.pivotX;
        this.y = model.pivotY;
        this.z = model.pivotZ;
        this.pitch = model.pitch;
        this.yaw = model.yaw;
        this.roll = model.roll;
        this.visible = model.visible;
        return this;
    }

    public void apply(T model) {
        model.scaleX = this.scaleX;
        model.scaleY = this.scaleY;
        model.scaleZ = this.scaleZ;
        model.pivotX = this.x;
        model.pivotY = this.y;
        model.pivotZ = this.z;
        model.pitch = this.pitch;
        model.yaw = this.yaw;
        model.roll = this.roll;
        model.visible = this.visible;
    }
}
