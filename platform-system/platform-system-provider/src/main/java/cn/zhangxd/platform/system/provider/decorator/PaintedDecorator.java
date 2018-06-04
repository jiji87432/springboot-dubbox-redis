package cn.zhangxd.platform.system.provider.decorator;

public class PaintedDecorator extends RoomDecorator {

    public PaintedDecorator(Room roomToBeDecorated) {
        super(roomToBeDecorated);
    }

    @Override
    public String showRoom() {
        doPainting();
        return super.showRoom() + "刷墙漆";
    }

    // 刷墙漆
    private void doPainting() {
    }

}