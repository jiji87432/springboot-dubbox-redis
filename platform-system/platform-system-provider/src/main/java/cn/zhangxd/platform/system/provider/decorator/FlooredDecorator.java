package cn.zhangxd.platform.system.provider.decorator;

public class FlooredDecorator extends RoomDecorator {

    public FlooredDecorator(Room roomToBeDecorated) {
        super(roomToBeDecorated);
    }

    @Override
    public String showRoom() {
        doFlooring();
        return super.showRoom() + "铺地板";
    }

    // 铺地板
    private void doFlooring() {
    }
}