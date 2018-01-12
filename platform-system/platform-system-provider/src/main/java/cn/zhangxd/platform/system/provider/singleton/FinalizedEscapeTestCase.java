package cn.zhangxd.platform.system.provider.singleton;

public class FinalizedEscapeTestCase {

    public static FinalizedEscapeTestCase caseForEscape = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("哈哈，我已逃逸！");
        caseForEscape = this;
    }
}