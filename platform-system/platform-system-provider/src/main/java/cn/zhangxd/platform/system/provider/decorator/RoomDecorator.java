package cn.zhangxd.platform.system.provider.decorator;

// 装修工程的模板
abstract public class RoomDecorator implements Room {
    // wrapper 的具体体现，每个独立的装修工序都是在上一个装修工序

    // 的基础上进行的，装修就是这样层层包装完成的
    protected Room roomToBeDecorated;

    public RoomDecorator(Room roomToBeDecorated) {
        this.roomToBeDecorated = roomToBeDecorated;
    }

    @Override
    public String showRoom() {
        // 委托（delegate）
        return roomToBeDecorated.showRoom();
    }
}